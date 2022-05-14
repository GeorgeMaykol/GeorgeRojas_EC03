package com.idat.idat_GeorgeRojas_ec03.service;

import java.util.List;

import com.idat.idat_GeorgeRojas_ec03.dto.HospitalRequestDTO;
import com.idat.idat_GeorgeRojas_ec03.dto.HospitalResponseDTO;

public interface HospitalService {
	
	public void guardarHospital(HospitalRequestDTO h);
	public void eliminarHospital(Integer id);
	public void editarHospital(HospitalRequestDTO h);
	public List<HospitalResponseDTO> listarHospital();
	public HospitalResponseDTO hospitalById(Integer id);

}
