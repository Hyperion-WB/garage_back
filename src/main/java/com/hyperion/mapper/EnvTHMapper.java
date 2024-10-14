package com.hyperion.mapper;

import com.hyperion.pojo.EnvTH;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EnvTHMapper {
    @Insert("insert into env_check(field_name,value,exceed_time) values(#{fieldName},#{value},now())")
    void insertEnvTH(EnvTH envThresholdExceed);
    @Select("select * from env_check")
    List<EnvTH> getEnvExceed();
}
