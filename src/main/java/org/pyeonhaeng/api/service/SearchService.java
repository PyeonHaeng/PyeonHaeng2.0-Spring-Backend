package org.pyeonhaeng.api.service;

import org.pyeonhaeng.api.common.enums.OrderStatus;
import org.pyeonhaeng.api.entity.EventReturnData;

import java.util.List;

public interface SearchService {

    public abstract List<EventReturnData> searchEvent(String name, OrderStatus order, int pageSize, int offset);

}
