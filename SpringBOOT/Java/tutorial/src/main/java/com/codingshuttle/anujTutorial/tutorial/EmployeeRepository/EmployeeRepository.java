package com.codingshuttle.anujTutorial.tutorial.EmployeeRepository;

import com.codingshuttle.anujTutorial.tutorial.EmployeeEntity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}
