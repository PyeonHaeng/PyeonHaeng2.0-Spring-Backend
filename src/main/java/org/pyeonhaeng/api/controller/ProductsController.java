package org.pyeonhaeng.api.controller;


import lombok.RequiredArgsConstructor;
import org.pyeonhaeng.api.common.enums.OrderStatus;
import org.pyeonhaeng.api.common.enums.PromotionStatus;
import org.pyeonhaeng.api.common.enums.StoreStatus;
import org.pyeonhaeng.api.entity.EventReturnData;
import org.pyeonhaeng.api.model.EventResponse;
import org.pyeonhaeng.api.service.*;
import org.pyeonhaeng.api.utility.PhUtility;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("/v2")
@RestController
public class ProductsController {

    private final ProductsServiceImpl productsServiceImpl;
    private final ProductDetailServiceImpl productDetailServiceImpl;
    private final ProductsCountServiceImpl productsCountServiceImpl;
    private final ProductHistoryServiceImpl productHistoryServiceImpl;


    @GetMapping(value = "products/{product_id}/price-history")
    public ResponseEntity productHistory(@PathVariable("product_id") int productId) throws Exception{

        List<EventReturnData> historyData = productHistoryServiceImpl.productHistory(productId);

        if(historyData.isEmpty()){
            return ResponseEntity.badRequest().body(new EventResponse(0,"Can't find any products.",null));
        }
        else{
            return ResponseEntity.ok(new EventResponse(historyData.size(),null,historyData));

        }
    }


    @RequestMapping(value = "products/count",produces = "application/json")
    public ResponseEntity productCount(
            @RequestParam(value = "store",required = true)String store,
            @RequestParam(value = "promotion",required = true)String promotion
            ) throws Exception{

        PromotionStatus promotionStatus = PromotionStatus.fromDisplayName(promotion);
        StoreStatus storeStatus = StoreStatus.fromDisplayName(store);

        long count = productsCountServiceImpl.productsCount(storeStatus,promotionStatus);

        Map<String, Object> response = new HashMap<>();
        response.put("count",count);

        return ResponseEntity.ok().body(response);

    }


    @GetMapping(value = "products/{product_id}",produces = "application/json")
    public ResponseEntity detailProduct(@PathVariable("product_id") int productId)throws Exception{

        List<EventReturnData> detailData = productDetailServiceImpl.productDetail(productId);

        if(detailData.isEmpty()){
            return ResponseEntity.badRequest().body(new EventResponse(0,"Can't find any products.",null));
        }
        else{
            return ResponseEntity.ok(new EventResponse(detailData.size(),null,detailData));

        }
    }


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
