package io.mahesh.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.mahesh.web.model.LineaMovil;
import io.mahesh.web.model.request.LineaMovilRequest;
import io.mahesh.web.services.LineaMovilService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/lineaMovil")
@Api(value = "lineaMovil", produces = "application/json", tags = { "Controlador LineaMovil" })
public class LineaMovilController {
    @Autowired
    LineaMovilService lineaMovilService;

    @GetMapping("/")
    @ApiOperation(value = "Listar registros", tags = { "Controlador LineaMovil" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = LineaMovil.class) })
    public List<LineaMovil> GetLineaMovils() {
        return lineaMovilService.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Listar un registro", tags = { "Controlador LineaMovil" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = LineaMovil.class) })
    public LineaMovil GetLineaMovil(@PathVariable Integer id) {
            return lineaMovilService.findById(id);
    }
    @PostMapping("/")
    @ApiOperation(value = "Servicio para registrar", tags = { "Controlador LineaMovil" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = LineaMovil.class) })
    public LineaMovil PostLineaMovil(@RequestBody LineaMovilRequest lineaMovil) {
        return lineaMovilService.registrar(lineaMovil);
    }
    @PutMapping("/")
    @ApiOperation(value = "Modificar un registro", tags = { "Controlador LineaMovil" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = LineaMovil.class) })
    public LineaMovil PutLineaMovil(@RequestBody LineaMovilRequest lineaMovil) {
        return lineaMovilService.update(lineaMovil);
    }
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar un registro", tags = { "Controlador LineaMovil" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = LineaMovil.class) })
    public Integer DeleteLineaMovil(@PathVariable Integer id) {
        lineaMovilService.deleteById(id);
        return id;
    }
}