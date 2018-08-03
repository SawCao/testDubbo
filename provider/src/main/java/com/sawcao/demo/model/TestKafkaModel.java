package com.sawcao.demo.model;

import lombok.Data;

import java.util.Date;

@Data
public class TestKafkaModel {

    private Long id;

    private String msg;

    private String name_id;

    private String name;

    private Date sendTime;

}
