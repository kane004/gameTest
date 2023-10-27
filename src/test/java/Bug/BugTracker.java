package Bug;

import java.io.IOException;
import java.util.Base64;
import java.nio.charset.StandardCharsets;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class BugTracker {

    // 禅道 API 地址
    private static final String ZENTAO_API_URL = "https://zentao.t2cdn.com/zentao/bug-create-1-0-moduleID=6.html\n";

    // 禅道用户名和密码
    private static final String ZENTAO_USERNAME = "kane";
    private static final String ZENTAO_PASSWORD = "Kane123456";

    public static void submitBug(String bugTitle, String bugDetails) {
        // 构建 Bug 创建请求 JSON
        String jsonRequest = buildBugCreateRequest(bugTitle, bugDetails);

        // 发起 HTTP POST 请求
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(ZENTAO_API_URL);
            System.out.println("发起请求...");


            // 添加 Basic 认证头
            String auth = ZENTAO_USERNAME + ":" + ZENTAO_PASSWORD;
            String base64Auth = Base64.getEncoder().encodeToString(auth.getBytes(StandardCharsets.UTF_8));
            httpPost.setHeader("Authorization", "Basic " + base64Auth);



            /**
             *
            // 添加 Bearer 认证头，用 API 密钥或令牌替代用户名和密码
            httpPost.setHeader("Authorization", "Bearer " + YOUR_API_KEY_OR_TOKEN);
             */

            // 设置请求体
            httpPost.setEntity(new StringEntity(jsonRequest, "application/json", "UTF-8"));

            // 执行请求
            HttpResponse response = httpClient.execute(httpPost);
            System.out.println("执行请求...");

            // 处理响应
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                String responseText = EntityUtils.toString(response.getEntity());
                System.out.println("Bug submitted successfully. Response: " + responseText);
            } else {
                System.err.println("Failed to submit bug. HTTP status code: " + statusCode);
            }

            httpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String buildBugCreateRequest(String bugTitle, String bugDetails) {
        // 根据禅道 API 文档构建 JSON 请求
        // 使用传入的参数来构建标题和内容

        String jsonRequest = "{\n" +
                //模块ID
                "  \"module\": \"6\",\n" +

                //产品ID
                "  \"product\": \"1\",\n" +

                //影响版本-主干
                "  \"openedBuild\": \"trunk\",\n" +

                //严重程度
                "  \"severity\": \"3\",\n" +

                //优先级
                "  \"pri\": \"3\",\n" +

                //当前指派
                "  \"assignedTo\": \"Kane\",\n" +

                //BUG类型-代码错误
                "  \"type\": \"codeerror\",\n" +

                //标题
                "  \"title\": \"" + bugTitle + "\",\n" +

                //操作步骤
                "  \"steps\": \"Steps to reproduce the issue:\\n" + bugDetails + "\",\n" +


                "}";

        return jsonRequest;
    }
}
