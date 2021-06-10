
package modelo;

import java.util.Date;


public class Pago {
    private String idPago;
    private Integer tipoPagp;
    private Date fecha;
    private String metodo;
    private String monto;
    private String contratoServicio;
    private String quienPaga;

    public Pago() {
     this.idPago=null;
     this.tipoPagp=null;
     this.fecha=null;
     this.metodo=null;
     this.metodo=null;
     this.contratoServicio=null;
     this.quienPaga=null;
    }

    public String getIdPago() {
        return idPago;
    }

    public void setIdPago(String idPago) {
        this.idPago = idPago;
    }

    public Integer getTipoPagp() {
        return tipoPagp;
    }

    public void setTipoPagp(Integer tipoPagp) {
        this.tipoPagp = tipoPagp;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getContratoServicio() {
        return contratoServicio;
    }

    public void setContratoServicio(String contratoServicio) {
        this.contratoServicio = contratoServicio;
    }

    public String getQuienPaga() {
        return quienPaga;
    }

    public void setQuienPaga(String quienPaga) {
        this.quienPaga = quienPaga;
    }
    
    
    
}
