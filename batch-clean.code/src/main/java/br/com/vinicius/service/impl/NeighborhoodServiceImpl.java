package br.com.vinicius.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vinicius.entity.Neighborhood;
import br.com.vinicius.repository.NeighborhoodRepository;
import br.com.vinicius.service.NeighborhoodService;

@Service("neighborhoodService")
public class NeighborhoodServiceImpl implements NeighborhoodService {

	@Autowired
	private NeighborhoodRepository repository;
	
	private static final String STRING_FIELD_EMPTY = "";
	private static final Long LONG_FIELD_EMPTY = 0L;

	public NeighborhoodServiceImpl() {		
		
	}

	@Override
	public Neighborhood findNeighborhoodByIdOrName(Neighborhood neighborhood) {	
		checkAndBreakIfNameAndIdIsNull(neighborhood);
		
		Optional<Long> idNeighborhood = Optional.ofNullable(neighborhood.getIdBairro());
		
		if (idNeighborhood.isPresent()) {
			return repository.findNeighborhoodById(neighborhood.getIdBairro());
		} else {
			return repository.findNeighborhoodByName(neighborhood.getNomeBairro());
		} 
	}

	@Override
	public void neighborhoodSave(Neighborhood neighborhood) {	
		
		repository.saveNeighborhood(neighborhood);		
	}
	
	@Override
	public void deleteNeighborhood(Neighborhood neighborhood) {
		checkAndBreakIfNameAndIdIsNull(neighborhood);
		
		Optional<Long> idNeighborhood = Optional.ofNullable(neighborhood.getIdBairro());
		
		if (idNeighborhood.isPresent()) {
			repository.deleteNeighborhood(neighborhood);
		} else {
			repository.deleteNeighborhood(neighborhood);
		} 		
	}
	
	@Override
	public void checkAndBreakIfNameAndIdIsNull(Neighborhood neighborhood) {
		if (LONG_FIELD_EMPTY == neighborhood.getIdBairro() && STRING_FIELD_EMPTY.equals(neighborhood.getNomeBairro())) {
			throw new IllegalArgumentException("Não foi informado o ID nem o NOME do Bairro");
		}
	}
}
