package springboot.springbootjpa.intergrationQueryDSL.entity;

import javax.persistence.*;

@Entity
@Table(name = "good_type")
public class GoodsType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private Long TypeID;


    @Column(name = "type_name")
    private String TypeName;

    @Column(name = "type_is_how")
    private int TypeISHow;

    @Column(name = "type_order")
    private int TypeOrder;


    public GoodsType() {
    }

    public GoodsType(String typeName, int typeISHow, int typeOrder) {
        TypeName = typeName;
        TypeISHow = typeISHow;
        TypeOrder = typeOrder;
    }

    public Long getTypeID() {
        return TypeID;
    }

    public void setTypeID(Long typeID) {
        TypeID = typeID;
    }

    public String getTypeName() {
        return TypeName;
    }

    public void setTypeName(String typeName) {
        TypeName = typeName;
    }

    public int getTypeISHow() {
        return TypeISHow;
    }

    public void setTypeISHow(int typeISHow) {
        TypeISHow = typeISHow;
    }

    public int getTypeOrder() {
        return TypeOrder;
    }

    public void setTypeOrder(int typeOrder) {
        TypeOrder = typeOrder;
    }

    @Override
    public String toString() {
        return "GoodsType{" +
                "TypeID=" + TypeID +
                ", TypeName='" + TypeName + '\'' +
                ", TypeISHow=" + TypeISHow +
                ", TypeOrder=" + TypeOrder +
                '}';
    }
}
