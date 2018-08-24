package br.com.vinicius.service;

import br.com.vinicius.entity.Neighborhood;

public interface NeighborhoodService {

	Neighborhood findNeighborhoodByIdOrName(Neighborhood neighborhood);

	void neighborhoodSave(Neighborhood neighborhood);

	void deleteNeighborhood(Neighborhood neighborhood);

	void checkAndBreakIfNameAndIdIsNull(Neighborhood neighborhood);

}