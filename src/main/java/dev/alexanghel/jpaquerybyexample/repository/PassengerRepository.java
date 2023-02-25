package dev.alexanghel.jpaquerybyexample.repository;

import dev.alexanghel.jpaquerybyexample.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {}

