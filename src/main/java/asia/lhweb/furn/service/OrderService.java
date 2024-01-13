package asia.lhweb.furn.service;


import asia.lhweb.furn.bean.Furn;
import asia.lhweb.furn.bean.Member;
import asia.lhweb.furn.bean.Order;

import java.util.List;

/**
 * 订单服务
 *
 * @author Administrator
 * @description 针对表【Order】的数据库操作Service
 * @createDate 2024-01-12 20:54:18
 */
public interface OrderService {
    /**
     * 保存
     * 保存家居到数据库
     *
     * @param order 订单
     */
    void save(Order order);

    /**
     * 找到所有
     *
     * @return {@link List}<{@link Order}>
     */
    List<Order> findAll();

    /**
     * 更新
     *
     * @param order 订单
     */
    void update(Order order);

    /**
     * 删除通过id
     *
     * @param id id
     */
    void delById(Integer id);
    /**
     * 按条件查找
     *
     * @param name 名字
     * @return {@link List}<{@link Member}>
     */
    List<Order> findByCondition(String name);
}
