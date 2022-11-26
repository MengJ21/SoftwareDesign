package Trial2PorkData;

import Trial2PorkData.report.reportImpl.GetAvgPrice;
import Trial2PorkData.report.reportImpl.GetDiffirencePrice;

import java.text.SimpleDateFormat;
import java.util.*;

public class PorkData {
    public Map<Date, Double> getPorkList() {
        return porkList;
    }

    public void setPorkList(Map<Date, Double> porkList) {
        this.porkList = porkList;
    }

    // 每日价格
    Map<Date,Double> porkList = new LinkedHashMap<>();
    // 每周均价,第一个参数是周数，表示第几周，第二个表示该周的平均价格。
    Map<Integer,Double> avgPriceList = new LinkedHashMap<>();
    Map<Integer,Double> priceDifferenceList = new LinkedHashMap<>();
    public void getPrice(Date date, Double price) {
        this.porkList.put(date,price);
    }
    public void markChanged() {
        this.avgPriceList = new GetAvgPrice().priceChange(porkList);
        this.priceDifferenceList = new GetDiffirencePrice().priceChange(porkList);
        System.out.println();
        for (Map.Entry<Integer,Double> entry: avgPriceList.entrySet()){
            System.out.print(entry.getKey() + "周均价：" + entry.getValue()+" ");
        }
        System.out.println();
        for (Map.Entry<Integer,Double> entry: priceDifferenceList.entrySet()) {
            System.out.print(entry.getKey() + "周差价：" + entry.getValue()+" ");
        }
        System.out.println();
    }
}
