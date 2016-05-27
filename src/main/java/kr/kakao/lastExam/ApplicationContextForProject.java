package kr.kakao.lastExam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * Created by JKKim on 2016. 5. 26..
 */
@SpringBootApplication
public class ApplicationContextForProject extends WebMvcConfigurerAdapter{
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.enableContentNegotiation(new MappingJackson2JsonView());
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ApplicationContextForProject.class, args);
    }

}