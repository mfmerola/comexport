package com.comex.springboot.vo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Statistics implements Serializable{

    private static final long serialVersionUID = 6205485780839694443L;
    
    private LinkedList<Transaction> transactions;
    
    public static final Statistics instance = new Statistics(); 

    public Statistics() {
        this.transactions = new LinkedList<Transaction>();
        
    }
    public LinkedList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(LinkedList<Transaction> transactions) {
        this.transactions = transactions;
    }
    
    public int addTransaction(Transaction trans) {
        int result = 0;
        if (!this.transactions.isEmpty() &&
            transactions.getLast().getDateRef().plusMinutes(1).isBefore(LocalDateTime.now())) {
            result = 1;
            transactions.clear();
        }
        this.transactions.add(trans);
        return result;
    }
    
    public Map<String, Object> getValues() {
        Map<String, Object> result = new HashMap<String, Object>();
        DoubleSummaryStatistics stat = transactions.stream().mapToDouble(transaction -> transaction.getAmount()).summaryStatistics();

        result.put("sum", stat.getSum());
        result.put("max", stat.getMax());
        result.put("min", stat.getMin());
        result.put("avg", stat.getAverage());
        result.put("count", stat.getCount());
        return result;
    }


}
