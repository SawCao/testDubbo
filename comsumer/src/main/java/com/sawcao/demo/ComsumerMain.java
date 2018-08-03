package com.sawcao.demo;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.sawcao.demo.server.impl.testDubboServerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by IntelliJ IDEA.
 * User: caorui
 * Time: 2018/8/1
 **/
@EnableTransactionManagement
@SpringBootApplication
public class ComsumerMain {
    public static void main(String[] args) {

        SpringApplication.run(ComsumerMain.class, args);

    }
}