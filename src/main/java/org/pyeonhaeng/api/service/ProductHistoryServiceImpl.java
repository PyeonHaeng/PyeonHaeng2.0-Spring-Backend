package org.pyeonhaeng.api.service;


import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.pyeonhaeng.api.entity.EventReturnData;
import org.pyeonhaeng.api.repository.ProductHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Builder
@Service
public class ProductHistoryServiceImpl implements ProductHistoryService{

    @Autowired
    private final ProductHistoryRepository productHistoryRepository;


    @Override
    public List<EventReturnData> productHistory(int id){

        List<EventReturnData> eventHistory = productHistoryRepository.historyById(id);

        return eventHistory;
    }
}
