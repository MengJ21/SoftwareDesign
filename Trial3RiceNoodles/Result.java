package Trial3RiceNoodles;

public class Result {
    private String selectInfo;
    private Double sum;

    public String getSelectInfo() {
        return selectInfo;
    }

    public void setSelectInfo(String selectInfo) {
        this.selectInfo = selectInfo;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Result() {
    }

    public Result(String selectInfo, Double sum) {
        this.selectInfo = selectInfo;
        this.sum = sum;
    }
}
