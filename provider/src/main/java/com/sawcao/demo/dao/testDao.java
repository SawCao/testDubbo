package com.sawcao.demo.dao;


import com.sawcao.demo.model.testModel;
import org.springframework.stereotype.Repository;


@Repository
public interface testDao {

    public testModel getNameById(String id);

    public void deleteById(String s);

    public void insert(testModel test);

}
