package asia.lhweb.furn.service.impl;

import asia.lhweb.furn.bean.*;
import asia.lhweb.furn.dao.MemberMapper;
import asia.lhweb.furn.dao.OrderMapper;
import asia.lhweb.furn.service.MemberService;
import asia.lhweb.furn.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author :罗汉
 * @date : 2024/1/12
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;

    /**
     * 保存
     *
     * @param order 订单
     */
    @Override
    public void save(Order order) {
        orderMapper.insertSelective(order);
    }

    /**
     * 找到所有会员
     *
     * @return {@link List}<{@link Furn}>
     */
    @Override
    public List<Order> findAll() {
        return  orderMapper.selectByExample(null);
    }

    /**
     * 更新
     *
     * @param order 订单
     */
    @Override
    public void update(Order order) {
        orderMapper.updateByPrimaryKeySelective(order);
    }

    /**
     * 删除通过id
     *
     * @param id id
     */
    @Override
    public void delById(Integer id) {
        orderMapper.deleteByPrimaryKey(id);
    }

    /**
     * 按条件查找
     *
     * @param name 名字
     * @return {@link List}<{@link Member}>
     */
    @Override
    public List<Order> findByCondition(String name) {
        OrderExample memberExample = new OrderExample();
        //通过Criteria可以设置查询的条件
        OrderExample.Criteria criteria = memberExample.createCriteria();

        if (StringUtils.hasText(name)) {
            // criteria.ad("%"+name+"%");
        }
        //name没有传值  依然是返回查询所有的记录
        return orderMapper.selectByExample(memberExample);
    }
}
