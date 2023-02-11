package com.example.async;

import java.util.concurrent.CompletableFuture;

public interface Messages {
    CompletableFuture<String> sendMessage(String word);
}
