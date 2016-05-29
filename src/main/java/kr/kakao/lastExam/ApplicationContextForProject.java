package kr.kakao.lastExam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;

/**
 * Created by JKKim on 2016. 5. 26..
 */
@SpringBootApplication
public class ApplicationContextForProject extends WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ApplicationContextForProject.class, args);
    }

}