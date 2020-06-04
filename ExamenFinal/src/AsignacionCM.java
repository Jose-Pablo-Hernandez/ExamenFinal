
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * 
 */
public class AsignacionCM extends javax.swing.JInternalFrame {

    String[] NombresColumnasAsignacionM = {"carrera", "sede", "jornada", "seccion", "aula", "curso", "maestro"};

    public void MostrarDB(String Tabla) {
        String[] columnas = new String[7];
        String query, query2, query3, query4, query5, query6, query7, query8;
        try {

            Connection c = DriverManager.getConnection(Principal.BD, Principal.Usuario, Principal.Contraseña);
            query = "SELECT * FROM " + Tabla;
            query2 = "SELECT nombre_carrera FROM carreras where codigo_carrera = ?";
            query3 = "SELECT nombre_sede FROM sedes where codigo_sede = ?";
            query4 = "SELECT nombre_jornada FROM jornadas where codigo_jornada = ?";
            query5 = "SELECT nombre_seccion FROM secciones where codigo_seccion = ?";
            query6 = "SELECT nombre_aula FROM aulas where codigo_aula = ?";
            query7 = "SELECT nombre_curso FROM cursos where codigo_curso = ?";
            query8 = "SELECT nombre_maestro FROM maestros where codigo_maestro = ?";

            PreparedStatement consulta = c.prepareStatement(query);
            ResultSet resultado = consulta.executeQuery();
            DefaultTableModel md = new DefaultTableModel(null, NombresColumnasAsignacionM);
            tblAsignacionM.setModel(md);
            PreparedStatement cCarrera = c.prepareStatement(query2);
            PreparedStatement cSede = c.prepareStatement(query3);
            PreparedStatement cJornada = c.prepareStatement(query4);
            PreparedStatement cSeccion = c.prepareStatement(query5);
            PreparedStatement cAula = c.prepareStatement(query6);
            PreparedStatement cCurso = c.prepareStatement(query7);
            PreparedStatement cMaestro = c.prepareStatement(query8);

            String[] info = new String[7];
            while (resultado.next()) {
                for (int i = 0; i < 7; i++) {
                    info[i] = resultado.getString(i + 1);
                }

                cCarrera.setString(1, info[0]);
                cSede.setString(1, info[1]);
                cJornada.setString(1, info[2]);
                cSeccion.setString(1, info[3]);
                cAula.setString(1, info[4]);
                cCurso.setString(1, info[5]);
                cMaestro.setString(1, info[6]);
                ResultSet rCarrera = cCarrera.executeQuery();
                ResultSet rSede = cSede.executeQuery();
                ResultSet rJornada = cJornada.executeQuery();
                ResultSet rSeccion = cSeccion.executeQuery();
                ResultSet rAula = cAula.executeQuery();
                ResultSet rCurso = cCurso.executeQuery();
                ResultSet rMaestro = cMaestro.executeQuery();
                while (rCarrera.next()) {
                    columnas[0] = rCarrera.getString("nombre_carrera");

                }
                while (rSede.next()) {
                    columnas[1] = rSede.getString("nombre_sede");

                }
                 while (rJornada.next()) {
                    columnas[2] = rJornada.getString("nombre_jornada");

                }
                 while (rSeccion.next()) {
                    columnas[3] = rSeccion.getString("nombre_seccion");

                }
                 
                 while (rAula.next()) {
                    columnas[4] = rAula.getString("nombre_aula");

                }
                 while (rCurso.next()) {
                    columnas[5] = rCurso.getString("nombre_curso");

                }
                 while (rMaestro.next()) {
                    columnas[6] = rMaestro.getString("nombre_maestro");

                }

                md.addRow(columnas);
            }

        } catch (Exception err) {
            err.printStackTrace();
        }

    }

