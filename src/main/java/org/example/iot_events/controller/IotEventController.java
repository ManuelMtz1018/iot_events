package org.example.iot_events.controller;

import lombok.RequiredArgsConstructor;
import org.example.iot_events.model.IotEvent;
import org.example.iot_events.service.IotEventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/api-iot")
@RequiredArgsConstructor
public class IotEventController {

    private final IotEventService service;

    @PostMapping("/events/add")
    public ResponseEntity<IotEvent> createEvent(@RequestBody IotEvent event) {
        return ResponseEntity.ok(service.save(event));
    }

    @PutMapping("/events/{id}")
    public ResponseEntity<IotEvent> updateEvent(@PathVariable Long id, @RequestBody IotEvent event) {
        try {
            return ResponseEntity.ok(service.update(id, event));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/events/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/events/all")
    public ResponseEntity<List<IotEvent>> getAllEvents() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/events/latest")
    public ResponseEntity<IotEvent> getLatestEvent() {
        return service.findLatest()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/events/{id}")
    public ResponseEntity<IotEvent> getEventById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
