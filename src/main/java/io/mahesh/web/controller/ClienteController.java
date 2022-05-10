package io.mahesh.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.mahesh.web.model.Cliente;
import io.mahesh.web.model.request.ClienteRequest;
import io.mahesh.web.services.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/cliente")
@Api(value = "cliente", produces = "application/json", tags = { "Controlador Cliente" })
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping("/")
    @ApiOperation(value = "Listar registros", tags = { "Controlador Cliente" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Cliente.class) })
    public List<Cliente> GetClientes() {
        return clienteService.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Listar un registro", tags = { "Controlador Cliente" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Cliente.class) })
    public Cliente GetCliente(@PathVariable Integer id) {
            return clienteService.findById(id);
    }
    @PostMapping("/")
    @ApiOperation(value = "Servicio para registrar", tags = { "Controlador Cliente" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Cliente.class) })
    public Cliente PostCliente(@RequestBody ClienteRequest cliente) {
        return clienteService.registrar(cliente);
    }
    @PutMapping("/")
    @ApiOperation(value = "Modificar un registro", tags = { "Controlador Cliente" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Cliente.class) })
    public Cliente PutCliente(@RequestBody ClienteRequest cliente) {
        return clienteService.update(cliente);
    }
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar un registro", tags = { "Controlador Cliente" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Cliente.class) })
    public Integer DeleteCliente(@PathVariable Integer id) {
        clienteService.deleteById(id);
        return id;
    }
}