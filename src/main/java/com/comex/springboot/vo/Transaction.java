package com.comex.springboot.vo;

import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModelProperty;

public class Transaction extends Object implements Serializable{

    private static final long serialVersionUID = 3725707114957059976L;
    
    @ApiModelProperty(notes = "Amount of the transaction")
    private double amount;
    @ApiModelProperty(notes = "Indicate the last 60 seconds.")
    private Long timestamp;
    
    private LocalDateTime dateRef;
    
    public Long getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public LocalDateTime getDateRef() {
        return dateRef;
    }
    public void setDateRef(LocalDateTime dateRef) {
        this.dateRef = dateRef;
    }

}
