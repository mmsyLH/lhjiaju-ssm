package asia.lhweb.furn.controller;

import asia.lhweb.furn.bean.Furn;
import asia.lhweb.furn.result.Result;
import asia.lhweb.furn.service.FurnService;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author :罗汉
 * @date : 2023/9/24
 */
@Controller
public class FurnController {
    @Resource
    private FurnService furnService;

    @PostMapping("/save")
    @ResponseBody
    public Result<Furn> save(@RequestBody Furn furn){
        System.out.println(furn);
        System.out.println("你好");
        furnService.save(furn);
        return Result.success();
    }
    @Test
    public void test1(){
        System.out.println("你好啊");
    }
}
