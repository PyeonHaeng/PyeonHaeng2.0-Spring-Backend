package org.pyeonhaeng.api.service;

import org.pyeonhaeng.api.entity.EventReturnData;

import java.util.List;

public interface ProductDetailService {

    public abstract List<EventReturnData> productDetail(int id);
}
