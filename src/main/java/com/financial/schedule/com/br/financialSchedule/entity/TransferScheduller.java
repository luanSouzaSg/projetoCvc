package com.financial.schedule.com.br.financialSchedule.entity;

public class TransferScheduller {
    private String sourceAccount;
    private String destinationAccount;
    private String valueTransfer;
    private String rate;
    private String dateConfirm;
    private String dateTransfer;

    public String getValueTransfer() {
        return valueTransfer;
    }
    public void setValueTransfer(String valueTransfer) {
        this.valueTransfer = valueTransfer;
    }
    public String getSourceAccount() {
        return sourceAccount;
    }
    public void setSourceAccount(String sourceAccount) {
        this.sourceAccount = sourceAccount;
    }
    public String getDestinationAccount() {
        return destinationAccount;
    }
    public void setDestinationAccount(String destinationAccount) {
        this.destinationAccount = destinationAccount;
    }
    public String getRate() {
        return rate;
    }
    public void setRate(String rate) {
        this.rate = rate;
    }
    public String getDateTransfer() {
        return dateTransfer;
    }
    public void setDateTransfer(String dateTransfer) {
        this.dateTransfer = dateTransfer;
    }
    public String getDateConfirm() {
        return dateConfirm;
    }
    public void setDateConfirm(String dateConfirm) {
        this.dateConfirm = dateConfirm;
    }
}
