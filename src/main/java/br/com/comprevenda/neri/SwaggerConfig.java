package br.com.comprevenda.neri;
import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.collect.Lists;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {


    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .build()
                .globalOperationParameters(globalOperationParameters())
                .apiInfo(apiInfo())
                .enableUrlTemplating(false);
    }

    private ArrayList<Parameter> globalOperationParameters() {
        return Lists.newArrayList(new ParameterBuilder()
                .name("Authorization")
                .description("Authorization Token")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Título")
                .description("Descrição")
                .version("1.0")
                .build();
    }


}
