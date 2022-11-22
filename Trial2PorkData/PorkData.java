package Trial2PorkData;

import java.text.SimpleDateFormat;
import java.util.*;

public class PorkData {
    // 每日价格
    Map<Date,Double> porkList = new LinkedHashMap<>();
    // 每周均价,第一个参数是周数，表示第几周，第二个表示该周的平均价格。
    Map<Integer,Double> avgPriceList = new LinkedHashMap<>();
    Map<Integer,Double> priceDifferenceList = new LinkedHashMap<>();
    public void getPrice(Date date, Double price) {
        this.porkList.put(date,price);
    }
    public void markChanged() {
        Double avg = 0.0;
        int count = 0;
        // 便利每一个map中的元素。
        for (Map.Entry<Date,Double> entry: this.porkList.entrySet()) {
            avg += entry.getValue();
            // 每七天取一次平均值
            if (++count % 7 == 0) {
                avg /= 7;
                // 加入周数和该周的平均价格。
                this.avgPriceList.put(count / 7, avg);
                // 计算差价，需要刨除第一周。从第二周开始。
                if (count / 7 != 1) {
                    double lastPrice = avgPriceList.get(count / 7 - 1);
                    priceDifferenceList.put(count / 7, avg - lastPrice);
                }
            }
        }
        for (Map.Entry<Date,Double> entry: this.porkList.entrySet()) {
            System.out.print(entry.getValue()+" ");
        }
        System.out.println();
        for (Map.Entry<Integer,Double> entry: avgPriceList.entrySet()){
            System.out.print(entry.getValue()+" ");
        }
        System.out.println();

        for (Map.Entry<Integer,Double> entry: priceDifferenceList.entrySet()) {
            System.out.print(entry.getValue()+" ");
        }
        System.out.println();
    }
}
