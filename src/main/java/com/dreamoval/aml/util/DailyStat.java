package com.dreamoval.aml.util;

/**
 * Created by dreamadmin on 7/29/14.
 */
public class DailyStat {

   private int day;
    private int count;

    /**
     *Method to get day for daily statistics
     * @return day
     */
    public int getDay() {
        return day;
    }

    /**
     *Method to set a day
     * @param day given to set specific day
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     *Method to return count 
     * @return count
     */
    public int getCount() {
        return count;
    }

    /**
     *Method to set count
     * @param count given to set count
     */
    public void setCount(int count) {
        this.count = count;
    }
}
