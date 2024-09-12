package com.example.kotlinserverexample.memberProfile.impl

import com.example.kotlinserverexample.memberProfile.entity.MemberProfileEntity
import com.example.kotlinserverexample.memberProfile.repository.MemberProfileRepositoryImpl
import com.linecorp.kotlinjdsl.spring.data.SpringDataQueryFactory
import com.linecorp.kotlinjdsl.spring.data.listQuery
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Repository

@Repository
@RequiredArgsConstructor
class MemberProfileRepositoryImpl(private val springDataQueryFactory: SpringDataQueryFactory): MemberProfileRepositoryImpl {
//    override fun findByMemberId(id: Long): MemberProfileEntity {
//        val profiles = springDataQueryFactory.listQuery<MemberProfileEntity> {
//            select(entity(MemberProfileEntity::class))
//            from(entity())
//        }
//    }
}