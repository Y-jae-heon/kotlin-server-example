package com.example.kotlinserverexample.global.response

import com.example.kotlinserverexample.global.exception.ErrorResponse
import org.springframework.core.MethodParameter
import org.springframework.data.domain.Page
import org.springframework.http.MediaType
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.http.server.ServerHttpRequest
import org.springframework.http.server.ServerHttpResponse
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice

@RestControllerAdvice(
    basePackages = ["com.example.kotlinserverexample"]
)
class ResponseHandler: ResponseBodyAdvice<Any> {
    /**
     * 어떤 응답이 가로채져야 하는지 결정
     * returnType이 void 타입이 아닌 경우에만 Advice 적용히려면
     * `return returnType.parameterType != Void.TYPE`
     */
    override fun supports(
        returnType: MethodParameter,
        converterType: Class<out HttpMessageConverter<*>>
    ): Boolean = MappingJackson2HttpMessageConverter::class.java.isAssignableFrom(converterType)

    /**
     * 컨트롤러가 반환한 응답 본문을 실제로 가로채서 처리
     */
    override fun beforeBodyWrite(
        body: Any?,
        returnType: MethodParameter,
        selectedContentType: MediaType,
        selectedConverterType: Class<out HttpMessageConverter<*>>,
        request: ServerHttpRequest,
        response: ServerHttpResponse
    ): Any? {
        return when (body) {
            is ErrorResponse -> body
            is DeleteDetailResponse -> body
            is Page<*> -> {
                PageResponse(
                    status = 200,
                    message = "SUCCESS",
                    data = body.content,
                    total = body.totalElements,
                    totalPage = body.totalPages,
                    count = body.content.size
                )
            }
            is ArrayList<*> -> {
                ListResponse(
                    status = 200,
                    message = "SUCCESS",
                    data = body,
                    count = body.size,
                )
            }
            null ->{
                NullableResponse(
                    status = 200,
                    message = "success"
                )
            }
            else -> {
                CommonResponse(
                    status = 200,
                    message = "success",
                    data = body
                )
            }
        }
    }
}