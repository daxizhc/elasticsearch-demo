package com.haochen.elasticsearch;

import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.test.context.junit4.SpringRunner;

import com.haochen.elasticsearch.document.Student;

import lombok.extern.slf4j.Slf4j;

import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class ApplicationTest {

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;


    //创建Student索引
    @Test
    public void createIndex() {
        boolean index = elasticsearchOperations.createIndex(Student.class);
        log.info("create index : " + index);

    }

    //查询Student索引下所有文档
    @Test
    public void queryAllDocument() {
        SearchQuery query = new NativeSearchQueryBuilder().withQuery(matchAllQuery()).build();
        List<Student> students = elasticsearchOperations.queryForList(query, Student.class);
        log.info("all documents: {}", students);
    }

    //往Student索引插入文档
    @Test
    public void createDocument() {
        Student student = new Student(UUID.randomUUID().toString(), "zhangsan", 18);
        IndexQuery indexQuery = new IndexQueryBuilder().withId(student.getId()).withObject(student).build();
        String id = elasticsearchOperations.index(indexQuery);
        log.info("save document success, {}", id);
    }

    //删除索引
    @Test
    public void deleteIndex() {
        boolean b = elasticsearchOperations.deleteIndex(Student.class);
        log.info("delete index " + b);
    }


}
