package br.com.comprevenda.neri;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    
//	@Bean
//	public SecurityConfiguration security() {
//	    final String swaggerToken = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJyb2RyaWdvZ3JlZ29yaW9uZXJpQGhvdG1haWwuY29tIiwiY3JlYXRlZCI6MTU0NjAxNDkxNjkzMCwiZXhwIjoxNTQ2NjE5NzE2fQ.xAoEFQn5bD5_2nO_230jUSDWnqhl1H3rbwr-TnSgugLORs05T1dHg0fEVei-56BnEyY1PWyxEQG--Sufbc_LDw";
//	    return new SecurityConfiguration(null, null, null, null, "Bearer " + swaggerToken, ApiKeyVehicle.HEADER, "Authorization", ",");
//	}
	
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
          .select()
          .apis(RequestHandlerSelectors.basePackage("br.com.comprevenda.neri.controller"))
          .paths(PathSelectors.any())
          .build()
          .apiInfo(apiInfo())
          .securitySchemes(Arrays.asList(apiKey()));
    }
    
//    @Bean
//    public Docket api(){
//        final String swaggerToken = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJyb2RyaWdvZ3JlZ29yaW9uZXJpQGhvdG1haWwuY29tIiwiY3JlYXRlZCI6MTU0NjAyMDYxMTQyNSwiZXhwIjoxNTQ2NjI1NDExfQ.VojfYf6eGI6sr2Zoii-RQd8tfJ6-sicx7WOFxa2PknM_IIgCjO-BPGjm9JgNFLwpEN0U8z1J_Zb9GBNqVoKM3g";    
//        
//        return new Docket(DocumentationType.SWAGGER_2)
//                .globalOperationParameters(Arrays.asList(
//                        new ParameterBuilder()
//                                .name("Authorization")
//                                .modelRef(new ModelRef("string"))
//                                .parameterType("header")
//                                .required(true)
//                                .hidden(true)
//                                .defaultValue("Bearer " + swaggerToken)
//                                .build()
//                        ));
//                
//    }

    private List<Parameter> singletonList(Parameter build) {
    	 List<Parameter> list =  new ArrayList<>();
    	 list.add(build);
		return list;
	}

	private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Venda e Compre Mais")
                .description("The REST API Venda e Compre Mais.").termsOfServiceUrl("")
                .contact(new Contact("Rodrigo Neri", "Fullstack Developer", "rodrigogregorioneri@hotmail.com"))
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .version("0.0.1")
                .build();
    }

    private ApiKey apiKey() {
        return new ApiKey("rodrigogregorioneri@hotmail.com", "Authorization", "header");
      }
}
