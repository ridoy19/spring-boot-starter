package com.mynagad.apiexternal.billpaytxnstatus.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.Query;

@Data
//@NoArgsConstructor
@AllArgsConstructor
public class BillerTransactionStatusResponse {
    private String txnId;
    private String txnTime;
    private double txnAmount;
    private String customerMobileNo;
}
