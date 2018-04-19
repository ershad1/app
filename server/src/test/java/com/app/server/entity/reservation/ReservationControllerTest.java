package com.data.app.server.entity.reservation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(ReservationController.class)
public class ReservationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ReservationService reservationService;

    @Test
    public void getReservation_shouldReturnReservationInfo() throws Exception {
        BDDMockito.given(reservationService.getReservationDetails(ArgumentMatchers.anyString()))
                .willReturn(new Reservation(1L, "ershad", "haq"));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/reservation/ershad"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("firstName").value("ershad"))
                .andExpect(MockMvcResultMatchers.jsonPath("lastName").value("haq"));
    }

    @Test
    public void getReservation_NotFound() throws Exception{
        BDDMockito.given(reservationService.getReservationDetails(ArgumentMatchers.anyString()))
                .willThrow(new ReservationNotFoundException());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/reservation/ershad"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}
