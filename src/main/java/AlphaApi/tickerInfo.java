package AlphaApi;

import Entities.TabularData.ClosingValues_H2;
import Entities.TabularData.Company_H2;
import org.patriques.AlphaVantageConnector;
import org.patriques.TimeSeries;
import org.patriques.input.timeseries.OutputSize;
import org.patriques.output.AlphaVantageException;
import org.patriques.output.timeseries.Daily;
import org.patriques.output.timeseries.data.StockData;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class tickerInfo {

//    public static HashMap<String, Double> differenceValues_DAY = new HashMap<>();
//    public static HashMap<String, Double> closeValues = new HashMap<>();
//    public static HashMap<String, Double> openValues = new HashMap<>();


    //public static HashMap<String, List<StockData>> initialInputs = new HashMap<>();

    //public static HashMap<LocalDateTime, HashMap<Double,Double>> captured = new HashMap<>();

    public static void main(String[] args) {
        String apiKey = "0SCP39FSC734BRX5";
        int timeout = 35000;
        AlphaVantageConnector apiConnector = new AlphaVantageConnector(apiKey, timeout);
        TimeSeries stockTimeSeries = new TimeSeries(apiConnector);


            try {
                //Daily dailyResponse = stockTimeSeries.daily("GOOG", OutputSize.FULL);
                Daily dailyResponse = stockTimeSeries.daily("GOOG", OutputSize.FULL);
                //IntraDay response = stockTimeSeries.intraDay("GOOG", Interval.SIXTY_MIN, OutputSize.COMPACT);
                //Map<String, String> metaData = dailyResponse.getMetaData();
                //System.out.println("Information: " + metaData.get("1. Information"));
                //System.out.println("Stock: " + metaData.get("2. Symbol"));

                List<StockData> stockData = dailyResponse.getStockData();
                stockData.forEach(stock -> {
                    HashMap<String, Double> closedAt = new HashMap<>();
                    String companyName = dailyResponse.getMetaData().get("2.Symbol");
                    String keyDayOfWeek = stock.getDateTime().format(DateTimeFormatter.ofPattern("D u E"));
                    double closeValue = Double.parseDouble(String.format("%.2f", stock.getClose()));
                    closedAt.put(keyDayOfWeek, closeValue);





//                    ClosingValues_H2 close = new ClosingValues_H2(co, keyDayOfWeek,closeValue);
//                    Company_H2 co = new Company_H2(companyName, close);






                });
            } catch (AlphaVantageException e) {
                System.out.println("something went wrong");
            }

            //injected method
            //Calcs.highestAvgDayOfWeek(captured);
//            int xx = differenceValues_DAY.size();
//            System.out.println(xx);
//            //System.out.println(differenceValues_DAY);
//
//
//            for (Map.Entry<String, Double> x : differenceValues_DAY.entrySet()) {
//                String key = x.getKey();
//                Double value = x.getValue();
//
//
//            }
    }

    public static void persistData (HashMap<String, List<StockData>> x){



    }
}
