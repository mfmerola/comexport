package com.comex.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * © Copyright Corp 2018<br>
 *
 *
 * The <code>com.comex.springboot.SpringBootWebApplication</code> class is
 * a kind of starter of the web application (boot), in this case, it is
 * Demo' project as back-end.
 *
 *
 * @author mfmerola@gmail.com
 * @version 1.0
 * @since JDK1.8
 *
 *
 * @see SpringApplication;
 * @see SpringBootApplication;
 */
@SpringBootApplication(scanBasePackages = {"com.comex.springboot.controllers"})
public class SpringBootWebApplication {
    /**
     * The main(String[]) method, it means a started of the web application (boot).
     * @param args - The arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebApplication.class, args);
    }

}