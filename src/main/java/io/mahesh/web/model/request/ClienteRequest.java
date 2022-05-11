package io.mahesh.web.model.request;
import java.util.Date;
import lombok.Data;

@Data
public class ClienteRequest {
    private int idCliente;
    private String nombreCompleto;
    private int idTipoDocumento;
    private int nroDocumento;
    private Date fechaNacimiento;
}