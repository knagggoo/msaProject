package com.tm.tmservice.repository;

import com.tm.tmservice.domain.WTM_CALPOL_USER;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface wtmCalPolUserRepository extends JpaRepository<WTM_CALPOL_USER, String>, wtmCalPolUserRepositoryCustom
{

}
