package asia.lhweb.furn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author :罗汉
 * @date : 2023/9/24
 */
@Controller
public class TestController {

    @RequestMapping("/hi")
    public String hi(){
        System.out.println("你好");
        System.out.println("hi");
        return "hi";
    }
}
