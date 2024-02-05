package org.pyeonhaeng.api.service;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.pyeonhaeng.api.common.enums.PromotionStatus;
import org.pyeonhaeng.api.common.enums.StoreStatus;
import org.pyeonhaeng.api.entity.EventReturnData;
import org.pyeonhaeng.api.repository.ProductsCountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Builder
@Service
public class ProductsCountServiceImpl implements ProductsCountService{

    @Autowired
    private final ProductsCountRepository productsCountRepository;

    @Override
    public long productsCount(StoreStatus storeStatus, PromotionStatus promotionStatus){

        if (promotionStatus == PromotionStatus.NONE || promotionStatus == PromotionStatus.ALL){
            return productsCountRepository.countByStore(storeStatus.getDisplayName());
        }
        else{
            return productsCountRepository.countByStorePromotion(storeStatus.getDisplayName(),promotionStatus.getDisplayName());
        }

    }
}
