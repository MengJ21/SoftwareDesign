package Trial3RiceNoodles.decorator;

import Trial3RiceNoodles.RiceNoodles.IRiceNoodles;

public abstract class IDecorator extends IRiceNoodles{
    protected IRiceNoodles iRiceNoodles;
    protected Integer num;
    public abstract String getDescription();
}
