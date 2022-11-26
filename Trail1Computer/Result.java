package Trail1Computer;

public class Result {
    private String content;
    private double price;

    public Result(String content, double price) {
        this.content = content;
        this.price = price;
    }
    public Result() {

    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
