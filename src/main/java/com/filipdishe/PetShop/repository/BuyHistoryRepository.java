package com.filipdishe.PetShop.repository;

import com.filipdishe.PetShop.model.BuyHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyHistoryRepository extends JpaRepository<BuyHistory, Long> {
}
