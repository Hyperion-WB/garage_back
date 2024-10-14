package com.hyperion.pojo;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class EnvTH {
    private Long id;// 主键
    private String fieldName;// 字段名
    private Integer value;// 数值
    private LocalDateTime exceedTime;// 数值获取时间

    @Override
    public String toString(){
        return String.format("%s %s %s",fieldName,value,exceedTime);//测试用例
    }
}
