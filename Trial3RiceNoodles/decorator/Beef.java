package Trial3RiceNoodles.decorator;

import Trial3RiceNoodles.RiceNoodles.IRiceNoodles;

public class Beef extends IDecorator {
    public Beef(IRiceNoodles iRiceNoodles, int num) {
        super.iRiceNoodles = iRiceNoodles;
        super.num = num;
    }
    @Override
    public String getDescription() {
        return super.iRiceNoodles.getDescription() + "牛肉" + "*" + num;
    }

    @Override
    public double cost() {
        return super.iRiceNoodles.cost() + 5.0 * num;
    }
}
