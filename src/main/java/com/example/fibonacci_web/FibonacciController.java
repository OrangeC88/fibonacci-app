package com.example.fibonacci_web;

import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class FibonacciController {
    private static final Logger logger = LoggerFactory.getLogger(FibonacciController.class);

    @GetMapping("/fibonacci")
    public long getFibonacci(@RequestParam int n) {
    logger.info("Received request for Fibonacci with n = {}", n);

    long result = fibonacci(n);

    logger.info("Returning result: {}", result);
        return result;
    }

    private long fibonacci(int n) {
        if (n <= 1) return n;

        long a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            long temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
}