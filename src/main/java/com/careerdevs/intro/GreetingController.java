package com.careerdevs.intro;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api")
public class GreetingController {

    private final AtomicLong counter = new AtomicLong();
    private final static String template = "Hello %s";

    // root route || home route
    @GetMapping
    public String getHello(){
        return "Hello World";
    }

    // dummy data route | introduction to endpoint -> sayHello endpoint
    @GetMapping("/sayHello")
    public Greeting sayHello() {
        return new Greeting(42, "Hello CareerDevs!");
    }

    // query parameters. localhost:8080/greeting?{value}={data}
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    // dynamic routing | uri parameters
    @GetMapping("/hello/{name}")
    public Greeting hello(@PathVariable String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
