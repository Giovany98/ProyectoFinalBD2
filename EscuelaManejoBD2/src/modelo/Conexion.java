
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Conexion {
    private Connection miConexion;
    private static final String url = "jdbc:sqlserver://UMG-VM\\INSTANCIA1:49220;databaseName=SBO_ESCUELA_MANEJO";
    private static final String user = "sa";
    private static final String password = "1234";
//    public static String usuario;
//    public static String password;
    public static boolean status = false;

    public Connection getMiConexion() {
        status = false;
        return miConexion;
    }

    public void setMiConexion(Connection miConexion) {
        this.miConexion = miConexion;
    }
    
    public void Conectar(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            miConexion = (Connection) DriverManager.getConnection(url,user,password);
            status = true;
        } catch (Exception e) {
            System.out.println("Error en la conexion!! " + e);
        }
    }
    
    public void cerrarConexion(){
        try {
            if(miConexion!=null){
                if(miConexion.isClosed()==false){
                    miConexion.close();
                }
            }
        } catch (Exception e) {
            System.out.println("Error al cerrar la conexion!! " + e);
        }
    }

    public Connection conexion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
//    public void setcuenta(String usuario, String password){
//        Conexion.user = usuario;
//        Conexion.password = password;
//    }
    
        public boolean getstatus(){
        return  status;
    }
//    
//    public ResultSet Consulta(String consulta){
//        Connection con = getMiConexion();
//        Statement declara;
//        try{
//            declara=con.createStatement();
//            ResultSet respuesta = declara.executeQuery(consulta);
//            return respuesta;
//        }catch (SQLException e){
//            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(),
//            "Error de Conexion",JOptionPane.ERROR_MESSAGE);
//        }
//        return null;
//    }
    
        
        public int Login(String User, String Pass){
            Integer resultado = null;
            
            try {
                Statement ejecutar = miConexion.createStatement();
                ResultSet rs = ejecutar.executeQuery("SELECT * FROM LOGINS WHERE NOMBRE = '"+User+"' and Contraseña ='"+Pass+"';");
                
                if(rs.next()){
                    JOptionPane.showMessageDialog(null, "Bienvenido","Usuario Correcto",JOptionPane.YES_OPTION);
                    resultado = 1;
                }else{
                    JOptionPane.showMessageDialog(null,"Error de Autenticacion: ","Usuario y contraseña incorrecto", JOptionPane.ERROR_MESSAGE);
                    resultado = 0;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Error al conectar "+ e.getMessage());
            }
            return resultado;
        }
}
    

