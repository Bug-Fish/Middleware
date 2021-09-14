package com.zjy.redis.zjy.mapper;

import com.zjy.redis.zjy.entity.StaffInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ElRepository extends ElasticsearchRepository<StaffInfo, Long> {

}
