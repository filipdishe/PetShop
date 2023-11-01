package com.filipdishe.PetShop.dto;

import java.time.LocalDateTime;

public class BuyHistoryDto {

    private Long historyLogId;
    private LocalDateTime executionDate;
    private Integer successfulBuys;
    private Integer unsuccessfulBuys;

    public BuyHistoryDto() {
    }

    public BuyHistoryDto(Long historyLogId, LocalDateTime executionDate, Integer successfulBuys, Integer unsuccessfulBuys) {
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
