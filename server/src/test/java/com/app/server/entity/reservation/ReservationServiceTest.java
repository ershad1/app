package com.data.app.server.entity.reservation;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ReservationServiceTest {

    ReservationService reservationService;

    @Mock
    ReservationRepository reservationRepository;

    @Before
    public void setUp() throws Exception {
        reservationService = new ReservationService(reservationRepository);
    }


    @Test
    public void getReservationDetails_returnsReservationInfo() {
        BDDMockito.given(reservationRepository.findByFirstName("ershad"))
                .willReturn(new Reservation(1L, "ershad", "haq"));

        Reservation reservation = reservationService.getReservationDetails("ershad");

        Assertions.assertThat(reservation.getFirstName()).isEqualTo("ershad");
        Assertions.assertThat(reservation.getLastName()).isEqualTo("haq");

    }

    @Test(expected = ReservationNotFoundException.class)
    public void getReservationDetails_whenNotFound(){
        BDDMockito.given(reservationRepository.findByFirstName("ershad"))
                .willReturn(null);
        Reservation reservation = reservationService.getReservationDetails("ershad");


    }


}