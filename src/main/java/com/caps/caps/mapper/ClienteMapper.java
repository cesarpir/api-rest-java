package com.caps.caps.mapper;

import com.caps.caps.model.Cliente;
import com.caps.caps.schema.ClienteSchema;
import org.mapstruct.Mapper;

@Mapper
public interface ClienteMapper {

    ClienteSchema convert(Cliente cliente);

    Cliente convert(ClienteSchema schema);

}
