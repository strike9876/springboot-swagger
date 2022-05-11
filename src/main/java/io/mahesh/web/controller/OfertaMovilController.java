package io.mahesh.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.mahesh.web.model.OfertaMovil;
import io.mahesh.web.model.request.OfertaMovilRequest;
import io.mahesh.web.services.OfertaMovilService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/ofertaMovil")
@Api(value = "ofertaMovil", produces = "application/json", tags = { "Controlador OfertaMovil" })
public class OfertaMovilController {
    @Autowired
    OfertaMovilService ofertaMovilService;

    @GetMapping("/")
    @ApiOperation(value = "Listar registros", tags = { "Controlador OfertaMovil" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = OfertaMovil.class) })
    public List<OfertaMovil> GetOfertaMovils() {
        return ofertaMovilService.findAll();
    }

    @GetMapping("/{idOferta}/{idLineaMovil}")
    @ApiOperation(value = "Listar un registro", tags = { "Controlador OfertaMovil" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = OfertaMovil.class) })
    public OfertaMovil GetOfertaMovil(@PathVariable Integer idOferta, @PathVariable Integer idLineaMovil) {
            return ofertaMovilService.selectByIdOfertaIdLineaMovil(idOferta, idLineaMovil);
    }
    @PostMapping("/")
    @ApiOperation(value = "Servicio para registrar", tags = { "Controlador OfertaMovil" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = OfertaMovil.class) })
    public OfertaMovil PostOfertaMovil(@RequestBody OfertaMovilRequest ofertaMovil) {
        return ofertaMovilService.registrar(ofertaMovil);
    }
    @PutMapping("/")
    @ApiOperation(value = "Modificar un registro", tags = { "Controlador OfertaMovil" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = OfertaMovil.class) })
    public OfertaMovil PutOfertaMovil(@RequestBody OfertaMovilRequest ofertaMovil) {
        return ofertaMovilService.update(ofertaMovil);
    }
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar un registro", tags = { "Controlador OfertaMovil" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = OfertaMovil.class) })
    public Integer DeleteOfertaMovil(@PathVariable Integer id) {
        ofertaMovilService.deleteById(id);
        return id;
    }
}