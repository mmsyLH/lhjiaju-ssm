package asia.lhweb.furn.controller;

import asia.lhweb.furn.bean.Admin;

import asia.lhweb.furn.bean.Furn;
import asia.lhweb.furn.bean.Member;
import asia.lhweb.furn.dao.AdminMapper;
import asia.lhweb.furn.dao.MemberMapper;
import asia.lhweb.furn.result.PageResult;
import asia.lhweb.furn.result.Result;

import asia.lhweb.furn.service.AdminService;
import asia.lhweb.furn.service.MemberService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;

import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

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
