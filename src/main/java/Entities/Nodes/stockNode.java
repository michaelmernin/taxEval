package Entities.Nodes;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Set;

@NodeEntity
public class stockNode {

    @Id
    @GeneratedValue
    Long id;

    String stockName;

    double openPrice;
    double closePrice;
    double dayHigh;
    double dayLow;

    @Relationship(type="Purchased_By", direction = Relationship.INCOMING)

    Set<traderNode> owners;

    @Relationship(type="Sold_By", direction = Relationship.INCOMING)
    Set<traderNode> sellers;



}
