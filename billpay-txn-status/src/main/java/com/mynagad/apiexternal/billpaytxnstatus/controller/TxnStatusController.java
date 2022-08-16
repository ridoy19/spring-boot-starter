package com.mynagad.apiexternal.billpaytxnstatus.controller;

import com.mynagad.apiexternal.billpaytxnstatus.model.BillerTxnStatusRequestByTxnId;
import com.mynagad.apiexternal.billpaytxnstatus.model.dto.BillerTransactionStatusResponse;
import com.mynagad.apiexternal.billpaytxnstatus.service.TransactionStatusImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${application.api-url}")
public class TxnStatusController {

    private TransactionStatusImpl transactionStatus;

    @Autowired
    public TxnStatusController(TransactionStatusImpl transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    @PostMapping("/biller/getDataByTxnId")
    public BillerTransactionStatusResponse getDataByTxnId(@RequestBody BillerTxnStatusRequestByTxnId request)  {
        return transactionStatus.getDataByTxnId(request);
    }
}
