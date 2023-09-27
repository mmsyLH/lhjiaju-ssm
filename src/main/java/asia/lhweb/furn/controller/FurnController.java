package asia.lhweb.furn.controller;

import asia.lhweb.furn.bean.Furn;
import asia.lhweb.furn.result.PageResult;
import asia.lhweb.furn.result.Result;
import asia.lhweb.furn.service.FurnService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @author :罗汉
 * @date : 2023/9/24
 */
@Controller

public class FurnController {
    @Resource
    private FurnService furnService;

    /**
     * @Validated 对接受到的javabean进行效验 然后封装到
     *
     * @param furn 家具
     * @return {@link Result}
     */
    @PostMapping("/save")
    @ResponseBody

    public Result save(@Validated @RequestBody Furn furn, Errors errors) {
        HashMap<String, Object> map = new HashMap<>();
        List<FieldError> fieldErrors = errors.getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            map.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        if (map.isEmpty()){//效验通过
            furnService.save(furn);
            return Result.success();
        }else {
            return Result.error(map);
        }

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

    /**
     * 列表按页翻页
     *
     * @param pageNum  要显示几页
     * @param pageSize 每页要显示几条记录
     * @return {@link Result}<{@link PageResult}>
     */
    @ResponseBody
    @RequestMapping("/furnsByPage")
    public Result<PageResult> listFurnsByPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                              @RequestParam(defaultValue = "5") Integer pageSize) {
        // 查询前，需要调用 PageHelper.startPage()
        // 看下源码 startPage(int pageNum, int pageSize)
        PageHelper.startPage(pageNum, pageSize);
        // 在 PageHelper.startPage() 后调用 findAll 就是分页查询(物理分页有 limit)
        List<Furn> furnList = furnService.findAll();
        // 分页查询完之后，可以使用 pageInfo 来包装查询后的结果，
        // 1. 只需要将 pageInfo 交给页面就行
        // 2. pageInfo 封装了详细的分页信息，包括查询出来的数据
        // 比如总共有多少页，当前是第几页等
        // 3. 看源码 PageInfo(List<T> list, int navigatePages)
        PageInfo pageInfo = new PageInfo(furnList, pageSize);
        long total = pageInfo.getTotal();
        List list = pageInfo.getList();
        // page.getResult();
        PageResult pageResult = new PageResult(total, list);
        return Result.success(pageResult);
    }

    /**
     * 根据家居名进行分页查询
     *
     * @param pageNum  要显示几页
     * @param pageSize 每页要显示几条记录
     * @return {@link Result}<{@link PageResult}>
     */
    @ResponseBody
    @RequestMapping("/furnsByConditionPage")
    public Result<PageResult> listFurnsByConditionPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                                       @RequestParam(defaultValue = "5") Integer pageSize,
                                                       @RequestParam(defaultValue = " ") String search) {
        System.out.println("你好");
        System.out.println(search);
        PageHelper.startPage(pageNum, pageSize);
        List<Furn> furnList = furnService.findByCondition(search);
        PageInfo pageInfo = new PageInfo(furnList, pageSize);
        long total = pageInfo.getTotal();
        List list = pageInfo.getList();
        // page.getResult();
        PageResult pageResult = new PageResult(total, list);
        return Result.success(pageResult);
    }
}
