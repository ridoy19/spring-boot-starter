package com.nagad.billpaytxnstatus.service;

import com.nagad.billpaytxnstatus.model.TransactionStatusResponseBiller;
import com.nagad.billpaytxnstatus.model.dto.TransactionStatusInfo;

import java.util.List;

public interface ITransactionStatus {
    TransactionStatusResponseBiller getDataByTxnId(String txnId);
}
