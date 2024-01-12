package asia.lhweb.furn.service;


import asia.lhweb.furn.bean.Admin;

/**
 * 管理服务
 *
 * @author 罗汉
 * @date 2024/01/12
 */
public interface AdminService {
   /**
    * 登录
    *
    * @return {@link Admin}
    */
   Admin login(Admin admin);
}
