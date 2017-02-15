package entity;

import javax.persistence.*;

/**
 * 商品详细信息持久化类
 * Created by 黄桂道 on 2017-1-21.
 */
@Entity
public class Orderitem {
    private int id;
    private Orderform orderid;
    private Commodity commodity;
    private Double discount;
    private Double actprice;
    private Double amount;

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //多个订单明细对一个订单表
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDERID")
    public Orderform getOrderid() {
        return orderid;
    }

    public void setOrderid(Orderform orderid) {
        this.orderid = orderid;
    }

    //多个订单明细对一个商品
    @ManyToOne(targetEntity = Commodity.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "COMMODITY")
    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    @Basic
    @Column(name = "DISCOUNT", nullable = true, precision = 2)
    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    @Basic
    @Column(name = "ACTPRICE", nullable = true, precision = 2)
    public Double getActprice() {
        return actprice;
    }

    public void setActprice(Double actprice) {
        this.actprice = actprice;
    }

    @Basic
    @Column(name = "AMOUNT", nullable = true, precision = 2)
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orderitem orderitem = (Orderitem) o;

        if (id != orderitem.id) return false;
        if (orderid != null ? !orderid.equals(orderitem.orderid) : orderitem.orderid != null) return false;
        if (commodity != null ? !commodity.equals(orderitem.commodity) : orderitem.commodity != null) return false;
        if (discount != null ? !discount.equals(orderitem.discount) : orderitem.discount != null) return false;
        if (actprice != null ? !actprice.equals(orderitem.actprice) : orderitem.actprice != null) return false;
        if (amount != null ? !amount.equals(orderitem.amount) : orderitem.amount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (orderid != null ? orderid.hashCode() : 0);
        result = 31 * result + (commodity != null ? commodity.hashCode() : 0);
        result = 31 * result + (discount != null ? discount.hashCode() : 0);
        result = 31 * result + (actprice != null ? actprice.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        return result;

    }

    @Override
    public String toString() {
        return "Orderitem{" +
                "id=" + id +
                ", orderid=" + orderid +
                ", commodity=" + commodity +
                ", discount=" + discount +
                ", actprice=" + actprice +
                ", amount=" + amount +
                '}';
    }
}
