package io.mahesh.web.controller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.mahesh.web.model.response.ClienteMovilOfertasResponse;
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

    @GetMapping("/byRange/{fechaini}/{fechafin}")
	@ApiOperation(value = "Listar Citas por fechas", tags = { "Controlador Cita" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = ClienteMovilOfertasResponse.class)
	})
	public List<ClienteMovilOfertasResponse> byrangecitaprogramadatotal(@PathVariable String fechaini, @PathVariable String fechafin) {
		SimpleDateFormat ddmmyy=new SimpleDateFormat("yyyy-MM-dd");
		Date ini;
		Date fin;
		try {
			ini = ddmmyy.parse(fechaini + " 00:00:00");
			fin = ddmmyy.parse(fechafin + " 23:59:59");
			return this.service.GetClienteOferta(ini, fin).stream().collect(Collectors.toList());
		} catch (ParseException e) {
			return new ArrayList<>();
		}
	}
}