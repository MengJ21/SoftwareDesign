package Trial2PorkData.report.reportImpl;

import Trial2PorkData.Market;
import Trial2PorkData.report.PriceReport;
import Trial2PorkData.report.PriceStatistics;

import java.awt.*;
import java.util.*;
import java.util.Map.Entry;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.jfree.chart.axis.DateAxis;


public class PriceLineChart extends Application implements PriceStatistics{
    public static Map<Date,Double> porkList = new LinkedHashMap<>();
    Date date;
    Double price;
    PriceReport priceReport;
    Double differPrice;
    @Override
    public void createPanel(Map<Date,Double> porkList) {
        PriceLineChart.porkList = porkList;
        this.priceReport = new GetDiffirencePrice();
        Map<Integer, Double> differPriceList = priceReport.priceChange(porkList);
        // 获取差价。
        this.differPrice = differPriceList.get(porkList.size() % 7 != 0 ? porkList.size() / 7 + 1 : porkList.size() / 7);
        Iterator<Entry<Date, Double>> iterator = porkList.entrySet().iterator();
        Entry<Date, Double> tail = null;
        // 获取数据列表最后一个元素，也就是今天的日期和价格。
        while (iterator.hasNext()) {
            tail = iterator.next();
        }
        assert tail != null;
        this.date = tail.getKey();
        this.price = tail.getValue();
    }
    @Override
    public void start(Stage stage) {
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("日期");
        yAxis.setLabel("价格");
        final LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis, yAxis);

        lineChart.setTitle("猪肉价格波动表");
        XYChart.Series<Number, Number> series = new XYChart.Series<Number, Number>();
        series.setName("统计");
        // populating the series with data
        Calendar calendar = Calendar.getInstance();
        for (Entry<Date,Double> entry: porkList.entrySet()) {
            calendar.setTime(entry.getKey());
            int i = calendar.get(Calendar.DATE);
            series.getData().add(new XYChart.Data<Number, Number>(i, entry.getValue()));
        }
        Scene scene = new Scene(lineChart, 800, 600);
        lineChart.getData().add(series);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) throws InterruptedException {
          launch(args);
    }
}
