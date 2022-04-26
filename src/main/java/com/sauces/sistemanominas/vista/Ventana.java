/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.sistemanominas.vista;

import com.sauces.sistemanominas.controlador.Controlador;
import com.sauces.sistemanominas.modelo.Empleado;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author daw1
 */
public class Ventana extends javax.swing.JFrame {

    /**
     * Creates new form Ventana
     */
    public Ventana() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoListado = new javax.swing.ButtonGroup();
        selectorFicheros = new javax.swing.JFileChooser();
        panelDatos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfDni = new javax.swing.JTextField();
        tfNombre = new javax.swing.JTextField();
        tfIngresos = new javax.swing.JFormattedTextField();
        cbTipo = new javax.swing.JComboBox<>();
        tfSalario = new javax.swing.JFormattedTextField();
        bBorrar = new javax.swing.JButton();
        bModificar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        spHoras = new javax.swing.JSpinner();
        panelTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEmpleados = new javax.swing.JTable();
        bListar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        bDni = new javax.swing.JRadioButton();
        bNombre = new javax.swing.JRadioButton();
        bIngresos = new javax.swing.JRadioButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        miAbrir = new javax.swing.JMenuItem();
        miGuardar = new javax.swing.JMenuItem();
        menuEmpelado = new javax.swing.JMenu();
        miNuevo = new javax.swing.JMenuItem();
        miBuscar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de nóminas");
        setResizable(false);

        panelDatos.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del empleado"));

        jLabel1.setText("DNI");

        jLabel2.setText("NOMBRE");

        jLabel3.setText("TIPO");

        jLabel4.setText("SALARIO");

        jLabel5.setText("INGRESOS");

        tfDni.setEditable(false);

        tfNombre.setEditable(false);

        tfIngresos.setEditable(false);

        cbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FIJO", "EVENTUAL" }));
        cbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoActionPerformed(evt);
            }
        });

        tfSalario.setEditable(false);
        tfSalario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        bBorrar.setText("BORRAR");
        bBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBorrarActionPerformed(evt);
            }
        });

        bModificar.setText("MODIFICAR");

        jLabel6.setText("HORAS");

        spHoras.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout panelDatosLayout = new javax.swing.GroupLayout(panelDatos);
        panelDatos.setLayout(panelDatosLayout);
        panelDatosLayout.setHorizontalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addComponent(bBorrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bModificar))
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(25, 25, 25)
                                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfNombre)
                                    .addComponent(cbTipo, 0, 104, Short.MAX_VALUE)
                                    .addComponent(tfSalario)
                                    .addComponent(tfDni)))
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(tfIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(34, 34, 34)
                                .addComponent(spHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelDatosLayout.setVerticalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(83, 83, 83)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(tfIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bBorrar)
                    .addComponent(bModificar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelTabla.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de empleados"));

        empleadoTM=new EmpleadoTableModel();
        tablaEmpleados.setModel(empleadoTM);
        jScrollPane1.setViewportView(tablaEmpleados);

        bListar.setText("LISTAR EMPLEADOS");

        jLabel7.setText("ORDEN DEL LISTADO");

        grupoListado.add(bDni);
        bDni.setText("DNI");

        grupoListado.add(bNombre);
        bNombre.setText("NOMBRE");

        grupoListado.add(bIngresos);
        bIngresos.setText("INGRESOS");

        javax.swing.GroupLayout panelTablaLayout = new javax.swing.GroupLayout(panelTabla);
        panelTabla.setLayout(panelTablaLayout);
        panelTablaLayout.setHorizontalGroup(
            panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaLayout.createSequentialGroup()
                .addGroup(panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTablaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(panelTablaLayout.createSequentialGroup()
                        .addGroup(panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelTablaLayout.createSequentialGroup()
                                .addGap(166, 166, 166)
                                .addComponent(bListar))
                            .addGroup(panelTablaLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bDni)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bNombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bIngresos)))
                        .addGap(0, 116, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelTablaLayout.setVerticalGroup(
            panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(bListar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(bDni)
                    .addComponent(bNombre)
                    .addComponent(bIngresos))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        menuArchivo.setText("Archivo");

        miAbrir.setText("Abrir");
        menuArchivo.add(miAbrir);

        miGuardar.setText("Guardar");
        menuArchivo.add(miGuardar);

        jMenuBar1.add(menuArchivo);

        menuEmpelado.setText("Empleado");

        miNuevo.setText("Nuevo");
        miNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miNuevoActionPerformed(evt);
            }
        });
        menuEmpelado.add(miNuevo);

        miBuscar.setText("Buscar");
        miBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miBuscarActionPerformed(evt);
            }
        });
        menuEmpelado.add(miBuscar);

        jMenuBar1.add(menuEmpelado);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_miBuscarActionPerformed

    private void miNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miNuevoActionPerformed
        // TODO add your handling code here:
        if(dialogoEmpleado.mostrar()==DialogoEmpleado.ACEPTAR){
            mostrarDni(dialogoEmpleado.getDni());
            mostrarNombre(dialogoEmpleado.getNombre());
            String tipo=dialogoEmpleado.getTipo();
            mostarTipo(tipo);
            mostrarSalario(dialogoEmpleado.getSalario());
            if(tipo=="EVENTUAL"){
                mostrarHoras(dialogoEmpleado.getHoras());
            }
        }
    }//GEN-LAST:event_miNuevoActionPerformed

    private void cbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoActionPerformed
        // TODO add your handling code here:
        if(cbTipo.getSelectedItem().equals("FIJO")){
            this.jLabel6.setVisible(false);
            this.spHoras.setVisible(false);
        }else{
            this.jLabel6.setVisible(true);
            this.spHoras.setVisible(true);
        }
    }//GEN-LAST:event_cbTipoActionPerformed

    private void bBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBorrarActionPerformed
        // TODO add your handling code here:
       String dni= JOptionPane.showInputDialog("Introduce el DNI del empleado a despedir");
       controla
    }//GEN-LAST:event_bBorrarActionPerformed
    private Controlador controlador;
    private DialogoEmpleado dialogoEmpleado=new DialogoEmpleado(this,true);
    private EmpleadoTableModel empleadoTM;
    public String getTipo(){
        return (String)cbTipo.getSelectedItem();
    }
    public String getDni(){
        return tfDni.getText();
    }
    public String getNombre(){
        return tfNombre.getText();
    }
    public float getSalario(){
        return Float.parseFloat(this.tfSalario.getText().replace(',','.'));
    }
    public int getHoras(){
        return (int)spHoras.getValue();
    }
    public String getOrden(){
        return"a";
    }
    public void mostarTipo(String tipo){
        cbTipo.setSelectedItem(tipo);
    }
    public void mostrarDni(String dni){
        tfDni.setText(dni);
    }
    public void mostrarNombre(String nombre){
        tfNombre.setText(nombre);
    }
    public void mostrarSalario(float salario){
        tfSalario.setValue(salario);
    }
    public void mostrarHoras(int horas){
        spHoras.setValue(horas);
    }
    public void mostrarIngresos(float ingresos){
        tfIngresos.setValue(ingresos);
    }
    public void listarEmpleados(List<Empleado> listado){
        empleadoTM.setListado(listado);
        empleadoTM.fireTableDataChanged();
    }
    public void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje);
    }
    public boolean solicitarConfirmacion(){
       if(JOptionPane.showConfirmDialog(this, "¿Confirmamos?", "Confirmacion", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
           return true;
       }else{
           return false;
       }
    }
    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }
    public void limpiarCampos(){
        tfDni.setText("");
        tfNombre.setText("");
        tfSalario.setValue(0);
        spHoras.setValue(0);
        tfIngresos.setValue(0);
    }
    public void mostrar(){
    setVisible(true);
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
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBorrar;
    private javax.swing.JRadioButton bDni;
    private javax.swing.JRadioButton bIngresos;
    private javax.swing.JButton bListar;
    private javax.swing.JButton bModificar;
    private javax.swing.JRadioButton bNombre;
    private javax.swing.JComboBox<String> cbTipo;
    private javax.swing.ButtonGroup grupoListado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenu menuEmpelado;
    private javax.swing.JMenuItem miAbrir;
    private javax.swing.JMenuItem miBuscar;
    private javax.swing.JMenuItem miGuardar;
    private javax.swing.JMenuItem miNuevo;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JPanel panelTabla;
    private javax.swing.JFileChooser selectorFicheros;
    private javax.swing.JSpinner spHoras;
    private javax.swing.JTable tablaEmpleados;
    private javax.swing.JTextField tfDni;
    private javax.swing.JFormattedTextField tfIngresos;
    private javax.swing.JTextField tfNombre;
    private javax.swing.JFormattedTextField tfSalario;
    // End of variables declaration//GEN-END:variables
}
