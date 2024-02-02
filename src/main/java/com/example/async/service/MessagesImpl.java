package com.example.async.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Service
public class MessagesImpl implements Messages {

    @Override
    @Async("executor")
    public CompletableFuture<String> sendMessage(String word) {
        sleep();
        return CompletableFuture.completedFuture("Thread: " + Thread.currentThread().getName() + " " + word);
    }

    private void sleep() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
