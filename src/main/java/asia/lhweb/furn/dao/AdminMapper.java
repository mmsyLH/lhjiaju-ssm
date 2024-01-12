package asia.lhweb.furn.dao;

import asia.lhweb.furn.bean.Admin;
import org.apache.ibatis.annotations.Select;

/**
* @author Administrator
* @description 针对表【admin】的数据库操作Mapper
* @createDate 2024-01-12 19:23:09
* @Entity generator.domain.Admin
*/
public interface AdminMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
    @Select("select * from admin where username = #{username}")
    Admin getByUsername(String username);
}
