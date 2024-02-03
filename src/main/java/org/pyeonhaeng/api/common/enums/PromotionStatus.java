package org.pyeonhaeng.api.common.enums;

public enum PromotionStatus {
    ALL("All"),
    NONE("None"),
    ONEPLUSONE("1+1"),
    TWOPLUSONE("2+1");

    private final String displayName;

    PromotionStatus(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName(){
        return displayName;
    }

}
