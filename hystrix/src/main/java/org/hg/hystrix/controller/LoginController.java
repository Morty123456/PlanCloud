package org.hg.hystrix.controller;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;

/**
 * @author: wzh
 * @time: 2020/8/8 21:17
 * @description:
 */
@RestController
public class LoginController {

    @Autowired
    RestTemplate restTemplate;

    //使用Post请求传递参数
    @PostMapping("/login")
    public String login(String username, String password, HttpSession httpSession){
//        System.out.println("username>>>>>>>>>>"+username);
//        System.out.println("password>>>>>>>>>>"+password);
        //restTemplate 使用get请求传递参数
        String getPassword = restTemplate.getForObject("http://providerPlan/login?username={1}",String.class,username);
//        System.out.println(">>>>>>>>> "+password);
        if (getPassword.equals(password)){
            httpSession.setAttribute("username", username);
            return "1";
        }else{
            return "0";
        }
    }
}
