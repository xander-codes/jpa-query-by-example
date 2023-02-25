package dev.alexanghel.jpaquerybyexample.controller;

import dev.alexanghel.jpaquerybyexample.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {}

