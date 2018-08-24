package br.com.vinicius.repository;

import br.com.vinicius.entity.Neighborhood;

public interface NeighborhoodRepository {

	Neighborhood findNeighborhoodById(Long id);

	Neighborhood findNeighborhoodByName(String nomeBairro);

	void saveNeighborhood(Neighborhood neighborhood);

	void deleteNeighborhood(Neighborhood neighborhood);

}