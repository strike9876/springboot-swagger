package io.mahesh.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.mahesh.web.model.Oferta;
import io.mahesh.web.services.OfertaService;
import io.swagger.annotations.*;

@RestController
@RequestMapping("/oferta")
@Api(value = "oferta", produces = "application/json", tags = { "Controlador Oferta" })
public class OfertaController {
    @Autowired
    OfertaService ofertaService;

    @GetMapping("/")
    @ApiOperation(value = "Listar registros", tags = { "Controlador Oferta" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Oferta.class) })
    public List<Oferta> GetOfertas() {
        return ofertaService.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Listar un registro", tags = { "Controlador Oferta" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Oferta.class) })
    public Oferta GetOferta(@PathVariable Integer id) {
            return ofertaService.findById(id);
    }
    @PostMapping("/")
    @ApiOperation(value = "Servicio para registrar", tags = { "Controlador Oferta" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Oferta.class) })
    public Oferta PostOferta(@RequestBody Oferta oferta) {
        return ofertaService.registrar(oferta);
    }
    @PutMapping("/")
    @ApiOperation(value = "Modificar un registro", tags = { "Controlador Oferta" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Oferta.class) })
    public Oferta PutOferta(@RequestBody Oferta oferta) {
        return ofertaService.update(oferta);
    }
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar un registro", tags = { "Controlador Oferta" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Oferta.class) })
    public Integer DeleteOferta(@PathVariable Integer id) {
        ofertaService.deleteById(id);
        return id;
    }
}