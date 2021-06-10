package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TipoPagoDAO extends Conexion {

    private String sql;
    private PreparedStatement ejecutar;
    private String respuesta;
    private Date date;
    private ResultSet rs;

    public String registrarTipoPago(TipoPago tp) {
        respuesta = null;

        try {
            this.Conectar();
            sql = "INSERT INTO TIPO_PAGO (IDTIPOPAGO, Descripcion) values(?,?);";
            ejecutar = this.getMiConexion().prepareStatement(sql);
            ejecutar.setInt(1, tp.getIdTipoPago());
            ejecutar.setString(2, tp.getDescripcion());
            ejecutar.executeUpdate();
            respuesta = "Registro almacenado correctamente!!!";
        } catch (Exception e) {
            System.out.println("Error de Statement  " + e);
            respuesta = "No se puede almacenar el registro";
        } finally {
            this.cerrarConexion();
        }
        return respuesta;
    }

    public String modificarTipoPago(TipoPago tp) {
        respuesta = null;
        try {
            this.Conectar();
            sql = "UPDATE TIPO_PAGO SET Descripcion=? WHERE IDTIPOPAGO=?";
            ejecutar = this.getMiConexion().prepareStatement(sql);
            ejecutar.setString(1, tp.getDescripcion());
            ejecutar.setInt(2, tp.getIdTipoPago());
            ejecutar.executeUpdate();
            respuesta = "Registro modificado correctamente";
        } catch (Exception e) {
            System.out.println("Error al modificar!! " + e);
            respuesta = "No se puede modificar el registro";
        } finally {
            this.cerrarConexion();
        }
        return respuesta;
    }

    public String eliminarTipoPago(String codigo) {
        respuesta = null;
        try {
            this.Conectar();
            sql = "DELETE FROM TIPO_PAGO WHERE  IDTIPOPAGO = ?";
            ejecutar = this.getMiConexion().prepareStatement(sql);
            ejecutar.setString(1, codigo);
            ejecutar.executeUpdate();
            respuesta = "Registro eliminado correctamente";
        } catch (Exception e) {
            System.out.println("Error al Eliminar!! " + e);
            respuesta = "No se puede eliminar el registro";
        } finally {
            this.cerrarConexion();
        }

        return respuesta;
    }
    
        public ArrayList<TipoPago> listaCliente(){
        ArrayList<TipoPago> lista = null;
        try {
            this.Conectar();
            sql = "SELECT * FROM TIPO_PAGO";
            ejecutar = this.getMiConexion().prepareStatement(sql);
            rs = ejecutar.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                TipoPago tp = new TipoPago();
                tp.setIdTipoPago(rs.getInt("IDTIPOPAGO"));
                tp.setDescripcion(rs.getString("Descripcion"));
                lista.add(tp);
            }
        }catch (Exception e) {
            System.out.println("Error al Mostrar Tabla!! " + e);
        }finally{
            this.cerrarConexion();
        }
        
        return lista;
    }
}
