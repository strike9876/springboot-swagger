package io.mahesh.web.model.response;

import io.mahesh.web.model.Cliente;
import io.mahesh.web.model.LineaMovil;
import io.mahesh.web.model.Oferta;
import lombok.Data;

@Data
public class ClienteMovilOfertasResponse {
    private Cliente cliente;
    private LineaMovil lineaMovil;
    private Oferta oferta;
}