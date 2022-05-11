package io.mahesh.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.mahesh.web.model.Tipo;
import io.mahesh.web.services.TipoService;
import io.swagger.annotations.*;

@RestController
@RequestMapping("/tipo")
@Api(value = "tipo", produces = "application/json", tags = { "Controlador Tipo" })
public class TipoController {
    @Autowired
    TipoService tipoService;

    @GetMapping("/")
    @ApiOperation(value = "Listar registros", tags = { "Controlador Tipo" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Tipo.class) })
    public List<Tipo> GetTipos() {
        return tipoService.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Listar un registro", tags = { "Controlador Tipo" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Tipo.class) })
    public Tipo GetTipo(@PathVariable Integer id) {
            return tipoService.findById(id);
    }
    @PostMapping("/")
    @ApiOperation(value = "Servicio para registrar", tags = { "Controlador Tipo" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Tipo.class) })
    public Tipo PostTipo(@RequestBody Tipo tipo) {
        return tipoService.registrar(tipo);
    }
    @PutMapping("/")
    @ApiOperation(value = "Modificar un registro", tags = { "Controlador Tipo" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Tipo.class) })
    public Tipo PutTipo(@RequestBody Tipo tipo) {
        return tipoService.update(tipo);
    }
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar un registro", tags = { "Controlador Tipo" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Tipo.class) })
    public Integer DeleteTipo(@PathVariable Integer id) {
        tipoService.deleteById(id);
        return id;
    }
}