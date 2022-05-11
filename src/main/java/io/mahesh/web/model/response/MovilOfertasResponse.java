package io.mahesh.web.model.response;
import java.util.List;

import io.mahesh.web.model.LineaMovil;
import io.mahesh.web.model.Oferta;
import lombok.Data;

@Data
public class MovilOfertasResponse {
    private LineaMovil lineaMovil;
    private List<Oferta> listOferta;
}