package crk.interview.xmens.stat.infra.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

@Getter
@Setter
@DynamoDBTable(tableName = "stat")
@NoArgsConstructor
public class StatTable {

    @DynamoDBHashKey
    public String hashKey;

    @DynamoDBAttribute
    public int countMutantDna = 0;

    @DynamoDBAttribute
    public int countHumanDna = 0;

    public StatTable(String hashKey) {
        this.hashKey = hashKey;
    }
}
