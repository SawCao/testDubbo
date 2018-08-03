package com.sawcao.demo.server;

import com.sawcao.demo.model.testModel;

/**
 * Created by IntelliJ IDEA.
 * User: caorui
 * Time: 2018/8/2
 **/
public interface testApi {

    public testModel getNameById(String id);

    public void deleteById(String s);

    public testModel insert(testModel test);

    public String helloworld();
}
