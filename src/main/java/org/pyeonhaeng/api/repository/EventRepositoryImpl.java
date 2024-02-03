package org.pyeonhaeng.api.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import org.pyeonhaeng.api.common.enums.OrderStatus;
import org.pyeonhaeng.api.entity.EventReturnData;
import org.pyeonhaeng.api.entity.QEventEntity;
import org.pyeonhaeng.api.entity.QSyncKeyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.List;


@Repository
public class EventRepositoryImpl implements EventRepository{


    @Autowired
    private EntityManager em;

    @Override
    public List<EventReturnData> searchEventbyName(String name, OrderStatus order, Pageable pageable){

        QEventEntity event = QEventEntity.eventEntity;
        QSyncKeyEntity syncKey = QSyncKeyEntity.syncKeyEntity;

        JPAQuery query = new JPAQuery(em);


        BooleanExpression filterCondition = event.name.like("%"+name+"%");

        BooleanExpression synckeyCondition = event.date.eq(syncKey.month);


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

        if(order == OrderStatus.asc){
            query.orderBy(event.price.asc());
        } else if (order == OrderStatus.desc) {
            query.orderBy(event.price.desc());
        }

        query.offset(pageable.getOffset()).limit(pageable.getPageSize());

        List<EventReturnData> result = query.fetch();


        return result;
    }

}
