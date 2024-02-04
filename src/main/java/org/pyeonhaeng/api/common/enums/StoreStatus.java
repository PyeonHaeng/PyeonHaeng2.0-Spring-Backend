package org.pyeonhaeng.api.common.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum StoreStatus {
    GS25("GS25"),
    CU("CU"),
    SEVEN_ELEVEN("7-ELEVEn"),
    MINISTOP("MINISTOP"),
    emart24("emart24");

    private final String displayName;

    StoreStatus(String displayName){
        this.displayName = displayName;
    }

    @JsonValue
    public String getDisplayName(){
        return displayName;
    }

    public static StoreStatus fromDisplayName(String displayName){
        for (StoreStatus status : values()){
            if(status.getDisplayName().equals(displayName)){
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown displayName: " + displayName);
    }

}
