package com.example.kotlinserverexample.member.impl

import com.example.kotlinserverexample.member.entity.Gender
import com.example.kotlinserverexample.member.entity.MemberEntity
import com.example.kotlinserverexample.member.repository.MemberRepositoryImpl
import com.linecorp.kotlinjdsl.querydsl.expression.col
import com.linecorp.kotlinjdsl.spring.data.SpringDataQueryFactory
import com.linecorp.kotlinjdsl.spring.data.listQuery
import com.linecorp.kotlinjdsl.spring.data.singleQuery
import lombok.RequiredArgsConstructor
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository

@Repository
@RequiredArgsConstructor
class MemberRepositoryImpl(private val springDataQueryFactory: SpringDataQueryFactory): MemberRepositoryImpl {
    override fun findByNameAndAgeAndAddressAndGender(name: String?, age: Int?, address: String?, gender: Gender?, pageable: Pageable): Page<MemberEntity> {
        val member = springDataQueryFactory.listQuery<MemberEntity> {
            select(entity(MemberEntity::class))
            from(entity(MemberEntity::class))
            whereAnd(
                name?.let { col(MemberEntity::name).like("%$it%") }, // 이름이 null이 아니면 조건 추가
                age?.let { col(MemberEntity::age).equal(it) }, // 나이가 null이 아니면 조건 추가
                address?.let { col(MemberEntity::address).like("%$it%") }, // 주소가 null이 아니면 조건 추가
                gender?.let { col(MemberEntity::gender).equal(it) } // 성별이 null이 아니면 조건 추가
            )
            offset(pageable.offset.toInt())
            limit(pageable.pageSize)
        }

        val total = springDataQueryFactory.singleQuery<Long> {
            select(count(entity(MemberEntity::class)))
            from(entity(MemberEntity::class))
            whereAnd(
                name?.let { col(MemberEntity::name).like("%$it%") }, // 이름이 null이 아니면 조건 추가
                age?.let { col(MemberEntity::age).equal(it) }, // 나이가 null이 아니면 조건 추가
                address?.let { col(MemberEntity::address).like("%$it%") }, // 주소가 null이 아니면 조건 추가
                gender?.let { col(MemberEntity::gender).equal(it) } // 성별이 null이 아니면 조건 추가
            )
        }

        return PageImpl(member, pageable, total )
    }

}