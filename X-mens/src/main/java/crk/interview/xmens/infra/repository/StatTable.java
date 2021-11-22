package crk.interview.xmens.infra.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@DynamoDBTable(tableName = "stat")
public class StatTable {

    @DynamoDBHashKey
    private int countMutantDna;

    @DynamoDBHashKey
    private int countHumanDna;

}
