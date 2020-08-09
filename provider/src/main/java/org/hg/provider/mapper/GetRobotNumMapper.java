package org.hg.provider.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: wzh
 * @time: 2020/8/8 22:25
 * @description:
 */
public interface GetRobotNumMapper {
    //记得加 @Param 注释，不然无法使用 ${} 获取到 mybatis的参数
    //#{}和${} 的区别：前者会自动加上''，后者仅仅是替换一下内容
    List<Double> getRobotNum(@Param("numType") String numType, @Param("axis") String axis);
}
