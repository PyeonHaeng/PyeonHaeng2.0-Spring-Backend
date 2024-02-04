package org.pyeonhaeng.api.service;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.pyeonhaeng.api.common.enums.OrderStatus;
import org.pyeonhaeng.api.common.enums.PromotionStatus;
import org.pyeonhaeng.api.common.enums.StoreStatus;
import org.pyeonhaeng.api.entity.EventReturnData;
import org.pyeonhaeng.api.repository.ProductsEventRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Builder
@Service
public class ProductsServiceImpl implements ProductsService{

    @Autowired
    private final ProductsEventRepositoryImpl productsEventRepository;

    @Override
    public List<EventReturnData> productsEvent(StoreStatus store, PromotionStatus promotion, OrderStatus order, int pageSize, int offset){

        List<EventReturnData> selectedEvent = productsEventRepository.productsEventbyCondition(store,promotion,order, PageRequest.of(offset,pageSize));

        return selectedEvent;
    }
}
