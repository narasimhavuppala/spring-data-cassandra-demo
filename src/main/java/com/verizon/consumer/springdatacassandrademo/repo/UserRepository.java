package com.verizon.consumer.springdatacassandrademo.repo;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import com.verizon.consumer.springdatacassandrademo.model.User;

@Repository
public interface UserRepository extends CassandraRepository<User, Long> {

	public void deleteByIdAndName(Long id,String name);
	
	@Query("DELETE FROM USERS WHERE USER_ID=?0 AND NAME=?1")
	public void deleteByIdAndNameUsingQuery(Long id,String name);
}
