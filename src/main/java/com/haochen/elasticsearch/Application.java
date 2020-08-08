package com.haochen.elasticsearch;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);

        RestHighLevelClient elasticsearchClient = (RestHighLevelClient)ctx.getBean("elasticsearchClient");

        System.out.println(elasticsearchClient);

        ctx.close();

    }

}
