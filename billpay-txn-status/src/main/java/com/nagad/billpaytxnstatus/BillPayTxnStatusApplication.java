package com.nagad.billpaytxnstatus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableEurekaClient
public class BillPayTxnStatusApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillPayTxnStatusApplication.class, args);
	}

}
