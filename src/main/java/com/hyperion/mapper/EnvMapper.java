package com.hyperion.mapper;

import com.hyperion.pojo.Env;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface EnvMapper {
    @Insert("insert into env(temp,pre,hum,gas,fire,create_time) values(#{temp},#{pre},#{hum},#{gas},#{fire},now())")
    void update(Env env);
    @Select("SELECT temp, pre, hum, gas, fire FROM env ORDER BY id DESC LIMIT 1")
    Env getEnv();
}
