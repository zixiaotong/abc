package com.abc.abc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author zishang
 */
@SpringBootApplication
@ServletComponentScan
@MapperScan("com.abc.abc.dao.persistence")
public class AbcApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AbcApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(AbcApplication.class, args);
    }

}
