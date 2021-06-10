/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.time.Instant;
import java.util.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PagoDAO extends Conexion {

    private String sql;
    private PreparedStatement ejecutar;
    private String respuesta;
    private Date date;
    private ResultSet rs;

    public String registrarPAGO(Pago pago) {
        respuesta = null;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
            String date = sdf.format(pago.getFecha());

            this.Conectar();
            sql = "INSERT INTO PAGO (IDPago,Tipo,Fecha,Metodo,Monto,ContratoServicio,Quien_Paga) values (?,?,?,?,?,?,?);";
            ejecutar = this.getMiConexion().prepareStatement(sql);
            ejecutar.setString(1, pago.getIdPago());
            ejecutar.setInt(2, pago.getTipoPagp());
            ejecutar.setString(3, date);
            ejecutar.setString(4, pago.getMetodo());
            ejecutar.setString(5, pago.getMonto());
            ejecutar.setString(6, pago.getContratoServicio());
            ejecutar.setString(7, pago.getQuienPaga());
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

    public String modificarPago(Pago pago) {
        respuesta = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
            String date = sdf.format(pago.getFecha());

            this.Conectar();
            sql = "UPDATE PAGO SET Tipo = ?, Fecha = ?, Metodo = ?, Monto = ?, ContratoServicio = ?, Quien_Paga = ? WHERE IDPago = ? ";
            ejecutar = this.getMiConexion().prepareStatement(sql);
            ejecutar.setInt(1, pago.getTipoPagp());
            ejecutar.setString(2, date);
            ejecutar.setString(3, pago.getMetodo());
            ejecutar.setString(4, pago.getMonto());
            ejecutar.setString(5, pago.getContratoServicio());
            ejecutar.setString(6, pago.getQuienPaga());
            ejecutar.setString(7, pago.getIdPago());
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

    public String eliminarPago(String codigo) {
        respuesta = null;
        try {
            this.Conectar();
            sql = "DELETE FROM PAGO WHERE IDPago = ?";
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

    public Pago mostrarPago(String codigo) {

        Pago pago = new Pago();
        try {
            this.Conectar();
            sql = "SELECT * FROM PAGO WHERE DPI = ?";
            ejecutar = this.getMiConexion().prepareStatement(sql);
            ejecutar.setString(1, codigo);
            ejecutar.executeQuery();
            rs = ejecutar.executeQuery();
            if (rs.next()) {
                pago.setIdPago(rs.getString("IDPago"));
                pago.setTipoPagp(rs.getInt("Tipo"));
                pago.setFecha(rs.getDate("Fecha"));
                pago.setMetodo(rs.getString("Metodo"));
                pago.setMonto(rs.getString("Monto"));
                pago.setContratoServicio(rs.getString("ContratoServicio"));
                pago.setQuienPaga(rs.getString("Quien_Paga"));
            }
        } catch (Exception e) {
            System.out.println("Error al Mostrar!! " + e);
            respuesta = "No se puede mostrar el registro";
        } finally {
            this.cerrarConexion();
        }
        return pago;

    }

    public ArrayList<Pago> listaPago() {
        ArrayList<Pago> lista = null;
        try {
            this.Conectar();
            sql = "SELECT * FROM PAGO";
            ejecutar = this.getMiConexion().prepareStatement(sql);
            rs = ejecutar.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Pago pago = new Pago();
                pago.setIdPago(rs.getString("IDPago"));
                pago.setTipoPagp(rs.getInt("Tipo"));
                pago.setFecha(rs.getDate("Fecha"));
                pago.setMetodo(rs.getString("Metodo"));
                pago.setMonto(rs.getString("Monto"));
                pago.setContratoServicio(rs.getString("ContratoServicio"));
                pago.setQuienPaga(rs.getString("Quien_Paga"));

                lista.add(pago);
            }
        } catch (Exception e) {
            System.out.println("Error al Mostrar Tabla!! " + e);
        } finally {
            this.cerrarConexion();
        }

        return lista;
    }
}
