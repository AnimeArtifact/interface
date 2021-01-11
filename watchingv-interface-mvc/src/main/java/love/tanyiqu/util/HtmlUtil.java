package love.tanyiqu.util;


import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HtmlUtil {

    // 使用post请求获取html
    public String getHtmlPost(String url, Map<String, String> params) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost(url);

        // 声明List集合，封装表单中的参数
        List<NameValuePair> formParams = new ArrayList<>();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            formParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }

        // 创建表单的entity的对象
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(formParams, "utf8");

        // 设置表单的entity对象到post请求中
        httpPost.setEntity(formEntity);
        httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4372.0 Safari/537.36 Edg/89.0.752.1 FS");

        CloseableHttpResponse response = httpClient.execute(httpPost);

        // 解析响应
        String content;
        if (response.getStatusLine().getStatusCode() == 200) {
            content = EntityUtils.toString(response.getEntity(), "utf8");
        } else {
            return "";
        }

        // 释放资源
        response.close();
        httpClient.close();

        return content;
    }

    @Test
    public void test() throws IOException {
        String url = "http://www.zuidazy4.com/index.php?m=vod-search";

        Map<String, String> params = new HashMap<>();
        params.put("submit", "search");
        params.put("wd", "胜者");

        String content = getHtmlPost(url, params);

        System.out.println(content);
    }

}
