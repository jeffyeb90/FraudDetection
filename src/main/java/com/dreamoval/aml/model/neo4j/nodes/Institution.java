/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dreamoval.aml.model.neo4j.nodes;
import org.neo4j.graphdb.Direction;
import java.util.Set;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

/**The Class represents the institution model with respect to its relationships and data 
*Modified by dreamadmin on 20/06/16.
*@author dreamadmin
*Institution  class
*/


/**class is represented as a node */
@NodeEntity
public class Institution {
    
    /** the id given to the institution node*/
    @GraphId
    private String id;
    
    private String name;
    private String shortName;
    private String country;
    
    /**creates a relationship between institution and a set of accounts  */
    @RelatedTo(type = "Holds", direction = Direction.OUTGOING)
    public @Fetch
    Set<Account> accounts;
    
    
     /**
     * @return the institution id
     */ 
    public String getId(){
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
     * @return the shortName
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * @param shortName the shortName to set
     */
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }
}
