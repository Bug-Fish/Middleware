package com.example.demo;

import com.zjy.redis.zjy.DemoApplication;
import com.zjy.redis.zjy.entity.StaffInfo;
import com.zjy.redis.zjy.mapper.ElRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.elasticsearch.core.query.StringQuery;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class TestApplication2 {

    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;

    // 给ES索引（保存）一个文档
    @Test
    public void save() {
        StaffInfo staffInfo = new StaffInfo();
        staffInfo.setName("cxr");
        staffInfo.setAge(24);


        IndexQuery indexQuery = new IndexQueryBuilder()
                .withId(staffInfo.getName())
                .withObject(staffInfo)
                .build();

        // 存入索引，返回文档ID
        String documentId = elasticsearchTemplate.index(indexQuery);
        System.out.println(documentId);

    }

    // 测试elasticsearchTemplate搜索
    @Test
    public void search() throws IOException {

        String json = "{\n" +
                "        \"match\" : {\n" +
                "            \"name\" : \"cxr\"\n" +
                "        }\n" +
                "    }";

        StringQuery query = new StringQuery(json);
        query.addIndices("test");
        query.addTypes("news");

        List<StaffInfo> staffInfos = elasticsearchTemplate.queryForList(query, StaffInfo.class);
        if(staffInfos.size() > 0) {
            for (StaffInfo staffInfo : staffInfos){
                System.out.println(staffInfo.toString());
            }
        }
    }

    @Autowired
    private ElRepository elRepository;

    @Test
    public void test01() {
        StaffInfo staffInfo = new StaffInfo();
        staffInfo.setName("jy");
        staffInfo.setAge(213);
        elRepository.save(staffInfo);
    }

    @Test
    public void test02() {

    }


}
