package br.com.vinicius.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vinicius.entity.VehicleBrand;
import br.com.vinicius.repository.VehicleBrandRepository;
import br.com.vinicius.service.VehicleBrandService;

@Service("vehicleBrandService")
public class VehicleBrandServiceImpl implements VehicleBrandService {

	@Autowired
	private VehicleBrandRepository repository;
	
	private static final String STRING_FIELD_EMPTY = "";
	private static final Long LONG_FIELD_EMPTY = 0L;

	@Override
	public VehicleBrand findVehicleBrandByIdOrName(VehicleBrand brand) {
//		checkAndBreakIfFieldNull(brand);
		
		Optional<Long> idVehicleBrand = Optional.ofNullable(brand.getIdMarcaVeic());
		
		if (idVehicleBrand.isPresent()) {
			return repository.findVehicleBrandById(brand.getIdMarcaVeic());
		} else {
			return repository.findVehicleBrandByName(brand.getNome());
		} 
	}

	@Override
	public void VehicleBrandSave(VehicleBrand brand) {		

		repository.vehicleBrandSave(brand);
	}

	@Override
	public void deleteVehicleBrand(VehicleBrand brand) {
		checkAndBreakIfFieldNull(brand);
		
		Optional<Long> idVehicleBrand = Optional.ofNullable(brand.getIdMarcaVeic());
		
		if (idVehicleBrand.isPresent()) {
			repository.deleteVehicleBrand(repository.findVehicleBrandById(brand.getIdMarcaVeic()));
		} else {
			repository.deleteVehicleBrand(repository.findVehicleBrandByName(brand.getNome()));
		} 
	}
	
	private void checkAndBreakIfFieldNull(VehicleBrand brand) {
		if (null == brand.getIdMarcaVeic() && STRING_FIELD_EMPTY.equals(brand.getNome())) {
			throw new IllegalArgumentException("Não foi informado o ID nem NOME da Marca");
		}
	}

	@Override
	public List<VehicleBrand> findAll() {
		return this.repository.findAllVehicleBrand();
	}
}
