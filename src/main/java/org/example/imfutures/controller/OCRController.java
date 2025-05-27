/*
package org.example.imfutures.controller;


import com.alibaba.fastjson.JSONObject;
import org.apache.tomcat.util.codec.binary.Base64;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//身份证OCR智能识别接口
public class OCRController {
    public static String img_base64(String path) {
        */
/**
         *  对path进行判断，如果是本地文件就二进制读取并base64编码，如果是url,则返回
         *//*

        String imgBase64="";
        if (path.startsWith("http")){
            imgBase64 = path;
        }else {
            try {
                File file = new File(path);
                byte[] content = new byte[(int) file.length()];
                FileInputStream finputstream = new FileInputStream(file);
                finputstream.read(content);
                finputstream.close();
                imgBase64 = new String(Base64.encodeBase64(content));
            } catch (IOException e) {
                e.printStackTrace();
                return imgBase64;
            }
        }

        return imgBase64;
    }

    public static void main(String[] args) {
        String host = "https://cardnumber.market.alicloudapi.com";
        String path = "/rest/160601/ocr/ocr_idcard.json";
        String appcode = "你的appcode";
        String imgFile = "本地图片路径或者图片的url";
        String method = "POST";

        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/json; charset=UTF-8");

        Map<String, String> querys = new HashMap<String, String>();
        // 对图像进行base64编码
        String imgBase64 = img_base64(imgFile);

        //configure配置
        JSONObject configObj = new JSONObject();
        configObj.put("side", "face");

        String config_str = configObj.toString();

        // 拼装请求body的json字符串
        JSONObject requestObj = new JSONObject();
        requestObj.put("image", imgBase64);
        if(configObj.size() > 0) {
            requestObj.put("configure", config_str);
        }
        String bodys = requestObj.toString();

        try {
            */
/**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             *//*

            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            int stat = response.getStatusLine().getStatusCode();
            if(stat != 200){
                System.out.println("Http code: " + stat);
                System.out.println("http header error msg: "+ response.getFirstHeader("X-Ca-Error-Message"));
                System.out.println("Http body error msg:" + EntityUtils.toString(response.getEntity()));
                return;
            }

            String res = EntityUtils.toString(response.getEntity());
            JSONObject res_obj = JSON.parseObject(res);

            System.out.println(res_obj.toJSONString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
*/
