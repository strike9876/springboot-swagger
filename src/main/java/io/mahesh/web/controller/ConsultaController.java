package io.mahesh.web.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.mahesh.web.model.response.MovilOfertasResponse;
import io.mahesh.web.services.ConsultaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/consulta")
@Api(value = "consulta", produces = "application/json", tags = { "Controlador Consulta" })
public class ConsultaController {
    @Autowired
    private ConsultaService service;

    @GetMapping("/ofertasPorCadaLinea/{nroDocumento}/{idTipoDocumento}")
    @ApiOperation(value = "Consulta por nroDocumento y idTipoDocumento para mostrar todas las lineas con oferta", tags = { "Controlador Consulta" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = MovilOfertasResponse.class) })
    public List<MovilOfertasResponse> GetOfertasPorCadaLineaDeCliente(@PathVariable Integer nroDocumento, @PathVariable Integer idTipoDocumento) {
        return service.GetOfertasPorCadaLineaDeCliente(nroDocumento, idTipoDocumento);
    }

    
}