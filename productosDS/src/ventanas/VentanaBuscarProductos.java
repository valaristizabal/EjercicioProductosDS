/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventanas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.mariadb.jdbc.Connection;
import productosds.ConeccionDB;

/**
 *
 * @author val
 */
public class VentanaBuscarProductos extends javax.swing.JFrame {

    DefaultTableModel modelo = new DefaultTableModel();
    /**
     * Creates new form VentanaListaProductos
     */
    public VentanaBuscarProductos() {
        setLocationRelativeTo(null);
        initComponents();
        try {
            // Establece el modelo recién creado a la tabla de usuarios (userTable)
            tabla.setModel(modelo); //nombre de la tabla

            // Declara las variables para preparar y ejecutar la consulta SQL
            PreparedStatement ps = null;
            ResultSet rs = null;

            // Crea un objeto de conexión a la base de datos usando la clase previamente definida: ConeccionDB
            ConeccionDB conn = new ConeccionDB();

            // Obtiene una conexión activa a la base de datos
            Connection con = conn.getConexion();

            // Definir la consulta SQL a ejecutar
            String sql = "SELECT * FROM productos";

            // Preparar la consulta SQL para su ejecución, esto ayuda a prevenir la inyección SQL
            ps = con.prepareStatement(sql);
            // Ejecuta la consulta y guarda el resultado en la variable rs

            rs = ps.executeQuery();

            // Obtiene metadatos del resultado, como número de columnas, nombres de columnas, etc.
            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            // Obtiene la cantidad de columnas del resultado
            int cantidadColumnas = rsMd.getColumnCount();

            // Define las columnas para el modelo de la JTable
            modelo.addColumn("Código");
            modelo.addColumn("Nombre");
            modelo.addColumn("Precio");
            modelo.addColumn("Distribuidor");
            modelo.addColumn("Categoria");

            // Define los anchos de las columnas em la tabla
            int[] anchos = {80, 220, 120, 150, 120};
            for (int i = 0; i < tabla.getColumnCount(); i++) {
                // Establece el ancho de cada columna
                tabla.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }

            // El while se ejecuta mientras existan registros en la base de datos, pinta la información en la tabla
            while (rs.next()) {
                // Crea un array para guardar los valores de las columnas de un registro
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    // Obtiene el objeto de la columna i+1 (los indices en rs empiezan en 1, no en 0) y lo guarda en el array
                    filas[i] = rs.getObject(i + 1);

                }
                modelo.addRow(filas);
            }

            // Si ocurre algún errr SQL durante la ejecución del bloque try, entra en el bloque catch    
        } catch (SQLException ex) {
            System.err.print(ex.toString());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtCodigoBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        codigo1 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtCodigo = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtCategoria = new javax.swing.JTextField();
        txtDistribuidor = new javax.swing.JTextField();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        btnGuardar.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        btnGuardar.setText("guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Código:");

        btnBuscar.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        btnBuscar.setText("buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Código:");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Nombre:");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Precio:");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Distribuidor:");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Categoría:");

        jLabel1.setFont(new java.awt.Font("Century Gothic", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("LISTA DE PRODUCTOS");

        codigo1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        codigo1.setForeground(new java.awt.Color(102, 102, 102));
        codigo1.setText("Seleccione un elemento de la tabla para conocer sus detalles");

        btnRegresar.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        btnRegresar.setText("regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnActualizar.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        btnActualizar.setText("actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        btnEliminar.setText("eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(280, 280, 280))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel2)
                        .addGap(29, 29, 29)
                        .addComponent(txtCodigoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(btnBuscar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(codigo1)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtDistribuidor, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(btnActualizar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                                .addComponent(btnEliminar))
                            .addComponent(txtCodigo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCategoria))))
                .addContainerGap(66, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(49, 49, 49)
                    .addComponent(btnRegresar)
                    .addContainerGap(805, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCodigoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtDistribuidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(codigo1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnGuardar)
                        .addComponent(btnActualizar)
                        .addComponent(btnEliminar)))
                .addContainerGap(112, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(450, Short.MAX_VALUE)
                    .addComponent(btnRegresar)
                    .addGap(36, 36, 36)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        try {
            // Declara las variables para preparar y ejecutar la consulta SQL
            PreparedStatement ps = null;
            ResultSet rs = null;

            // conexión a la base de datos
            ConeccionDB conn = new ConeccionDB();
            Connection con = conn.getConexion();

            //preparar la consulta sql y guardar el nuevo dato a la base de datos
            ps = con.prepareStatement("INSERT INTO productos (codigo, nombre, precio, distribuidor, categoria) VALUES (?,?,?,?,?)");
            ps.setString(1, txtCodigo.getText());
            ps.setString(2, txtNombre.getText());
            ps.setString(3, txtPrecio.getText());
            ps.setString(4, txtDistribuidor.getText());
            ps.setString(5, txtCategoria.getText());

            ps.execute();

            JOptionPane.showMessageDialog(null, "Producto guardado");
            Object[] fila = new Object[5];
            fila[0] = txtCodigo.getText();
            fila[1] = txtNombre.getText();
            fila[2] = txtPrecio.getText();
            fila[3] = txtDistribuidor.getText();
            fila[4] = txtCategoria.getText();
            modelo.addRow(fila);
            limpiarCampos();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar producto");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:

        DefaultTableModel modelo = new DefaultTableModel();
        tabla.setModel(modelo);
        
        String campo = txtCodigoBuscar.getText();
        String where = "";

        if (!"".equals(campo)) {
            where = " WHERE codigo = '" + campo + "'";

        }

        try {
            // Declara las variables para preparar y ejecutar la consulta SQL
            PreparedStatement ps = null;
            ResultSet rs = null;

            // Crea un objeto de conexión a la base de datos usando la clase previamente definida: ConeccionDB
            ConeccionDB conn = new ConeccionDB();

            // Obtiene una conexión activa a la base de datos
            Connection con = conn.getConexion();

            // Definir la consulta SQL a ejecutar
            String sql = "SELECT * FROM productos" + where;

            // Preparar la consulta SQL para su ejecución, esto ayuda a prevenir la inyección SQL
            ps = con.prepareStatement(sql);
            // Ejecuta la consulta y guarda el resultado en la variable rs

            rs = ps.executeQuery();

            // Obtiene metadatos del resultado, como número de columnas, nombres de columnas, etc.
            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            // Obtiene la cantidad de columnas del resultado
            int cantidadColumnas = rsMd.getColumnCount();

            // Define las columnas para el modelo de la JTable
            modelo.addColumn("Código");
            modelo.addColumn("Nombre");
            modelo.addColumn("Precio");
            modelo.addColumn("Distribuidor");
            modelo.addColumn("Categoria");

            // Define los anchos de las columnas em la tabla
            int[] anchos = {80, 220, 120, 150, 120};
            for (int i = 0; i < tabla.getColumnCount(); i++) {
                // Establece el ancho de cada columna
                tabla.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }

            // El while se ejecuta mientras existan registros en la base de datos, pinta la información en la tabla
            while (rs.next()) {
                // Crea un array para guardar los valores de las columnas de un registro
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    // Obtiene el objeto de la columna i+1 (los indices en rs empiezan en 1, no en 0) y lo guarda en el array
                    filas[i] = rs.getObject(i + 1);

                }
                modelo.addRow(filas);
            }

            // Si ocurre algún errr SQL durante la ejecución del bloque try, entra en el bloque catch    
        } catch (SQLException ex) {
            System.err.print(ex.toString());
        }


    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        // TODO add your handling code here:
        int seleccionado = tabla.getSelectedRow();

        txtCodigo.setText(tabla.getValueAt(seleccionado, 0).toString());
        txtNombre.setText(tabla.getValueAt(seleccionado, 1).toString());
        txtPrecio.setText(tabla.getValueAt(seleccionado, 2).toString());
        txtDistribuidor.setText(tabla.getValueAt(seleccionado, 3).toString());
        txtCategoria.setText(tabla.getValueAt(seleccionado, 4).toString());
    }//GEN-LAST:event_tablaMouseClicked

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:

        int seleccionado = tabla.getSelectedColumn();

        PreparedStatement ps = null;
        try {
            ConeccionDB objCon = new ConeccionDB();
            Connection conn = objCon.getConexion();

            ps = conn.prepareStatement("UPDATE productos SET nombre=?, precio=?, distribuidor=?, categoria=? WHERE codigo=?");

            ps.setString(1, txtNombre.getText());
            ps.setString(2, txtPrecio.getText());
            ps.setString(3, txtDistribuidor.getText());
            ps.setString(4, txtCategoria.getText());
            ps.setString(5, txtCodigo.getText());

            ps.execute();

            JOptionPane.showMessageDialog(null, "producto modificado correctamente");
            tabla.setValueAt(txtCodigo.getText(), seleccionado, 0);
            tabla.setValueAt(txtNombre.getText(), seleccionado, 1);
            tabla.setValueAt(txtPrecio.getText(), seleccionado, 2);
            tabla.setValueAt(txtDistribuidor.getText(), seleccionado, 3);
            tabla.setValueAt(txtCategoria.getText(), seleccionado, 4);

            limpiarCampos();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar");
            System.err.println(ex);
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        // TODO add your handling code here:
        PreparedStatement ps = null;
        try {

            ConeccionDB objCon = new ConeccionDB();
            Connection conn = objCon.getConexion();

            int Fila = tabla.getSelectedRow();
            String codigo = tabla.getValueAt(Fila, 0).toString();

            ps = conn.prepareStatement("DELETE FROM productos WHERE codigo=?");
            ps.setString(1, codigo);
            ps.execute();

            modelo.removeRow(Fila);
            JOptionPane.showMessageDialog(null, "Producto Eliminado");
            limpiarCampos();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Eliminar Producto");
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    public void limpiarCampos() {
        txtCodigo.setText("");
        txtNombre.setText("");
        txtPrecio.setText("");
        txtDistribuidor.setText("");
        txtCategoria.setText("");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaBuscarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaBuscarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaBuscarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaBuscarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaBuscarProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel codigo1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCodigoBuscar;
    private javax.swing.JTextField txtDistribuidor;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
