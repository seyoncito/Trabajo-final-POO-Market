import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Font.ITALIC;

public class Acerca extends JFrame {
    public Acerca() {
        setTitle("Market");

        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        add(panel, BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("Archivo");
        menuBar.add(fileMenu);

        JMenu nuevMenu = new JMenu("Nuevo");
        JMenuItem newFileItemF = new JMenuItem("Nueva Factura");
        nuevMenu.add(newFileItemF);
        fileMenu.add(nuevMenu);

        JMenuItem newClientItem = new JMenuItem("Nuevo Cliente");
        nuevMenu.add(newClientItem);
        fileMenu.add(nuevMenu);

        JMenuItem openItem = new JMenuItem("Abrir");
        JMenuItem saveItem = new JMenuItem("Guardar");
        JMenuItem exitItem = new JMenuItem("Salir");
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        // Add a separator
        fileMenu.add(exitItem);

        JMenu facturasMenu = new JMenu("Facturas");
        menuBar.add(facturasMenu);


        JMenuItem Serch = new JMenuItem("Buscar");
        facturasMenu.add(Serch);

        JMenu acercaDeMenu = new JMenu("Acerca De");
        menuBar.add(acercaDeMenu);
        JMenuItem openItemE = new JMenuItem("Logueo");
        fileMenu.add(openItemE);
        acercaDeMenu.add(openItemE);


        setJMenuBar(menuBar);

        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        openItemE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                LoginPanel Login = new LoginPanel();
                Login.setVisible(true);
                dispose();
            }
        });

        newFileItemF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

               FacturaNueva nuevaFactura= new FacturaNueva();
              nuevaFactura.setVisible(true);

            }
        });
        newClientItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistrCliente crearClientePanel = new RegistrCliente();
                crearClientePanel.setVisible(true);

            }
        });


        setVisible(true);

      //  btnCreaCliente.addActionListener(e -> new RegistrCliente().setVisible(true));
       // btnNuevaFactura.addActionListener(e -> new FacturaNueva().setVisible(true));
     //

        JLabel jLabel1 = new JLabel("Programación Orientada a Objetos");
        // Establecer la fuente con un tamaño más legible y un estilo común
        jLabel1.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(jLabel1);

        JLabel jLabel2 = new JLabel("INTEGRANTES");
        jLabel2.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
        panel.add(jLabel2);

        JLabel jLabel3 = new JLabel("Huamani Peñalva , Julio Cesar");
        jLabel3.setFont(new Font("Arial", ITALIC, 16));
        panel.add(jLabel3);

        JLabel jLabel4 = new JLabel("Yuly Vanessa Flores Arias");
        jLabel4.setFont(new Font("Arial", ITALIC, 16));
        panel.add(jLabel4);

        JLabel jLabel5 = new JLabel("2024");
        jLabel5.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
        panel.add(jLabel5); // NOI18N


    }

}