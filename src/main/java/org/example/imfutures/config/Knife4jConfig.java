package org.example.imfutures.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Knife4jConfig {

    @Bean
    public OpenAPI springAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("智行未来接口文档")
                        .description("测试用，生产环境不能使用")
                        .version("1.0.0-version")
                        .contact(new Contact()
                                .name("安安不吃香菜")
                                .email("abcd6543210204@163.com")))
                .externalDocs(new ExternalDocumentation()
                        .description("测试用，生产环境不能使用")
                        .url("http://127.0.0.1:8080"));
    }
}
