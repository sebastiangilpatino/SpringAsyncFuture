package com.example.async.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Configuration
public class ExecutorConfiguration {
    @Bean("executor")
    public Executor myExecutor(){
        //Choose any type of thread pool
        //return Executors.newWorkStealingPool(12);
        return Executors.newFixedThreadPool(8);
    }
}
