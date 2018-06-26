package AlphaApi;

import org.patriques.AlphaVantageConnector;
import org.patriques.TimeSeries;
import org.patriques.input.timeseries.Interval;
import org.patriques.input.timeseries.OutputSize;
import org.patriques.output.AlphaVantageException;
import org.patriques.output.timeseries.Daily;
import org.patriques.output.timeseries.IntraDay;
import org.patriques.output.timeseries.data.StockData;

import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class tickerInfo {

    public static HashMap<String, Double> differenceValues_DAY = new HashMap<>();
    public static HashMap<String, Double> closeValues = new HashMap<>();
    public static HashMap<String, Double> openValues = new HashMap<>();

    //public static HashMap<LocalDateTime, HashMap<Double,Double>> captured = new HashMap<>();

    public static void main(String[] args) {
        String apiKey = "0SCP39FSC734BRX5";
        int timeout = 35000;
        AlphaVantageConnector apiConnector = new AlphaVantageConnector(apiKey, timeout);
        TimeSeries stockTimeSeries = new TimeSeries(apiConnector);

//        HashMap<LocalDateTime, HashMap> captured = new HashMap<>();
//        HashMap<Double, Double> openClose = new HashMap<>();
//        HashMap<LocalDateTime, Double> close = new HashMap<>();
//        HashMap<LocalDateTime, Double> open = new HashMap<>();

        try {
            Daily dailyResponse = stockTimeSeries.daily("GOOG", OutputSize.FULL);
            //IntraDay response = stockTimeSeries.intraDay("GOOG", Interval.SIXTY_MIN, OutputSize.COMPACT);
            //Map<String, String> metaData = dailyResponse.getMetaData();
            //System.out.println("Information: " + metaData.get("1. Information"));
            //System.out.println("Stock: " + metaData.get("2. Symbol"));

            List<StockData> stockData = dailyResponse.getStockData();
            stockData.forEach(stock -> {

                String keyDayOfWeek = stock.getDateTime().format(DateTimeFormatter.ofPattern("D u E"));
                String dayOfWeek = stock.getDateTime().format(DateTimeFormatter.ofPattern("E"));
                String year = stock.getDateTime().format(DateTimeFormatter.ofPattern("u"));
                String hour = stock.getDateTime().format(DateTimeFormatter.ofPattern("H"));
                //String year = stock.getDateTime().format(DateTimeFormatter.ofPattern("E"));
                double openValue = Double.parseDouble(String.format("%.2f", stock.getOpen()));
                //String open = String.valueOf(x)String.format("%.2f", x);
                double closeValue = Double.parseDouble(String.format("%.2f", stock.getClose()));
                //String closeValue = String.format("%.2f", y);
                double profit = openValue - closeValue;

                openValues.put(dayOfWeek, openValue);
                closeValues.put(dayOfWeek, closeValue);
                differenceValues_DAY.put(keyDayOfWeek, profit);




            });
        } catch (AlphaVantageException e) {
            System.out.println("something went wrong");
        }

        //injected method
        //Calcs.highestAvgDayOfWeek(captured);
        int xx = differenceValues_DAY.size();
        System.out.println(xx);
        //System.out.println(differenceValues_DAY);



        for(Map.Entry<String, Double> x: differenceValues_DAY.entrySet()) {
            String key = x.getKey();
            Double value = x.getValue();


            }
    }
}
