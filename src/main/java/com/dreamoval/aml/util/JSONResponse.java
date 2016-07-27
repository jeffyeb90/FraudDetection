/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dreamoval.aml.util;

/**
 *
 * @author malike_st
 */
public class JSONResponse {

    private boolean status;
    private String message;
    private Object data;
    private int count;

    /**
     * Default constructor
     */
    public JSONResponse() {
    }

    /**
     *Method to check for status
     * @return boolean response
     */
    public boolean isStatus() {
        return status;
    }

    /**
     *Method to set status of JSON Response
     * @param status given to set status
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     *Method to get message of a JSON response
     * @return message as JSON response
     */
    public String getMessage() {
        return message;
    }

    /**
     *Method to set message
     * @param message given to set new message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     *Method to get data
     * @return data
     */
    public Object getData() {
        return data;
    }

    /**
     *Method to set data
     * @param data given to set data
     */
    public void setData(Object data) {
        this.data = data;
    }

    /**
     *Method to get count of JSON Response
     * @return count
     */
    public int getCount() {
        return count;
    }

    /**
     *Method to set count
     * @param count given to set count for JSON Response
     */
    public void setCount(int count) {
        this.count = count;
    }
}
