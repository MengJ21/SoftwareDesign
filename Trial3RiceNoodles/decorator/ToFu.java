package Trial3RiceNoodles.decorator;

import Trial3RiceNoodles.RiceNoodles.IRiceNoodles;

public class ToFu extends IDecorator {
    public ToFu(IRiceNoodles iRiceNoodles, int num) {
        super.iRiceNoodles = iRiceNoodles;
        super.num = num;
    }
    @Override
    public String getDescription() {
        return super.iRiceNoodles.getDescription() + "豆腐*" + super.num;
    }

    @Override
    public double cost() {
        return super.iRiceNoodles.cost() + 2.0 * super.num;
    }
}
