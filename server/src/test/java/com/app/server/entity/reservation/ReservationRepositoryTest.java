package com.data.app.server.entity.reservation;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ReservationRepositoryTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    ReservationRepository reservationRepository;

    @Test
    public void getReservation_returnReservationDetails(){
        Reservation savedReservation = entityManager.persistAndFlush(new Reservation("ershad", "haq"));

        Reservation reservation = reservationRepository.findByFirstName("ershad");

        Assertions.assertThat(reservation.getFirstName()).isEqualTo(savedReservation.getFirstName());
        Assertions.assertThat(reservation.getLastName()).isEqualTo(savedReservation.getLastName());
    }
}