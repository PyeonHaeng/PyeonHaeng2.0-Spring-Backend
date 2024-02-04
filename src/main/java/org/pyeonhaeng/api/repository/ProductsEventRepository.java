package org.pyeonhaeng.api.repository;

import org.pyeonhaeng.api.common.enums.OrderStatus;
import org.pyeonhaeng.api.common.enums.PromotionStatus;
import org.pyeonhaeng.api.common.enums.StoreStatus;
import org.pyeonhaeng.api.entity.EventReturnData;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductsEventRepository {

    public abstract List<EventReturnData> productsEventbyCondition(StoreStatus store, PromotionStatus promotion, OrderStatus order, Pageable pageable);
}
