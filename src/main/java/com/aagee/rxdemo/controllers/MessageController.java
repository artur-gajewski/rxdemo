package com.aagee.rxdemo.controllers;

import com.aagee.rxdemo.models.Message;
import org.reactivestreams.Publisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class MessageController {

    @GetMapping("/messages")
    public Publisher<Message> messagePublisher() {
        Flux<Message> messageFlux = Flux.<Message>generate(sink ->
                sink.next(new Message("Hello world!")))
                .take(5);

        return messageFlux;
    }

}
