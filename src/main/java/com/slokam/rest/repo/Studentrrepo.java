package com.slokam.rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.slokam.rest.entity.Student;

@Repository
public interface Studentrrepo extends JpaRepository<Student, Integer> {
      //student =pojo,integer=primary key
}
