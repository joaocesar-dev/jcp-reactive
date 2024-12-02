package br.dev.jcp.training.jcpreactive.repositories;

import br.dev.jcp.training.jcpreactive.domain.Customer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CustomerRepository extends ReactiveCrudRepository<Customer, Integer> {
}
