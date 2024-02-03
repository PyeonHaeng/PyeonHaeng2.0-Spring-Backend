package org.pyeonhaeng.api.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.pyeonhaeng.api.common.enums.PromotionStatus;


@Converter(autoApply = true)
public class PromotionStatusConverter implements AttributeConverter<PromotionStatus,String> {

    @Override
    public String convertToDatabaseColumn(PromotionStatus attribute){
        if (attribute == null){
            return null;
        }
        return attribute.getDisplayName();
    }


    @Override
    public PromotionStatus convertToEntityAttribute(String dbData){
        if (dbData == null){
            return null;
        }

        for (PromotionStatus status : PromotionStatus.values()){
            if(status.getDisplayName().equals(dbData)){
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown database value: " + dbData);
    }
}
