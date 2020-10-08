package org.hg.provider.controller;

import org.hg.commons.SixAxis;
import org.hg.commons.SixAxisType;
import org.hg.commons.ThreeAxis;
import org.hg.commons.ThreeAxisType;
import org.hg.provider.mapper.GetRobotNumMapper;
import org.hg.provider.mapper.LoginMapper;
import org.hg.provider.mapper.OnLoadFileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: wzh
 * @time: 2020/8/8 20:57
 * @description:
 */
@RestController
public class Controller {
    @Autowired
    LoginMapper loginMapper;

    @GetMapping("/login")
    //使用 get请求 传递参数，使用 @RequestParam 获取参数
    public String login(@RequestParam("username") String username){
        return loginMapper.getPassword(username);
    }

    @Autowired
    GetRobotNumMapper getRobotNumMapper;

    @GetMapping("/getRobotNum")
    public Double[] getRobotNum(@RequestParam("numType") String numType, @RequestParam("axis") String axis){
        List<Double> list = getRobotNumMapper.getRobotNum(numType, axis);
        //list 不好传递，所以先转为 double 数组
        Double[] doubles = new Double[list.size()];
        for (int i=0;i<doubles.length;i++)
            doubles[i] = list.get(i);
//        for (double l : list)
//            System.out.print(l+" ");
//        System.out.println("微服务，provider层");
        return doubles;
    }

    @Autowired
    OnLoadFileMapper onLoadFileMapper;

    @PostMapping("/onLoadSixAxis")
    public String onLoad(@RequestBody SixAxisType sixAxisType){
//        SixAxis numOfAxis = map.get("numOfAxis");
//        String fileType = map.get("fileType");

        System.out.println("provider>>>>>>"+sixAxisType.toString());
        onLoadFileMapper.addSixAxis(sixAxisType.getNumOfAxis(), sixAxisType.getFileType());
        return "ok";
    }
    @PostMapping("/onLoadThreeAxis")
    public boolean onLoad(@RequestBody ThreeAxisType threeAxisType){
        System.out.println("provider>>>>>>"+threeAxisType.toString());
        onLoadFileMapper.addThreeAxis(threeAxisType.getNumOfAxis(), threeAxisType.getFileType());
        return true;
    }
}
