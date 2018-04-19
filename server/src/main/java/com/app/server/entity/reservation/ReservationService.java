package com.data.app.server.entity.reservation;

import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    private ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation getReservationDetails(String name) {
        Reservation reservation= reservationRepository.findByFirstName(name);
        if (reservation == null) {
            throw new ReservationNotFoundException();
        }

        return reservation;
    }
}
