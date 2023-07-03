package com.example.fooddeliverywebsite.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fooddeliverywebsite.model.Register;

public interface RegisterRepo extends JpaRepository<Register,Integer> {

	Register findByEmailId(String emailId);

}
