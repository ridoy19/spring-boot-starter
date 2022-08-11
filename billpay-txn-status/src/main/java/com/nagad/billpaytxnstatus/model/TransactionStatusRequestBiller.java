package com.nagad.billpaytxnstatus.model;

import lombok.Data;

import javax.persistence.Column;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
/*@Entity*/
public class TransactionStatusRequestBiller {
    @Column(nullable = false, unique = true)
   // @Id
    private String txnId;
    private String startDateTime;
    private String endDateTime;

    public TransactionStatusRequestBiller() {
    }
}
