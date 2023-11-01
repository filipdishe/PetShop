package com.filipdishe.PetShop.service;

import com.filipdishe.PetShop.dto.BuyHistoryDto;
import com.filipdishe.PetShop.mapper.BuyHistoryMapper;
import com.filipdishe.PetShop.repository.BuyHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BuyHistoryServiceImpl implements BuyHistoryService{

    private final BuyHistoryRepository buyHistoryRepository;

    private final BuyHistoryMapper buyHistoryMapper;

    @Autowired
    public BuyHistoryServiceImpl(BuyHistoryRepository buyHistoryRepository, BuyHistoryMapper buyHistoryMapper) {
        this.buyHistoryRepository = buyHistoryRepository;
        this.buyHistoryMapper = buyHistoryMapper;
    }

    @Override
    public List<BuyHistoryDto> getHistoryLog() {
        return buyHistoryRepository.findAll()
                .stream()
                .map(buyHistory -> buyHistoryMapper.buyHistoryToBuyHistoryDto(buyHistory))
                .collect(Collectors.toList());
    }
}
