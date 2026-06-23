package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arreglos.GestorCursos;
import clases.Curso;


public class PanelCursos extends JPanel {

    private static final long serialVersionUID = 1L;

    private JTextField txtCodigo;
    private JTextField txtAsignatura;
    private JTextField txtCreditos;
    private JTextField txtHoras;

    private JComboBox<String> cboCiclo;

    private JButton btnGuardar;
    private JButton btnLimpiar;
    private JButton btnEliminar;

    private JTable table;
    private DefaultTableModel modelo;

    private GestorCursos gestor;


    public PanelCursos() {


        gestor = new GestorCursos();


        setLayout(new BorderLayout());
        setBackground(new Color(245, 247, 250));


        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout(16,0));
        panelPrincipal.setBackground(new Color(245,247,250));
        panelPrincipal.setBorder(
                BorderFactory.createEmptyBorder(16,16,16,16)
        );

        add(panelPrincipal, BorderLayout.CENTER);



        // PANEL FORMULARIO

        JPanel panelFormulario = new JPanel();
        panelFormulario.setPreferredSize(new Dimension(310,650));
        panelFormulario.setBackground(Color.WHITE);
        panelFormulario.setBorder(
                BorderFactory.createLineBorder(
                        new Color(210,215,220)
                )
        );

        panelFormulario.setLayout(null);

        panelPrincipal.add(
                panelFormulario,
                BorderLayout.WEST
        );



        JLabel lblTitulo = new JLabel("Detalle del Curso");

        lblTitulo.setBounds(16,12,250,25);
        lblTitulo.setFont(
                new Font("Segoe UI",Font.BOLD,13)
        );

        panelFormulario.add(lblTitulo);



        JSeparator separator = new JSeparator();

        separator.setBounds(0,45,310,2);

        panelFormulario.add(separator);



        // CODIGO

        JLabel lblCodigo = new JLabel("CÓDIGO");

        lblCodigo.setBounds(16,62,120,20);

        panelFormulario.add(lblCodigo);


        txtCodigo = new JTextField();

        txtCodigo.setBounds(16,85,278,32);

        panelFormulario.add(txtCodigo);



        // ASIGNATURA

        JLabel lblAsignatura = new JLabel("ASIGNATURA");

        lblAsignatura.setBounds(16,130,120,20);

        panelFormulario.add(lblAsignatura);



        txtAsignatura = new JTextField();

        txtAsignatura.setBounds(16,153,278,32);

        panelFormulario.add(txtAsignatura);



        // CREDITOS

        JLabel lblCreditos = new JLabel("CRÉDITOS");

        lblCreditos.setBounds(16,198,120,20);

        panelFormulario.add(lblCreditos);



        txtCreditos = new JTextField();

        txtCreditos.setBounds(16,221,278,32);

        panelFormulario.add(txtCreditos);



        // HORAS

        JLabel lblHoras = new JLabel("HORAS");

        lblHoras.setBounds(16,266,120,20);

        panelFormulario.add(lblHoras);



        txtHoras = new JTextField();

        txtHoras.setBounds(16,289,278,32);

        panelFormulario.add(txtHoras);



        // CICLO


        JLabel lblCiclo = new JLabel("CICLO");

        lblCiclo.setBounds(16,334,120,20);

        panelFormulario.add(lblCiclo);



        String ciclos[] = {

                "I Ciclo",
                "II Ciclo",
                "III Ciclo",
                "IV Ciclo",
                "V Ciclo",
                "VI Ciclo",
                "VII Ciclo",
                "VIII Ciclo",
                "IX Ciclo",
                "X Ciclo"

        };


        cboCiclo = new JComboBox<>(ciclos);

        cboCiclo.setBounds(16,357,278,32);

        panelFormulario.add(cboCiclo);




        // BOTONES


        // ==================== BOTÓN GUARDAR ====================
        btnGuardar = new JButton("GUARDAR");
        btnGuardar.setBounds(16, 550, 85, 35);
        btnGuardar.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnGuardar.setFocusPainted(false);
        btnGuardar.setBackground(new Color(46, 125, 50));
        btnGuardar.setForeground(Color.WHITE);
        panelFormulario.add(btnGuardar);

        // ==================== BOTÓN LIMPIAR ====================
        btnLimpiar = new JButton("LIMPIAR");
        btnLimpiar.setBounds(112, 550, 85, 35);
        btnLimpiar.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnLimpiar.setFocusPainted(false);
        btnLimpiar.setBackground(new Color(255, 193, 7));
        btnLimpiar.setForeground(Color.BLACK);
        panelFormulario.add(btnLimpiar);

