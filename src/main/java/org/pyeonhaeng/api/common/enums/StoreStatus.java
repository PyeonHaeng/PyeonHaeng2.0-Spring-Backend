package org.pyeonhaeng.api.common.enums;

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

    public String getDisplayName(){
        return displayName;
    }

}
