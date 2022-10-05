package com.interview;

public class DigitalWallet {
    private String walletId;
    private String userName;
    private String userAccessCode;
    private int walletBalance;

    public DigitalWallet(String walletId, String userName) {
        this.walletId = walletId;
        this.userName = userName;
    }

    public DigitalWallet(String walletId, String userName, String userAccessCode) {
        this.walletId = walletId;
        this.userName = userName;
        this.userAccessCode = userAccessCode;
    }

    public String getWalletId() {
        return walletId;
    }

    public String getUsername() {
        return userName;
    }

    public String getUserAccessToken() {
        return userAccessCode;
    }

    public int getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(int walletBalance) {
        this.walletBalance = walletBalance;
    }

    @Override
    public String toString() {
        return "DigitalWallet{" +
                "walletId='" + walletId + '\'' +
                ", userName='" + userName + '\'' +
                ", userAccessCode='" + userAccessCode + '\'' +
                ", walletBalance=" + walletBalance +
                '}';
    }
}
