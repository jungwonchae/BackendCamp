package com.example.smspr.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

//db에 자동 생성

@Getter
@Table
@Entity
public class Tbpost {
    //primary key 임을 알려주는 @Id
    @Id private String id;
    @Setter @Column(nullable = false) private String title;
    @Setter @Column(nullable = false) private String content;

    protected Tbpost(){}
    private Tbpost(String id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
    public static Tbpost of(String title, String content){
        String id = UUID.randomUUID().toString().replace("-", "").substring(0,12);
        return new Tbpost(id, title, content);
    }

}
