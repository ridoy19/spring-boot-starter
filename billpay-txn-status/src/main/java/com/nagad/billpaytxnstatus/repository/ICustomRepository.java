package com.nagad.billpaytxnstatus.repository;

import com.nagad.billpaytxnstatus.models.TransactionStatusResponseBiller;

import java.util.List;


public interface ICustomRepository
        /*extends JpaRepository<TransactionStatusRequestBiller, String>*/ {
    TransactionStatusResponseBiller runNativeQuery(String txnId);
}
