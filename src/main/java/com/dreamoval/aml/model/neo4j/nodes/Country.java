
package com.dreamoval.aml.model.neo4j.nodes;

import com.dreamoval.aml.model.neo4j.nodes.Account;
import java.util.Set;
import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

/**The Class represents the country model with respect to its relationships and data
*Modified by dreamadmin on 20/06/16.
*@author dreamadmin
*Country  class
*/

/**class is represented as a node */
@NodeEntity
public class Country {
    /** the id given to the country node*/
    @GraphId
    private String id;
    
    
    private String name;
    private String code;
    
    /** creates relationship between country and a set of accounts   */
    @RelatedTo(type = "Owns", direction = Direction.OUTGOING)
    private @Fetch
    Set<Account> accounts;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the accounts
     */
    public Set<Account> getAccounts() {
        return accounts;
    }

    /**
     * @param accounts the accounts to set
     */
    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }
}
