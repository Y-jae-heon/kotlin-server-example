package com.example.kotlinserverexample.global.configuration

import org.springframework.context.annotation.Configuration
import org.springframework.data.domain.PageRequest
import org.springframework.data.web.PageableHandlerMethodArgumentResolver
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig: WebMvcConfigurer {
//    Swagger에 변경된 Default Setting의 description이 반영되지않아서 주석
//    override fun addArgumentResolvers(resolvers: MutableList<HandlerMethodArgumentResolver>) {
//        val pageableResolver = PageableHandlerMethodArgumentResolver()
//        pageableResolver.setFallbackPageable((PageRequest.of(0, 30)))
//        resolvers.add(pageableResolver)
//    }
}