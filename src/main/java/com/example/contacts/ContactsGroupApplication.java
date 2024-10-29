package com.example.contacts;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.contacts.mapper")
public class ContactsGroupApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContactsGroupApplication.class, args);
    }

}
