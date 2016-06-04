package kr.kakao.lastExam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by JKKim on 2016. 5. 26..
 */
@SpringBootApplication
@EnableRedisHttpSession
public class ApplicationContextForProject extends WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter {
//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        registry.viewResolver(getViewResolver());
//        registry.enableContentNegotiation(new MappingJackson2JsonView());
//    }

//    @Bean
//    public ViewResolver getViewResolver() {
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/WEB-INF/views");
//        resolver.setSuffix(".html");
//        return resolver;
//    }

    @Bean
    public JedisConnectionFactory connectionFactory() {
        return new JedisConnectionFactory();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ApplicationContextForProject.class, args);
    }

}