package asia.lhweb.furn.service.impl;

import asia.lhweb.furn.bean.Furn;
import asia.lhweb.furn.bean.Member;
import asia.lhweb.furn.bean.MemberExample;
import asia.lhweb.furn.dao.MemberMapper;
import asia.lhweb.furn.service.MemberService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author :罗汉
 * @date : 2024/1/12
 */
@Service
public class MemberServiceImpl implements MemberService {
    @Resource
    private MemberMapper memberMapper;

    /**
     * 保存
     * 保存家居到数据库
     *
     * @param member 会员
     */
    @Override
    public void save(Member member) {
        memberMapper.insertSelective(member);
    }

    /**
     * 找到所有会员
     *
     * @return {@link List}<{@link Furn}>
     */
    @Override
    public List<Member> findAll() {
        return  memberMapper.selectByExample(null);
    }

    /**
     * 更新
     *
     * @param member 会员
     */
    @Override
    public void update(Member member) {
        memberMapper.updateByPrimaryKeySelective(member);
    }

    /**
     * 删除通过id
     *
     * @param id id
     */
    @Override
    public void delById(Integer id) {
        memberMapper.deleteByPrimaryKey(id);
    }

    /**
     * 按条件查找
     *
     * @param name 名字
     * @return {@link List}<{@link Member}>
     */
    @Override
    public List<Member> findByCondition(String name) {
        MemberExample memberExample = new MemberExample();
        //通过Criteria可以设置查询的条件
        MemberExample.Criteria criteria = memberExample.createCriteria();

        if (StringUtils.hasText(name)) {
            criteria.andUsernameLike("%"+name+"%");
        }
        //name没有传值  依然是返回查询所有的记录
        return memberMapper.selectByExample(memberExample);
    }
}
