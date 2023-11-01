package com.filipdishe.PetShop.controller;

import com.filipdishe.PetShop.dto.BuyHistoryDto;
import com.filipdishe.PetShop.service.BuyHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/history")
public class BuyHistoryController {

    private final BuyHistoryService buyHistoryService;

    @Autowired
    public BuyHistoryController(BuyHistoryService buyHistoryService) {
        this.buyHistoryService = buyHistoryService;
    }

    @GetMapping("/history-log")
    public ResponseEntity<List<BuyHistoryDto>> listHistoryLog() {
        List<BuyHistoryDto> allHistoryLog = buyHistoryService.getHistoryLog();

        if(allHistoryLog.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(allHistoryLog);
        }
    }
}
