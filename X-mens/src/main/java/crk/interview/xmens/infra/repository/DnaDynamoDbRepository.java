package crk.interview.xmens.infra.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface DnaDynamoDbRepository extends CrudRepository<DnaTable, String> {

}
