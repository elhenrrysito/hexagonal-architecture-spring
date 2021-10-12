package com.henrry.personaslicencias.infrastructure.mappers;

import com.henrry.personaslicencias.domain.data.LicenseDTO;
import com.henrry.personaslicencias.infrastructure.entity.License;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface LicenseMapper {

    LicenseMapper INSTANCE = Mappers.getMapper(LicenseMapper.class);

    LicenseDTO licenseToLicenseDTO(License license);

    License licenseDTOToLicense(LicenseDTO licenseDTO);

    List<LicenseDTO> licenseListToLicenseDTOList(List<License> licenseList);

    List<License> licenseDTOListToLicenseList(List<LicenseDTO> licenseDTOList);
}
