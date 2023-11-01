package com.filipdishe.PetShop.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "buy_history")
public class BuyHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long historyLogId;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime executionDate;

    private Integer successfulBuys;
    private Integer unsuccessfulBuys;

    public BuyHistory() {
    }

    public BuyHistory(Long historyLogId, LocalDateTime executionDate, Integer successfulBuys, Integer unsuccessfulBuys) {
        this.historyLogId = historyLogId;
        this.executionDate = executionDate;
        this.successfulBuys = successfulBuys;
        this.unsuccessfulBuys = unsuccessfulBuys;
    }

    public Long getHistoryLogId() {
        return historyLogId;
    }

    public void setHistoryLogId(Long historyLogId) {
        this.historyLogId = historyLogId;
    }

    public LocalDateTime getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(LocalDateTime executionDate) {
        this.executionDate = executionDate;
    }

    public Integer getSuccessfulBuys() {
        return successfulBuys;
    }

    public void setSuccessfulBuys(Integer successfulBuys) {
        this.successfulBuys = successfulBuys;
    }

    public Integer getUnsuccessfulBuys() {
        return unsuccessfulBuys;
    }

    public void setUnsuccessfulBuys(Integer unsuccessfulBuys) {
        this.unsuccessfulBuys = unsuccessfulBuys;
    }
}
