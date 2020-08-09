package org.hg.provider.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author: wzh
 * @time: 2020/8/8 21:03
 * @description:
 */
@Configuration
@MapperScan("org.hg.provider.mapper")
public class MyBatisConfig {
}
