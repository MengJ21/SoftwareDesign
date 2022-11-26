package Trial2PorkData.report.reportImpl;

import Trial2PorkData.report.PriceReport;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class GetDiffirencePrice implements PriceReport {
    PriceReport priceReport;
    @Override
    public Map<Integer, Double> priceChange(Map<Date, Double> porkList) {
        // 由于计算差价用到了计算平均价，所以可以利用装饰器模式引入平均价。
        this.priceReport = new GetAvgPrice();
        Map<Integer, Double> avgMap = priceReport.priceChange(porkList);
        // 存放结果的map
        Map<Integer,Double> priceDifferenceList = new LinkedHashMap<>();
        // 存放上周的均价。
        Double prePrice = 0.0;
        for (Map.Entry<Integer,Double> entry: avgMap.entrySet()) {
            if (entry.getKey() != 1) {
                priceDifferenceList.put(entry.getKey(), prePrice - entry.getValue());
            }
            prePrice = entry.getValue();
        }
        return priceDifferenceList;
    }
}
