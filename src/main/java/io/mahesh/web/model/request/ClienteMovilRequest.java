package io.mahesh.web.model.request;
import lombok.Data;

@Data
public class ClienteMovilRequest {
    private int idClienteMovil;
    private int idLineaMovil;
    private int idCliente;
}