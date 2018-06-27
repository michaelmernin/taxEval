package Entities.TabularData;


import javax.persistence.*;

@Entity
@Table(name = "closingValues")
public class ClosingValues {

    @Id
    @GeneratedValue
    int id;

    Company company;

    @Column
    String date;

    @Column
    Double closedAt;

    public ClosingValues() {
    }

    public ClosingValues(Company company, String date, Double closedAt) {
        this.company = company;
        this.date = date;
        this.closedAt = closedAt;
    }
}
