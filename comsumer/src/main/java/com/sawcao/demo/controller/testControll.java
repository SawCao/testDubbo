package com.sawcao.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.sawcao.demo.server.impl.testDubboServerImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.sawcao.demo.model.testModel;


@RestController
public class testControll {
    @Autowired
    private testDubboServerImpl _testService;

    @RequestMapping("/hello")
    public String index(){
        return _testService.helloworld();
    }
    @ApiOperation(value = "根据ID获取用户信息", notes = "")
    @ApiImplicitParam(name = "id", value = "用于查询的ID", required = true, dataType = "String")
    @RequestMapping("/get")
    @ResponseBody
    public String get(String id){
        System.err.println("检查键值对：" + id);
        System.err.println(_testService.getNameById(id));
        return JSONObject.toJSONString(_testService.getNameById(id));
    }

    @ApiOperation(value = "输入相关信息创建对应的用户", notes = "该过程包含了kafka的运用")
    @ApiImplicitParams({
            @ApiImplicitParam( name="id", value = "用于添加的ID", required = true, dataType = "String"),
            @ApiImplicitParam( name="name1", value = "用于添加的NAME", required = true, dataType = "String")
    })
    @RequestMapping("/add")
    @ResponseBody
    public String add(String id,String name1){
        testModel t = new testModel();
        System.err.println("将要插入的id为：" + id  + " name为：" + name1);
        t.setId(id);
        t.setName1(name1);
        System.err.println("装载完毕，准备调用Duubbo服务插入");
        _testService.insert(t);
        return t.getId()+"   " + t.getName1();
    }

    @ApiOperation(value = "删除用户", notes = "")
    @ApiImplicitParam(name = "id", value = "用于删除的ID", required = true, dataType = "String")
    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable("id")String id){

        _testService.deleteById(id);
        return "success";
    }

}
