package com.myapp.thymeleaf.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapp.thymeleaf.entity.Employe;


public interface EmployeRepository extends JpaRepository<Employe, Integer> {

}
