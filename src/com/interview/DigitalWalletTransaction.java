package com.interview;

public class DigitalWalletTransaction {

    private DigitalWallet digitalWallet;

    void addMoney(DigitalWallet digitalWallet, int amount) throws TransactionException {
        if(digitalWallet.getUserAccessToken().isEmpty()) {
            throw new TransactionException("USER_NOT_AUTHORIZED", "User not Authorized");
        }
        if(amount <=0) {
            throw new TransactionException("INVALID_AMOUNT", "Amount should be greater than zero");
        }
        int walletBalance = digitalWallet.getWalletBalance();
        digitalWallet.setWalletBalance(walletBalance + amount);
    }

    void payMoney(DigitalWallet digitalWallet, int amount) throws TransactionException {
        if(digitalWallet.getUserAccessToken().isEmpty()) {
            throw new TransactionException("USER_NOT_AUTHORIZED", "User not Authorized");
        }
        if(amount <=0) {
            throw new TransactionException("INVALID_AMOUNT", "Amount should be greater than zero");
        }
        int walletBalance = digitalWallet.getWalletBalance();
        if(walletBalance < amount) {
            throw new TransactionException("INSUFFICIENT_BALANCE", "Insufficient balance");
        }
        digitalWallet.setWalletBalance(walletBalance - amount);
    }
}
