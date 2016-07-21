package com.dreamoval.aml.model;

import java.util.List;


public class Response {
    private List<Object> columns;
    private List<Object> data;

    /**
     * Method to return a list of columns
     * @return columns as an object 
     */
    public List<Object> getColumns() {
        return columns;
    }

    /**
     * Method to set columns in a list
     * @param columns given to set columns of the class
     */
    public void setColumns(List<Object> columns) {
        this.columns = columns;
    }

    /**
     * Method to return data in a list
     * @return data as a list of objects
     */
    public List<Object> getData() {
        return data;
    }

    /**
     * Method to set data in a list of objects
     * @param data given to set the data of the class
     */
    public void setData(List<Object> data) {
        this.data = data;
    }
}