    /**
     * Creates new form AsignacionCM
     */
    public AsignacionCM() {
        initComponents();
        
        try {
            Connection cn = DriverManager.getConnection(Principal.BD, Principal.Usuario, Principal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select nombre_carrera from carreras");
            ResultSet rs = pst.executeQuery();

            PreparedStatement pst2 = cn.prepareStatement("select nombre_sede from sedes");
            ResultSet rs2 = pst2.executeQuery();

            PreparedStatement pst3 = cn.prepareStatement("select nombre_jornada from jornadas");
            ResultSet rs3 = pst3.executeQuery();

            PreparedStatement pst4 = cn.prepareStatement("select nombre_seccion from secciones");
            ResultSet rs4 = pst4.executeQuery();

            PreparedStatement pst5 = cn.prepareStatement("select nombre_aula from aulas");
            ResultSet rs5 = pst5.executeQuery();

            PreparedStatement pst6 = cn.prepareStatement("select nombre_curso from cursos");
            ResultSet rs6 = pst6.executeQuery();

            PreparedStatement pst7 = cn.prepareStatement("select nombre_maestro from maestros");
            ResultSet rs7 = pst7.executeQuery();

            cbox_carrera.addItem("Seleccione una opción");
            while (rs.next()) {
                cbox_carrera.addItem(rs.getString("nombre_carrera"));
            }

            cbox_sede.addItem("Seleccione una opción");
            while (rs2.next()) {
                cbox_sede.addItem(rs2.getString("nombre_sede"));
            }

            cbox_j.addItem("Seleccione una opción");
            while (rs3.next()) {
                cbox_j.addItem(rs3.getString("nombre_jornada"));
            }

            cbox_sec.addItem("Seleccione una opción");
            while (rs4.next()) {
                cbox_sec.addItem(rs4.getString("nombre_seccion"));
            }

            cbox_aula.addItem("Seleccione una opción");
            while (rs5.next()) {
                cbox_aula.addItem(rs5.getString("nombre_aula"));
            }

            cbox_curso.addItem("Seleccione una opción");
            while (rs6.next()) {
                cbox_curso.addItem(rs6.getString("nombre_curso"));
            }

            cbox_alum.addItem("Seleccione una opción");
            while (rs7.next()) {
                cbox_alum.addItem(rs7.getString("nombre_maestro"));
            }

        } catch (Exception e) {

        }
        
        MostrarDB("asignacioncursosmastros");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblAsignacionM = new javax.swing.JTable();
        lb5 = new javax.swing.JLabel();
        lb6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbox_alum = new javax.swing.JComboBox<>();
        lb7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cbox_carrera = new javax.swing.JComboBox<>();
        cbox_sede = new javax.swing.JComboBox<>();
        btnRegistrar = new javax.swing.JButton();
        lb1 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        lb2 = new javax.swing.JLabel();
        txtbuscado = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbox_j = new javax.swing.JComboBox<>();
        txt_id = new javax.swing.JTextField();
        cbox_sec = new javax.swing.JComboBox<>();
        lb3 = new javax.swing.JLabel();
        lb4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbox_aula = new javax.swing.JComboBox<>();
        cbox_curso = new javax.swing.JComboBox<>();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setVisible(true);

        jTabbedPane3.setBackground(new java.awt.Color(255, 255, 255));

        tblAsignacionM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblAsignacionM.setGridColor(new java.awt.Color(255, 255, 255));
        tblAsignacionM.setSelectionBackground(new java.awt.Color(102, 204, 255));
        jScrollPane4.setViewportView(tblAsignacionM);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Datos", jPanel4);

        lb5.setText("...");

        lb6.setText("...");

        jLabel10.setText("Aula");

        cbox_alum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_alumActionPerformed(evt);
            }
        });

        lb7.setText("...");

        jLabel11.setText("Maestro");

        cbox_carrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_carreraActionPerformed(evt);
            }
        });

        cbox_sede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_sedeActionPerformed(evt);
            }
        });

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        lb1.setText("...");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        lb2.setText("...");

        jLabel5.setText("Carrera");

        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel6.setText("Sede");

        btnModificar.setText("Modificar");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        jLabel7.setText("Seccion");

        jLabel4.setText("Codigo");

        cbox_j.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_jActionPerformed(evt);
            }
        });

        txt_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idActionPerformed(evt);
            }
        });

        cbox_sec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_secActionPerformed(evt);
            }
        });

        lb3.setText("...");

        lb4.setText("...");

        jLabel8.setText("Jornada");

        jLabel9.setText("Curso");

        cbox_aula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_aulaActionPerformed(evt);
            }
        });

        cbox_curso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_cursoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtbuscado, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbox_j, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbox_sec, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb3)
                            .addComponent(lb4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                        .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cbox_aula, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbox_curso, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb5)
                                    .addComponent(lb6)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(131, 131, 131)
                                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbox_alum, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lb7))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_id)
                            .addComponent(cbox_carrera, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbox_sede, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb1)
                            .addComponent(lb2))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbox_carrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cbox_sede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cbox_j, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cbox_sec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(cbox_aula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(cbox_curso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(cbox_alum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb7))
                        .addGap(56, 56, 56)
                        .addComponent(btnRegistrar)
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBuscar)
                            .addComponent(txtbuscado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnModificar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbox_alumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_alumActionPerformed
        try {
            Connection cn = DriverManager.getConnection(Principal.BD, Principal.Usuario, Principal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select codigo_maestro from maestros where nombre_maestro= ?");
            pst.setString(1, cbox_alum.getSelectedItem().toString());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                lb7.setText(rs.getString("codigo_maestro"));

            } else {

            }

        } catch (Exception e) {

        }    // TODO add your handling code here:
    }//GEN-LAST:event_cbox_alumActionPerformed

    private void cbox_carreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_carreraActionPerformed
        try {
            Connection cn = DriverManager.getConnection(Principal.BD, Principal.Usuario, Principal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select codigo_carrera from carreras where nombre_carrera= ?");
            pst.setString(1, cbox_carrera.getSelectedItem().toString());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                lb1.setText(rs.getString("codigo_carrera"));

            } else {

            }

        } catch (Exception e) {

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_cbox_carreraActionPerformed

    private void cbox_sedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_sedeActionPerformed

        try {
            Connection cn = DriverManager.getConnection(Principal.BD, Principal.Usuario, Principal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select codigo_sede from sedes where nombre_sede= ?");
            pst.setString(1, cbox_sede.getSelectedItem().toString());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                lb2.setText(rs.getString("codigo_sede"));

            } else {

            }

        } catch (Exception e) {

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_cbox_sedeActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

        try {
            Connection cn = DriverManager.getConnection(Principal.BD, Principal.Usuario, Principal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("insert into asignacioncursosmastros values(?,?,?,?,?,?,?,?)");
            pst.setString(1, txt_id.getText().trim());
            pst.setString(2, lb1.getText().trim());
            pst.setString(3, lb2.getText().trim());
            pst.setString(4, lb3.getText().trim());
            pst.setString(5, lb4.getText().trim());
            pst.setString(6, lb5.getText().trim());
            pst.setString(7, lb6.getText().trim());
            pst.setString(8, lb7.getText().trim());
           

            pst.executeUpdate();
            MostrarDB("asignacioncursosmastros");
            JOptionPane.showMessageDialog(this, "¡REGISTRO EXITOSO!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

           
            txt_id.setText("");
            lb1.setText("");
            lb2.setText("");
            lb3.setText("");
            lb4.setText("");
            lb5.setText("");
            lb6.setText("");
            lb7.setText("");
            cbox_j.setSelectedIndex(0);
            cbox_curso.setSelectedIndex(0);
            cbox_sede.setSelectedIndex(0);
            cbox_carrera.setSelectedIndex(0);
            cbox_alum.setSelectedIndex(0);
            cbox_sec.setSelectedIndex(0);
            cbox_aula.setSelectedIndex(0);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "¡REGITRO FALLIDO!", "Error", JOptionPane.ERROR_MESSAGE);

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String buscar = txtbuscado.getText().trim();
        if (buscar.isEmpty()) {
            JOptionPane.showMessageDialog(this, "¡No se ingreso el campo de busqueda!", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            Connection cn = DriverManager.getConnection(Principal.BD, Principal.Usuario, Principal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select * from asignacioncursosmastros where id_Maestro = ?");
            pst.setString(1, txtbuscado.getText().trim());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                txt_id.setText(rs.getString("id_Maestro"));
                lb1.setText(rs.getString("codigo_carrera"));
                lb2.setText(rs.getString("codigo_sede"));
                lb3.setText(rs.getString("codigo_jornada"));
                lb4.setText(rs.getString("codigo_seccion"));
                lb5.setText(rs.getString("codigo_aula"));
                lb6.setText(rs.getString("codigo_curso"));
                lb7.setText(rs.getString("codigo_maestro"));
               

                btnEliminar.setEnabled(true);
                btnModificar.setEnabled(true);

            } else {
                JOptionPane.showMessageDialog(null, " no registrado.");
            }

        } catch (Exception err) {
            err.printStackTrace();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            Connection cn = DriverManager.getConnection(Principal.BD, Principal.Usuario, Principal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("delete from asignacioncursosmastros where id_Maestro = ?");

            pst.setString(1, txtbuscado.getText().trim());
            pst.executeUpdate();
            MostrarDB("asignacioncursosmastros");
            txtbuscado.setText("");

            JOptionPane.showMessageDialog(this, "REGISTRO ELIMINADO.", "Exito", JOptionPane.INFORMATION_MESSAGE);
            btnEliminar.setEnabled(false);
            btnModificar.setEnabled(false);

            txt_id.setText("");
           
            lb1.setText("");
            lb2.setText("");
            lb3.setText("");
            lb4.setText("");
            lb5.setText("");
            lb6.setText("");
            lb7.setText("");
            cbox_carrera.setSelectedIndex(0);
            cbox_j.setSelectedIndex(0);
            cbox_aula.setSelectedIndex(0);
            cbox_alum.setSelectedIndex(0);
            cbox_sec.setSelectedIndex(0);
            cbox_sede.setSelectedIndex(0);
            cbox_curso.setSelectedIndex(0);
            txtbuscado.setText("");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error en la eliminación de registros.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        try {
            String codigo = txtbuscado.getText().trim();

            Connection cn = DriverManager.getConnection(Principal.BD, Principal.Usuario, Principal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("update asignacioncursosmastros set codigo_carrera = ? , codigo_sede= ? , codigo_jornada=? , codigo_seccion= ?, codigo_aula= ?,codigo_curso= ?,codigo_maestro= ? where id_Alumno = " + codigo);

           
            pst.setString(1, lb1.getText().trim());
            pst.setString(2, lb2.getText().trim());
            pst.setString(3, lb3.getText().trim());
            pst.setString(4, lb4.getText().trim());
            pst.setString(5, lb5.getText().trim());
            pst.setString(6, lb6.getText().trim());
            pst.setString(7, lb7.getText().trim());
            
            pst.executeUpdate();
            MostrarDB("asignacioncursosmastros");
            JOptionPane.showMessageDialog(this, "MODIFICACION EXITOSA.", "Exito", JOptionPane.INFORMATION_MESSAGE);

            btnEliminar.setEnabled(false);
            btnModificar.setEnabled(false);
            txt_id.setText("");
           
            lb1.setText("");
            lb2.setText("");
            lb3.setText("");
            lb4.setText("");
            lb5.setText("");
            lb6.setText("");
            lb7.setText("");
            cbox_carrera.setSelectedIndex(0);
            cbox_j.setSelectedIndex(0);
            cbox_aula.setSelectedIndex(0);
            cbox_alum.setSelectedIndex(0);
            cbox_sec.setSelectedIndex(0);
            cbox_sede.setSelectedIndex(0);
            cbox_curso.setSelectedIndex(0);
            txtbuscado.setText("");

        } catch (Exception e) {
            System.out.println(e);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarActionPerformed

    private void cbox_jActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_jActionPerformed
        try {
            Connection cn = DriverManager.getConnection(Principal.BD, Principal.Usuario, Principal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select codigo_jornada from jornadas where nombre_jornada= ?");
            pst.setString(1, cbox_j.getSelectedItem().toString());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                lb3.setText(rs.getString("codigo_jornada"));

            } else {

            }

        } catch (Exception e) {

        }        // TODO add your handling code here:
    }//GEN-LAST:event_cbox_jActionPerformed

    private void txt_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idActionPerformed

    private void cbox_secActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_secActionPerformed
        try {
            Connection cn = DriverManager.getConnection(Principal.BD, Principal.Usuario, Principal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select codigo_seccion from secciones where nombre_seccion= ?");
            pst.setString(1, cbox_sec.getSelectedItem().toString());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                lb4.setText(rs.getString("codigo_seccion"));

            } else {

            }

        } catch (Exception e) {

        }  // TODO add your handling code here:
    }//GEN-LAST:event_cbox_secActionPerformed

    private void cbox_aulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_aulaActionPerformed
        try {
            Connection cn = DriverManager.getConnection(Principal.BD, Principal.Usuario, Principal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select codigo_aula from aulas where nombre_aula= ?");
            pst.setString(1, cbox_aula.getSelectedItem().toString());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                lb5.setText(rs.getString("codigo_aula"));

            } else {

            }

        } catch (Exception e) {

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_cbox_aulaActionPerformed

    private void cbox_cursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_cursoActionPerformed
        try {
            Connection cn = DriverManager.getConnection(Principal.BD, Principal.Usuario, Principal.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select codigo_curso from cursos where nombre_curso= ?");
            pst.setString(1, cbox_curso.getSelectedItem().toString());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                lb6.setText(rs.getString("codigo_curso"));

            } else {

            }

        } catch (Exception e) {

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_cbox_cursoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cbox_alum;
    private javax.swing.JComboBox<String> cbox_aula;
    private javax.swing.JComboBox<String> cbox_carrera;
    private javax.swing.JComboBox<String> cbox_curso;
    private javax.swing.JComboBox<String> cbox_j;
    private javax.swing.JComboBox<String> cbox_sec;
    private javax.swing.JComboBox<String> cbox_sede;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lb3;
    private javax.swing.JLabel lb4;
    private javax.swing.JLabel lb5;
    private javax.swing.JLabel lb6;
    private javax.swing.JLabel lb7;
    private javax.swing.JTable tblAsignacionM;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txtbuscado;
    // End of variables declaration//GEN-END:variables
}
