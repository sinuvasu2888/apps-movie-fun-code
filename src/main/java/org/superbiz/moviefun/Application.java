package org.superbiz.moviefun;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    @Bean
    public ServletRegistrationBean Servletreg(ActionServlet actionServlet) {

        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(actionServlet, "/moviefun/*");

        return servletRegistrationBean;
    }


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
