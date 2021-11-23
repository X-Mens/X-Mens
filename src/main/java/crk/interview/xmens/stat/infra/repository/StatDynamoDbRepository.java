package crk.interview.xmens.stat.infra.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@EnableScan
@Repository
public interface StatDynamoDbRepository extends CrudRepository<StatTable, String> {

}
