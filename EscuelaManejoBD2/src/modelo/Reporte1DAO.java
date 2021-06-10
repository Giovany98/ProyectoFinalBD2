package modelo;

import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.time.Instant;
import java.util.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Reporte1DAO extends Conexion {

    private String sql;
    private PreparedStatement ejecutar;
    private String respuesta;
    private Date date;
    private ResultSet rs;

    public ArrayList<Reporte1> listaReporte1() {
        ArrayList<Reporte1> lista = null;
        try {
            this.Conectar();
            sql = "SELECT A.CodigoVehiculo, A.Marca, A.Modelo, A.Anio, B.Calle_avenida, B.Numero_casa, B.Colonia, B.Departamento, B.Estado from VEHICULO A\n"
                    + "INNER JOIN DIRECCION_ESCUELA B\n"
                    + "ON A.CodigoDireccion = B.CodigoDireccion\n"
                    + "WHERE A.Anio >= 2016";
            ejecutar = this.getMiConexion().prepareStatement(sql);
            rs = ejecutar.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Reporte1 rp1 = new Reporte1();      
                rp1.setCodigoVehiculo(rs.getString("CodigoVehiculo"));
                rp1.setMarca(rs.getString("Marca"));
                rp1.setModelo(rs.getString("Modelo"));
                rp1.setAnio(rs.getString("Anio"));
                rp1.setCalleAvenida(rs.getString("Calle_avenida"));
                rp1.setNumeroCasa(rs.getInt("Numero_Casa"));
                rp1.setColonia(rs.getString("Colonia"));
                rp1.setDepartamento(rs.getString("Departamento"));
                rp1.setEstado(rs.getString("Estado"));
                lista.add(rp1);
            }
        } catch (Exception e) {
            System.out.println("Error al Mostrar Tabla!! " + e);
        } finally {
            this.cerrarConexion();
        }

        return lista;
    }

}
