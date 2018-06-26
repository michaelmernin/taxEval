package graphDAO;

import Entities.Nodes.stockNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface stockRepo extends Neo4jRepository<stockNode, Long> {

    stockNode findById(long id);


}