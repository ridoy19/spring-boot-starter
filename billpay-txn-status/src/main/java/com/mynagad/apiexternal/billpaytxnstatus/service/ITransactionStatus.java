package com.mynagad.apiexternal.billpaytxnstatus.service;

import com.mynagad.apiexternal.billpaytxnstatus.model.BillerTxnStatusRequestByTxnId;
import com.mynagad.apiexternal.billpaytxnstatus.model.dto.BillerTransactionStatusResponse;

public interface ITransactionStatus {
    BillerTransactionStatusResponse getDataByTxnId(BillerTxnStatusRequestByTxnId request);
}

