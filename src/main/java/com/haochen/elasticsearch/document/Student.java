package com.haochen.elasticsearch.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "student", type="student", replicas = 0)
public class Student {

    @Id
    private String id;

    @Field(type = FieldType.Text, store = true)
    private String name;

    @Field(type = FieldType.Integer, store = true)
    private Integer age;

}
