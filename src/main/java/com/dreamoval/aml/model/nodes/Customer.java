package com.dreamoval.aml.model.nodes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Set;
import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

/**
 * Created by dreamadmin on 10/10/14.
 */
@NodeEntity
public class Customer {

    @GraphId
    private String id;
    private String name;
    private boolean kycVerified;
    private int riskScore;
    @JsonIgnoreProperties
    @RelatedTo(type = "Owns", direction = Direction.OUTGOING)
    public @Fetch
    Set<Account> accounts;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isKycVerified() {
        return kycVerified;
    }

    public void setKycVerified(boolean kycVerified) {
        this.kycVerified = kycVerified;
    }

    public int getRiskScore() {
        return riskScore;
    }

    public void setRiskScore(int riskScore) {
        this.riskScore = riskScore;
    }

    @Override
    public String toString() {
        String results = name + "'s accounts are";
        if (accounts != null) {
            for (Account account : accounts) {
                results += "\t- " + account.getNumber() + "\n";
            }
        }
        return results;
    }
}
