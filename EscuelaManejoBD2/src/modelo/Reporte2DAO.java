package modelo;

import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.time.Instant;
import java.util.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Reporte2DAO extends Conexion{

    private String sql;
    private PreparedStatement ejecutar;
    private String respuesta;
    private Date date;
    private ResultSet rs;

    public ArrayList<Reporte2> listaReporte2() {
        ArrayList<Reporte2> lista = null;
        try {
            this.Conectar();
            sql = "select A.NumeroContrato, B.Nombre, B.Apellido, A.VehiculoAsignado, C.Marca, C.Modelo, C.Anio, A.FechaInicio, A.FechaFin, A.Estado \n"
                    + "from CONTRATO A\n"
                    + "INNER JOIN PERSONAL B\n"
                    + "ON A.InstructorAsignado = B.DPI\n"
                    + "INNER JOIN VEHICULO C \n"
                    + "ON A.VehiculoAsignado = C.CodigoVehiculo\n"
                    + "WHERE A.Estado = 'Finalizado'";
            ejecutar = this.getMiConexion().prepareStatement(sql);
            rs = ejecutar.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Reporte2 rp2 = new Reporte2();
                rp2.setNumeroContrato(rs.getString("NumeroContrato"));
                rp2.setNombre(rs.getString("Nombre"));
                rp2.setApellido(rs.getString("Apellido"));
                rp2.setVehiculo(rs.getString("VehiculoAsignado"));
                rp2.setMarca(rs.getString("Marca"));
                rp2.setModelo(rs.getString("Modelo"));
                rp2.setAnio(rs.getString("Anio"));
                rp2.setFechaInicio(rs.getDate("FechaInicio"));
                rp2.setFechaFin(rs.getDate("FechaFin"));
                rp2.setEstado(rs.getString("Estado"));
                lista.add(rp2);
            }
        } catch (Exception e) {
            System.out.println("Error al Mostrar Tabla!! " + e);
        } finally {
            this.cerrarConexion();
        }

        return lista;
    }
}
