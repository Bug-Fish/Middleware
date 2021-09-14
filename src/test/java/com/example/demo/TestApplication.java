package com.example.demo;

import com.zjy.redis.zjy.DemoApplication;
import com.zjy.redis.zjy.entity.StaffInfo;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class TestApplication {

    @Autowired
    JestClient jestClient;

    // 给ES索引（保存）一个文档
    @Test
    public void contextLoad() throws IOException {
        StaffInfo staffInfo = new StaffInfo();
        staffInfo.setName("zjy");
        staffInfo.setAge(23);

        // 构建一个索引功能
        Index index = new Index.Builder(staffInfo).index("test").type("news").build();
        // 执行
        jestClient.execute(index);
    }

    // 测试Jest搜索
    @Test
    public void jestSearch() throws IOException {

        String json = "{\n" +
                "    \"query\" : {\n" +
                "        \"match\" : {\n" +
                "            \"content\" : \"Hello\"\n" +
                "        }\n" +
                "    }\n" +
                "}";

        // 构建一个搜索功能
        Search search = new Search.Builder(json).addIndex("test").addType("news").build();
        // 执行
        SearchResult result = jestClient.execute(search);
        // 打印结果
        System.out.println(result.getJsonString());
    }
}