package org.pyeonhaeng.api.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.pyeonhaeng.api.common.enums.StoreStatus;

@Converter(autoApply = true)
public class StoreStatusConverter implements AttributeConverter<StoreStatus,String> {

    @Override
    public String convertToDatabaseColumn(StoreStatus attribute){
        if (attribute == null){
            return null;
        }
        return attribute.getDisplayName();
    }


    @Override
    public StoreStatus convertToEntityAttribute(String dbData){
        if (dbData == null){
            return null;
        }

        for (StoreStatus status : StoreStatus.values()){
            if(status.getDisplayName().equals(dbData)){
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown database value: " + dbData);
    }
}
