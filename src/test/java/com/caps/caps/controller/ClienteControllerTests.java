package com.caps.caps.controller;


import com.caps.caps.mapper.ClienteMapper;
import com.caps.caps.model.Cliente;
import com.caps.caps.service.ClienteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ClienteController.class)
public class ClienteControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClienteService service;

    @MockBean
    private ClienteMapper schemaMapper;

    @Test
    public void findAll() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setId(0L);
        cliente.setName("CESAR ALEXANDRE");
        cliente.setDocument("19173686800");
        List<Cliente> clienteList = List.of(cliente);
        when(service.listClientes()).thenReturn(clienteList);
        this.mockMvc.perform(get("/v1/clientes"))
                .andExpect(status().isOk());
    }

}
