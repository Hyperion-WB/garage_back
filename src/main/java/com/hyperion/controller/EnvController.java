package com.hyperion.controller;

import com.hyperion.pojo.Env;
import com.hyperion.pojo.EnvTH;
import com.hyperion.service.EnvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class EnvController {
    @Autowired
    private EnvService envService;
    @PostMapping("/update")//数据存储
    public ResponseEntity<Env> update(@RequestBody Env env) {
        Env update = envService.update(env);
        envService.check(update);
        return ResponseEntity.ok(update);
    }
    @GetMapping("/get")//数据获取，可以调用，获取最新写入的数据，用作测试
    public ResponseEntity<Env> getEnv(){
        Env last = envService.getEnv();
        return ResponseEntity.ok(last);
    }
    @GetMapping("/exceed")//获取超过阈值的数据
    public ResponseEntity<List<EnvTH>>getEnvExceed(){
        List<EnvTH>exceedList = envService.getEnvExceed();
        return ResponseEntity.ok(exceedList);
    }

}
