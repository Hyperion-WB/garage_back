package com.hyperion.service;

import com.hyperion.pojo.Env;
import com.hyperion.pojo.EnvTH;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EnvService {

    Env update(Env env);

    Env getEnv();

    void check(Env update);

    List<EnvTH> getEnvExceed();
}
