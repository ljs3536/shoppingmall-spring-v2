package com.hertz.shoppingMall.review.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReview is a Querydsl query type for Review
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReview extends EntityPathBase<Review> {

    private static final long serialVersionUID = -1178807391L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReview review = new QReview("review");

    public final com.hertz.shoppingMall.config.jpa.QBaseDateEntity _super = new com.hertz.shoppingMall.config.jpa.QBaseDateEntity(this);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDateTime = _super.createdDateTime;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.hertz.shoppingMall.member.model.QMember member;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDateTime = _super.modifiedDateTime;

    public final com.hertz.shoppingMall.order.model.QOrderItem orderItem;

    public final com.hertz.shoppingMall.product.model.QProduct product;

    public final NumberPath<Integer> rating = createNumber("rating", Integer.class);

    public QReview(String variable) {
        this(Review.class, forVariable(variable), INITS);
    }

    public QReview(Path<? extends Review> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReview(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReview(PathMetadata metadata, PathInits inits) {
        this(Review.class, metadata, inits);
    }

    public QReview(Class<? extends Review> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new com.hertz.shoppingMall.member.model.QMember(forProperty("member")) : null;
        this.orderItem = inits.isInitialized("orderItem") ? new com.hertz.shoppingMall.order.model.QOrderItem(forProperty("orderItem"), inits.get("orderItem")) : null;
        this.product = inits.isInitialized("product") ? new com.hertz.shoppingMall.product.model.QProduct(forProperty("product"), inits.get("product")) : null;
    }

}

