package org.pyeonhaeng.api.service;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.pyeonhaeng.api.common.enums.OrderStatus;
import org.pyeonhaeng.api.entity.EventReturnData;
import org.pyeonhaeng.api.repository.EventRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Builder
@Service
public class SearchServiceImpl implements SearchService{

        @Autowired
        private final EventRepositoryImpl eventRepository;

        @Override
        public List<EventReturnData> searchEvent(String name, OrderStatus order, int pageSize, int offset){

                List<EventReturnData> selectedEvent = eventRepository.searchEventbyName(name,order, PageRequest.of(offset,pageSize));

                return selectedEvent;
        }
}
