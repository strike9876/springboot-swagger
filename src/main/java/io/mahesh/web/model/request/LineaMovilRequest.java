package io.mahesh.web.model.request;
import lombok.Data;

@Data
public class LineaMovilRequest {
    private int idLineaMovil;
    private int nroTelefono;
    private int idEstado;
    private int idTipo;
    private int idPlan;
}