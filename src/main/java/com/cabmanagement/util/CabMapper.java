package com.cabmanagement.util;

import com.cabmanagement.dto.CabDTO;
import com.cabmanagement.entites.Cab;

public class CabMapper {

	public static CabDTO entityToDTO(Cab cab) {

		CabDTO cabDTO = new CabDTO();
		if (cab == null) {
			return cabDTO;
		}
		cabDTO.setId(cab.getId());
		cabDTO.setCabRegistrationNumber(cab.getCabRegistrationNumber());
		cabDTO.setCabModel(cab.getCabModel());
		cabDTO.setCabColour(cab.getCabColour());
		return cabDTO;
	}

	public static Cab DTOToEntity(CabDTO cabDTO) {

		Cab cab = new Cab();
		if (cabDTO == null) {
			return cab;
		}
		cab.setId(cabDTO.getId());
		cab.setCabRegistrationNumber(cabDTO.getCabRegistrationNumber());
		cab.setCabModel(cabDTO.getCabModel());
		cab.setCabColour(cabDTO.getCabColour());
		return cab;
	}
}
