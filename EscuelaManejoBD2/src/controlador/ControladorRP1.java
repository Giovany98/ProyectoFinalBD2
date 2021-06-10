
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.ClienteDAO;
import vista.frmCliente;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Reporte1;
import modelo.Reporte1DAO;
import vista.frmReporte1;

public class ControladorRP1 implements ActionListener, MouseListener {
    
    frmReporte1 vistaReporte1 = new frmReporte1();
    Reporte1DAO modeloReporte1 = new Reporte1DAO();
    Reporte1 rp1 = new Reporte1();
    
    
        public ControladorRP1(frmReporte1 vistaReporte1, Reporte1DAO modeloReporte1, Reporte1 rp1 ) {
        this.vistaReporte1 = vistaReporte1;
        this.modeloReporte1 = modeloReporte1;
        this.rp1 = rp1;
        llenarTabla(vistaReporte1.tblDatos);
    }
    
        public void llenarTabla(JTable tablaDatos) {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        tablaDatos.setModel(modeloTabla);
        modeloTabla.addColumn("ID VEHICULO");
        modeloTabla.addColumn("MARCA");
        modeloTabla.addColumn("MODELO");
        modeloTabla.addColumn("AÑO");
        modeloTabla.addColumn("CALLE_AVENIDA");
        modeloTabla.addColumn("NUMERO_CASA");
        modeloTabla.addColumn("COLONIA");
        modeloTabla.addColumn("DEPARTAMENTO");
        modeloTabla.addColumn("ESTADO");
        Object[] columna = new Object[9];
        int numeroRegistros = modeloReporte1.listaReporte1().size();
        for (int i = 0; i < numeroRegistros; i++) {
            columna[0] = modeloReporte1.listaReporte1().get(i).getCodigoVehiculo();
            columna[1] = modeloReporte1.listaReporte1().get(i).getMarca();
            columna[2] = modeloReporte1.listaReporte1().get(i).getModelo();
            columna[3] = modeloReporte1.listaReporte1().get(i).getAnio();
            columna[4] = modeloReporte1.listaReporte1().get(i).getCalleAvenida();
            columna[5] = modeloReporte1.listaReporte1().get(i).getNumeroCasa();
            columna[6] = modeloReporte1.listaReporte1().get(i).getColonia();
            columna[7] = modeloReporte1.listaReporte1().get(i).getDepartamento();
            columna[8] = modeloReporte1.listaReporte1().get(i).getEstado();
            modeloTabla.addRow(columna);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
