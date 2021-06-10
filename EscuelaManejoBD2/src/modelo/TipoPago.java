
package modelo;

public class TipoPago {
    
    private Integer idTipoPago;
    private String Descripcion;

    public TipoPago() {
        this.idTipoPago=null;
        this.Descripcion=null;
    }

    public Integer getIdTipoPago() {
        return idTipoPago;
    }

    public void setIdTipoPago(Integer idTipoPago) {
        this.idTipoPago = idTipoPago;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
    
    
}
