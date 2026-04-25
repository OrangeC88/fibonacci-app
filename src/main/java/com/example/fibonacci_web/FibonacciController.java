package com.example.fibonacci_web;

import org.springframework.web.bind.annotation.*;

@RestController
public class FibonacciController {

    @GetMapping("/fibonacci")
    public long getFibonacci(@RequestParam int n) {
        return fibonacci(n);
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