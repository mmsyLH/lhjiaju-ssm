package asia.lhweb.furn.bean;

import java.util.Date;
import java.math.BigDecimal;

/**
 * 订单

 *
 * @author 罗汉
 * @date 2024/01/13
 */
public class Order{
    private String id;
    private Date createTime;
    private BigDecimal price;
    private Integer status;
    private Integer memberId;
    private String address;

    public Order() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}