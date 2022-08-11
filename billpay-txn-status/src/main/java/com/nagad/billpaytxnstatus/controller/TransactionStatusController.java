package com.nagad.billpaytxnstatus.controller;

import com.nagad.billpaytxnstatus.model.TransactionStatusResponseBiller;
import com.nagad.billpaytxnstatus.model.dto.TransactionStatusInfo;
import com.nagad.billpaytxnstatus.service.TransactionStatusImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("${apiUrl}")
public class TransactionStatusController {
//    @Value("${apiUrl}")
//    private String apiUrl;
//    @Autowired
//    private TransactionStatusBillerRepositoryImpl repository;

    private TransactionStatusImpl transactionStatus;

    @Autowired
    public TransactionStatusController(TransactionStatusImpl transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    @GetMapping("/{txnId}")
    public TransactionStatusResponseBiller getDataByTxnId(@PathVariable String txnId)  {
//        List<Object> response = repository.runNativeQuery(txnId);
//        System.out.println(apiUrl);
//        Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmployeeController.class).getEmployeeByCode(txnId)).withSelfRel();
        return transactionStatus.getDataByTxnId(txnId);
    }
}
