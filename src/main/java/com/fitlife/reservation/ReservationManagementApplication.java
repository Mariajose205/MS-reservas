package com.fitlife.reservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;

@SpringBootApplication
@EnableRabbit
public class ReservationManagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReservationManagementApplication.class, args);
    }
}
