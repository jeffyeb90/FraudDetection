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
    
    
     /**Method to return institution ID
     * @return the institution id
     */ 
    public String getId(){
        return id;
    }

    /**Method to get the name of the institution
     * @return the name of institution
     */
    public String getName() {
        return name;
    }

    /**Method to set name of institution
     * @param name given to set institution name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**Method to get the short name of the institution
     * @return the shortName of the institution
     */
    public String getShortName() {
        return shortName;
    }

    /**Method to set short name of institution
     * @param shortName given as the short name to be used
     */
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    /**Method to get the country of the institution
     * @return the country of the institution
     */
    public String getCountry() {
        return country;
    }

    /**Method to set the country of the institution
     * @param country given as the institution's country
     */
    public void setCountry(String country) {
        this.country = country;
    }
}
