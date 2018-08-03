package com.sawcao.demo.server.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.sawcao.demo.dao.testDao;
import com.sawcao.demo.kafka.KafkaReceiver;
import com.sawcao.demo.kafka.KafkaSender;

import com.sawcao.demo.model.testModel;
import com.sawcao.demo.server.testApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

/**
 * Created by IntelliJ IDEA.
 * User: caorui
 * Time: 2018/8/1
 **/
@Service
@org.springframework.stereotype.Service
//@CacheConfig(cacheNames="userCache") // 本类内方法指定使用缓存时，默认的名称就是userCache
public class testDubboServerImpl implements testApi {
    @Autowired
    private testDao _testDao;

    @Autowired
    private KafkaReceiver receiver;

    @Autowired
    private KafkaSender sender;

    @Override
    @Cacheable(cacheNames = "dubbo", key = "#p0") //#p0 指的是输入的第一个参数
    public testModel getNameById(String id){
        System.err.println("根据id=" + id +"获取用户对象，从数据库中获取");
        return _testDao.getNameById(id);
    }

    @Override
    @CacheEvict(cacheNames = "dubbo",key = "#p0")
    public void deleteById(String s){
        System.err.println("需要删除的是" + s);
        _testDao.deleteById(s);
    }

    @Override
    @CachePut(cacheNames = "dubbo",key="#p0.id") //#p0.id 指的是输入的第一个参数的id属性
    public testModel insert(testModel test){
        System.err.println("即将插入：" + test);
        System.err.println("将要发送kafka01");
        sender.send(test.getId(),test.getName1());
        System.err.println("完成发送kafka01");

        System.err.println("将要发送kafka02");
        sender.send(test.getId(),test.getName1());
        System.err.println("完成发送kafka02");
        _testDao.insert(test);
        return test;
    }

    @Override
    public String helloworld(){
        return "hello dubbo";
    }
}
