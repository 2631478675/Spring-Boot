package springboot.springbootjpa.intergrationQueryDSL.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QGoodsType is a Querydsl query type for GoodsType
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QGoodsType extends EntityPathBase<GoodsType> {

    private static final long serialVersionUID = 944199151L;

    public static final QGoodsType goodsType = new QGoodsType("goodsType");

    public final NumberPath<Long> TypeID = createNumber("TypeID", Long.class);

    public final NumberPath<Integer> TypeISHow = createNumber("TypeISHow", Integer.class);

    public final StringPath TypeName = createString("TypeName");

    public final NumberPath<Integer> TypeOrder = createNumber("TypeOrder", Integer.class);

    public QGoodsType(String variable) {
        super(GoodsType.class, forVariable(variable));
    }

    public QGoodsType(Path<? extends GoodsType> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGoodsType(PathMetadata metadata) {
        super(GoodsType.class, metadata);
    }

}

