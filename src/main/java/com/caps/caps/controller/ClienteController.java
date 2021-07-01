package com.caps.caps.controller;

import com.caps.caps.mapper.ClienteMapper;
import com.caps.caps.schema.ClienteSchema;
import com.caps.caps.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @Autowired
    private ClienteMapper schemaMapper;

    @GetMapping
    @ResponseBody
    public List<ClienteSchema> getListAll() {
        return service.listClientes().stream().map(schemaMapper::convert).collect(Collectors.toList());
    }

    @PostMapping
    public ClienteSchema insertCliente(@Valid @RequestBody ClienteSchema request) {
        return schemaMapper.convert(service.insertCliente(request));
    }

    @PutMapping("/{id}")
    public ClienteSchema updateCliente(@PathVariable Long id,
                                       @RequestBody ClienteSchema request) {
        if(request == null) {
            request = new ClienteSchema();
        }
        request.setId(id);
        return schemaMapper.convert(service.updateCliente(request));
    }

    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Long id) {
        service.deleteCliente(id);
    }

}
