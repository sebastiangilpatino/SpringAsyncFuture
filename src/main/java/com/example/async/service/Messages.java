package com.example.async.service;

import java.util.concurrent.CompletableFuture;

public interface Messages {
    CompletableFuture<String> sendMessage(String word);
}
