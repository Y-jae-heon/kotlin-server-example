package com.example.kotlinserverexample.global.configuration

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.Operation
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.media.Content
import io.swagger.v3.oas.models.media.Schema
import io.swagger.v3.oas.models.responses.ApiResponses
import org.springdoc.core.customizers.OpenApiCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

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

    @Bean
    fun customizeResponses(): OpenApiCustomizer {
        return OpenApiCustomizer { openApi: OpenAPI ->
            val schemaMap = mutableMapOf<String, Schema<*>>()

            // Collect all schemas
            openApi.components?.schemas?.let { schemas ->
                schemaMap.putAll(schemas)
            }

            openApi.paths.orEmpty().values.forEach { pathItem ->
                pathItem.readOperations().forEach { operation ->
                    operation.responses?.forEach { (_, apiResponse) ->
                        apiResponse.content?.forEach { (_, mediaType) ->
                            val originalSchema = mediaType.schema
                            val resolvedSchema = resolveSchemaRef(originalSchema, schemaMap)
                            val wrappedSchema = wrapSchema(resolvedSchema)
                            mediaType.schema = wrappedSchema
                        }
                    }
                }
            }
        }
    }

    private fun resolveSchemaRef(schema: Schema<*>?, schemaMap: Map<String, Schema<*>>): Schema<*> {
        return when {
            schema == null -> Schema<Any>()
            schema.`$ref` != null -> {
                val ref = schema.`$ref`!!
                val refKey = ref.substringAfterLast("/")  // 'PageMemberEntity' 추출
                schemaMap[refKey] ?: schema
            }
            else -> schema
        }
    }

    private fun wrapSchema(originalSchema: Schema<*>): Schema<Any> {
        val wrapperSchema = Schema<Any>()

        if(originalSchema.name.contains("Error")) {
            return originalSchema as Schema<Any>
        } else {
            wrapperSchema.addProperty("message", Schema<Any>().apply {
                type = "string"
                example = "SUCCESS"
            })

            wrapperSchema.addProperty("status", Schema<Any>().apply {
                type = "integer"
                example = 200
            })
        }


        val contentSchema = if (originalSchema.properties != null && originalSchema.properties.containsKey("content")) {
            wrapperSchema.addProperty("count", Schema<Any>().apply {
                type = "integer"
                example = 1
            })
            wrapperSchema.addProperty("total", Schema<Any>().apply {
                type = "integer"
                example = 1
            })
            wrapperSchema.addProperty("totalPage", Schema<Any>().apply {
                type = "integer"
                example = 2
            })
            originalSchema.properties["content"] as? Schema<*> ?: originalSchema

        } else {
            originalSchema
        }

        wrapperSchema.addProperty("data", contentSchema)

        return wrapperSchema
    }
}