package com.filipdishe.PetShop.mapper;

import com.filipdishe.PetShop.dto.BuyHistoryDto;
import com.filipdishe.PetShop.model.BuyHistory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BuyHistoryMapper {

    BuyHistoryDto buyHistoryToBuyHistoryDto(BuyHistory buyHistory);

    BuyHistory buyHistoryDtoToBuyHistory(BuyHistoryDto buyHistoryDto);
}
