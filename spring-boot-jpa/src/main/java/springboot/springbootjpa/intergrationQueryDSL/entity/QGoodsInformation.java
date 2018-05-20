package springboot.springbootjpa.intergrationQueryDSL.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGoodsInformation is a Querydsl query type for GoodsInformation
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QGoodsInformation extends EntityPathBase<GoodsInformation> {

    private static final long serialVersionUID = -1506826025L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGoodsInformation goodsInformation = new QGoodsInformation("goodsInformation");

    public final NumberPath<Long> GoodID = createNumber("GoodID", Long.class);

    public final StringPath GoodOrder = createString("GoodOrder");

    public final NumberPath<Double> GoodPrice = createNumber("GoodPrice", Double.class);

    public final QGoodsType goodsType;

    public final StringPath GoodTitle = createString("GoodTitle");

    public final StringPath GoodUnit = createString("GoodUnit");

    public QGoodsInformation(String variable) {
        this(GoodsInformation.class, forVariable(variable), INITS);
    }

    public QGoodsInformation(Path<? extends GoodsInformation> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGoodsInformation(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGoodsInformation(PathMetadata metadata, PathInits inits) {
        this(GoodsInformation.class, metadata, inits);
    }

    public QGoodsInformation(Class<? extends GoodsInformation> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.goodsType = inits.isInitialized("goodsType") ? new QGoodsType(forProperty("goodsType")) : null;
    }

}

