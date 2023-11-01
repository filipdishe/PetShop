package com.filipdishe.PetShop.service;

import com.filipdishe.PetShop.dto.BuyHistoryDto;

import java.util.List;

/**
 * This class is responsible for getting history logs about purchase of pets.
 */
public interface BuyHistoryService {

    /**
     * Get all history logs about purchase of pets.
     */
    List<BuyHistoryDto> getHistoryLog();
}
