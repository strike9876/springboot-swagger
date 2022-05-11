package io.mahesh.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.mahesh.web.model.TipoDocumento;
import io.mahesh.web.services.TipoDocumentoService;
import io.swagger.annotations.*;

@RestController
@RequestMapping("/tipoDocumento")
@Api(value = "tipoDocumento", produces = "application/json", tags = { "Controlador TipoDocumento" })
public class TipoDocumentoController {
    @Autowired
    TipoDocumentoService tipoDocumentoService;

    @GetMapping("/")
    @ApiOperation(value = "Listar registros", tags = { "Controlador TipoDocumento" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = TipoDocumento.class) })
    public List<TipoDocumento> GetTipoDocumentos() {
        return tipoDocumentoService.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Listar un registro", tags = { "Controlador TipoDocumento" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = TipoDocumento.class) })
    public TipoDocumento GetTipoDocumento(@PathVariable Integer id) {
            return tipoDocumentoService.findById(id);
    }
    @PostMapping("/")
    @ApiOperation(value = "Servicio para registrar", tags = { "Controlador TipoDocumento" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = TipoDocumento.class) })
    public TipoDocumento PostTipoDocumento(@RequestBody TipoDocumento tipoDocumento) {
        return tipoDocumentoService.registrar(tipoDocumento);
    }
    @PutMapping("/")
    @ApiOperation(value = "Modificar un registro", tags = { "Controlador TipoDocumento" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = TipoDocumento.class) })
    public TipoDocumento PutTipoDocumento(@RequestBody TipoDocumento tipoDocumento) {
        return tipoDocumentoService.update(tipoDocumento);
    }
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar un registro", tags = { "Controlador TipoDocumento" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = TipoDocumento.class) })
    public Integer DeleteTipoDocumento(@PathVariable Integer id) {
        tipoDocumentoService.deleteById(id);
        return id;
    }
}