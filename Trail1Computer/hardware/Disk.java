package Trail1Computer.hardware;

public class Disk extends Hardware{
    private Integer price;
    private String type;
    private String description;

    public Disk() {
    }

    public Disk(Integer price, String type, String description) {
        this.price = price;
        this.type = type;
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
