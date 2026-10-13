package com.empresa.cadastro_pizza.controller;

import com.empresa.cadastro_pizza.business.PizzaService;
import com.empresa.cadastro_pizza.infrastructure.entitys.Pizza;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizza")
@RequiredArgsConstructor
public class PizzaController {

    private final PizzaService pizzaService;

    @PostMapping
    public ResponseEntity<Void> cadastrarPizza(@RequestBody Pizza pizza) {
        pizzaService.salvarPizza(pizza);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Pizza>> listarPizzas() {
        return ResponseEntity.ok(pizzaService.listarPizzas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pizza> buscarPizzaPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(pizzaService.buscarPizzaPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarPizza(@PathVariable Integer id, @RequestBody Pizza pizza) {
        pizzaService.atualizarPizza(id, pizza);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPizza(@PathVariable Integer id) {
        pizzaService.deletarPizza(id);
        return ResponseEntity.ok().build();
    }
}
