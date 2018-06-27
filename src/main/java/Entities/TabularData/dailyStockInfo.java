package Entities.TabularData;




import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@javax.persistence.Table(name = "dailyStockInfo")
public class dailyStockInfo {

    @Id
    @GeneratedValue
    int id;

    @Column
    String name;

    @Column
    List<LocalDateTime> date;

    @Column
    List<Double> closingValues;

    @Column
    List<Double> openingValues;

    @Column
    List<Double> closingValues;

    @Column
    List<Double> closingValues;

    @Column
    List<Double> closingValues;

//









}
