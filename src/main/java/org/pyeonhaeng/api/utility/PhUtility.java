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


}
