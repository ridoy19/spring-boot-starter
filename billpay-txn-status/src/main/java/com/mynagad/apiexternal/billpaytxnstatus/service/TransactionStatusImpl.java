package com.mynagad.apiexternal.billpaytxnstatus.service;

import com.mynagad.apiexternal.billpaytxnstatus.model.BillerTxnStatusRequestByTxnId;
import com.mynagad.apiexternal.billpaytxnstatus.model.dto.BillerTransactionStatusResponse;

import com.mynagad.apiexternal.billpaytxnstatus.repository.CustomBillerRepositoryImpl;
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
    public BillerTransactionStatusResponse getDataByTxnId(BillerTxnStatusRequestByTxnId request) {
        repository.getBillerTableName(request.getServiceId())
        List<Map<String, String>> transactionStatusInfoList = repository.getTransactionStatusByTxnId(request.getServiceId(), request.getTxnId());
        return new BillerTransactionStatusResponse(transactionStatusInfoList.get(0).get("TXNID"),
                transactionStatusInfoList.get(0).get("TXNTIME"), Double.parseDouble(transactionStatusInfoList.get(0).get("TXNAMOUNT")), transactionStatusInfoList.get(0).get("CUSTOMERMOBILENO"));
    }
}
