package com.data.app.server.entity.reservation;

import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    Reservation findByFirstName(String name);
}
