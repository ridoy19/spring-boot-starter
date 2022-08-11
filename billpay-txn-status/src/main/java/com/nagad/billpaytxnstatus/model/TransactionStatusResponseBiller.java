package com.nagad.billpaytxnstatus.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionStatusResponseBiller {
    private String customerMobileNo;
    private double txnAmount;
}
