package com.mynagad.apiexternal.billpaytxnstatus.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillerTxnStatusRequestByTxnId {
    @NotNull @NotBlank @NotEmpty
    private String serviceId;
    @NotNull @NotBlank @NotEmpty
    private String txnId;
}
