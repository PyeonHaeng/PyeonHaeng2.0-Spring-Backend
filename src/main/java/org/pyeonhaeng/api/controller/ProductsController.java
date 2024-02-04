package org.pyeonhaeng.api.controller;


import lombok.RequiredArgsConstructor;
import org.pyeonhaeng.api.common.enums.OrderStatus;
import org.pyeonhaeng.api.common.enums.PromotionStatus;
import org.pyeonhaeng.api.common.enums.StoreStatus;
import org.pyeonhaeng.api.entity.EventReturnData;
import org.pyeonhaeng.api.model.EventResponse;
import org.pyeonhaeng.api.service.ProductsServiceImpl;
import org.pyeonhaeng.api.utility.PhUtility;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/v2")
@RestController
public class ProductsController {

    private final ProductsServiceImpl productsServiceImpl;


    @RequestMapping(value = "products",produces = "application/json")
    public ResponseEntity productsEvent(
            @RequestParam(value = "store", required = true)String store,
            @RequestParam(value = "promotion",required = true)String promotion,
            @RequestParam(value = "order",required = false)OrderStatus order,
            @RequestParam(value = "page_size", required = false,defaultValue = "10") int pageSize,
            @RequestParam(value = "offset",required = false,defaultValue = "0") int offset
            ) throws Exception{

        PromotionStatus promotionStatus;
        StoreStatus storeStatus;

        promotionStatus = PromotionStatus.fromDisplayName(promotion);
        storeStatus = StoreStatus.fromDisplayName(store);

        if(order == OrderStatus.normal){
            order = null;
        }

        if(pageSize<=0){
            pageSize = 1;
        }

        if(offset<0){
            offset = 0;
        }

        if (promotionStatus == PromotionStatus.NONE || promotionStatus == PromotionStatus.ALL){
            promotion = null;
        }

        List<EventReturnData> productsData = productsServiceImpl.productsEvent(storeStatus,promotionStatus,order,pageSize,offset);


        if(productsData.isEmpty()){
            return ResponseEntity.badRequest().body(new EventResponse(0,"Can't find any products.",null));
        }
        else{
            return ResponseEntity.ok(new EventResponse(productsData.size(),null,productsData));

        }

    }
}
