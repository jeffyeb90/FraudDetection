package com.dreamoval.aml.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dreamadmin 
 */
public class MonthlyChart {

    private List<DailyStat> stats;

    /**
     *Method to add new daily statistics
     * @param dailyStat given as details to be added
     */
    public void addStat(DailyStat dailyStat){
        if (this.stats == null) {
            this.stats = new ArrayList<DailyStat>();
        }
        stats.add(dailyStat);
    }

    /**
     *Method to remove daily statistics
     * @param dailyStat given as details to be removed
     */
    public void removeStat(DailyStat dailyStat){
        if(this.stats!=null){
            stats.remove(dailyStat);
        }
    }

    /**
     *Method to get a list of daily statistics
     * @return list of daily statistics
     */
    public List<DailyStat> getStats() {
        return stats;
    }

    /**
     *Method to set statistics for a list of daily statistics
     * @param stats given as the list of daily statistics
     */
    public void setStats(List<DailyStat> stats) {
        this.stats = stats;
    }
}
