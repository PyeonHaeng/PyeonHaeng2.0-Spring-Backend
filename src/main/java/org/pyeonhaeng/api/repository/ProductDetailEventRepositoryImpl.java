package org.pyeonhaeng.api.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import org.pyeonhaeng.api.entity.EventReturnData;
import org.pyeonhaeng.api.entity.QEventEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ProductDetailEventRepositoryImpl implements ProductDetailEventRepository{


    @Autowired
    private EntityManager em;

    @Override
    public List<EventReturnData> searchEventbyId(int id){
        QEventEntity event = QEventEntity.eventEntity;

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


        List<EventReturnData> result = query.fetch();

        return result;
    }
}
