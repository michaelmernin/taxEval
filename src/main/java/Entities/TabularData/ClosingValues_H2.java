package Entities.TabularData;


import javax.persistence.*;

@Entity
@Table(name = "closingValues")
public class ClosingValues_H2 {

    @Id
    @GeneratedValue
    int id;

    Company_H2 companyH2;

    @Column
    String date;

    @Column
    Double closedAt;

    public ClosingValues_H2() {
    }

    public ClosingValues_H2(Company_H2 companyH2, String date, Double closedAt) {
        this.companyH2 = companyH2;
        this.date = date;
        this.closedAt = closedAt;
    }
}
