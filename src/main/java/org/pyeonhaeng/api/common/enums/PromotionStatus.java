package org.pyeonhaeng.api.common.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PromotionStatus {

    ONEPLUSONE("1+1"),
    TWOPLUSONE("2+1"),
    ALL("All"),
    NONE("None");

    private final String displayName;


    PromotionStatus(String displayName){
        this.displayName = displayName;
    }

    @JsonValue
    public String getDisplayName(){
        return displayName;
    }

    public static PromotionStatus fromDisplayName(String displayName){
        for (PromotionStatus status : values()){
            if(status.getDisplayName().equals(displayName)){
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown displayName: " + displayName);
    }

}
