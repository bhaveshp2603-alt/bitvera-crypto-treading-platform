package com.bhavesh.service;

import com.bhavesh.domain.WalletTransactionType;
import com.bhavesh.modal.Wallet;
import com.bhavesh.modal.WalletTransaction;

import java.util.List;

public interface TransactionService {

    List<WalletTransaction> getTransactionsByWallet(Wallet wallet);

    WalletTransaction createTransaction(
            Wallet wallet,
            WalletTransactionType type,
            String transferId,
            String purpose,
            Long amount
    );
}
