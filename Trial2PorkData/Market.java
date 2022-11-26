package Trial2PorkData;

import Trial2PorkData.report.reportImpl.PriceLineChart;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Market {
    private PorkData porkData;
    public void setPorkData() throws InterruptedException {
        porkData = new PorkData();
        Date date = new Date();
        Random random = new Random();
        for (int i = 0;i < 30;i++) {
            // 模拟当每天数据变化时，通知porkdata数据变化。这里将一秒类比一天。
            Thread.sleep(1000);
            // 日期加一天。
            Calendar c1 = Calendar.getInstance();
            c1.setTime(date);
            c1.add(Calendar.DAY_OF_MONTH, 1);
            date = c1.getTime();
            System.out.println(date);
            // 向porkData中传递数据。
            porkData.getPrice(date,(random.nextDouble() * 10.0 + 20.0));
            System.out.println(date + "   " + (random.nextDouble() * 10.0 + 20.0));
        }
        PriceLineChart.porkList = porkData.getPorkList();
    }
    public PorkData getPorkData() {
        return this.porkData;
    }
}
