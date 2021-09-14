package com.zjy.redis.zjy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zjy.redis.zjy.entity.StaffInfo;
import com.zjy.redis.zjy.mapper.StaffInfoMapper;
import com.zjy.redis.zjy.service.IStaffInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2021-09-11
 */
@Service
public class StaffInfoServiceImpl extends ServiceImpl<StaffInfoMapper, StaffInfo> implements IStaffInfoService {

    @Autowired
    private StaffInfoMapper mapper;

    @Override
    @Cacheable(value = {"hello"}, key = "#root.method.name")
    public List<StaffInfo> getAllStaff() {
        QueryWrapper<StaffInfo> wrapper = new QueryWrapper<>();
//        wrapper.select(null);
        List<StaffInfo> list = mapper.selectList(null);
        return list;
    }

    @Override
    public int insert(StaffInfo staffInfo) {
        return baseMapper.insert(staffInfo);
    }
}
