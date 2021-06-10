package escuelamanejobd2;

import controlador.ControladorCliente;
import controlador.ControladorPago;

import controlador.ControladorTipoPago;
import modelo.Cliente;
import modelo.ClienteDAO;

import vista.frmCliente;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.*;
import modelo.Pago;
import modelo.PagoDAO;
import modelo.TipoPago;
import modelo.TipoPagoDAO;
import vista.Interfaz;
import vista.MenuPrincipal;

import vista.frmPago;
import vista.frmTipoPago;

public class Main {

    public static void main(String[] args) {
//        frmCliente vistaCliente = new frmCliente();
//        ClienteDAO modeloCli = new ClienteDAO();
//        Cliente cliente = new Cliente();
//        ControladorCliente controlCli = new ControladorCliente(vistaCliente, modeloCli, cliente);
//        vistaCliente.setVisible(true);
//        vistaCliente.setLocationRelativeTo(null);

//        frmPersona vistaPersona = new frmPersona();
//        PersonaDAO modeloPer = new PersonaDAO();
//        Persona persona = new Persona();
//        ControladorPersona controlPer = new ControladorPersona(vistaPersona, modeloPer, persona);
//        vistaPersona.setVisible(true);
//        vistaPersona.setLocationRelativeTo(null);
//        frmTipoPago vistaTipoPago = new frmTipoPago();
//        TipoPagoDAO modeloTipoPago = new TipoPagoDAO();
//        TipoPago tp = new TipoPago();
//        ControladorTipoPago controlCli = new ControladorTipoPago(vistaTipoPago, modeloTipoPago, tp);
//        vistaTipoPago.setVisible(true);
//        vistaTipoPago.setLocationRelativeTo(null);

//        frmPago vistaPago = new frmPago();
//        PagoDAO modeloPago = new PagoDAO();
//        Pago pago = new Pago();
//        ControladorPago controlPago = new ControladorPago(vistaPago, modeloPago, pago);
//        vistaPago.setVisible(true);
//        vistaPago.setLocationRelativeTo(null);

//            Interfaz inter = new Interfaz();
//            inter.setVisible(true);
//            inter.setLocationRelativeTo(null);

//            Principal principal = new Principal();
//            principal.setVisible(true);
//            principal.setLocationRelativeTo(null);

            MenuPrincipal mp = new MenuPrincipal();
            mp.setVisible(true);
            mp.setLocationRelativeTo(null);
            
            
    }

}
