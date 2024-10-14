package com.hyperion.pojo;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Env {
    private Long id;
    //温度数值
    private Float temp;
    //压力数值
    private Integer pre;
    //湿度数值
    private Integer hum;
    //可燃气体数值
    private Integer gas;
    //火焰的值
    private Integer fire;
    //数值获取时间
    private LocalDateTime createTime;
}
