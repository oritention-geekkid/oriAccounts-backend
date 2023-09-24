package cn.org.oritention.accounts.controller;

import cn.org.oritention.accounts.pojo.DataObj;
import cn.org.oritention.accounts.pojo.Result;
import cn.org.oritention.accounts.service.DataSyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class DataSyncController {
    @Autowired
    private DataSyncService dataSyncService;

    @PostMapping("/dataSync")
    public Result dataSync(@RequestBody DataObj dataObj) {
        return dataSyncService.dataSync(dataObj);
    }
}
