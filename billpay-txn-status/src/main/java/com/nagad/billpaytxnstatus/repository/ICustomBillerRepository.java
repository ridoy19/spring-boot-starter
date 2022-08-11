package com.nagad.billpaytxnstatus.repository;


import com.nagad.billpaytxnstatus.model.TransactionStatusResponseBiller;
import com.nagad.billpaytxnstatus.model.dto.TransactionStatusInfo;

import java.util.List;
import java.util.Map;

public interface ICustomBillerRepository {
    List <Map<String, String >>  getTransactionStatusByTxnId(String txnId);
}
