package com.example.demo.service;

import com.example.demo.model.Job;
import com.example.demo.repository.JobRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class JobService {
    private final JobRepository repository;

    public JobService(JobRepository repository) {
        this.repository = repository;
    }


    public Mono<Job> save(Job job){
        return repository.save(job);
    }

    public Flux<Job> findAll(){
        return repository.findAll();
    }

    public Mono<Job> findById(UUID uuid){
        return repository.findById(uuid);
    }
}
