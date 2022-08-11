package com.nagad.billpaytxnstatus.service;

import com.nagad.billpaytxnstatus.model.TransactionStatusResponseBiller;
import com.nagad.billpaytxnstatus.model.dto.TransactionStatusInfo;
import com.nagad.billpaytxnstatus.repository.CustomBillerRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TransactionStatusImpl implements ITransactionStatus{
    private CustomBillerRepositoryImpl repository;

    @Autowired
    public TransactionStatusImpl(CustomBillerRepositoryImpl repository) {
        this.repository = repository;
    }

    @Override
    public TransactionStatusResponseBiller getDataByTxnId(String txnId) {
        List<Map<String, String>> transactionStatusInfoList = repository.getTransactionStatusByTxnId(txnId);
        System.out.println("From TT " + transactionStatusInfoList.get(0).get("TXNAMOUNT"));
        return new TransactionStatusResponseBiller( transactionStatusInfoList.get(0).get("CUSTOMERMOBILENO"), Double.parseDouble(transactionStatusInfoList.get(0).get("TXNAMOUNT")));
    }
}
