package com.sawcao.demo;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.sawcao.demo.config.DubboConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;



/**
 * Created by IntelliJ IDEA.
 * User: caorui
 * Time: 2018/8/1
 **/

@SpringBootApplication
@MapperScan("com.sawcao.demo.dao")
public class ProviderMain {
    public static void main(String[] args) {
        SpringApplication.run(ProviderMain.class, args);
    }
}
