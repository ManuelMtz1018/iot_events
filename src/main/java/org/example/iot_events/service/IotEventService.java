package org.example.iot_events.service;

import org.example.iot_events.model.IotEvent;

import java.util.List;
import java.util.Optional;

public interface IotEventService {
    IotEvent save(IotEvent event);
    List<IotEvent> findAll();
    Optional<IotEvent> findById(Long id);
    IotEvent update(Long id, IotEvent event);
    void deleteById(Long id);
    Optional<IotEvent> findLatest();
}
