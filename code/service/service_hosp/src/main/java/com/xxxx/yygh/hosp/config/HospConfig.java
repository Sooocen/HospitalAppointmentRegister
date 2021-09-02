package com.xxxx.yygh.hosp.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置Mapper扫描路径
 * 也可以在启动类添加
 *
 * @author Sooocen
 * @since 2021-08-02
 */
@Configuration
@MapperScan("com.xxxx.yygh.hosp.mapper")
public class HospConfig {
    /**
     * 配置分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
}
