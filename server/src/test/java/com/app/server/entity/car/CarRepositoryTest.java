package com.data.app.server.entity.car;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CarRepositoryTest {

    @Autowired
    private CarRepository repository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void findByName_returnsCar() throws Exception{
        Car savedCar = entityManager.persistFlushFind(new Car("prius", "hybrid"));
        Car car = repository.findByName("prius");

        assertThat(car.getName()).isEqualTo(savedCar.getName());
        assertThat(car.getType()).isEqualTo(savedCar.getType());
    }

    @Test
    public void getCar_returnsCarDetails() throws Exception{
        Car car =repository.findByName("prius");

        assertThat(car.getName()).isEqualTo("prius");
    }

}