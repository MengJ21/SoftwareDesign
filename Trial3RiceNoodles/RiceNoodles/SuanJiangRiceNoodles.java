package Trial3RiceNoodles.RiceNoodles;

public class SuanJiangRiceNoodles extends IRiceNoodles {
    public SuanJiangRiceNoodles() {
        super.label = "酸浆米线+";
    }

    @Override
    public double cost() {
        return 10;
    }
}
