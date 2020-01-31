package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GeneralRepositoryImp implements GeneralRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Object> getCustomers() {

		List<Map<String, Object>> queryForList = jdbcTemplate
				.queryForList("Select id, name, email,created_date from customer");
		return new ArrayList<>();
	}
}
