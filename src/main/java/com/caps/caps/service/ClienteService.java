package com.caps.caps.service;

import com.caps.caps.mapper.ClienteMapper;
import com.caps.caps.model.Cliente;
import com.caps.caps.repository.ClienteRepository;
import com.caps.caps.schema.ClienteSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private ClienteMapper schemaMapper;

    public List<Cliente> listClientes() {
        List<Cliente> clienteList = (List<Cliente>) repository.findAll();
        return clienteList;
    }

    public Cliente insertCliente(ClienteSchema request) {
        return repository.save(schemaMapper.convert(request));
    }

    public Cliente updateCliente(ClienteSchema request) {
        return repository.save(schemaMapper.convert(request));
    }

    public void deleteCliente(Long idCliente) {
        repository.deleteById(idCliente);
    }

}
