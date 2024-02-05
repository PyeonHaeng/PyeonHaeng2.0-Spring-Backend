package org.pyeonhaeng.api.repository;


import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import org.pyeonhaeng.api.common.enums.StoreStatus;
import org.pyeonhaeng.api.entity.EventReturnData;
import org.pyeonhaeng.api.entity.QEventEntity;
import org.pyeonhaeng.api.entity.QSyncKeyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductHistoryRepositoryImpl implements ProductHistoryRepository{

    @Autowired
    private EntityManager em;


    public List<EventReturnData> historyById(int id) {
        QEventEntity event = QEventEntity.eventEntity;
        QSyncKeyEntity syncKey = QSyncKeyEntity.syncKeyEntity;


        JPAQuery query = new JPAQuery(em);

        BooleanExpression filterCondition = event.pk.eq(id);

        query.select(Projections.fields(EventReturnData.class,
                        event.pk,
                        event.name,
                        event.img,
                        event.tag,
                        event.date,
                        event.price,
                        event.proinfo,
                        event.store)
                )
                .from(event)
                .where(filterCondition);


        List<EventReturnData> item = query.fetch();

        if(item.isEmpty()){
            return null;
        }
        String productName = item.get(0).getName();
        StoreStatus cvsName= item.get(0).getStore();


        filterCondition = event.name.eq(productName).and(event.store.eq(cvsName));


        BooleanExpression synckeyCondition = event.date.ne(syncKey.month);

        query = new JPAQuery(em);

        query.select(Projections.fields(EventReturnData.class,
                        event.pk,
                        event.name,
                        event.img,
                        event.tag,
                        event.date,
                        event.price,
                        event.proinfo,
                        event.store)
                )
                .from(event)
                .innerJoin(syncKey)
                .on(synckeyCondition)
                .where(filterCondition);


        query.orderBy(event.date.desc());

        List<EventReturnData> result = query.fetch();

        return result;
    }

}
