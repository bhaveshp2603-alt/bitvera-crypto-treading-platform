package com.bhavesh.service;

import com.bhavesh.domain.WalletTransactionType;
import com.bhavesh.modal.Wallet;
import com.bhavesh.modal.WalletTransaction;
import com.bhavesh.repository.WalletTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    private WalletTransactionRepository walletTransactionRepository;

    @Override
    public List<WalletTransaction> getTransactionsByWallet(Wallet wallet) {
        return walletTransactionRepository.findByWallet(wallet);
    }

    @Override
    public WalletTransaction createTransaction(Wallet wallet,
                                               WalletTransactionType type,
                                               String transferId,
                                               String purpose,
                                               Long amount) {
        WalletTransaction transaction = new WalletTransaction();

        transaction.setWallet(wallet);
        transaction.setType(type);
        transaction.setTransferId(transferId);
        transaction.setPurpose(purpose);
        transaction.setAmount(amount);
        transaction.setDate(java.time.LocalDate.now());

        return walletTransactionRepository.save(transaction);
    }
}
