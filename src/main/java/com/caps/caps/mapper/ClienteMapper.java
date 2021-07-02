package com.caps.caps.mapper;

import com.caps.caps.model.Cliente;
import com.caps.caps.schema.ClienteSchema;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClienteMapper {

    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    ClienteSchema convert(Cliente cliente);

    Cliente convert(ClienteSchema schema);

}
