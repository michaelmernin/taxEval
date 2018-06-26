package Entities.TabularData;


import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Table;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@javax.persistence.Table(name = "stockInfo")
public class stockInfo {

    @Id
    @GeneratedValue
    int id;

    @Column
    String name;

    @ManyToOne
    LocalDateTime date;

    @ManyToOne
    double close;

    @OneToMany
    double open;

    @OneToMany
    double high;

    @OneToMany
    double low;









}
