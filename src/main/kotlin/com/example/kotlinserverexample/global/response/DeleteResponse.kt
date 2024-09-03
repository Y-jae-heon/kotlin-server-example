package com.example.kotlinserverexample.global.response

class DeleteResponse(
    val deleteStatusCode: DeleteStatusCode
) {
    fun toDetails(): DeleteDetailResponse {
        return DeleteDetailResponse(
            status = deleteStatusCode.status.value(),
            message = deleteStatusCode.message
        )
    }
}