package com.sawcao.demo.server.impl;

import com.sawcao.demo.model.testModel;
import org.springframework.stereotype.Component;


/**
 * Created by IntelliJ IDEA.
 * User: caorui
 * Time: 2018/8/2
 **/
@Component
public class testDubboServerImpl {
    @com.alibaba.dubbo.config.annotation.Reference
    private com.sawcao.demo.server.testApi testApi;

    public testModel getNameById(String id){
        return testApi.getNameById(id);
    }

    public void deleteById(String s){
        testApi.deleteById(s);
    }

    public testModel insert(testModel test){
        return testApi.insert(test);
    }

    public String helloworld(){return  testApi.helloworld();}
}
