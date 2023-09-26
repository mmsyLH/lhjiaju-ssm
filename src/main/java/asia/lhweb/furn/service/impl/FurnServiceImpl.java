package asia.lhweb.furn.service.impl;

import asia.lhweb.furn.bean.Furn;
import asia.lhweb.furn.bean.FurnExample;
import asia.lhweb.furn.dao.FurnMapper;
import asia.lhweb.furn.service.FurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author :罗汉
 * @date : 2023/9/26
 */
@Service
public class FurnServiceImpl implements FurnService {
    @Resource
    private FurnMapper furnMapper;
    @Override
    public void save(Furn furn) {
        furnMapper.insertSelective(furn);
    }

    /**
     * 找到所有家居
     *
     * @return {@link List}<{@link Furn}>
     */
    @Override
    public List<Furn> findAll() {
        //传入null表示返回所有信息
        return furnMapper.selectByExample(null);
    }

    /**
     * 更新家居
     *
     * @param furn 家具
     */
    @Override
    public void update(Furn furn) {
        furnMapper.updateByPrimaryKeySelective(furn);
    }

    /**
     * 删除通过id
     *
     * @param id id
     */
    @Override
    public void delById(Integer id) {
        furnMapper.deleteByPrimaryKey(id);
    }

    /**
     * 按条件查找
     *
     * @param name 名字
     * @return {@link List}<{@link Furn}>
     */
    @Override
    public List<Furn> findByCondition(String name) {
        FurnExample furnExample = new FurnExample();
        //通过Criteria可以设置查询的条件
        FurnExample.Criteria criteria = furnExample.createCriteria();

        if (StringUtils.hasText(name)) {
            criteria.andNameLike("%"+name+"%");
        }
        //name没有传值  依然是返回查询所有的记录
        return furnMapper.selectByExample(furnExample);
    }
}
