package Trail1Computer;

import Trail1Computer.hardware.Hardware;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    public List<Hardware> list;
    /*
        计算价格。
     */
    public int computePrice() {
        int sum = 0;
        for (Hardware hardware: list) {
            sum += hardware.getPrice();
        }
        return sum;
    }

    /*
         获取配置详细信息。
     */
    public String getDescription() {
        StringBuilder sb = new StringBuilder();
        for (Hardware hardware: list) {
            sb.append(hardware.getType()).append("：").append(hardware.getDescription()).append("\n");
        }
        return String.valueOf(sb);
    }
    public List<Hardware> getList() {
        return list;
    }

    public void setList(Hardware hardware) {
        this.list.add(hardware);
    }

    public Computer() {
        this.list = new ArrayList<>();
    }

    public Computer(List<Hardware> list) {
        this.list = list;
    }
}
