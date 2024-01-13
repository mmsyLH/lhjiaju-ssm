package asia.lhweb.furn.dao;


import asia.lhweb.furn.bean.OrderItem;

/**
 * @author Administrator
 * @description 针对表【order_item】的数据库操作Mapper
 * @createDate 2024-01-13 12:29:46
 * @Entity generator.domain.OrderItem
 */
public interface OrderItemMapper {

    int deleteByPrimaryKey(Long id);

    int insert(OrderItem record);

    int insertSelective(OrderItem record);

    OrderItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);

}
