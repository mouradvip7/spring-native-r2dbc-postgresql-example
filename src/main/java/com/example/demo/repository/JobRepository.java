package com.example.demo.repository;

import com.example.demo.model.Job;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JobRepository extends R2dbcRepository<Job, UUID> {
}
