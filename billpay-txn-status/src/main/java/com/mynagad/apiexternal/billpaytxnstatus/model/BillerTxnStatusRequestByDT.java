package com.mynagad.apiexternal.billpaytxnstatus.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillerTxnStatusRequestByDT {
    private String serviceId;
    private String startDateTime;
    private String endDateTime;
}
