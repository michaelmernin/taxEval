package Entities.TabularData;


import javax.persistence.*;

@Entity
@Table(name = "openingValues")
public class OpeningValues_H2 {

    @Id
    @GeneratedValue
    int id;

    Company_H2 companyH2;
}
