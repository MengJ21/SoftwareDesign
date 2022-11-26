package Trail1Computer;

import Trail1Computer.hardware.Hardware;
import Trail1Computer.utils.JsonUtil;
import com.alibaba.fastjson.JSONObject;

import java.util.Iterator;
import java.util.Set;

public class HandleInput {
    public static Result getContent(String input) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        // 定义一个computer。
        Computer computer = new Computer();
        JSONObject content = JSONObject.parseObject(input);
        Set<String> keySet = content.keySet();
        Iterator<String> iterator = keySet.iterator();
        String component = "";
        while (iterator.hasNext()) {
            // 获取组件类型。
            component = iterator.next();
            // 组件对应的类。
            String classPath = "Trail1Computer.hardware." + component;
            // 反射类。
            Class<?> cls = Class.forName(classPath);
            // 变成硬件类，因为具体的组件类都继承了Hardware类。
            Hardware hardware = (Hardware) cls.newInstance();
            // 获取具体硬件的配置信息。
            String type = content.getString(component);
            // 利用jsonUtil根据具体的硬件类型获取详细信息。
            JSONObject jsonObject = JsonUtil.transformToJson(component, type);
            // 将Hardware类注入computer中。这样便将所有硬件注入了。
            hardware.setType(jsonObject.getString("type"));
            hardware.setDescription(jsonObject.getString("description"));
            hardware.setPrice(Integer.valueOf(jsonObject.getString("price")));
            computer.setList(hardware);
        }
        return new Result(computer.getDescription(), computer.computePrice());
    }
}
