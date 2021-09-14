package com.zjy.redis.zjy.controller;


import com.zjy.redis.zjy.entity.StaffInfo;
import com.zjy.redis.zjy.service.IStaffInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2021-09-11
 */
@RestController
@RequestMapping("/zjy")
public class StaffInfoController {

    @Autowired
    private IStaffInfoService staffInfoService;

    @RequestMapping("hello")
    public String hello() {
        long start = System.currentTimeMillis();

        String s = staffInfoService.getAllStaff().toString();

        long end = System.currentTimeMillis();

        System.out.println("程序运行时间：" + (end - start) + "ms");
        return s;
    }

    @RequestMapping("insertStaff")
    public String insertStaff() {

        List<StaffInfo> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            StaffInfo staffInfo = new StaffInfo();
            staffInfo.setAge(i);
            staffInfo.setName(i + "1");
            list.add(staffInfo);
        }
        staffInfoService.saveBatch(list);
        return "true";
    }
}

