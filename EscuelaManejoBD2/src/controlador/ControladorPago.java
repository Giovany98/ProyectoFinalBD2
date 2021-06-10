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
import modelo.Pago;
import modelo.PagoDAO;
import vista.frmPago;

public class ControladorPago implements ActionListener, MouseListener {

    frmPago vistaPago = new frmPago();
    PagoDAO modeloPago = new PagoDAO();
    Pago pago = new Pago();

    public ControladorPago(frmPago vistaPago, PagoDAO modeloPago, Pago pago) {
        this.vistaPago = vistaPago;
        this.modeloPago = modeloPago;
        this.pago = pago;
        this.vistaPago.btnGuardar.addActionListener(this);
        this.vistaPago.btnModificar.addActionListener(this);
        this.vistaPago.btnEliminar.addActionListener(this);
        this.vistaPago.btnMostrar.addActionListener(this);
        this.vistaPago.tblDatos.addMouseListener(this);
        llenarTabla(vistaPago.tblDatos);

    }

    public void insertPago() {
        pago.setIdPago(vistaPago.txtIdPago.getText());
        pago.setTipoPagp(Integer.parseInt(vistaPago.txtTipoPago.getText()));
        pago.setFecha(vistaPago.txtFecha.getDate());
        pago.setMetodo(vistaPago.txtMetodo.getText());
        pago.setMonto(vistaPago.txtMonto.getText());
        pago.setContratoServicio(vistaPago.txtContratoServicio.getText());
        pago.setQuienPaga(vistaPago.txtDPICliente.getText());
        String respuestaInsert = this.modeloPago.registrarPAGO(pago);
        if (respuestaInsert != null) {
            JOptionPane.showMessageDialog(null, respuestaInsert);
            llenarTabla(vistaPago.tblDatos);
        }
    }

    public void modificarPago() {
        pago.setIdPago(vistaPago.txtIdPago.getText());
        pago.setTipoPagp(Integer.parseInt(vistaPago.txtTipoPago.getText()));
        pago.setFecha(vistaPago.txtFecha.getDate());
        pago.setMetodo(vistaPago.txtMetodo.getText());
        pago.setMonto(vistaPago.txtMonto.getText());
        pago.setContratoServicio(vistaPago.txtContratoServicio.getText());
        pago.setQuienPaga(vistaPago.txtDPICliente.getText());
        String respuestaUpdate = this.modeloPago.modificarPago(pago);
        if (respuestaUpdate != null) {
            JOptionPane.showMessageDialog(null, respuestaUpdate);
            llenarTabla(vistaPago.tblDatos);
        }
    }

    public void eliminarPago() {
        pago.setIdPago(vistaPago.txtIdPago.getText());
        String respuestaEliminar = modeloPago.eliminarPago(pago.getIdPago());
        JOptionPane.showMessageDialog(vistaPago, respuestaEliminar);
        llenarTabla(vistaPago.tblDatos);
    }

    public void mostrarPago() {
        
        pago.setIdPago(vistaPago.txtIdPago.getText());
        pago = modeloPago.mostrarPago(pago.getIdPago());
        vistaPago.txtTipoPago.setText(String.valueOf(pago.getTipoPagp()));
        vistaPago.txtFecha.setDate(pago.getFecha());
        vistaPago.txtMetodo.setText(pago.getMetodo());
        vistaPago.txtMonto.setText(pago.getMonto());
        vistaPago.txtContratoServicio.setText(pago.getContratoServicio());
        vistaPago.txtDPICliente.setText(pago.getQuienPaga());
    }
    
        public void llenarTabla(JTable tablaDatos) {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        tablaDatos.setModel(modeloTabla);
        modeloTabla.addColumn("IDPago");
        modeloTabla.addColumn("Tipo");
        modeloTabla.addColumn("Fecha");
        modeloTabla.addColumn("Metodo");
        modeloTabla.addColumn("Monto");
        modeloTabla.addColumn("ContratoServicio");
        modeloTabla.addColumn("Quien_Pago");
        Object[] columna = new Object[7];
        int numeroRegistros = modeloPago.listaPago().size();
        for (int i = 0; i < numeroRegistros; i++) {
            columna[0] = modeloPago.listaPago().get(i).getIdPago();
            columna[1] = modeloPago.listaPago().get(i).getTipoPagp();
            columna[2] = modeloPago.listaPago().get(i).getFecha();
            columna[3] = modeloPago.listaPago().get(i).getMetodo();
            columna[4] = modeloPago.listaPago().get(i).getMonto();
            columna[5] = modeloPago.listaPago().get(i).getContratoServicio();
            columna[6] = modeloPago.listaPago().get(i).getQuienPaga();
            modeloTabla.addRow(columna);
        }

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaPago.btnGuardar) {
            insertPago();
        }
        if (e.getSource() == vistaPago.btnModificar) {
            modificarPago();
        }
        if (e.getSource() == vistaPago.btnEliminar) {
            eliminarPago();
        }
        if (e.getSource() == vistaPago.btnMostrar) {
            mostrarPago();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vistaPago.tblDatos) {
            vistaPago.txtIdPago.setText(vistaPago.tblDatos.getValueAt(vistaPago.tblDatos.getSelectedRow(), 0).toString());
            vistaPago.txtTipoPago.setText(vistaPago.tblDatos.getValueAt(vistaPago.tblDatos.getSelectedRow(), 1).toString());
            vistaPago.txtFecha.setDate((Date) vistaPago.tblDatos.getValueAt(vistaPago.tblDatos.getSelectedRow(), 2));
            vistaPago.txtMetodo.setText(vistaPago.tblDatos.getValueAt(vistaPago.tblDatos.getSelectedRow(), 3).toString());
            vistaPago.txtMonto.setText(vistaPago.tblDatos.getValueAt(vistaPago.tblDatos.getSelectedRow(), 4).toString());
            vistaPago.txtContratoServicio.setText(vistaPago.tblDatos.getValueAt(vistaPago.tblDatos.getSelectedRow(), 5).toString());
            vistaPago.txtDPICliente.setText(vistaPago.tblDatos.getValueAt(vistaPago.tblDatos.getSelectedRow(), 6).toString());

        }
   
        
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
