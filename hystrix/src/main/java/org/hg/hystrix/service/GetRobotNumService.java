package org.hg.hystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: wzh
 * @time: 2020/8/8 22:17
 * @description:
 */
@Service
public class GetRobotNumService {

    @Autowired
    RestTemplate restTemplate;

    /*
     * 发起的远程调用可能会失败
     * 在方法上添加 @HystrixCommand 注解，配置 fallbackMethod 属性
     * 这个属性表示该方法调用失败时的替代方法
     */
    @HystrixCommand(fallbackMethod = "error")
    public List<List<Double>> getRobotNum(String numType){
        List<List<Double>> robotnum = new LinkedList<>();
        String[] axisMore = {"S","L","U","R","B","T"};
        String[] axisLess = {"R", "B", "T"};
        if (numType.equals("rangeOfMotion") || numType.equals("maximumSpeed")){
            for (String axis : axisMore){
                //double 数组容易传递，再转为 list
                Double[] newNum = restTemplate.getForObject("http://providerPlan/getRobotNum?numType={1}&axis={2}", Double[].class, numType, axis);
                robotnum.add(Arrays.asList(newNum));
            }
        }
        else {
            for (String axis : axisLess){
                Double[] newNum = restTemplate.getForObject("http://providerPlan/getRobotNum?numType={1}&axis={2}", Double[].class, numType, axis);
                robotnum.add(Arrays.asList(newNum));
            }
        }
        return robotnum;
    }

    public List<List<Double>> error(String numType){
        List<List<Double>> robotnum = new LinkedList<>();
        System.out.println("方法降级");
        return robotnum;
    }
}
