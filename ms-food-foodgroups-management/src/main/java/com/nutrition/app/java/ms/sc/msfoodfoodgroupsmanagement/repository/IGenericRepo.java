package com.nutrition.app.java.ms.sc.msfoodfoodgroupsmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IGenericRepo<T, ID> extends JpaRepository<T, ID> {
}
