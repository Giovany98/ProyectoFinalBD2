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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Reporte2;
import modelo.Reporte2DAO;
import vista.frmReporte2;

public class ControladorRP2 implements ActionListener, MouseListener {

    frmReporte2 vistaReporte2 = new frmReporte2();
    Reporte2DAO modeloReporte2 = new Reporte2DAO();
    Reporte2 rp2 = new Reporte2();

    public ControladorRP2(frmReporte2 vistaReporte2, Reporte2DAO modeloReporte2, Reporte2 rp2) {
        this.vistaReporte2 = vistaReporte2;
        this.modeloReporte2 = modeloReporte2;
        this.rp2 = rp2;
        llenarTabla(vistaReporte2.tblDatos);
    }

    public void llenarTabla(JTable tablaDatos) {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        tablaDatos.setModel(modeloTabla);
        modeloTabla.addColumn("NUMERO CONTRATO");
        modeloTabla.addColumn("NOMBRE");
        modeloTabla.addColumn("APELLIDO");
        modeloTabla.addColumn("VEHICULO ASIGNADO");
        modeloTabla.addColumn("MARCA");
        modeloTabla.addColumn("MODELO");
        modeloTabla.addColumn("AÑO");
        modeloTabla.addColumn("FECHA INICIO");
        modeloTabla.addColumn("FECHA FIN");
        modeloTabla.addColumn("ESTADO");
        Object[] columna = new Object[10];
        int numeroRegistros = modeloReporte2.listaReporte2().size();
        for (int i = 0; i < numeroRegistros; i++) {
            columna[0] = modeloReporte2.listaReporte2().get(i).getNumeroContrato();
            columna[1] = modeloReporte2.listaReporte2().get(i).getNombre();
            columna[2] = modeloReporte2.listaReporte2().get(i).getApellido();
            columna[3] = modeloReporte2.listaReporte2().get(i).getVehiculo();
            columna[4] = modeloReporte2.listaReporte2().get(i).getMarca();
            columna[5] = modeloReporte2.listaReporte2().get(i).getModelo();
            columna[6] = modeloReporte2.listaReporte2().get(i).getAnio();
            columna[7] = modeloReporte2.listaReporte2().get(i).getFechaInicio();
            columna[8] = modeloReporte2.listaReporte2().get(i).getFechaFin();
            columna[9] = modeloReporte2.listaReporte2().get(i).getEstado();
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
