package Trial3RiceNoodles.RiceNoodles;

public abstract class IRiceNoodles {
    protected String label = "unknown";
    public String getDescription() {
        return this.label;
    }
    public abstract double cost();
}
