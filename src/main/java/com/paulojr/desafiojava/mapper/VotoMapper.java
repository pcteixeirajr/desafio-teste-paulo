package com.paulojr.desafiojava.mapper;

import com.paulojr.desafiojava.dto.VotoDTO;
import com.paulojr.desafiojava.entity.Voto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VotoMapper {
    VotoMapper INSTANCE = Mappers.getMapper(VotoMapper.class);

    Voto toModel(VotoDTO votoDTO);

    VotoDTO toDTO(Voto voto);
}
