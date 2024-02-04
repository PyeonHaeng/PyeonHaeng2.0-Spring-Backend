package org.pyeonhaeng.api.entity;


import jakarta.persistence.*;
import lombok.*;
import org.pyeonhaeng.api.common.enums.PromotionStatus;
import org.pyeonhaeng.api.common.enums.StoreStatus;
import org.pyeonhaeng.api.converter.PromotionStatusConverter;
import org.pyeonhaeng.api.converter.StoreStatusConverter;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "event")
@Table(name = "event")
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pk;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(nullable = true, length = 200)
    private String img;

    @Column(nullable = false)
    private int price;

    @Column(nullable = true)
    @Convert(converter = StoreStatusConverter.class)
    private StoreStatus store;

    @Column(nullable = true)
    @Convert(converter = PromotionStatusConverter.class)
    private PromotionStatus tag;

    @Column(nullable = true)
    private int proinfo;

    @Column(nullable = true)
    private LocalDate date;


}
