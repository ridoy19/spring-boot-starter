package com.nagad.billpaytxnstatus.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionStatusResponseBiller {
    private String txnId;
//    private String txnAmount;
//    private String paymentChannel;
//    private String txnStatus;
//    private String txnDateTime;
//    private String customerMobileNo;
//    private String merchantWalletNo;
//    private String reference;
//    private String paymentFor;
}
