package Entities.Nodes;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Set;

@NodeEntity
public class companyNode {

    @Relationship(type="BelongsTo_INDUSTRY", direction = Relationship.OUTGOING)
    Set<traderNode> owners;

    @Relationship(type="Sold_By", direction = Relationship.INCOMING)
    Set<traderNode> sellers;
}
