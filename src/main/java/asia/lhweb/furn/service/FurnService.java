package asia.lhweb.furn.service;

import asia.lhweb.furn.bean.Furn;

import java.util.List;

/**
 * @author :罗汉
 * @date : 2023/9/26
 */
public interface FurnService {
   /**
    * 保存家居到数据库
    *
    * @param furn 家具
    */
   void save(Furn furn);

   /**
    * 找到所有家居
    *
    * @return {@link List}<{@link Furn}>
    */
   List<Furn> findAll();

   /**
    * 更新家居
    *
    * @param furn 家具
    */
   void update(Furn furn);

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
    * @return {@link List}<{@link Furn}>
    */
   List<Furn> findByCondition(String name);
}
