package asia.lhweb.furn.service.impl;

import asia.lhweb.furn.bean.Furn;
import asia.lhweb.furn.dao.FurnMapper;
import asia.lhweb.furn.service.FurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
