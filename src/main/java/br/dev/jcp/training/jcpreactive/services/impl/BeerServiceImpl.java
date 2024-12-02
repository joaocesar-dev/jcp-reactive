package br.dev.jcp.training.jcpreactive.services.impl;

import br.dev.jcp.training.jcpreactive.mapper.BeerMapper;
import br.dev.jcp.training.jcpreactive.model.BeerDTO;
import br.dev.jcp.training.jcpreactive.repositories.BeerRepository;
import br.dev.jcp.training.jcpreactive.services.BeerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    @Override
    public Flux<BeerDTO> listBeers() {
        return beerRepository.findAll()
                .map(beerMapper::beerToBeerDto);
    }

    @Override
    public Mono<BeerDTO> getBeerById(Integer beerId) {
        return beerRepository.findById(beerId)
                .map(beerMapper::beerToBeerDto);
    }

    @Override
    public Mono<BeerDTO> saveNewBeer(BeerDTO beerDTO) {
        return beerRepository.save(beerMapper.beerDtoToBeer(beerDTO))
                .map(beerMapper::beerToBeerDto);
    }

    @Override
    public Mono<BeerDTO> updateBeer(Integer beerId, BeerDTO beerDTO) {
        return beerRepository.findById(beerId)
                .map(beer -> {
                    beer.setBeerName(beerDTO.getBeerName());
                    beer.setBeerStyle(beerDTO.getBeerStyle());
                    beer.setPrice(beerDTO.getPrice());
                    beer.setUpc(beerDTO.getUpc());
                    return beer;
                })
                .flatMap(beerRepository::save)
                .map(beerMapper::beerToBeerDto);
    }

    @Override
    public Mono<BeerDTO> patchBeer(Integer beerId, BeerDTO beerDTO) {
        return beerRepository.findById(beerId)
                .map(beer -> {
                    if (StringUtils.hasText(beerDTO.getBeerName())) {
                        beer.setBeerName(beerDTO.getBeerName());
                    }
                    if (StringUtils.hasText(beerDTO.getBeerStyle())) {
                        beer.setBeerStyle(beerDTO.getBeerStyle());
                    }
                    if (beerDTO.getPrice() != null) {
                        beer.setPrice(beerDTO.getPrice());
                    }
                    if (StringUtils.hasText(beerDTO.getUpc())) {
                        beer.setUpc(beerDTO.getUpc());
                    }
                    if (beerDTO.getQuantityOnHand() != null) {
                        beer.setQuantityOnHand(beerDTO.getQuantityOnHand());
                    }
                    return beer;
                })
                .flatMap(beerRepository::save)
                .map(beerMapper::beerToBeerDto);
    }

    @Override
    public Mono<Void> deleteBeerById(Integer beerId) {
        return beerRepository.deleteById(beerId);
    }
}
