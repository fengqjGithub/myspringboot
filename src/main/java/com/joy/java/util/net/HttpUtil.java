package com.joy.java.util.net;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.CharsetUtils;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Http工具类.
 * 编译时依赖于httpclient4.5.1.
 */
public class HttpUtil {

    private CloseableHttpClient httpClient ;

    public HttpUtil(){
        httpClient= HttpClients.createDefault();
    }

    /**
     * 构造自己的httpClient
     * @param httpClient
     */
    public HttpUtil(CloseableHttpClient httpClient){
        this.httpClient=httpClient;
    }

    /**
     * 上传文件
     * @param localFilePath 本地文件路径
     * @param postUrl 上传到的url
     * @param partName 上传文件对应的参数
     * @throws ParseException
     * @throws IOException
     * @return HttpResponse 响应信息
     */
    public CloseableHttpResponse postFile(String localFilePath, String postUrl, String partName) throws ParseException, IOException {
        try {
            // 要上传的文件的路径
            String filePath = new String(localFilePath);
            // 把一个普通参数和文件上传给下面这个地址 是一个servlet
            HttpPost httpPost = new HttpPost(postUrl);
            // 把文件转换成流对象FileBody
            File file = new File(filePath);
            FileBody bin = new FileBody(file);
            /*StringBody uploadFileName = new StringBody("my.png",
                    ContentType.create("text/plain", Consts.UTF_8));*/
            // 以浏览器兼容模式运行，防止文件名乱码。
            HttpEntity reqEntity = MultipartEntityBuilder.create()
                    .setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
                    .addPart(partName, bin) // uploadFile对应服务端类的同名属性<File类型>
                    //.addPart("uploadFileName", uploadFileName)// uploadFileName对应服务端类的同名属性<String类型>
                    .setCharset(CharsetUtils.get("UTF-8")).build();

            httpPost.setEntity(reqEntity);

            // 发起请求 并返回请求的响应
            CloseableHttpResponse response = httpClient.execute(httpPost);
            try {
                // 获取响应对象
                HttpEntity resEntity = response.getEntity();
                // 销毁
                EntityUtils.consume(resEntity);
                return response;
            } finally {
                response.close();
            }
        } finally {
            httpClient.close();
        }
    }

    /**
     * 下载文件
     * @param url http://www.xxx.com/img/333.jpg
     * @param destFileName xxx.jpg/xxx.png/xxx.txt
     * @throws ClientProtocolException
     * @throws IOException
     * @return HttpResponse 响应信息
     */
    public HttpResponse getFile(String url, String destFileName)throws ClientProtocolException, IOException {
        // 生成一个httpclient对象
        HttpGet httpget = new HttpGet(url);
        HttpResponse response = httpClient.execute(httpget);
        HttpEntity entity = response.getEntity();
        InputStream in = entity.getContent();
        File file = new File(destFileName);
        try {
            FileOutputStream fout = new FileOutputStream(file);
            int l = -1;
            byte[] tmp = new byte[1024];
            while ((l = in.read(tmp)) != -1) {
                fout.write(tmp, 0, l);
                // 注意这里如果用OutputStream.write(buff)的话，图片会失真，大家可以试试
            }
            fout.flush();
            fout.close();
        } finally {
            // 关闭低层流。
            in.close();
            httpClient.close();
            return response;
        }
    }
}
