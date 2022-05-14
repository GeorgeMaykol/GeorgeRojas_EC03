package com.idat.idat_GeorgeRojas_ec03.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.idat_GeorgeRojas_ec03.dto.HospitalRequestDTO;
import com.idat.idat_GeorgeRojas_ec03.dto.HospitalResponseDTO;
import com.idat.idat_GeorgeRojas_ec03.model.Hospital;
import com.idat.idat_GeorgeRojas_ec03.repository.HospitalRepository;

@Service
public class HospitalServiceImpl implements HospitalService {

	@Autowired
	private HospitalRepository repository;
	
	@Override
	public void guardarHospital(HospitalRequestDTO h) {
		Hospital hospital = new Hospital();
		hospital.setIdHospital(h.getIdRequest());
		hospital.setNombre(h.getNombreRequest());
		hospital.setDescripcion(h.getDescripcionRequest());
		hospital.setDistrito(h.getDistritoRequest());
		repository.save(hospital);
	}

	@Override
	public void eliminarHospital(Integer id) {
		repository.deleteById(id);
		
	}

	@Override
	public void editarHospital(HospitalRequestDTO h) {
		Hospital hospital = new Hospital();
		hospital.setIdHospital(h.getIdRequest());
		hospital.setNombre(h.getNombreRequest());
		hospital.setDescripcion(h.getDescripcionRequest());
		hospital.setDistrito(h.getDistritoRequest());
		repository.saveAndFlush(hospital);
		
	}

	@Override
	public List<HospitalResponseDTO> listarHospital() {
		List<Hospital> hospital = repository.findAll();
		List<HospitalResponseDTO> dto = new ArrayList<HospitalResponseDTO>();
		HospitalResponseDTO hospitalDTO = null;
		
		for(Hospital hospitales : hospital) {
			hospitalDTO = new HospitalResponseDTO();
			hospitalDTO.setIdResponse(hospitales.getIdHospital());
			hospitalDTO.setNombreResponse(hospitales.getNombre());
			hospitalDTO.setDescripcionResponse(hospitales.getDescripcion());
			hospitalDTO.setDistritoResponse(hospitales.getDistrito());
			dto.add(hospitalDTO);
		}
		return dto;
	}

	@Override
	public HospitalResponseDTO hospitalById(Integer id) {
		Hospital hospital = repository.findById(id).orElse(null);
		HospitalResponseDTO hospitalDTO = new HospitalResponseDTO();
		
		hospitalDTO = new HospitalResponseDTO();
		hospitalDTO.setIdResponse(hospital.getIdHospital());
		hospitalDTO.setNombreResponse(hospital.getNombre());
		hospitalDTO.setDescripcionResponse(hospital.getDescripcion());
		hospitalDTO.setDistritoResponse(hospital.getDistrito());
		return hospitalDTO;
	}

}
