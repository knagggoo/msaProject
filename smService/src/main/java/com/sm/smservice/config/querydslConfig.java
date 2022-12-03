package com.sm.smservice.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration      // @Bean 어노테이션을 사용하는 클래스의 경우 반드시 @Configuration과 함께 사용
public class querydslConfig
{
    //  어디서든 querydsl을 사용 할 수 있도록 사용 가능 하도록 설정

    @PersistenceContext     // 영속성?
    private EntityManager entityManager;        // connectionPool 사용을 위한 할당 , 클라이언트 요청 시 할당, 종료 시 회수

    @Bean
    public JPAQueryFactory jpaQueryFactory()
    {
        return new JPAQueryFactory(entityManager);
    }
}
