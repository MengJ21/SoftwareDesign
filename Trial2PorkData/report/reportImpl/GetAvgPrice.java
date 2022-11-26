package Trial2PorkData.report.reportImpl;

import Trial2PorkData.report.PriceReport;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class GetAvgPrice implements PriceReport {
    @Override
    public Map<Integer, Double> priceChange(Map<Date, Double> porkList) {
        Map<Integer, Double> avgPriceList = new LinkedHashMap<>();
        Double avg = 0.0;
        int count = 0;
        // 便利每一个map中的元素。
        for (Map.Entry<Date,Double> entry: porkList.entrySet()) {
            avg += entry.getValue();
            // 每七天取一次平均值
            if (++count % 7 == 0) {
                avg /= 7;
                // 加入周数和该周的平均价格。
                avgPriceList.put(count / 7, avg);
                avg = 0.0;
            }
        }
        if (count % 7 != 0) {
            avgPriceList.put(count / 7 + 1, avg / (count % 7));
        }
        return avgPriceList;
    }
}
