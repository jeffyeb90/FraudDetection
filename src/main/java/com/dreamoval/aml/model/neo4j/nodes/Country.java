
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

    /**Method to get ID of a country
     * @return the id of a country
     */
    public String getId() {
        return id;
    }

    /**Method to get name of a country
     * @return the name of a country
     */
    public String getName() {
        return name;
    }

    /**Method to set name of the country
     * @param name given to set name of country
     */
    public void setName(String name) {
        this.name = name;
    }

    /**Method to get the code of a country
     * @return the code of the country
     */
    public String getCode() {
        return code;
    }

    /** Method to set code of country
     * @param code given to set the code of country
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**Method to return a set of accounts of country
     * @return the accounts as a set
     */
    public Set<Account> getAccounts() {
        return accounts;
    }

    /**Method to set accounts of country
     * @param accounts given as a set of accounts to be set for country
     */
    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }
}
