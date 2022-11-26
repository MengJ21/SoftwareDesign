package Trial2PorkData;

import Trial2PorkData.report.reportImpl.PriceLineChart;

import java.util.Date;

public class Main {
    /*
    函数需要模拟市场发送数据，请等待30s。
     */
    public static void main(String[] args) throws InterruptedException {
        Market market = new Market();
        market.setPorkData();
        market.getPorkData().markChanged();
        // 调用价格变动图表的main函数。
        PriceLineChart.main(args);
    }

}
