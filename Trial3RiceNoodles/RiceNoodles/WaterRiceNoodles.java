package Trial3RiceNoodles.RiceNoodles;

public class WaterRiceNoodles extends IRiceNoodles {
    public WaterRiceNoodles() {
        super.label = "水米线+";
    }

    @Override
    public double cost() {
        return 8;
    }
}
