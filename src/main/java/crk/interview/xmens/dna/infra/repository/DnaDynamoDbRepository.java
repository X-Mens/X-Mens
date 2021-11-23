package crk.interview.xmens.dna.infra.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@EnableScan
@Repository
public interface DnaDynamoDbRepository extends CrudRepository<DnaTable, String> {

}
