package com.zjy.redis.zjy.service;

import com.zjy.redis.zjy.entity.StaffInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2021-09-11
 */
public interface IStaffInfoService extends IService<StaffInfo> {
    List<StaffInfo> getAllStaff();

    int insert(StaffInfo staffInfo);
}
