package com.empresa.cadastro_pizza.infrastructure.repository;

import com.empresa.cadastro_pizza.infrastructure.entitys.Pizza;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface PizzaRepository extends JpaRepository<Pizza, Integer> {
}
