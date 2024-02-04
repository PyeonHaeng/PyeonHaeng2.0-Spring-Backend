package org.pyeonhaeng.api.service;

import org.pyeonhaeng.api.common.enums.OrderStatus;
import org.pyeonhaeng.api.common.enums.PromotionStatus;
import org.pyeonhaeng.api.common.enums.StoreStatus;
import org.pyeonhaeng.api.entity.EventReturnData;

import java.util.List;

public interface ProductsService {

    public abstract List<EventReturnData> productsEvent(StoreStatus store, PromotionStatus promotion, OrderStatus order, int pageSize, int offset);
}
