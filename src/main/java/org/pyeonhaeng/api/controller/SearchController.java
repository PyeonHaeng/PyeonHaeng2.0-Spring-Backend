package org.pyeonhaeng.api.controller;


import lombok.RequiredArgsConstructor;
import org.pyeonhaeng.api.common.enums.OrderStatus;
import org.pyeonhaeng.api.entity.EventReturnData;
import org.pyeonhaeng.api.service.SearchServiceImpl;
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
public class SearchController {

    private final SearchServiceImpl searchServiceImpl;

    @RequestMapping(value = "search",produces = "application/json")
    public ResponseEntity searchItem(
            @RequestParam(value = "product_name",required = true) String name,
            @RequestParam(value = "order",required = false,defaultValue = "normal") OrderStatus order,
            @RequestParam(value = "page_size",required = false,defaultValue = "10") int pageSize,
            @RequestParam(value = "offset",required = false,defaultValue = "0") int offset
            )throws Exception{


        String processedName = PhUtility.checkName(name);

        if(order == OrderStatus.normal){
            order = null;
        }

        if(pageSize<=0){
            pageSize = 1;
        }
        if(offset<0){
            offset=0;
        }

        List<EventReturnData> searchData = searchServiceImpl.searchEvent(processedName,order,pageSize,offset);

        String result = PhUtility.makeSearchResponseJson(searchData);

        int responseCount = searchData.size();

        if(responseCount == 0 ){
            return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
        }
        else{
            return new ResponseEntity(result, HttpStatus.OK);
        }


    }





}
