package com.nagad.billpaytxnstatus.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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
