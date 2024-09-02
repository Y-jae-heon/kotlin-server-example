package com.example.kotlinserverexample.global.configuration

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.EnableWebMvc
//import springfox.documentation.builders.ApiInfoBuilder
//import springfox.documentation.builders.PathSelectors
//import springfox.documentation.builders.RequestHandlerSelectors
//import springfox.documentation.service.ApiInfo
//import springfox.documentation.service.Contact
//import springfox.documentation.spi.DocumentationType
//import springfox.documentation.spring.web.plugins.Docket

@Configuration
class SwaggerConfiguration {
    @Bean
    fun openAPI(): OpenAPI {
        return OpenAPI()
            .components(Components())
            .info(configurationInfo())
    }

    private fun configurationInfo(): Info {
        return Info()
            .title("OpenAPI3 UI 테스트")
            .description("OpenAPI3 - Springdoc을 사용한 Swagger UI 테스트")
            .version("1.0.0")
    }
//    @Bean
//    fun api(): Docket {
//        return Docket(DocumentationType.SWAGGER_2)
//            .useDefaultResponseMessages(false)
//            .select()
//            .apis(RequestHandlerSelectors.basePackage("com.example.kotlinserverexample"))
//            .paths(PathSelectors.any())
//            .build()
//            .apiInfo(this.apiInfo())
//    }
//
//    private fun apiInfo(): ApiInfo {
//        return ApiInfoBuilder()
//            .title("JANE SHOP API")
//            .description("JANE SHOP API")
//            .version("1.0")
//            .contact(
//                Contact(
//                    "JANE SHOP",
//                    "https://www.janeshop.kr",
//                    "help@janeshop.kr"
//                )
//            )
//            .build()
//    }
//    @Bean
//    fun swaggerApi(): Docket = Docket(DocumentationType.OAS_30)
//        .consumes(getConsumeContentTypes())
//        .produces(getProduceContentTypes())
//        .apiInfo(swaggerInfo())
//        .select()
//        .apis(RequestHandlerSelectors.basePackage("com.example.kotlinserverexample"))
//        .paths(PathSelectors.any())
//        .build()
//        .useDefaultResponseMessages(false)
//
//    private fun swaggerInfo() = ApiInfoBuilder()
//        .title("스웨거 테스트")
//        .description("스웨거로 API를 테스트")
//        .version("1.0.0")
//        .build()
//
//    private fun getConsumeContentTypes(): Set<String> {
//        val consumes = HashSet<String>()
//        consumes.add("multipart/form-data")
//        return consumes
//    }
//
//    private fun getProduceContentTypes(): Set<String> {
//        val produces = HashSet<String>()
//        produces.add("application/json;charset=UTF-8")
//        return produces
//    }
}