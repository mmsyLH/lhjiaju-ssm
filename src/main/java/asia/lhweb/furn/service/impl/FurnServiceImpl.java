package asia.lhweb.furn.service.impl;

import asia.lhweb.furn.bean.Furn;
import asia.lhweb.furn.dao.FurnMapper;
import asia.lhweb.furn.service.FurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author :罗汉
 * @date : 2023/9/26
 */
@Service
public class FurnServiceImpl implements FurnService {
    @Autowired
    private FurnMapper furnMapper;
    @Override
    public void save(Furn furn) {
        furnMapper.insertSelective(furn);
    }
}
