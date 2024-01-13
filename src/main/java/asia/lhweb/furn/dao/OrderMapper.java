package asia.lhweb.furn.dao;

import asia.lhweb.furn.bean.Order;
import asia.lhweb.furn.bean.OrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface OrderMapper {


    int deleteByExample(OrderExample example);

    int insert(Order record);

    int insertSelective(Order record);
    @Select("select  * from `Order`")
    List<Order> selectByExample(Order example);
    int updateByPrimaryKeySelective(@Param("record") Order record);

    int updateByPrimaryKey(@Param("record") Order record, @Param("example") OrderExample example);

    void deleteByPrimaryKey(Integer id);

    List<Order> findAllOrder();
}