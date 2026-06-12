package org.example.iot_events.service;

import lombok.RequiredArgsConstructor;
import org.example.iot_events.model.IotEvent;
import org.example.iot_events.repository.IotEventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class IotEventServiceImpl implements IotEventService {

    private final IotEventRepository repository;

    @Override
    public IotEvent save(IotEvent event) {
        return repository.save(event);
    }

    @Override
    public List<IotEvent> findAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .toList();
    }

    @Override
    public Optional<IotEvent> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public IotEvent update(Long id, IotEvent event) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setDevice(event.getDevice());
                    existing.setPin(event.getPin());
                    existing.setAction(event.getAction());
                    existing.setTimestamp(event.getTimestamp());
                    return repository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Event not found with id: " + id));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<IotEvent> findLatest() {
        return repository.findFirstByOrderByTimestampDesc();
    }
}
