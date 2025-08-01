package fr.formation.spring.orderservice.repository;

import fr.formation.spring.orderservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}