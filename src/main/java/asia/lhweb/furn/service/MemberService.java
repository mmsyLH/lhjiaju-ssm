package asia.lhweb.furn.service;


import asia.lhweb.furn.bean.Furn;
import asia.lhweb.furn.bean.Member;

import java.util.List;

/**
* @author Administrator
* @description 针对表【member】的数据库操作Service
* @createDate 2024-01-12 20:54:18
*/
public interface MemberService {
    /**
     * 保存
     * 保存家居到数据库
     *
     * @param member 会员
     */
    void save(Member member);

    /**
     找到所有会员
     *
     * @return {@link List}<{@link Furn}>
     */
    List<Member> findAll();

    /**
     * 更新
     *
     * @param member 会员
     */
    void update(Member member);

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
    List<Member> findByCondition(String name);
}
