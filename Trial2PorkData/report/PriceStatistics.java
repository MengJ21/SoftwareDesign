package Trial2PorkData.report;

import java.util.Date;
import java.util.Map;

public interface PriceStatistics {
    void createPanel(Map<Date,Double> porkList);
}
