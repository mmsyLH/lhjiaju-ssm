package asia.lhweb.furn.service.impl;

import asia.lhweb.furn.bean.Admin;
import asia.lhweb.furn.dao.AdminMapper;
import asia.lhweb.furn.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author :罗汉
 * @date : 2024/1/12
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminMapper adminMapper;
    /**
     * 登录
     *
     * @return {@link Admin}
     */
    @Override
    public Admin login(Admin adminDTO) {
        String username = adminDTO.getUsername();
        String password = adminDTO.getPassword();
        Admin admin=adminMapper.getByUsername(username);
        if (admin==null) return null;
        if (!password.equals(admin.getPassword()))return null;
        return admin;
    }
}