        // ==================== BOTÓN ELIMINAR ====================
        btnEliminar = new JButton("ELIMINAR");
        btnEliminar.setBounds(208, 550, 86, 35);
        btnEliminar.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnEliminar.setFocusPainted(false);
        btnEliminar.setBackground(new Color(211, 47, 47));
        btnEliminar.setForeground(Color.WHITE);
        panelFormulario.add(btnEliminar);



        // PANEL TABLA

        
        // =======================
        // PANEL TABLA
        // =======================

        JPanel panelTabla = new JPanel();
        panelTabla.setLayout(new BorderLayout());
        panelTabla.setBackground(Color.WHITE);
        panelTabla.setBorder(BorderFactory.createLineBorder(new Color(210, 215, 220)));
        panelPrincipal.add(panelTabla, BorderLayout.CENTER);

        panelTabla.setBorder(
                BorderFactory.createLineBorder(
                        new Color(210,215,220)
                )
        );


        panelPrincipal.add(
                panelTabla,
                BorderLayout.CENTER
        );




        JScrollPane scroll = new JScrollPane();

        scroll.setBorder(
                new EmptyBorder(0,0,0,0)
        );


        panelTabla.add(
                scroll,
                BorderLayout.CENTER
        );



        table = new JTable();


        modelo = new DefaultTableModel(

                new Object[][] {},

                new String[]{

                        "Código",
                        "Asignatura",
                        "Créditos",
                        "Horas",
                        "Ciclo"

                }

        ){

            public boolean isCellEditable(
                    int fila,
                    int columna
            ){

                return false;

            }

        };


        table.setModel(modelo);


        scroll.setViewportView(table);




        // EVENTOS


        btnGuardar.addActionListener(
                
                new ActionListener(){

                    public void actionPerformed(ActionEvent e){

                        guardarCurso();

                    }

                }

        );



        btnLimpiar.addActionListener(

                new ActionListener(){

                    public void actionPerformed(ActionEvent e){

                        limpiarCampos();

                    }

                }

        );



        btnEliminar.addActionListener(

                new ActionListener(){

                    public void actionPerformed(ActionEvent e){

                        eliminarCurso();

                    }

                }

        );



        cargarTabla();

    }




    // ==========================
    // GUARDAR CURSO
    // ==========================


    private void guardarCurso(){


        try{


            int codigo =
                    Integer.parseInt(txtCodigo.getText());


            String asignatura =
                    txtAsignatura.getText();



            int creditos =
                    Integer.parseInt(
                            txtCreditos.getText()
                    );


            int horas =
                    Integer.parseInt(
                            txtHoras.getText()
                    );


            int ciclo =
                    cboCiclo.getSelectedIndex()+1;



            Curso curso =
                    new Curso(
                            codigo,
                            asignatura,
                            ciclo,
                            creditos,
                            horas
                    );



            gestor.agregarCurso(curso);



            JOptionPane.showMessageDialog(
                    this,
                    "Curso guardado correctamente"
            );


            cargarTabla();

            limpiarCampos();



        }catch(Exception e){


            JOptionPane.showMessageDialog(
                    this,
                    "Complete todos los campos"
            );


        }


    }






    // ==========================
    // CARGAR TABLA
    // ==========================


    private void cargarTabla(){


        modelo.setRowCount(0);



        for(Curso c : gestor.listarCursos()){


            modelo.addRow(
                    
                    new Object[]{


                            c.getCodCurso(),

                            c.getAsignatura(),

                            c.getCreditos(),

                            c.getHoras(),

                            c.getCiclo()+" Ciclo"


                    }

            );


        }


    }







    // ==========================
    // LIMPIAR
    // ==========================


    private void limpiarCampos(){


        txtCodigo.setText("");

        txtAsignatura.setText("");

        txtCreditos.setText("");

        txtHoras.setText("");

        cboCiclo.setSelectedIndex(0);


    }








    // ==========================
    // ELIMINAR
    // ==========================


    private void eliminarCurso(){


        int fila =
                table.getSelectedRow();



        if(fila==-1){


            JOptionPane.showMessageDialog(
                    this,
                    "Seleccione un curso"
            );


            return;

        }



        int codigo =
                Integer.parseInt(
                        modelo.getValueAt(
                                fila,
                                0
                        ).toString()
                );



        if(gestor.eliminarCurso(codigo)){


            JOptionPane.showMessageDialog(
                    this,
                    "Curso eliminado"
            );


            cargarTabla();


        }



    }



}