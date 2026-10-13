package com.empresa.cadastro_pizza.business;

import com.empresa.cadastro_pizza.infrastructure.entitys.Pizza;
import com.empresa.cadastro_pizza.infrastructure.repository.PizzaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {

    private final PizzaRepository repository;

    public PizzaService(PizzaRepository repository) {
        this.repository = repository;
    }

    public void salvarPizza(Pizza pizza) {
        repository.saveAndFlush(pizza);
    }

    public Pizza buscarPizzaPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pizza não encontrada com id: " + id));
    }

    public List<Pizza> listarPizzas() {
        return repository.findAll();
    }

    public void atualizarPizza(Integer id, Pizza pizzaAtualizada) {
        Pizza pizza = buscarPizzaPorId(id);
        pizza.setSabor(pizzaAtualizada.getSabor());
        pizza.setDescricao(pizzaAtualizada.getDescricao());
        pizza.setPreco(pizzaAtualizada.getPreco());
        repository.saveAndFlush(pizza);
    }

    public void deletarPizza(Integer id) {
        Pizza pizza = buscarPizzaPorId(id);
        repository.delete(pizza);
    }
}
