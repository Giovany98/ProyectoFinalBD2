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
import modelo.TipoPago;
import modelo.TipoPagoDAO;
import vista.frmTipoPago;

public class ControladorTipoPago implements ActionListener, MouseListener {

    frmTipoPago vistaTipoPago = new frmTipoPago();
    TipoPagoDAO modeloTipoPago = new TipoPagoDAO();
    TipoPago tp = new TipoPago();

    public ControladorTipoPago(frmTipoPago vistaTipoPago, TipoPagoDAO modeloTipoPago, TipoPago tp) {
        this.vistaTipoPago = vistaTipoPago;
        this.modeloTipoPago = modeloTipoPago;
        this.tp = tp;
        this.vistaTipoPago.btnGuardar.addActionListener(this);
        this.vistaTipoPago.btnEliminar.addActionListener(this);
        this.vistaTipoPago.btnModificar.addActionListener(this);
        this.vistaTipoPago.tblDatos.addMouseListener(this);
        llenarTabla(vistaTipoPago.tblDatos);
    }

    public void insertCliente() {
        tp.setIdTipoPago(Integer.parseInt(vistaTipoPago.txtIDPAGO.getText()));
        tp.setDescripcion(vistaTipoPago.txtDescripcion.getText());
        String respuestaInsert = this.modeloTipoPago.registrarTipoPago(tp);
        if (respuestaInsert != null) {
            JOptionPane.showMessageDialog(null, respuestaInsert);
            llenarTabla(vistaTipoPago.tblDatos);
        }
    }

    public void modificarCliente() {
        tp.setIdTipoPago(Integer.parseInt(vistaTipoPago.txtIDPAGO.getText()));
        tp.setDescripcion(vistaTipoPago.txtDescripcion.getText());
        String respuestaUpdate = this.modeloTipoPago.modificarTipoPago(tp);
        if (respuestaUpdate != null) {
            JOptionPane.showMessageDialog(null, respuestaUpdate);
            llenarTabla(vistaTipoPago.tblDatos);
        }
    }

    public void eliminarCliente() {
        tp.setIdTipoPago(Integer.parseInt(vistaTipoPago.txtIDPAGO.getText()));
        String respuestaEliminar = modeloTipoPago.eliminarTipoPago(String.valueOf(tp.getIdTipoPago()));
        JOptionPane.showMessageDialog(vistaTipoPago, respuestaEliminar);
        llenarTabla(vistaTipoPago.tblDatos);
    }
    
        public void llenarTabla(JTable tablaDatos) {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        tablaDatos.setModel(modeloTabla);
        modeloTabla.addColumn("ID TIPO PAGO");
        modeloTabla.addColumn("DESCRIPCION");
        Object[] columna = new Object[2];
        int numeroRegistros = modeloTipoPago.listaCliente().size();
        for (int i = 0; i < numeroRegistros; i++) {
            columna[0] = modeloTipoPago.listaCliente().get(i).getIdTipoPago();
            columna[1] = modeloTipoPago.listaCliente().get(i).getDescripcion();
            modeloTabla.addRow(columna);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
                if (e.getSource() == vistaTipoPago.btnGuardar) {
            insertCliente();
        }
        if (e.getSource() == vistaTipoPago.btnModificar) {
            modificarCliente();
        }
        if (e.getSource() == vistaTipoPago.btnEliminar) {
            eliminarCliente();
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
                if (e.getSource() == vistaTipoPago.tblDatos) {
            vistaTipoPago.txtIDPAGO.setText(vistaTipoPago.tblDatos.getValueAt(vistaTipoPago.tblDatos.getSelectedRow(), 0).toString());
            vistaTipoPago.txtDescripcion.setText(vistaTipoPago.tblDatos.getValueAt(vistaTipoPago.tblDatos.getSelectedRow(), 1).toString());

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
