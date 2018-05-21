package springboot.springbootjpa.intergrationQueryDSL.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "good_info")
public class GoodsInformation  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "good_id")
    private Long GoodID;

    @Column(name = "good_title")
    private String GoodTitle;

    @Column(name = "good_price")
    private double GoodPrice;

    @Column(name = "good_unit")
    private String GoodUnit;

    @Column(name = "good_order")
    private String GoodOrder;

    @OneToOne     //@OneToOne（一对一）关联
    @JoinColumn(name = "good_type_id")
    private GoodsType goodsType;

    public GoodsInformation() {

    }

    public Long getGoodID() {
        return GoodID;
    }

    public void setGoodID(Long goodID) {
        GoodID = goodID;
    }

    public String getGoodTitle() {
        return GoodTitle;
    }

    public void setGoodTitle(String goodTitle) {
        GoodTitle = goodTitle;
    }

    public double getGoodPrice() {
        return GoodPrice;
    }

    public void setGoodPrice(double goodPrice) {
        GoodPrice = goodPrice;
    }

    public String getGoodUnit() {
        return GoodUnit;
    }

    public void setGoodUnit(String goodUnit) {
        GoodUnit = goodUnit;
    }

    public String getGoodOrder() {
        return GoodOrder;
    }

    public void setGoodOrder(String goodOrder) {
        GoodOrder = goodOrder;
    }

    public GoodsType getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(GoodsType goodsType) {
        this.goodsType = goodsType;
    }

    public GoodsInformation(String goodTitle, double goodPrice, String goodUnit, String goodOrder, GoodsType goodsType) {
        GoodTitle = goodTitle;
        GoodPrice = goodPrice;
        GoodUnit = goodUnit;
        GoodOrder = goodOrder;
        this.goodsType = goodsType;
    }

    @Override
    public String toString() {
        return "GoodsInformation{" +
                "GoodID=" + GoodID +
                ", GoodTitle='" + GoodTitle + '\'' +
                ", GoodPrice=" + GoodPrice +
                ", GoodUnit='" + GoodUnit + '\'' +
                ", GoodOrder='" + GoodOrder + '\'' +
                ", goodsType=" + goodsType +
                '}';
    }


}
