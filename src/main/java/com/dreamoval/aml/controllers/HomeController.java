package com.dreamoval.aml.controllers;

import com.dreamoval.aml.model.mongo.domain.DailySummary;
import com.dreamoval.aml.model.mongo.domain.ITransaction;
import com.dreamoval.aml.model.mongo.services.DailySummaryService;
import com.dreamoval.aml.model.mongo.services.ITransactionService;
import com.dreamoval.aml.util.DailyStat;
import com.dreamoval.aml.util.MonthlyChart;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dreamadmin on 10/10/14.
 */

@Controller
public class HomeController {

  
   @Autowired

   DailySummaryService dailySummaryService;

    /**
     *Method to get monthly statistics in relation to daily transactions
     * @param model given to represent structure that holds statistics
     * @return string 
     */
    @RequestMapping(value="/stat")
    public @ResponseBody String index(Model model) {
//        List<ITransaction> transactions = transactionService.findAll();
        MonthlyChart monthlyChart = getMonthStats(dailySummaryService.findMonthlySummary());
        model.addAttribute("monthStats",monthlyChart);

        return "index";
    }

//    public String loadGraph(){
//        MonthlyChart monthlyChart = getMonthStats(dailySummaryService.findMonthlySummary());
//        JsonObject object = new JsonObject();
//        object.add("monthly",monthlyChart);
//
//    }

    /**
     * Method to add to a chart and get monthly statistics in relation to daily summaries for specific days
     * @param dailySummaries given to represent a list of daily summaries that have been stored
     * @return chart to show statistics
     */
    
    public MonthlyChart getMonthStats(List<DailySummary> dailySummaries){
        MonthlyChart chart = new MonthlyChart();

        int maximumValue = new DateTime().dayOfMonth().getMaximumValue();

        for(int i =1;i<maximumValue;i++){
            DailyStat stat = new DailyStat();
            stat.setDay(i);
            stat.setCount(0);
            for (DailySummary dailySummary : dailySummaries) {
                if(dailySummary.getDateCreated().getDayOfMonth() == i){
                    stat.setCount(dailySummary.getTransactionCount());
                }
            }
            chart.addStat(stat);
        }
        return chart;
    }
}
