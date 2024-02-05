package org.pyeonhaeng.api.service;


import org.pyeonhaeng.api.common.enums.PromotionStatus;
import org.pyeonhaeng.api.common.enums.StoreStatus;
import org.pyeonhaeng.api.entity.EventReturnData;

import java.util.List;


public interface ProductsCountService {
    public abstract long productsCount(StoreStatus storeStatus, PromotionStatus promotionStatus);

}
