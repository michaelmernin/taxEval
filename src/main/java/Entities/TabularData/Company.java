package Entities.TabularData;


import javax.persistence.*;

@Entity
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue
    int id;

    @Column
    String companyName;

    ClosingValues closingValues;


    public Company() {
    }

    public Company(String companyName, ClosingValues closingValues) {
        this.companyName = companyName;
        this.closingValues = closingValues;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public ClosingValues getClosingValues() {
        return closingValues;
    }

    public void setClosingValues(ClosingValues closingValues) {
        this.closingValues = closingValues;
    }
}
