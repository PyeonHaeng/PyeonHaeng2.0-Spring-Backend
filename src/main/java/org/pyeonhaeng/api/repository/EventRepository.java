package org.pyeonhaeng.api.repository;

import org.pyeonhaeng.api.common.enums.OrderStatus;
import org.pyeonhaeng.api.entity.EventReturnData;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface EventRepository {

    public abstract List<EventReturnData> searchEventbyName(String name, OrderStatus order, Pageable pageable);

}
