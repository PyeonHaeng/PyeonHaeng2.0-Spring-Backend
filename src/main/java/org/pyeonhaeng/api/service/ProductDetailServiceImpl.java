package org.pyeonhaeng.api.service;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.pyeonhaeng.api.entity.EventReturnData;
import org.pyeonhaeng.api.repository.ProductDetailEventRepository;
import org.pyeonhaeng.api.repository.ProductDetailEventRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Builder
@Service
public class ProductDetailServiceImpl implements ProductDetailService{

    @Autowired
    private final ProductDetailEventRepositoryImpl productDetailEventRepositoryImpl;

    @Override
    public List<EventReturnData> productDetail(int id){

        List<EventReturnData> selectedEvent = productDetailEventRepositoryImpl.searchEventbyId(id);

        return selectedEvent;
    }
}
