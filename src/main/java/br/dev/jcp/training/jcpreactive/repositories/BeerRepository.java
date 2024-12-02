package br.dev.jcp.training.jcpreactive.repositories;

import br.dev.jcp.training.jcpreactive.domain.Beer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface BeerRepository  extends ReactiveCrudRepository<Beer, Integer> {
}
