package Entities.TabularData;


import javax.persistence.*;

@Entity
@Table(name = "openingValues")
public class OpeningValues {

    @Id
    @GeneratedValue
    int id;

    Company company;
}
