package asia.lhweb.furn.controller;

import asia.lhweb.furn.bean.Furn;
import asia.lhweb.furn.result.PageResult;
import asia.lhweb.furn.result.Result;
import asia.lhweb.furn.service.FurnService;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
    public Result save(@RequestBody Furn furn){
        furnService.save(furn);
        return Result.success();
    }
    @ResponseBody
    @RequestMapping("/furns")
    public Result<List<Furn>> listFurns() {
        List<Furn> furnList = furnService.findAll();
        System.out.println(furnList);
        return Result.success(furnList);
    }
    @ResponseBody
    @PutMapping("/update")
    public Result update(@RequestBody Furn furn) {
        furnService.update(furn);
        return Result.success();
    }
    @DeleteMapping("/del/{id}")
    @ResponseBody
    public Result delById(@PathVariable Integer id) {
        furnService.delById(id);
        return Result.success();
    }
}
