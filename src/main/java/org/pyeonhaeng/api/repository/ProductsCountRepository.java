package org.pyeonhaeng.api.repository;

import org.pyeonhaeng.api.common.enums.PromotionStatus;
import org.pyeonhaeng.api.common.enums.StoreStatus;
import org.pyeonhaeng.api.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsCountRepository extends JpaRepository<EventEntity,Integer> {


    @Query(value = "SELECT COUNT(*) FROM event e INNER JOIN sync_key on e.date = sync_key.month WHERE e.store = :store AND e.tag = :promotion", nativeQuery = true)
    long countByStorePromotion(@Param("store")String storeStatus, @Param("promotion")String promotionStatus);


    @Query(value = "SELECT COUNT(*) FROM event e INNER JOIN sync_key on e.date = sync_key.month WHERE e.store = :store", nativeQuery = true)
    long countByStore(@Param("store") String storeStatus);


}
