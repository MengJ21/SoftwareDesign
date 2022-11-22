package Trial2PorkData;

import java.util.Date;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Market market = new Market();
        market.setPorkData();
        market.getPorkData().markChanged();
    }

}
