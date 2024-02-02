package com.example.async;

import com.example.async.service.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;

@SpringBootApplication
@EnableAsync
public class AsyncApplication implements CommandLineRunner {

    @Autowired
    private Messages messages;

    public static void main(String[] args) {
        SpringApplication.run(AsyncApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        LocalDateTime timeNow = LocalDateTime.now();
        System.out.println("Hello World "+ timeNow);
        CompletableFuture<String> msg1 = messages.sendMessage(LocalDateTime.now().toString());
        CompletableFuture<String> msg2 = messages.sendMessage(LocalDateTime.now().toString());
        CompletableFuture<String> msg3 = messages.sendMessage(LocalDateTime.now().toString());
        CompletableFuture<String> msg4 = messages.sendMessage(LocalDateTime.now().toString());
        CompletableFuture.allOf(msg1, msg2, msg3, msg4).join();
        System.out.println(msg1.get());
        System.out.println(msg2.get());
        System.out.println(msg3.get());
        System.out.println(msg4.get());
        LocalDateTime timeAfter = LocalDateTime.now();
        System.out.println("Bye World "+ timeAfter);
        System.out.println("Execution time "+ Duration.between(timeNow,timeAfter));
        System.exit(0);
    }
}
