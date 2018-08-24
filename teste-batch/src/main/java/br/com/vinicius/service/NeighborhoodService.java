package br.com.vinicius.service;

import br.com.vinicius.entity.Neighborhood;
import br.com.vinicius.repository.NeighborhoodRepository;


public class NeighborhoodService {

	private NeighborhoodRepository repository;

	public NeighborhoodService() {		
		this.repository = new NeighborhoodRepository();
	}

	public Neighborhood findNeighborhoodByIdOrName(Neighborhood neighborhood) {		
		if (null != neighborhood.getIdBairro()) {
			return repository.findNeighborhoodById(neighborhood.getIdBairro());
		} else if (null != neighborhood.getNomeBairro()) {
			return repository.findNeighborhoodByName(neighborhood.getNomeBairro().toUpperCase());
		} else {
			return null;
		}
	}

	public String neighborhoodSave(Neighborhood neighborhood) {
		neighborhood.setNomeBairro(neighborhood.getNomeBairro().toUpperCase());
		
		String result = repository.saveNeighborhood(neighborhood);
		
		return result;
	}
	
	public String deleteNeighborhood(Neighborhood neighborhood) {
		String result = null;
		
		if (null != neighborhood.getIdBairro()) {
			result = repository.deleteNeighborhood(repository.findNeighborhoodById(neighborhood.getIdBairro()));
			return result;
		} else if (null != neighborhood.getNomeBairro()) {
			result = repository.deleteNeighborhood(repository.findNeighborhoodByName(neighborhood.getNomeBairro().toUpperCase()));
			return result;
		} else {
			return null;
		}
	}
}
