package org.pyeonhaeng.api.service;

import org.pyeonhaeng.api.entity.EventReturnData;

import java.util.List;

public interface ProductHistoryService {

    public abstract List<EventReturnData> productHistory(int id);
}
