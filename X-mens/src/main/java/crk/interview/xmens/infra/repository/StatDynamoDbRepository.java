package crk.interview.xmens.infra.repository;

import org.socialsignin.spring.data.dynamodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface StatDynamoDbRepository extends CrudRepository<StatTable, String> {

    @Query(fields = "update set countHumanDna = if_not_exists(countHumanDna, 0) + 1")
    void increaseCountHumanDna();

    @Query(fields = "update set countMutantDna = if_not_exists(countMutantDna, 0) + 1")
    void increaseCountMutantDna();
}
