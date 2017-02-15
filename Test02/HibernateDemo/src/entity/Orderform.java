package entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

/**
 * 商品信息持久化类
 * Created by 黄桂道 on 2017-1-21.
 */
@Entity
public class Orderform {
    private int id;
    private Customer customer;
    private Date tradedate;
    private String status;
    private Double amount;
    private Set<Orderitem> orderitems;

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //多个订单对一个顾客
    @ManyToOne(targetEntity = Customer.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "customer")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Basic
    @Column(name = "tradedate", nullable = true)
    public Date getTradedate() {
        return tradedate;
    }

    public void setTradedate(Date tradedate) {
        this.tradedate = tradedate;
    }

    @Basic
    @Column(name = "status", nullable = true, length = 10)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "amount", nullable = true, precision = 2)
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    //一个订单对多个订单明细
    @OneToMany(fetch = FetchType.LAZY,targetEntity = Orderitem.class)
    @JoinColumn(name = "ORDERID")
    public Set<Orderitem> getOrderitems() {
        return orderitems;
    }

    public void setOrderitems(Set<Orderitem> orderitems) {
        this.orderitems = orderitems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orderform orderform = (Orderform) o;

        if (id != orderform.id) return false;
        if (customer != null ? !customer.equals(orderform.customer) : orderform.customer != null) return false;
        if (tradedate != null ? !tradedate.equals(orderform.tradedate) : orderform.tradedate != null) return false;
        if (status != null ? !status.equals(orderform.status) : orderform.status != null) return false;
        if (amount != null ? !amount.equals(orderform.amount) : orderform.amount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        result = 31 * result + (tradedate != null ? tradedate.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Orderform{" +
                "id=" + id +
                ", customer=" + customer +
                ", tradedate=" + tradedate +
                ", status='" + status + '\'' +
                ", amount=" + amount +
                '}';
    }
}
