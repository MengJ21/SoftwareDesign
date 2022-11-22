package Trial3RiceNoodles.decorator;

import Trial3RiceNoodles.RiceNoodles.IRiceNoodles;

public class Egg extends IDecorator {
    public Egg(IRiceNoodles iRiceNoodles, int num) {
        super.iRiceNoodles = iRiceNoodles;
        super.num = num;
    }
    @Override
    public String getDescription() {
        return super.iRiceNoodles.getDescription() + "鸡蛋*" + super.num;
    }

    @Override
    public double cost() {
        return super.iRiceNoodles.cost() + 2.0 * super.num;
    }
}
