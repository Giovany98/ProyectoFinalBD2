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


public class ControladorCliente implements ActionListener, MouseListener {

    //frmCliente vistaCliente = new frmCliente();
    frmCliente vistaCliente = new frmCliente();
    ClienteDAO modeloCliente = new ClienteDAO();
    Cliente cliente = new Cliente();

    public ControladorCliente(frmCliente vistaCliente, ClienteDAO modeloCliente, Cliente cliente) {
        this.vistaCliente = vistaCliente;
        this.modeloCliente = modeloCliente;
        this.cliente = cliente;
        this.vistaCliente.btnGuardar.addActionListener(this);
        this.vistaCliente.btnModificar.addActionListener(this);
        this.vistaCliente.btnEliminar.addActionListener(this);
        this.vistaCliente.btnMostrar.addActionListener(this);
        this.vistaCliente.tblDatos.addMouseListener(this);
        llenarTabla(vistaCliente.tblDatos);
    }

    public void insertCliente() {
        cliente.setDpi(vistaCliente.txtDPI.getText());
        cliente.setNombre(vistaCliente.txtNombre.getText());
        cliente.setApellido(vistaCliente.txtApellido.getText());
        cliente.setDireccion(vistaCliente.txtDireccion.getText());
        cliente.setFechaNacimiento(vistaCliente.txtFechaNacimiento.getDate());
        cliente.setTelefono(vistaCliente.txtTelefono.getText());
        cliente.setEmail(vistaCliente.txtTelefono.getText());
        cliente.setEstado(vistaCliente.txtEstado.getText());
        String respuestaInsert = this.modeloCliente.registrarCliente(cliente);
        if (respuestaInsert != null) {
            JOptionPane.showMessageDialog(null, respuestaInsert);
            llenarTabla(vistaCliente.tblDatos);
        }
    }

    public void modificarCliente() {
        cliente.setDpi(vistaCliente.txtDPI.getText());
        cliente.setNombre(vistaCliente.txtNombre.getText());
        cliente.setApellido(vistaCliente.txtApellido.getText());
        cliente.setDireccion(vistaCliente.txtDireccion.getText());
        cliente.setFechaNacimiento(vistaCliente.txtFechaNacimiento.getDate());
        cliente.setTelefono(vistaCliente.txtTelefono.getText());
        cliente.setEmail(vistaCliente.txtTelefono.getText());
        cliente.setEstado(vistaCliente.txtEstado.getText());
        String respuestaUpdate = this.modeloCliente.modificarCliente(cliente);
        if (respuestaUpdate != null) {
            JOptionPane.showMessageDialog(null, respuestaUpdate);
            llenarTabla(vistaCliente.tblDatos);
        }
    }

    public void eliminarCliente() {
        cliente.setDpi(vistaCliente.txtDPI.getText());
        String respuestaEliminar = modeloCliente.eliminarClient(cliente.getDpi());
        JOptionPane.showMessageDialog(vistaCliente, respuestaEliminar);
        llenarTabla(vistaCliente.tblDatos);
    }

    public void mostrarCliente() {
        cliente.setDpi(vistaCliente.txtDPI.getText());
        cliente = modeloCliente.mostrarCliente(cliente.getDpi());
        vistaCliente.txtNombre.setText(cliente.getNombre());
        vistaCliente.txtApellido.setText(cliente.getApellido());
        vistaCliente.txtDireccion.setText(cliente.getDireccion());
        vistaCliente.txtFechaNacimiento.setDate(cliente.getFechaNacimiento());
        vistaCliente.txtEmail.setText(cliente.getEmail());
        vistaCliente.txtTelefono.setText(cliente.getTelefono());
        vistaCliente.txtEstado.setText(cliente.getEstado());
    }

    public void llenarTabla(JTable tablaDatos) {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        tablaDatos.setModel(modeloTabla);
        modeloTabla.addColumn("DPI");
        modeloTabla.addColumn("NOMBRE");
        modeloTabla.addColumn("APELLIDO");
        modeloTabla.addColumn("DIRECCION");
        modeloTabla.addColumn("FECHA NACIMIENTO");
        modeloTabla.addColumn("EMAIL");
        modeloTabla.addColumn("TELEFONO");
        modeloTabla.addColumn("ESTADO");
        Object[] columna = new Object[8];
        int numeroRegistros = modeloCliente.listaCliente().size();
        for (int i = 0; i < numeroRegistros; i++) {
            columna[0] = modeloCliente.listaCliente().get(i).getDpi();
            columna[1] = modeloCliente.listaCliente().get(i).getNombre();
            columna[2] = modeloCliente.listaCliente().get(i).getApellido();
            columna[3] = modeloCliente.listaCliente().get(i).getDireccion();
            columna[4] = modeloCliente.listaCliente().get(i).getFechaNacimiento();
            columna[5] = modeloCliente.listaCliente().get(i).getEmail();
            columna[6] = modeloCliente.listaCliente().get(i).getTelefono();
            columna[7] = modeloCliente.listaCliente().get(i).getEstado();
            modeloTabla.addRow(columna);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaCliente.btnGuardar) {
            insertCliente();
        }
        if (e.getSource() == vistaCliente.btnModificar) {
            modificarCliente();
        }
        if (e.getSource() == vistaCliente.btnEliminar) {
            eliminarCliente();
        }
        if (e.getSource() == vistaCliente.btnMostrar) {
            mostrarCliente();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == vistaCliente.tblDatos) {
            vistaCliente.txtDPI.setText(vistaCliente.tblDatos.getValueAt(vistaCliente.tblDatos.getSelectedRow(), 0).toString());
            vistaCliente.txtNombre.setText(vistaCliente.tblDatos.getValueAt(vistaCliente.tblDatos.getSelectedRow(), 1).toString());
            vistaCliente.txtApellido.setText(vistaCliente.tblDatos.getValueAt(vistaCliente.tblDatos.getSelectedRow(), 2).toString());
            vistaCliente.txtDireccion.setText(vistaCliente.tblDatos.getValueAt(vistaCliente.tblDatos.getSelectedRow(), 3).toString());
            vistaCliente.txtFechaNacimiento.setDate((Date) vistaCliente.tblDatos.getValueAt(vistaCliente.tblDatos.getSelectedRow(), 4));
            vistaCliente.txtEmail.setText(vistaCliente.tblDatos.getValueAt(vistaCliente.tblDatos.getSelectedRow(), 5).toString());
            vistaCliente.txtTelefono.setText(vistaCliente.tblDatos.getValueAt(vistaCliente.tblDatos.getSelectedRow(), 6).toString());
            vistaCliente.txtEstado.setText(vistaCliente.tblDatos.getValueAt(vistaCliente.tblDatos.getSelectedRow(), 7).toString());

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
