package com.bhavesh.repository;

import com.bhavesh.modal.Wallet;
import com.bhavesh.modal.WalletTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WalletTransactionRepository extends JpaRepository<WalletTransaction,Long> {

    List<WalletTransaction> findByWallet(Wallet wallet);
}
