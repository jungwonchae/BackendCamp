package com.example.smspr.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Table
@Entity
public class Tbuser {
    @Id private String id;
    @Setter @Column(nullable = false) private String name;
    @Setter @Column(nullable = false) private String phone;
    @Setter @Column(nullable = false) private String birth;
    @Setter @Column(nullable = false) private String gender;

    protected Tbuser() {}
    private Tbuser(String id, String name, String phone, String birth, String gender) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.birth = birth;
        this.gender = gender;
    }

    public static Tbuser of(String name, String phone, String birth, String gender) {
        String id = UUID.randomUUID().toString().replace("-","").substring(0,12);
        return new Tbuser(id, name, phone, birth, gender);
    }
}
