package asia.lhweb.furn.controller;

import asia.lhweb.furn.bean.Admin;

import asia.lhweb.furn.dao.AdminMapper;
import asia.lhweb.furn.result.Result;

import asia.lhweb.furn.service.AdminService;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 管理员控制器
 *
 * @author 罗汉
 * @date 2024/01/12
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private AdminService adminService;

    @ResponseBody
    @PostMapping("/login")
    public Result userLogin(@RequestBody Admin admin) {
        Admin login = adminService.login(admin);
        if (login == null) {
            return Result.error("登录失败，用户名或者密码错误");
        }
        return Result.success(login);
    }

}
