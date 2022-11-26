package Trial2PorkData.report;

import java.util.Date;
import java.util.Map;

public interface PriceReport {
    Map<Integer,Double> priceChange(Map<Date,Double> porkList);
}
