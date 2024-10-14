package com.hyperion.service.Impl;

import com.hyperion.mapper.EnvMapper;
import com.hyperion.mapper.EnvTHMapper;
import com.hyperion.pojo.Env;
import com.hyperion.pojo.EnvTH;
import com.hyperion.service.EnvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service

public class EnvServiceImpl implements EnvService {
    @Autowired
   private EnvMapper envMapper;
    @Autowired
    private EnvTHMapper envTHMapper;
    @Override//写入环境数据
    public Env update(Env env) {
        envMapper.update(env);
        return env;
    }

    @Override//获取环境数据,测试用
    public Env getEnv() {
        return envMapper.getEnv();
    }

    @Override//检查环境数据是否超过阈值
    public void check(Env update) {
        // 定义阈值
        Integer gasThreshold = 20; // 可燃气体阈值
        Integer fireThreshold = 50; // 火焰阈值

        // 检查并记录超过阈值的数据
        if (update.getGas() != null) {
            checkAndRecord(update, "gas", Integer.parseInt(update.getGas().toString()), gasThreshold);
        }
        if (update.getFire() != null) {
            checkAndRecord(update, "fire", Integer.parseInt(update.getFire().toString()), fireThreshold);
        }
    }

    @Override
    public List<EnvTH> getEnvExceed() {//获取超过阈值的数据
        List<EnvTH> exceedList = envTHMapper.getEnvExceed();
        Collections.reverse(exceedList);//做了倒序，让最新的数据呈现在报警数据最上层
        return exceedList;
    }

    private void checkAndRecord(Env update, String fieldName, Integer value, double threshold) {//检查并记录超过阈值的数据的方法
        if (value > threshold) {
            EnvTH envThresholdExceed = new EnvTH();
            envThresholdExceed.setFieldName(fieldName);
            envThresholdExceed.setValue(value);
            envTHMapper.insertEnvTH(envThresholdExceed);
        }
    }

}
