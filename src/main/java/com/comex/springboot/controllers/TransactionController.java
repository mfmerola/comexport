package com.comex.springboot.controllers;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.comex.springboot.vo.Statistics;
import com.comex.springboot.vo.Transaction;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * © Copyright Corp 2018<br>
 *
 *
 * The <code>com.comex.springboot.controllers.UserController</code> class
 * is the endpoint regarding user, other word: /user (back-end).
 *
 *
 * @author mfmerola@gmail.com
 * @version 1.0
 * @since JDK1.8
 *
 *
 * @see Api;
 * @see ApiOperation;
 * @see ApiResponse;
 * @see ApiResponses;
 * @see Autowired;
 * @see HttpStatus;
 * @see ResponseEntity;
 * @see Model;
 */
@RestController
@Api(value = "Test Comex", description = "Operations")
public class TransactionController {
    
   
    @ApiOperation(value = "View a last 60 seconds statistics", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @RequestMapping(value = "/statistics", method = RequestMethod.GET)
    public ResponseEntity list() {
        try {

            return new ResponseEntity(Statistics.instance.getValues(), HttpStatus.OK);

        } catch(Exception exception) {
            java.util.Map<String, Object> errorAsJson = new java.util.HashMap<String, Object>();

            errorAsJson.put("verb", "GET");
            errorAsJson.put("exception", exception.getClass());
            errorAsJson.put("path", "/user");
            errorAsJson.put("timestamp", new Date());
            errorAsJson.put("message", exception.getMessage());

            return new ResponseEntity(errorAsJson, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Add transaction", response = Transaction.class)
    @ApiResponses(value = {
                           @ApiResponse(code = 201, message = "Successfully retrieved list"),
                           @ApiResponse(code = 204, message = "Your transaction occured more than 60 seconds ago"),
                           @ApiResponse(code = 412, message = "Input transaction is empty"),
                           @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
                           @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
                   })
    @RequestMapping(value = "/transaction", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity saveTransaction(@RequestBody Transaction transaction) {
        try {
            transaction.setDateRef(LocalDateTime.ofInstant(Instant.ofEpochMilli(transaction.getTimestamp()), 
                            TimeZone.getDefault().toZoneId()));
            
            int result = Statistics.instance.addTransaction(transaction);
            if(result == 1)
                return new ResponseEntity(new Date(), HttpStatus.NO_CONTENT);
            else {
                return new ResponseEntity(new Date(), HttpStatus.CREATED);
            }
        } catch(Exception exception) {
            java.util.Map<String, Object> errorAsJson = new java.util.HashMap<String, Object>();

            errorAsJson.put("verb", "POST");
            errorAsJson.put("exception", exception.getClass());
            errorAsJson.put("path", "/transaction");
            errorAsJson.put("timestamp", new Date());
            errorAsJson.put("message", exception.getMessage());

            return new ResponseEntity(errorAsJson, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}