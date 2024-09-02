package com.example.kotlinserverexample.member.impl

import com.linecorp.kotlinjdsl.spring.data.SpringDataQueryFactory
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Repository

@Repository
@RequiredArgsConstructor
class MemberImpl(private val springDataQueryFactory: SpringDataQueryFactory) {
//    override fun
}