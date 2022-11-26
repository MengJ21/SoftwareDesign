package Trail1Computer.utils;

import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;

public class JsonUtil {
    public static JSONObject transformToJson(String hardware,String type) {
        try {
            // 因为数据存在json文件中，所以需要先加载json数据。
            String path  = "D:\\JAVA--CODE\\SoftwareDesign\\Trail1Computer\\config.json";
            File file = new File(path);
            Reader reader = new InputStreamReader(Files.newInputStream(file.toPath()));
            int ch = 0;
            StringBuilder sb = new StringBuilder();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            reader.close();
            String jsonStr = sb.toString();
            // System.out.println(jsonStr);
            JSONObject jsonObject = (JSONObject) JSONObject.parse(jsonStr);
            // 获取具体硬件。
            JSONObject hardware1 = jsonObject.getJSONObject(hardware);
            // 获取类型的详细信息。
            JSONObject type1 = hardware1.getJSONObject(type);
            return type1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
