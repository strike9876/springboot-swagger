package io.mahesh.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.mahesh.web.model.ClienteMovil;
import io.mahesh.web.model.request.ClienteMovilRequest;
import io.mahesh.web.services.ClienteMovilService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/clienteMovil")
@Api(value = "clienteMovil", produces = "application/json", tags = { "Controlador ClienteMovil" })
public class ClienteMovilController {
    @Autowired
    ClienteMovilService clienteMovilService;

    @GetMapping("/")
    @ApiOperation(value = "Listar registros", tags = { "Controlador ClienteMovil" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = ClienteMovil.class) })
    public List<ClienteMovil> GetClienteMovils() {
        return clienteMovilService.findAll();
    }

    @GetMapping("/{idCliente}/{idLineaMovil}")
    @ApiOperation(value = "Listar un registro", tags = { "Controlador ClienteMovil" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = ClienteMovil.class) })
    public ClienteMovil GetClienteMovil(@PathVariable Integer idCliente, @PathVariable Integer idLineaMovil) {
            return clienteMovilService.selectByIdClienteIdLineaMovil(idCliente, idLineaMovil);
    }
    @PostMapping("/")
    @ApiOperation(value = "Servicio para registrar", tags = { "Controlador ClienteMovil" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = ClienteMovil.class) })
    public ClienteMovil PostClienteMovil(@RequestBody ClienteMovilRequest clienteMovil) {
        return clienteMovilService.registrar(clienteMovil);
    }
    @PutMapping("/")
    @ApiOperation(value = "Modificar un registro", tags = { "Controlador ClienteMovil" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = ClienteMovil.class) })
    public ClienteMovil PutClienteMovil(@RequestBody ClienteMovilRequest clienteMovil) {
        return clienteMovilService.update(clienteMovil);
    }
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar un registro", tags = { "Controlador ClienteMovil" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = ClienteMovil.class) })
    public Integer DeleteClienteMovil(@PathVariable Integer id) {
        clienteMovilService.deleteById(id);
        return id;
    }
}