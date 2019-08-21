package com.verizon.consumer.springdatacassandrademo.repo;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.verizon.consumer.springdatacassandrademo.model.User;

@Repository
public interface UserRepository extends CassandraRepository<User, Long> {

}
