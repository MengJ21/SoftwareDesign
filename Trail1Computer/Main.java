package Trail1Computer;

import Trail1Computer.hardware.CPU;
import Trail1Computer.hardware.GPU;
import Trail1Computer.hardware.Hardware;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
//        Class cls = Class.forName("GPU");
//        CPU cpu = (CPU) cls.newInstance();
//        cpu.test();
        CPU cpu = new CPU();
        cpu.test();
        GPU gpu = new GPU();
        gpu.test();
        Hardware hardware = new CPU();
    }
}
