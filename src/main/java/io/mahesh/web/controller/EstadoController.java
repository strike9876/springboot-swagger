package io.mahesh.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.mahesh.web.model.Estado;
import io.mahesh.web.services.EstadoService;
import io.swagger.annotations.*;

@RestController
@RequestMapping("/estado")
@Api(value = "estado", produces = "application/json", tags = { "Controlador Estado" })
public class EstadoController {
    @Autowired
    EstadoService estadoService;

    @GetMapping("/")
    @ApiOperation(value = "Listar registros", tags = { "Controlador Estado" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Estado.class) })
    public List<Estado> GetEstados() {
        return estadoService.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Listar un registro", tags = { "Controlador Estado" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Estado.class) })
    public Estado GetEstado(@PathVariable Integer id) {
            return estadoService.findById(id);
    }
    @PostMapping("/")
    @ApiOperation(value = "Servicio para registrar", tags = { "Controlador Estado" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Estado.class) })
    public Estado PostEstado(@RequestBody Estado estado) {
        return estadoService.registrar(estado);
    }
    @PutMapping("/")
    @ApiOperation(value = "Modificar un registro", tags = { "Controlador Estado" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Estado.class) })
    public Estado PutEstado(@RequestBody Estado estado) {
        return estadoService.update(estado);
    }
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar un registro", tags = { "Controlador Estado" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Estado.class) })
    public Integer DeleteEstado(@PathVariable Integer id) {
        estadoService.deleteById(id);
        return id;
    }
}