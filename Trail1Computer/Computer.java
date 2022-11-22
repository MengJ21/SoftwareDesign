package Trail1Computer;

import Trail1Computer.hardware.Hardware;

import java.util.List;

public class Computer {
    List<Hardware> list;

    public List<Hardware> getList() {
        return list;
    }

    public void setList(Hardware hardware) {
        this.list.add(hardware);
    }

    public Computer() {
    }

    public Computer(List<Hardware> list) {
        this.list = list;
    }
}
