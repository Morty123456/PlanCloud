package org.hg.hystrix.controller;

import org.hg.hystrix.service.GetRobotNumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: wzh
 * @time: 2020/8/8 22:16
 * @description:
 */
@RestController
public class GetRobotNum {
    @Autowired
    GetRobotNumService getRobotNumService;

    @PostMapping("/getRobotNum")
    public List<List<Double>> getRangeOfMotion(String numType){
        System.out.println("申请的数据类型是："+numType);
        List<List<Double>> robotNum = getRobotNumService.getRobotNum(numType);
        System.out.println("controller层得到的数据：");
        for (List<Double> num : robotNum){
            for (double n : num)
                System.out.print(n+" ");
            System.out.println();
        }
        return robotNum;
    }
}
