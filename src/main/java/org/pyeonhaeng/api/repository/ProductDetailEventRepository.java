package org.pyeonhaeng.api.repository;

import org.pyeonhaeng.api.entity.EventReturnData;

import java.util.List;

public interface ProductDetailEventRepository {

    public abstract List<EventReturnData> searchEventbyId(int id);
}
