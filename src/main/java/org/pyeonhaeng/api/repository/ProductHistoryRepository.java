package org.pyeonhaeng.api.repository;

import org.pyeonhaeng.api.entity.EventReturnData;

import java.util.List;

public interface ProductHistoryRepository {

    public abstract List<EventReturnData> historyById(int id);
}
