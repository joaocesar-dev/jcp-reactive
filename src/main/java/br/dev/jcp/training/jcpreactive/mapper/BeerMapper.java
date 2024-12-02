package br.dev.jcp.training.jcpreactive.mapper;

import br.dev.jcp.training.jcpreactive.domain.Beer;
import br.dev.jcp.training.jcpreactive.model.BeerDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface BeerMapper {
    Beer beerDtoToBeer(BeerDTO dto);
    BeerDTO beerToBeerDto(Beer beer);
}
