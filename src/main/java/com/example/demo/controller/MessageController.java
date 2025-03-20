package com.example.demo.controller;

import com.example.demo.dto.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class MessageController {

    private List<Message> messages = new ArrayList<>(Arrays.asList(
            new Message(1, "CV", "New work",  LocalDateTime.of(1999, 2, 3, 10, 15)),
            new Message(2, "Payment", "100 dollars", LocalDateTime.of(1909, 2, 3, 10, 15)),
            new Message(3, "Divorce", "Bye", LocalDateTime.of(1999, 2, 3, 10, 15)),
            new Message(4, "Taxes", "10 dollars", LocalDateTime.of(1999, 2, 3, 10, 15))
    ));

    @GetMapping("/message")
    public Iterable<Message> getMessages() {
        return messages;
    }

    @GetMapping("/message/{id}")
    public Optional<Message> findById(@PathVariable("id") int id) {
        return messages.stream().filter(m -> m.getId() == id).findFirst();
    }

    @PostMapping("/message")
    public Message addMessage(@RequestBody Message message) {
        messages.add(message);
        return message;
    }

    @PutMapping("/message/{id}")
    public ResponseEntity<Message> updateMessage(@PathVariable("id") int id, @RequestBody Message message) {
        int index = -1;
        for (int i = 0; i < messages.size(); i++) {
            Message curr = messages.get(i);
            if (curr.getId() == id) {
                index = i;
                messages.set(index, message);
            }
        }

        return index == -1 ?
                new ResponseEntity<>(addMessage(message), HttpStatus.CREATED) :
                new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/message/{id}")
    public void deleteMessage(@PathVariable("id") int id) {
        messages.removeIf(m -> m.getId() == id);
    }
}
