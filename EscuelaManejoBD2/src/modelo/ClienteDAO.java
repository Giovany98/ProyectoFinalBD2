package modelo;

import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.time.Instant;
import java.util.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ClienteDAO extends Conexion {

    private String sql;
    private PreparedStatement ejecutar;
    private String respuesta;
    private Date date;
    private ResultSet rs;

    public String registrarCliente(Cliente cli) {
        respuesta = null;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
            String date = sdf.format(cli.getFechaNacimiento());
            
            this.Conectar();
            sql = "INSERT INTO CLIENTE (DPI,Nombre,Apellido,Direccion,FechaNac,Email,Telefono,Estado) values (?,?,?,?,?,?,?,?);";
            ejecutar = this.getMiConexion().prepareStatement(sql);
            ejecutar.setInt(1, Integer.parseInt(cli.getDpi()));
            ejecutar.setString(2, cli.getNombre());
            ejecutar.setString(3, cli.getApellido());
            ejecutar.setString(4, cli.getDireccion());
            ejecutar.setString(5, date);
            ejecutar.setString(6, cli.getEmail());
            ejecutar.setString(7, cli.getTelefono());
            ejecutar.setString(8, cli.getEstado());
            ejecutar.executeUpdate();
            respuesta = "Registro almacenado correctamente!!!";
        } catch (Exception e) {
            System.out.println("Error de Statement  " + e);
            respuesta = "No se puede almacenar el registro";
        }finally{
            this.cerrarConexion();
        }
        return respuesta;
    }

    public String modificarCliente(Cliente cli) {
        respuesta = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
            String date = sdf.format(cli.getFechaNacimiento());

            this.Conectar();
            sql = "UPDATE CLIENTE SET Nombre = ?, Apellido = ?, Direccion = ?, FechaNac = ?, Email = ?, Telefono = ?, Estado = ? WHERE DPI = ? ";
            ejecutar = this.getMiConexion().prepareStatement(sql);
            ejecutar.setString(1, cli.getNombre());
            ejecutar.setString(2, cli.getApellido());
            ejecutar.setString(3, cli.getDireccion());
            ejecutar.setString(4, date);
            ejecutar.setString(5, cli.getEmail());
            ejecutar.setString(6, cli.getTelefono());
            ejecutar.setString(7, cli.getEstado());
            ejecutar.setString(8, cli.getDpi());
            //ejecutar.setInt(8, Integer.parseInt(cli.getDpi()));
            ejecutar.executeUpdate();
            respuesta = "Registro modificado correctamente";
        } catch (Exception e) {
            System.out.println("Error al modificar!! " + e);
            respuesta = "No se puede modificar el registro";
        }finally{
            this.cerrarConexion();
        }
        return respuesta;
    }
    
    public String eliminarClient(String codigo){
        respuesta = null;
        try {
            this.Conectar();
            sql = "DELETE FROM CLIENTE WHERE DPI = ?";
            ejecutar = this.getMiConexion().prepareStatement(sql);
            ejecutar.setString(1, codigo);
            ejecutar.executeUpdate();
            respuesta = "Registro eliminado correctamente";
        } catch (Exception e) {
            System.out.println("Error al Eliminar!! " + e);
            respuesta = "No se puede eliminar el registro";
        }finally{
            this.cerrarConexion();
        }
        
        return respuesta;
    }
    
    public Cliente mostrarCliente(String codigo){
        Cliente cliente = new Cliente();
        try {
            this.Conectar();
            sql = "SELECT * FROM CLIENTE WHERE DPI = ?";
            ejecutar = this.getMiConexion().prepareStatement(sql);
            ejecutar.setString(1, codigo);
            ejecutar.executeQuery();
            rs = ejecutar.executeQuery();
            if(rs.next() ){
                cliente.setDpi(rs.getString("DPI"));   
                cliente.setNombre(rs.getString("Nombre"));
                cliente.setApellido(rs.getString("Apellido"));
                cliente.setDireccion(rs.getString("Direccion"));
                cliente.setFechaNacimiento(rs.getDate("FechaNac"));
                cliente.setEmail(rs.getString("Email"));
                cliente.setTelefono(rs.getString("Telefono"));
                cliente.setEstado(rs.getString("Estado"));         
            }
        }  catch (Exception e) {
            System.out.println("Error al Mostrar!! " + e);
            respuesta = "No se puede mostrar el registro";
        }finally{
            this.cerrarConexion();
        }
        return cliente;
        
    }
    
    public ArrayList<Cliente> listaCliente(){
        ArrayList<Cliente> lista = null;
        try {
            this.Conectar();
            sql = "SELECT * FROM CLIENTE";
            ejecutar = this.getMiConexion().prepareStatement(sql);
            rs = ejecutar.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                Cliente cli = new Cliente();
                cli.setDpi(rs.getString("DPI"));
                cli.setNombre(rs.getString("Nombre"));
                cli.setApellido(rs.getString("Apellido"));
                cli.setDireccion(rs.getString("Direccion"));
                cli.setFechaNacimiento(rs.getDate("FechaNac"));
                cli.setEmail(rs.getString("Email"));
                cli.setTelefono(rs.getString("Telefono"));
                cli.setEstado(rs.getString("Estado"));
                lista.add(cli);
            }
        }catch (Exception e) {
            System.out.println("Error al Mostrar Tabla!! " + e);
        }finally{
            this.cerrarConexion();
        }
        
        return lista;
    }
}
