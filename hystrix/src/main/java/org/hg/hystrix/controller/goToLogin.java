package org.hg.hystrix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: wzh
 * @time: 2020/8/9 7:50
 * @description:
 */
@Controller
public class goToLogin {
    //使用 RestController 就不能解析为 html 页面了
    @GetMapping("/index")
    public String goToLogin(){
        return "login";
    }
}
