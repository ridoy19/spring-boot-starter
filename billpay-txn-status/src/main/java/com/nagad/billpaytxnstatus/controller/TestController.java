package com.nagad.billpaytxnstatus.controller;

import com.nagad.billpaytxnstatus.models.TransactionStatusResponseBiller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${apiUrl}")
public class TestController {
    @GetMapping("/")
    public String getDataByTxnId()  {
        return "Hello";
    }
}
