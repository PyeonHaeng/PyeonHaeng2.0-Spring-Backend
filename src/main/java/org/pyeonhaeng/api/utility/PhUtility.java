package org.pyeonhaeng.api.utility;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.pyeonhaeng.api.entity.EventReturnData;

import java.util.List;

@Slf4j
public final class PhUtility {
    private PhUtility(){}


    public static String checkName(String name){
        if ("".equals(name) || name==null){
            return null;
        }
        name = name.replaceAll("[\'\"']", "");
        return name;
    }

    public static String makeSearchResponseJson(List<EventReturnData> entity){
        int count = entity.size();

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("count",count);

        if(count == 0){
            jsonObject.put("message","Can't find any products.");
        }
        else{
            jsonObject.put("products",entity);
        }
        return jsonObject.toString();
    }
}
