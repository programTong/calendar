package com.tongtongbigboy;

import com.tongtongbigboy.util.JwtUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 启动类
 * @author tongtongbigboy
 * @date 2021/05/29 19:31
 */

@SpringBootApplication
@MapperScan("com.tongtongbigboy.mapper")
public class Application {

    public static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class);
        Environment env = context.getEnvironment();
        log.info("====================================================================");
        log.info("项目版本: {}", env.getProperty("project.version"));
        log.info("启动环境: {}", env.getProperty("project.env"));
        log.info("启动端口: {}", env.getProperty("server.port"));
        log.info("日志等级: {}", env.getProperty("logback.level"));
        log.info("日志Appender: {}", env.getProperty("logback.appender"));
        log.info("Startup complete ...");
        log.info("====================================================================");

    }

    @Bean
    public BCryptPasswordEncoder bcryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtUtil jwtUtil(){
        return new JwtUtil();
    }

}
