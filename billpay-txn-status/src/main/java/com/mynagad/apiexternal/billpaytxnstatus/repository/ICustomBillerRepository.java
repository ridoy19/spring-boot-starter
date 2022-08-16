package com.mynagad.apiexternal.billpaytxnstatus.repository;


import com.mynagad.apiexternal.billpaytxnstatus.model.dto.BillerTransactionStatusResponse;

import java.util.List;
import java.util.Map;

public interface ICustomBillerRepository {
    List <Map<String, String >>  getTransactionStatusByTxnId(String billerTableName, String txnId);
    String getBillerTableName(String serviceId);
}
