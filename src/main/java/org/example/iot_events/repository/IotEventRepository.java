package org.example.iot_events.repository;

import org.example.iot_events.model.IotEvent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IotEventRepository extends CrudRepository<IotEvent, Long> {
    Optional<IotEvent> findFirstByOrderByTimestampDesc();
}
