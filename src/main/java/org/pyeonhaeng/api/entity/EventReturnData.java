package org.pyeonhaeng.api.entity;


import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Data;
import org.pyeonhaeng.api.common.enums.PromotionStatus;
import org.pyeonhaeng.api.common.enums.StoreStatus;

import java.time.LocalDate;

@Data
public class EventReturnData {

    @Id
    private int pk;

    private String name;

    private String img;

    private int price;

    @Enumerated(EnumType.STRING)
    private StoreStatus store;

    @Enumerated(EnumType.STRING)
    private PromotionStatus tag;

    private int proinfo;

    private LocalDate date;
}
