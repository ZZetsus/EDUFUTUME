
import Conexion.ConexionDB;
import Conexion.MetodosSQL;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;

/**
 *
 * @author Vanessa
 */
public class Seleccion extends javax.swing.JFrame {

    /**
     * Creates new form Seleccion
     */
    int Userglob;
    int UserAdminMod;
    int Cespeciales;

    DefaultTableModel tcdatosglob = new DefaultTableModel();

    PreparedStatement Comando2;
    ResultSet Consulta2;
    ResultSet Correo;
    ResultSet Dir;
    ResultSet Tel;

    public Seleccion() {
        initComponents();

        this.setLocationRelativeTo(null);
        profesor.setLocationRelativeTo(null);
        Registro_profesor.setResizable(false);
        Registro_profesor.setLocationRelativeTo(null);
        Registro_profesor.setSize(1090, 700);
        profesor.setResizable(false);
        profesor.setSize(1090, 700);
        Administrador.setSize(1090, 700);
        ingadmin.setSize(1090, 700);
        ingadmin.setResizable(false);
        profesor2.setSize(1090, 700);
        Registro_profesor.setSize(1090, 700);
        this.setSize(1090, 700);
        this.setResizable(false);
        profesor2.setLocationRelativeTo(null);
        profesor2.setResizable(false);
        Registro_profesor.setResizable(false);
        Registro_profesor.setLocationRelativeTo(null);
        ingadmin.setLocationRelativeTo(null);
        Administrador.setLocationRelativeTo(null);
        Administrador.setResizable(false);
        tcdatosglob.addColumn("USUARIO");
        tcdatosglob.addColumn("NOMBRE(S)_USUARIO");
        tcdatosglob.addColumn("APELLIDO(S)");
        tcdatosglob.addColumn("CORREO1");
        tcdatosglob.addColumn("CORREO2");
        tcdatosglob.addColumn("DIRRECIÓN1");
        tcdatosglob.addColumn("DIRRECIÓN2");
        tcdatosglob.addColumn("TÉLEFONO1");
        tcdatosglob.addColumn("TÉLEFONO2");
    }

    public boolean Cadnumerica(String cad) {
        boolean isNumeric = cad.matches("[+-]?\\d*(\\.\\d+)?");
        return isNumeric;
    }

    public void ActivarMod() {
        txt_CONTRASEÑAMOD.setEnabled(true);
        txt_MODAPELLIDO.setEnabled(true);
        txt_MODNOMBRE.setEnabled(true);
        txt_MODDIR1.setEnabled(true);
        txt_MODDIR2.setEnabled(true);
        txt_MODTELEFONO1.setEnabled(true);
        txt_MODTELEFONO2.setEnabled(true);
        txt_CORREO1.setEnabled(true);
        txt_CORREO2.setEnabled(true);
        btn_ACTUALIZAR.setEnabled(true);

    }

    public void Datos(int user, String tipo) {
        try {
            Comando2 = MetodosSQL.ConsultaCorreo(user, tipo);
            Correo = Comando2.executeQuery();
            Comando2 = MetodosSQL.ConsultaDireccion(user, tipo);
            Dir = Comando2.executeQuery();
            Comando2 = MetodosSQL.ConsultaTelefono(user, tipo);
            Tel = Comando2.executeQuery();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void DesactivarMod() {
        txt_MODAPELLIDO.setEnabled(false);
        txt_MODNOMBRE.setEnabled(false);
        txt_MODDIR1.setEnabled(false);
        txt_MODDIR2.setEnabled(false);
        txt_MODTELEFONO1.setEnabled(false);
        txt_MODTELEFONO2.setEnabled(false);
        txt_CORREO1.setEnabled(false);
        txt_CORREO2.setEnabled(false);
        btn_ACTUALIZAR.setEnabled(false);
    }

    public void LimpiarAdmin() {

        //ENABLE MOD
        txt_MODNOMBRE.setEnabled(false);
        txt_MODAPELLIDO.setEnabled(false);
        txt_MODUSER.setEnabled(false);
        txt_MODDIR1.setEnabled(false);
        txt_MODTELEFONO2.setEnabled(false);
        txt_CORREO1.setEnabled(false);
        btn_ACTUALIZAR.setEnabled(false);
        txt_CONTRASEÑAMOD.setEnabled(false);

        //FOCUS
        BIENVENIDA.requestFocus();
        txt_BUSCARUSERMOD.requestFocus();
        txt_CREACIONNOMBREADMIN.requestFocus();
        txt_BUSCARADMINISTRADOR.requestFocus();

        //MOD
        txt_MODNOMBRE.setText("NA");
        txt_MODAPELLIDO.setText("NA");
        txt_MODUSER.setText("NA");
        txt_MODDIR1.setText("NA");
        txt_MODDIR2.setText("NA");
        txt_MODTELEFONO1.setText("NA");
        txt_MODTELEFONO2.setText("NA");
        txt_CORREO1.setText("NA");
        txt_CORREO2.setText("NA");
        txt_CONTRASEÑAMOD.setText("NA");
        txt_BUSCARUSERMOD.setText("");
        DesactivarMod();

        //CREACIONUSER
        txt_CREACIONNOMBREADMIN.setText("");
        txt_CREACIONAPELLIDOADMIN.setText("");
        txt_CREACIONUSUARIOADMIN.setText("");
        txt_CREACIONCONTRASEÑAADMIN.setText("");
        txt_CREACIONCONTRASEÑA2ADMIN.setText("");
        txt_CREACIONTELEFONOADMIN.setText("");
        txt_CREACIONDIRECCIONADMIN.setText("");
        txt_CREACIONCORREOADMIN.setText("");
        TIPO_CUENTA.setSelectedIndex(0);

        //CONSULTAUSER
        txt_BUSCARADMINISTRADOR.setText("");
        jCOMBO_BUSCARADMIN1.setSelectedIndex(0);
        jCOMBO_BUSCARADMIN2.setSelectedIndex(0);

        //USERCREDEN
        txt_USER_ADMINISTRADOR.setText("");
        txt_CONTRASEÑA_ADMINISTRADOR.setText("");

        //JTABLE
        try {
            DefaultTableModel temp;
            temp = (DefaultTableModel) TablaDatosAdministrador.getModel();
            int a = temp.getRowCount() - 1;
            for (int i = 0; i <= a; i++) {
                temp.removeRow(0);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void Limpiar_Profesor() {
        txt_USERPROFESOR.setText("");
        txt_CONTRASEÑAPROFESOR.setText("");
        txt_BUSCARESTUDIANTEPROFESOR.setText("");
        cbox_CONSULTAPROFESOR.setSelectedIndex(0);
        //JTABLE "CONSULTA ESTUDIANTE"
        try {
            DefaultTableModel temp;
            temp = (DefaultTableModel) TablaDatosProfesor.getModel();
            int a = temp.getRowCount() - 1;
            for (int i = 0; i <= a; i++) {
                temp.removeRow(0);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        //////////////////////////////////////////////////
        txt_BUSCARCONTENIDO.setText("");
        cbox_CONSULTACONTENIDO.setSelectedIndex(0);

        //JTABLE "CONSULTA ESTUDIANTE"
        try {
            DefaultTableModel temp;
            temp = (DefaultTableModel) TablaDatosContenidoProfesor.getModel();
            int a = temp.getRowCount() - 1;
            for (int i = 0; i <= a; i++) {
                temp.removeRow(0);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        //////////////////////////////////////////////////
        BTN_ELIMINAR.setEnabled(false);
        cbox_CURSO.setSelectedIndex(0);
        Eliminar_contenido();
        Eliminar_Profesor_Contraseña();
    }

    public void Eliminar_Profesor_Contraseña() {
        txt_ContraseñaAntigua.setText("");
        txt_ContraseñaNueva1.setText("");
        txt_ContraseñaNueva2.setText("");
    }

    public void Eliminar_contenido() {
        txt_NOMBRECONTENIDO.setText("");
        txt_LINK.setText("");
        txt_DESCRIPCION.setText("");
        cbox_CURSOMONTAR.setSelectedIndex(0);
    }

    public void Eliminar_contenido_DB() {
        DefaultTableModel temp;
        temp = (DefaultTableModel) TablaDatosContenidoProfesor.getModel();
        int fila = TablaDatosContenidoProfesor.getSelectedRow();
        String valor = TablaDatosContenidoProfesor.getValueAt(fila, 1).toString();
        PreparedStatement eliminar;
        try {
            eliminar = ConexionDB.conectar().prepareStatement("DELETE FROM CONTENIDO WHERE  \"NRO-CONTENIDO\"= '" + valor + "'");
            eliminar.executeUpdate();
            temp.removeRow(fila);
        } catch (Exception e) {
            System.out.println("No se pudo eliminar el contenido");
        }

    }

    public void LimpiarCreacionUserAdmin() {
        txt_CREACIONNOMBREADMIN.setText("");
        txt_CREACIONAPELLIDOADMIN.setText("");
        txt_CREACIONUSUARIOADMIN.setText("");
        txt_CREACIONCONTRASEÑAADMIN.setText("");
        txt_CREACIONCONTRASEÑA2ADMIN.setText("");
        txt_CREACIONTELEFONOADMIN.setText("");
        txt_CREACIONTELEFONOADMIN1.setText("");
        txt_CREACIONDIRECCIONADMIN.setText("");
        txt_CREACIONDIRECCIONADMIN1.setText("");
        txt_CREACIONCORREOADMIN.setText("");
        txt_CREACIONCORREOADMIN1.setText("");
        TIPO_CUENTA.setSelectedIndex(0);
    }

    public void LimpiarRegistroProfesor() {
        txt_NOMBREREGISTRO.setText("");
        txt_APELLIDOSREGISTRO.setText("");
        txt_USUARIOREGISTRO.setText("");
        txt_CONTRASEÑAREGISTRO1.setText("");
        txt_CONTRASEÑAREGISTRO2.setText("");
        txt_DIRECCIONREGISTRO1.setText("");
        txt_DIRECCIONREGISTRO2.setText("");
        txt_TELEFONOREGISTRO1.setText("");
        txt_TELEFONOREGISTRO2.setText("");
        txt_CORREOREGISTRO1.setText("");
        txt_CORREOREGISTRO2.setText("");

    }

    public void ConsultaUsuarioDatos(String tipo, String add) {
        String[] datos = new String[9];
        tcdatosglob.setRowCount(0);
        try {
            String cad = ("SELECT \"USUARIO-" + tipo + "\", \"NOMBRE(S)_USUARIO\", \"APELLIDO(S)_USUARIO\" FROM \"CUENTA-" + tipo + "\" " + add);
            System.out.println(cad);
            Comando2 = MetodosSQL.Consulta(cad);
            Consulta2 = Comando2.executeQuery();
            while (Consulta2.next()) {
                datos[0] = Consulta2.getInt(1) + "";
                datos[1] = Consulta2.getString(2);
                datos[2] = Consulta2.getString(3);
                Datos(Integer.parseInt(datos[0]), tipo);
                int i = 0, num1 = 0, num2 = 0;
                String cor1 = "", cor2 = "";
                /////CORREOOOOO
                while (Correo.next()) {
                    System.out.println("CORREOO");
                    if (i == 0) {
                        num1 = Correo.getInt("NRO-CORREO");
                        cor1 = Correo.getString("CORREO");
                        i++;
                    } else {
                        num2 = Correo.getInt("NRO-CORREO");
                        cor2 = Correo.getString("CORREO");
                    }
                }
                if (num1 > num2) {
                    datos[3] = cor2;
                    if (cor1.equals("VACÍO")) {
                        datos[4] = "VACÍO";
                    } else {
                        datos[4] = cor1;
                    }
                } else {
                    datos[3] = cor1;
                    if (cor2.equals("VACÍO")) {
                        datos[4] = "VACÍO";
                    } else {
                        datos[4] = cor2;
                    }
                }
                /////////////////////////
                /////DIRECCION
                i = 0;
                while (Dir.next()) {
                    System.out.println("DIREEE");
                    if (i == 0) {
                        num1 = Dir.getInt("NRO-DIRECCION");
                        cor1 = Dir.getString("DIRECCION");
                        i++;
                    } else {
                        num2 = Dir.getInt("NRO-DIRECCION");
                        cor2 = Dir.getString("DIRECCION");
                    }
                }
                if (num1 > num2) {
                    datos[5] = cor2;
                    if (cor1.equals("VACÍO")) {
                        datos[6] = "VACÍO";
                    } else {
                        datos[6] = cor1;
                    }
                } else {
                    datos[5] = cor1;
                    if (cor2.equals("VACÍO")) {
                        datos[6] = "VACÍO";
                    } else {
                        datos[6] = cor2;
                    }
                }
                /////////////////////////
                /////TELEFONO
                i = 0;
                while (Tel.next()) {
                    System.out.println("TELEFONO");
                    if (i == 0) {
                        num1 = Tel.getInt("NRO-TELEFONO");
                        cor1 = Tel.getString("TELEFONO");
                        i++;
                    } else {
                        num2 = Tel.getInt("NRO-TELEFONO");
                        cor2 = Tel.getString("TELEFONO");
                    }
                }
                if (num1 > num2) {
                    datos[7] = cor2;
                    if (cor1.equals("VACÍO")) {
                        datos[8] = "VACÍO";
                    } else {
                        datos[8] = cor1;
                    }
                } else {
                    datos[7] = cor1;
                    if (cor2.equals("VACÍO")) {
                        datos[8] = "VACÍO";
                    } else {
                        datos[8] = cor2;
                    }
                }
                tcdatosglob.addRow(datos);
            }
        } catch (Exception e) {
            System.out.println(e);
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

        profesor = new javax.swing.JFrame();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txt_USERPROFESOR = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        txt_CONTRASEÑAPROFESOR = new javax.swing.JPasswordField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        Inicio1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        Minimizar1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel89 = new javax.swing.JLabel();
        Administrador = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        Panelpestaña = new javax.swing.JTabbedPane();
        BIENVENIDA = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        txt_MODNOMBRE = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        txt_MODAPELLIDO = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        txt_MODUSER = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        Ingresotxt18 = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        txt_MODDIR1 = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        txt_MODTELEFONO2 = new javax.swing.JTextField();
        txt_CORREO1 = new javax.swing.JTextField();
        btn_ACTUALIZAR = new javax.swing.JButton();
        txt_BUSCARUSERMOD = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        btn_BUSCARMODIFICAR = new javax.swing.JButton();
        txt_MODTELEFONO1 = new javax.swing.JTextField();
        txt_MODDIR2 = new javax.swing.JTextField();
        txt_CORREO2 = new javax.swing.JTextField();
        label_PERTENECE = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        txt_CONTRASEÑAMOD = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        txt_CREACIONNOMBREADMIN = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        txt_CREACIONAPELLIDOADMIN = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        txt_CREACIONUSUARIOADMIN = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        txt_CREACIONCONTRASEÑAADMIN = new javax.swing.JPasswordField();
        jLabel46 = new javax.swing.JLabel();
        txt_CREACIONCONTRASEÑA2ADMIN = new javax.swing.JPasswordField();
        jLabel43 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        txt_CREACIONDIRECCIONADMIN = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        txt_CREACIONTELEFONOADMIN = new javax.swing.JTextField();
        txt_CREACIONCORREOADMIN = new javax.swing.JTextField();
        REGISTRAR = new javax.swing.JButton();
        jLabel56 = new javax.swing.JLabel();
        TIPO_CUENTA = new javax.swing.JComboBox<>();
        txt_CREACIONDIRECCIONADMIN1 = new javax.swing.JTextField();
        txt_CREACIONTELEFONOADMIN1 = new javax.swing.JTextField();
        txt_CREACIONCORREOADMIN1 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        txt_BUSCARADMINISTRADOR = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaDatosAdministrador = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        CONSULTAR = new javax.swing.JButton();
        jCOMBO_BUSCARADMIN2 = new javax.swing.JComboBox<>();
        jCOMBO_BUSCARADMIN1 = new javax.swing.JComboBox<>();
        jPanel17 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        Minimizar4 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        ingadmin = new javax.swing.JFrame();
        jPanel10 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txt_USER_ADMINISTRADOR = new javax.swing.JTextField();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator13 = new javax.swing.JSeparator();
        txt_CONTRASEÑA_ADMINISTRADOR = new javax.swing.JPasswordField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        Inicio2 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        Minimizar = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        profesor2 = new javax.swing.JFrame();
        jPanel13 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel28 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        txt_BUSCARESTUDIANTEPROFESOR = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaDatosProfesor = new javax.swing.JTable();
        BUSCARDATOS = new javax.swing.JButton();
        cbox_CONSULTAPROFESOR = new javax.swing.JComboBox<>();
        jPanel30 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        txt_BUSCARCONTENIDO = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaDatosContenidoProfesor = new javax.swing.JTable();
        btn_BUSCARCONTENIDO = new javax.swing.JButton();
        cbox_CONSULTACONTENIDO = new javax.swing.JComboBox<>();
        BTN_ELIMINAR = new javax.swing.JButton();
        jLabel87 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        cbox_CURSO = new javax.swing.JComboBox<>();
        btn_INGRESARCURSO = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        txt_NOMBRECONTENIDO = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        txt_DESCRIPCION = new javax.swing.JTextField();
        btn_ACTUALIZARCURSO = new javax.swing.JButton();
        cbox_CURSOMONTAR = new javax.swing.JComboBox<>();
        txt_LINK = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        txt_ContraseñaNueva2 = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        txt_ContraseñaAntigua = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        jLabel72 = new javax.swing.JLabel();
        txt_ContraseñaNueva1 = new javax.swing.JTextField();
        jLabel94 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        Minimizar2 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        Registro_profesor = new javax.swing.JFrame();
        jPanel32 = new javax.swing.JPanel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        txt_CORREOREGISTRO1 = new javax.swing.JTextField();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        txt_CORREOREGISTRO2 = new javax.swing.JTextField();
        txt_TELEFONOREGISTRO1 = new javax.swing.JTextField();
        jLabel85 = new javax.swing.JLabel();
        txt_TELEFONOREGISTRO2 = new javax.swing.JTextField();
        txt_DIRECCIONREGISTRO1 = new javax.swing.JTextField();
        jLabel86 = new javax.swing.JLabel();
        txt_DIRECCIONREGISTRO2 = new javax.swing.JTextField();
        txt_APELLIDOSREGISTRO = new javax.swing.JTextField();
        txt_CONTRASEÑAREGISTRO1 = new javax.swing.JTextField();
        txt_USUARIOREGISTRO = new javax.swing.JTextField();
        txt_NOMBREREGISTRO = new javax.swing.JTextField();
        txt_CONTRASEÑAREGISTRO2 = new javax.swing.JTextField();
        Minimizar3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        Estudiante = new javax.swing.JButton();
        ADMI = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();

        profesor.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        profesor.setUndecorated(true);
        profesor.setResizable(false);
        profesor.setSize(new java.awt.Dimension(1090, 700));
        profesor.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Castellar", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 153, 153));
        jLabel14.setText("Contraseña:");
        jPanel7.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 370, -1, -1));

        jLabel15.setFont(new java.awt.Font("Castellar", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 153, 153));
        jLabel15.setText("Usuario:");
        jPanel7.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 250, -1, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imagen profesor of (1).jpg"))); // NOI18N
        jPanel7.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 110, -1, 120));

        txt_USERPROFESOR.setFont(new java.awt.Font("Castellar", 0, 18)); // NOI18N
        txt_USERPROFESOR.setForeground(new java.awt.Color(153, 153, 153));
        txt_USERPROFESOR.setText("User");
        txt_USERPROFESOR.setBorder(null);
        txt_USERPROFESOR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_USERPROFESORMouseClicked(evt);
            }
        });
        txt_USERPROFESOR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_USERPROFESORKeyTyped(evt);
            }
        });
        jPanel7.add(txt_USERPROFESOR, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 300, 220, 20));
        jPanel7.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 440, 220, 21));
        jPanel7.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 320, 220, 20));

        txt_CONTRASEÑAPROFESOR.setForeground(new java.awt.Color(153, 153, 153));
        txt_CONTRASEÑAPROFESOR.setText("mmmmmmmmmmmmmm");
        txt_CONTRASEÑAPROFESOR.setBorder(null);
        txt_CONTRASEÑAPROFESOR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_CONTRASEÑAPROFESORMouseClicked(evt);
            }
        });
        txt_CONTRASEÑAPROFESOR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CONTRASEÑAPROFESORActionPerformed(evt);
            }
        });
        txt_CONTRASEÑAPROFESOR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_CONTRASEÑAPROFESORKeyTyped(evt);
            }
        });
        jPanel7.add(txt_CONTRASEÑAPROFESOR, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 420, 220, 20));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/password.png"))); // NOI18N
        jPanel7.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 410, 30, 30));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/descarga (1) (1).jpg"))); // NOI18N
        jPanel7.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 290, -1, -1));

        Inicio1.setFont(new java.awt.Font("Dubai Light", 1, 18)); // NOI18N
        Inicio1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Boton avanzar  (2) (2).png"))); // NOI18N
        Inicio1.setBorder(null);
        Inicio1.setBorderPainted(false);
        Inicio1.setContentAreaFilled(false);
        Inicio1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Inicio1.setFocusPainted(false);
        Inicio1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Boton avanzar  (2) (3).png"))); // NOI18N
        Inicio1.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Boton avanzar  (2) (3).png"))); // NOI18N
        Inicio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Inicio1ActionPerformed(evt);
            }
        });
        jPanel7.add(Inicio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 540, 62, -1));

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel7.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Castellar", 1, 14)); // NOI18N
        jLabel2.setText("REGISTRARSE");
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel7.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 500, 120, -1));

        jPanel11.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );

        jPanel7.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 80, 720));

        jPanel16.setBackground(new java.awt.Color(0, 204, 204));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );

        jPanel7.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 720));

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Castellar", 0, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("INGRESO PROFESORES");
        jPanel7.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, 340, 37));

        Minimizar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_Expand_Arrow_32px.png"))); // NOI18N
        Minimizar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Minimizar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Minimizar1MouseClicked(evt);
            }
        });
        jPanel7.add(Minimizar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 10, -1, 30));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/enter (2) (1).jpg"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/enter on (1).jpg"))); // NOI18N
        jButton1.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/enter on (1).jpg"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, -1));

        jLabel89.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_Multiply_32px.png"))); // NOI18N
        jLabel89.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel89.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel89MouseClicked(evt);
            }
        });
        jPanel7.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 10, 40, 30));

        profesor.getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 790));

        Administrador.setUndecorated(true);
        Administrador.setSize(new java.awt.Dimension(1110, 700));
        Administrador.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Administrador.getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1443, 0, -1, -1));

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panelpestaña.setBackground(new java.awt.Color(102, 255, 255));
        Panelpestaña.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        Panelpestaña.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Panelpestaña.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N

        BIENVENIDA.setBackground(new java.awt.Color(0, 153, 153));
        BIENVENIDA.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/tutor (1).png"))); // NOI18N
        jLabel35.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel9.setFont(new java.awt.Font("Castellar", 1, 36)); // NOI18N
        jLabel9.setText("BIENVENIDos");

        javax.swing.GroupLayout BIENVENIDALayout = new javax.swing.GroupLayout(BIENVENIDA);
        BIENVENIDA.setLayout(BIENVENIDALayout);
        BIENVENIDALayout.setHorizontalGroup(
            BIENVENIDALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BIENVENIDALayout.createSequentialGroup()
                .addContainerGap(261, Short.MAX_VALUE)
                .addGroup(BIENVENIDALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BIENVENIDALayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(264, 264, 264))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BIENVENIDALayout.createSequentialGroup()
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(256, 256, 256))))
        );
        BIENVENIDALayout.setVerticalGroup(
            BIENVENIDALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BIENVENIDALayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel9)
                .addGap(27, 27, 27)
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(183, Short.MAX_VALUE))
        );

        Panelpestaña.addTab("BIENVENIDA", BIENVENIDA);

        jPanel24.setBackground(new java.awt.Color(0, 153, 153));
        jPanel24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanel29.setBackground(new java.awt.Color(0, 153, 153));
        jPanel29.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel57.setFont(new java.awt.Font("Castellar", 0, 24)); // NOI18N
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel57.setText("MODIFICACION USUARIOS");

        jLabel58.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        jLabel58.setText("NOMBRE(S):");

        txt_MODNOMBRE.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        txt_MODNOMBRE.setForeground(new java.awt.Color(153, 153, 153));
        txt_MODNOMBRE.setBorder(null);
        txt_MODNOMBRE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_MODNOMBREMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_MODNOMBREMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_MODNOMBREMousePressed(evt);
            }
        });
        txt_MODNOMBRE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_MODNOMBREActionPerformed(evt);
            }
        });

        jLabel59.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        jLabel59.setText("APELLIDOS:");

        txt_MODAPELLIDO.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        txt_MODAPELLIDO.setForeground(new java.awt.Color(153, 153, 153));
        txt_MODAPELLIDO.setBorder(null);
        txt_MODAPELLIDO.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_MODAPELLIDO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_MODAPELLIDOMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_MODAPELLIDOMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_MODAPELLIDOMousePressed(evt);
            }
        });
        txt_MODAPELLIDO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_MODAPELLIDOActionPerformed(evt);
            }
        });

        jLabel60.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        jLabel60.setText("BUSCAR USUARIO: ");

        txt_MODUSER.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        txt_MODUSER.setForeground(new java.awt.Color(153, 153, 153));
        txt_MODUSER.setBorder(null);
        txt_MODUSER.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_MODUSERMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_MODUSERMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_MODUSERMousePressed(evt);
            }
        });
        txt_MODUSER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_MODUSERActionPerformed(evt);
            }
        });
        txt_MODUSER.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_MODUSERKeyTyped(evt);
            }
        });

        jLabel63.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        jLabel63.setText("DIRECCIONES:");

        Ingresotxt18.setFont(new java.awt.Font("Dubai Light", 1, 18)); // NOI18N
        Ingresotxt18.setForeground(new java.awt.Color(153, 153, 153));
        Ingresotxt18.setBorder(null);
        Ingresotxt18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Ingresotxt18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Ingresotxt18MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Ingresotxt18MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Ingresotxt18MousePressed(evt);
            }
        });
        Ingresotxt18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ingresotxt18ActionPerformed(evt);
            }
        });

        jLabel64.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        jLabel64.setText("TELÉFONOS:");

        txt_MODDIR1.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        txt_MODDIR1.setForeground(new java.awt.Color(153, 153, 153));
        txt_MODDIR1.setBorder(null);
        txt_MODDIR1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_MODDIR1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_MODDIR1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_MODDIR1MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_MODDIR1MousePressed(evt);
            }
        });
        txt_MODDIR1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_MODDIR1ActionPerformed(evt);
            }
        });

        jLabel65.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        jLabel65.setText("CORREOS:");

        txt_MODTELEFONO2.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        txt_MODTELEFONO2.setForeground(new java.awt.Color(153, 153, 153));
        txt_MODTELEFONO2.setBorder(null);
        txt_MODTELEFONO2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_MODTELEFONO2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_MODTELEFONO2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_MODTELEFONO2MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_MODTELEFONO2MousePressed(evt);
            }
        });
        txt_MODTELEFONO2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_MODTELEFONO2ActionPerformed(evt);
            }
        });
        txt_MODTELEFONO2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_MODTELEFONO2KeyTyped(evt);
            }
        });

        txt_CORREO1.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        txt_CORREO1.setForeground(new java.awt.Color(153, 153, 153));
        txt_CORREO1.setBorder(null);
        txt_CORREO1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_CORREO1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_CORREO1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_CORREO1MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_CORREO1MousePressed(evt);
            }
        });
        txt_CORREO1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CORREO1ActionPerformed(evt);
            }
        });

        btn_ACTUALIZAR.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        btn_ACTUALIZAR.setText("ACTUALIZAR");
        btn_ACTUALIZAR.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ACTUALIZAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ACTUALIZARActionPerformed(evt);
            }
        });

        txt_BUSCARUSERMOD.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        txt_BUSCARUSERMOD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_BUSCARUSERMODActionPerformed(evt);
            }
        });

        jLabel67.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        jLabel67.setText("USUARIO:");

        btn_BUSCARMODIFICAR.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        btn_BUSCARMODIFICAR.setText("BUSCAR");
        btn_BUSCARMODIFICAR.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_BUSCARMODIFICAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BUSCARMODIFICARActionPerformed(evt);
            }
        });

        txt_MODTELEFONO1.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        txt_MODTELEFONO1.setForeground(new java.awt.Color(153, 153, 153));
        txt_MODTELEFONO1.setBorder(null);
        txt_MODTELEFONO1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_MODTELEFONO1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_MODTELEFONO1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_MODTELEFONO1MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_MODTELEFONO1MousePressed(evt);
            }
        });
        txt_MODTELEFONO1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_MODTELEFONO1ActionPerformed(evt);
            }
        });
        txt_MODTELEFONO1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_MODTELEFONO1KeyTyped(evt);
            }
        });

        txt_MODDIR2.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        txt_MODDIR2.setForeground(new java.awt.Color(153, 153, 153));
        txt_MODDIR2.setBorder(null);
        txt_MODDIR2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_MODDIR2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_MODDIR2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_MODDIR2MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_MODDIR2MousePressed(evt);
            }
        });
        txt_MODDIR2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_MODDIR2ActionPerformed(evt);
            }
        });

        txt_CORREO2.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        txt_CORREO2.setForeground(new java.awt.Color(153, 153, 153));
        txt_CORREO2.setBorder(null);
        txt_CORREO2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_CORREO2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_CORREO2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_CORREO2MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_CORREO2MousePressed(evt);
            }
        });
        txt_CORREO2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CORREO2ActionPerformed(evt);
            }
        });

        label_PERTENECE.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        label_PERTENECE.setText("ESTA CUENTA PERTENECE A : ");
        label_PERTENECE.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel71.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N

        jLabel74.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        jLabel74.setText("CONTRASEÑA: ");

        txt_CONTRASEÑAMOD.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        txt_CONTRASEÑAMOD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_CONTRASEÑAMODKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        jLabel3.setText("OPCIONAL");

        jLabel20.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        jLabel20.setText("OPCIONAL");

        jLabel21.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        jLabel21.setText("OPCIONAL");

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel67, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
                                    .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(9, 9, 9))
                                .addComponent(jLabel58, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel29Layout.createSequentialGroup()
                                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel29Layout.createSequentialGroup()
                                        .addComponent(txt_MODUSER, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(49, 49, 49)
                                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel20)
                                            .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(txt_MODNOMBRE, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_MODAPELLIDO, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
                                .addComponent(txt_CONTRASEÑAMOD, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel29Layout.createSequentialGroup()
                                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Ingresotxt18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel21))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_MODDIR2, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                                    .addComponent(txt_CORREO1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txt_MODTELEFONO2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txt_MODTELEFONO1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txt_CORREO2)
                                    .addComponent(txt_MODDIR1)))))
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel29Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel60)
                                .addGap(36, 36, 36)
                                .addComponent(txt_BUSCARUSERMOD, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(btn_BUSCARMODIFICAR, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel29Layout.createSequentialGroup()
                                .addComponent(label_PERTENECE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(101, 101, 101)))
                .addGap(77, 77, 77))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
                        .addComponent(btn_ACTUALIZAR)
                        .addGap(328, 328, 328))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
                        .addComponent(jLabel57)
                        .addGap(206, 206, 206))))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_MODUSER, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel67)
                    .addComponent(jLabel63)
                    .addComponent(txt_MODDIR1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_MODDIR2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel58)
                    .addComponent(txt_MODNOMBRE, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel29Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(Ingresotxt18, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_MODTELEFONO1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_MODTELEFONO2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addComponent(jLabel64)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel59)
                            .addComponent(txt_MODAPELLIDO, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel65)
                            .addComponent(txt_CORREO1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_CORREO2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21)))
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_CONTRASEÑAMOD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_BUSCARUSERMOD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_BUSCARMODIFICAR)
                    .addComponent(jLabel60))
                .addGap(34, 34, 34)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label_PERTENECE)
                    .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(btn_ACTUALIZAR)
                .addGap(68, 68, 68))
        );

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, 829, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Panelpestaña.addTab("MODIFICACION DE USUARIO", jPanel24);

        jPanel22.setBackground(new java.awt.Color(0, 153, 153));
        jPanel22.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel37.setFont(new java.awt.Font("Castellar", 0, 24)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("CREACIÓN USUARIOS");

        jLabel39.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        jLabel39.setText("NOMBRE(S):");

        txt_CREACIONNOMBREADMIN.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        txt_CREACIONNOMBREADMIN.setForeground(new java.awt.Color(153, 153, 153));
        txt_CREACIONNOMBREADMIN.setBorder(null);
        txt_CREACIONNOMBREADMIN.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_CREACIONNOMBREADMIN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_CREACIONNOMBREADMINMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_CREACIONNOMBREADMINMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_CREACIONNOMBREADMINMousePressed(evt);
            }
        });
        txt_CREACIONNOMBREADMIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CREACIONNOMBREADMINActionPerformed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel38.setText("APELLIDOS:");

        txt_CREACIONAPELLIDOADMIN.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        txt_CREACIONAPELLIDOADMIN.setForeground(new java.awt.Color(153, 153, 153));
        txt_CREACIONAPELLIDOADMIN.setBorder(null);
        txt_CREACIONAPELLIDOADMIN.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_CREACIONAPELLIDOADMIN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_CREACIONAPELLIDOADMINMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_CREACIONAPELLIDOADMINMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_CREACIONAPELLIDOADMINMousePressed(evt);
            }
        });
        txt_CREACIONAPELLIDOADMIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CREACIONAPELLIDOADMINActionPerformed(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        jLabel40.setText("USUARIO:");

        txt_CREACIONUSUARIOADMIN.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        txt_CREACIONUSUARIOADMIN.setForeground(new java.awt.Color(153, 153, 153));
        txt_CREACIONUSUARIOADMIN.setBorder(null);
        txt_CREACIONUSUARIOADMIN.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_CREACIONUSUARIOADMIN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_CREACIONUSUARIOADMINMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_CREACIONUSUARIOADMINMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_CREACIONUSUARIOADMINMousePressed(evt);
            }
        });
        txt_CREACIONUSUARIOADMIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CREACIONUSUARIOADMINActionPerformed(evt);
            }
        });
        txt_CREACIONUSUARIOADMIN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_CREACIONUSUARIOADMINKeyTyped(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        jLabel41.setText("CONTRASEÑA:");

        txt_CREACIONCONTRASEÑAADMIN.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        txt_CREACIONCONTRASEÑAADMIN.setBorder(null);
        txt_CREACIONCONTRASEÑAADMIN.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_CREACIONCONTRASEÑAADMIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CREACIONCONTRASEÑAADMINActionPerformed(evt);
            }
        });
        txt_CREACIONCONTRASEÑAADMIN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_CREACIONCONTRASEÑAADMINKeyTyped(evt);
            }
        });

        jLabel46.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        jLabel46.setText("CONTRASEÑA:");

        txt_CREACIONCONTRASEÑA2ADMIN.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        txt_CREACIONCONTRASEÑA2ADMIN.setBorder(null);
        txt_CREACIONCONTRASEÑA2ADMIN.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_CREACIONCONTRASEÑA2ADMIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CREACIONCONTRASEÑA2ADMINActionPerformed(evt);
            }
        });
        txt_CREACIONCONTRASEÑA2ADMIN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_CREACIONCONTRASEÑA2ADMINKeyTyped(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        jLabel43.setText("DIRECCIÓN:");

        jLabel45.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        jLabel45.setText("TELÉFONO:");

        txt_CREACIONDIRECCIONADMIN.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        txt_CREACIONDIRECCIONADMIN.setForeground(new java.awt.Color(153, 153, 153));
        txt_CREACIONDIRECCIONADMIN.setBorder(null);
        txt_CREACIONDIRECCIONADMIN.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_CREACIONDIRECCIONADMIN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_CREACIONDIRECCIONADMINMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_CREACIONDIRECCIONADMINMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_CREACIONDIRECCIONADMINMousePressed(evt);
            }
        });
        txt_CREACIONDIRECCIONADMIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CREACIONDIRECCIONADMINActionPerformed(evt);
            }
        });

        jLabel44.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        jLabel44.setText("CORREO:");

        txt_CREACIONTELEFONOADMIN.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        txt_CREACIONTELEFONOADMIN.setForeground(new java.awt.Color(153, 153, 153));
        txt_CREACIONTELEFONOADMIN.setBorder(null);
        txt_CREACIONTELEFONOADMIN.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_CREACIONTELEFONOADMIN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_CREACIONTELEFONOADMINMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_CREACIONTELEFONOADMINMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_CREACIONTELEFONOADMINMousePressed(evt);
            }
        });
        txt_CREACIONTELEFONOADMIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CREACIONTELEFONOADMINActionPerformed(evt);
            }
        });
        txt_CREACIONTELEFONOADMIN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_CREACIONTELEFONOADMINKeyTyped(evt);
            }
        });

        txt_CREACIONCORREOADMIN.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        txt_CREACIONCORREOADMIN.setForeground(new java.awt.Color(153, 153, 153));
        txt_CREACIONCORREOADMIN.setBorder(null);
        txt_CREACIONCORREOADMIN.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_CREACIONCORREOADMIN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_CREACIONCORREOADMINMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_CREACIONCORREOADMINMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_CREACIONCORREOADMINMousePressed(evt);
            }
        });
        txt_CREACIONCORREOADMIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CREACIONCORREOADMINActionPerformed(evt);
            }
        });

        REGISTRAR.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        REGISTRAR.setText("REGISTRAR");
        REGISTRAR.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        REGISTRAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                REGISTRARActionPerformed(evt);
            }
        });

        jLabel56.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        jLabel56.setText("TIPO DE USUARIO:");

        TIPO_CUENTA.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N
        TIPO_CUENTA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONA", "PROFESOR", "ESTUDIANTE" }));
        TIPO_CUENTA.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txt_CREACIONDIRECCIONADMIN1.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        txt_CREACIONDIRECCIONADMIN1.setForeground(new java.awt.Color(153, 153, 153));
        txt_CREACIONDIRECCIONADMIN1.setBorder(null);
        txt_CREACIONDIRECCIONADMIN1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_CREACIONDIRECCIONADMIN1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_CREACIONDIRECCIONADMIN1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_CREACIONDIRECCIONADMIN1MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_CREACIONDIRECCIONADMIN1MousePressed(evt);
            }
        });
        txt_CREACIONDIRECCIONADMIN1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CREACIONDIRECCIONADMIN1ActionPerformed(evt);
            }
        });

        txt_CREACIONTELEFONOADMIN1.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        txt_CREACIONTELEFONOADMIN1.setForeground(new java.awt.Color(153, 153, 153));
        txt_CREACIONTELEFONOADMIN1.setBorder(null);
        txt_CREACIONTELEFONOADMIN1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_CREACIONTELEFONOADMIN1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_CREACIONTELEFONOADMIN1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_CREACIONTELEFONOADMIN1MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_CREACIONTELEFONOADMIN1MousePressed(evt);
            }
        });
        txt_CREACIONTELEFONOADMIN1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CREACIONTELEFONOADMIN1ActionPerformed(evt);
            }
        });
        txt_CREACIONTELEFONOADMIN1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_CREACIONTELEFONOADMIN1KeyTyped(evt);
            }
        });

        txt_CREACIONCORREOADMIN1.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        txt_CREACIONCORREOADMIN1.setForeground(new java.awt.Color(153, 153, 153));
        txt_CREACIONCORREOADMIN1.setBorder(null);
        txt_CREACIONCORREOADMIN1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_CREACIONCORREOADMIN1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_CREACIONCORREOADMIN1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_CREACIONCORREOADMIN1MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_CREACIONCORREOADMIN1MousePressed(evt);
            }
        });
        txt_CREACIONCORREOADMIN1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CREACIONCORREOADMIN1ActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        jLabel22.setText("OPCIONAL");

        jLabel23.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        jLabel23.setText("OPCIONAL");

        jLabel24.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        jLabel24.setText("OPCIONAL");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel22Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_CREACIONCONTRASEÑA2ADMIN))
                    .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel22Layout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txt_CREACIONCONTRASEÑAADMIN, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel22Layout.createSequentialGroup()
                                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_CREACIONUSUARIOADMIN, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel22Layout.createSequentialGroup()
                                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(21, 21, 21)
                                    .addComponent(txt_CREACIONAPELLIDOADMIN, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(txt_CREACIONNOMBREADMIN, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(40, 40, 40)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_CREACIONCORREOADMIN1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_CREACIONTELEFONOADMIN1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_CREACIONDIRECCIONADMIN1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel56)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                        .addComponent(txt_CREACIONCORREOADMIN, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_CREACIONTELEFONOADMIN, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_CREACIONDIRECCIONADMIN, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(56, 56, 56))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                        .addComponent(REGISTRAR)
                        .addGap(345, 345, 345))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                        .addComponent(TIPO_CUENTA, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(237, 237, 237))))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel39)
                            .addComponent(txt_CREACIONNOMBREADMIN, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel43)
                            .addComponent(txt_CREACIONDIRECCIONADMIN, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_CREACIONDIRECCIONADMIN1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(txt_CREACIONAPELLIDOADMIN, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel45)
                            .addComponent(txt_CREACIONTELEFONOADMIN, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_CREACIONTELEFONOADMIN1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel40)
                            .addComponent(txt_CREACIONUSUARIOADMIN, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel44)
                            .addComponent(txt_CREACIONCORREOADMIN, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(jLabel41))
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_CREACIONCORREOADMIN1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel24))
                                .addGap(25, 25, 25)
                                .addComponent(txt_CREACIONCONTRASEÑAADMIN, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(28, 28, 28))
                    .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TIPO_CUENTA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel56)))
                .addGap(15, 15, 15)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_CREACIONCONTRASEÑA2ADMIN, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addComponent(REGISTRAR)
                .addGap(68, 68, 68))
        );

        Panelpestaña.addTab("CREACION DE USUARIOS", jPanel22);

        jPanel23.setBackground(new java.awt.Color(0, 153, 153));
        jPanel23.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel23.setEnabled(false);

        txt_BUSCARADMINISTRADOR.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N
        txt_BUSCARADMINISTRADOR.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N

        TablaDatosAdministrador.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N
        TablaDatosAdministrador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(TablaDatosAdministrador);

        jLabel10.setFont(new java.awt.Font("Castellar", 0, 24)); // NOI18N
        jLabel10.setText("RESULTADOS");

        CONSULTAR.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N
        CONSULTAR.setText("BUSCAR");
        CONSULTAR.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CONSULTAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CONSULTARActionPerformed(evt);
            }
        });

        jCOMBO_BUSCARADMIN2.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N
        jCOMBO_BUSCARADMIN2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...", "USUARIO", "NOMBRE", "APELLIDO" }));
        jCOMBO_BUSCARADMIN2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCOMBO_BUSCARADMIN2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCOMBO_BUSCARADMIN2ActionPerformed(evt);
            }
        });

        jCOMBO_BUSCARADMIN1.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N
        jCOMBO_BUSCARADMIN1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...", "PROFESOR", "ESTUDIANTE" }));
        jCOMBO_BUSCARADMIN1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_BUSCARADMINISTRADOR, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCOMBO_BUSCARADMIN1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCOMBO_BUSCARADMIN2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(360, 360, 360)
                        .addComponent(CONSULTAR))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(313, 313, 313)
                        .addComponent(jLabel10))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 729, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jCOMBO_BUSCARADMIN1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCOMBO_BUSCARADMIN2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addComponent(txt_BUSCARADMINISTRADOR, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(CONSULTAR)))))
                .addGap(47, 47, 47)
                .addComponent(jLabel10)
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(95, Short.MAX_VALUE))
        );

        Panelpestaña.addTab("CONSULTA USUARIOS", jPanel23);

        jPanel21.add(Panelpestaña, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 660));

        Administrador.getContentPane().add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 910, 640));

        jPanel17.setBackground(new java.awt.Color(0, 153, 153));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel32.setFont(new java.awt.Font("Castellar", 0, 48)); // NOI18N
        jLabel32.setText("EDUFUTUME");
        jLabel32.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel17.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, -1, -1));

        Minimizar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_Expand_Arrow_32px.png"))); // NOI18N
        Minimizar4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Minimizar4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Minimizar4MouseClicked(evt);
            }
        });
        jPanel17.add(Minimizar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 0, -1, 30));

        jLabel91.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_Multiply_32px.png"))); // NOI18N
        jLabel91.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel91.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel91MouseClicked(evt);
            }
        });
        jPanel17.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 0, 40, 30));

        Administrador.getContentPane().add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, -1));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/administrador (2).png"))); // NOI18N
        jPanel8.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 130, 130));

        jButton2.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N
        jButton2.setText("CERRAR SESIÓN");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 540, -1, -1));

        jButton4.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N
        jButton4.setText("CONSULTA DE USUARIOS");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 210, 40));

        jButton5.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N
        jButton5.setText("CREACION USUARIOS");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 210, 40));

        jButton7.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N
        jButton7.setText("MODIFICACION DE USUARIO");
        jButton7.setBorder(null);
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 210, 40));

        jLabel36.setFont(new java.awt.Font("Castellar", 0, 14)); // NOI18N
        jLabel36.setText("BIENVENID@  ********");
        jPanel8.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 190, -1));

        jLabel48.setFont(new java.awt.Font("Castellar", 0, 18)); // NOI18N
        jLabel48.setText("ADMINISTRADOR");
        jPanel8.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        Administrador.getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 270, 640));

        ingadmin.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        ingadmin.setMinimumSize(new java.awt.Dimension(1090, 700));
        ingadmin.setUndecorated(true);
        ingadmin.setSize(new java.awt.Dimension(1090, 700));
        ingadmin.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Castellar", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 153, 153));
        jLabel26.setText("Contraseña:");
        jPanel10.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 400, -1, -1));

        jLabel28.setFont(new java.awt.Font("Castellar", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 153, 153));
        jLabel28.setText("Usuario:");
        jPanel10.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 250, -1, -1));

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Administrador off.jpg"))); // NOI18N
        jPanel10.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 120, -1, 120));

        txt_USER_ADMINISTRADOR.setFont(new java.awt.Font("Castellar", 0, 18)); // NOI18N
        txt_USER_ADMINISTRADOR.setForeground(new java.awt.Color(153, 153, 153));
        txt_USER_ADMINISTRADOR.setText("User");
        txt_USER_ADMINISTRADOR.setBorder(null);
        txt_USER_ADMINISTRADOR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_USER_ADMINISTRADORMouseClicked(evt);
            }
        });
        txt_USER_ADMINISTRADOR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_USER_ADMINISTRADORActionPerformed(evt);
            }
        });
        txt_USER_ADMINISTRADOR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_USER_ADMINISTRADORKeyTyped(evt);
            }
        });
        jPanel10.add(txt_USER_ADMINISTRADOR, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 310, 220, 20));
        jPanel10.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 460, 220, 21));
        jPanel10.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 330, 220, 20));

        txt_CONTRASEÑA_ADMINISTRADOR.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_CONTRASEÑA_ADMINISTRADOR.setForeground(new java.awt.Color(153, 153, 153));
        txt_CONTRASEÑA_ADMINISTRADOR.setText("contraseña");
        txt_CONTRASEÑA_ADMINISTRADOR.setBorder(null);
        txt_CONTRASEÑA_ADMINISTRADOR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_CONTRASEÑA_ADMINISTRADORMouseClicked(evt);
            }
        });
        txt_CONTRASEÑA_ADMINISTRADOR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CONTRASEÑA_ADMINISTRADORActionPerformed(evt);
            }
        });
        txt_CONTRASEÑA_ADMINISTRADOR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_CONTRASEÑA_ADMINISTRADORKeyTyped(evt);
            }
        });
        jPanel10.add(txt_CONTRASEÑA_ADMINISTRADOR, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 440, 220, 20));

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/password.png"))); // NOI18N
        jPanel10.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 440, 30, 30));

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/descarga (1) (1).jpg"))); // NOI18N
        jPanel10.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 300, -1, -1));

        Inicio2.setFont(new java.awt.Font("Dubai Light", 1, 18)); // NOI18N
        Inicio2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Boton avanzar  (2) (2).png"))); // NOI18N
        Inicio2.setBorder(null);
        Inicio2.setBorderPainted(false);
        Inicio2.setContentAreaFilled(false);
        Inicio2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Inicio2.setFocusPainted(false);
        Inicio2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Boton avanzar  (2) (3).png"))); // NOI18N
        Inicio2.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Boton avanzar  (2) (3).png"))); // NOI18N
        Inicio2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Inicio2ActionPerformed(evt);
            }
        });
        jPanel10.add(Inicio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 560, 62, -1));

        jPanel12.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel10.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, -1, -1));

        jPanel14.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel10.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 80, 710));

        jPanel18.setBackground(new java.awt.Color(0, 204, 204));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel10.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 750));

        jLabel42.setBackground(new java.awt.Color(0, 0, 0));
        jLabel42.setFont(new java.awt.Font("Castellar", 0, 24)); // NOI18N
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("INGRESO ADMINISTRADOR");
        jPanel10.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, 400, 37));

        jButton8.setBackground(new java.awt.Color(255, 255, 255));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/enter (2) (1).jpg"))); // NOI18N
        jButton8.setBorder(null);
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.setFocusPainted(false);
        jButton8.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/enter on (1).jpg"))); // NOI18N
        jButton8.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/enter on (1).jpg"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, -1));

        Minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_Expand_Arrow_32px.png"))); // NOI18N
        Minimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Minimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MinimizarMouseClicked(evt);
            }
        });
        jPanel10.add(Minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 10, -1, 30));

        jLabel88.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_Multiply_32px.png"))); // NOI18N
        jLabel88.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel88.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel88MouseClicked(evt);
            }
        });
        jPanel10.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 10, 40, 30));

        ingadmin.getContentPane().add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 710));

        profesor2.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        profesor2.setUndecorated(true);
        profesor2.setSize(new java.awt.Dimension(1090, 690));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel19.setBackground(new java.awt.Color(0, 204, 204));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel13.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 1090, 30));

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane1.setBackground(new java.awt.Color(204, 204, 204));
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTabbedPane1.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N

        jPanel28.setBackground(new java.awt.Color(255, 255, 255));
        jPanel28.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N

        jLabel51.setFont(new java.awt.Font("Castellar", 0, 24)); // NOI18N
        jLabel51.setText("RESULTADOS");

        txt_BUSCARESTUDIANTEPROFESOR.setFont(new java.awt.Font("Castellar", 0, 14)); // NOI18N

        TablaDatosProfesor.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N
        TablaDatosProfesor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(TablaDatosProfesor);

        BUSCARDATOS.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        BUSCARDATOS.setText("BUSCAR");
        BUSCARDATOS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BUSCARDATOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUSCARDATOSActionPerformed(evt);
            }
        });

        cbox_CONSULTAPROFESOR.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N
        cbox_CONSULTAPROFESOR.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...", "USUARIO", "NOMBRE", "APELLIDO" }));
        cbox_CONSULTAPROFESOR.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 774, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(144, 144, 144))
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGap(483, 483, 483)
                        .addComponent(BUSCARDATOS))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGap(450, 450, 450)
                        .addComponent(jLabel51))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(jLabel50)
                        .addGap(33, 33, 33)
                        .addComponent(txt_BUSCARESTUDIANTEPROFESOR, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(cbox_CONSULTAPROFESOR, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel50)
                    .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_BUSCARESTUDIANTEPROFESOR, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbox_CONSULTAPROFESOR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addComponent(BUSCARDATOS)
                .addGap(27, 27, 27)
                .addComponent(jLabel51)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("CONSULTA ESTUDIANTE", jPanel28);

        jPanel30.setBackground(new java.awt.Color(255, 255, 255));
        jPanel30.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N

        jLabel62.setFont(new java.awt.Font("Castellar", 0, 24)); // NOI18N
        jLabel62.setText("RESULTADOS");

        txt_BUSCARCONTENIDO.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N
        txt_BUSCARCONTENIDO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_BUSCARCONTENIDOActionPerformed(evt);
            }
        });

        TablaDatosContenidoProfesor.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N
        TablaDatosContenidoProfesor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(TablaDatosContenidoProfesor);

        btn_BUSCARCONTENIDO.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        btn_BUSCARCONTENIDO.setText("BUSCAR");
        btn_BUSCARCONTENIDO.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_BUSCARCONTENIDO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BUSCARCONTENIDOActionPerformed(evt);
            }
        });

        cbox_CONSULTACONTENIDO.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N
        cbox_CONSULTACONTENIDO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "..." }));
        cbox_CONSULTACONTENIDO.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        BTN_ELIMINAR.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        BTN_ELIMINAR.setText("ELIMINAR CONTENIDO");
        BTN_ELIMINAR.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_ELIMINAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_ELIMINARActionPerformed(evt);
            }
        });

        jLabel87.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cerrar.png"))); // NOI18N

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGap(217, 217, 217)
                        .addComponent(jLabel61)
                        .addGap(18, 18, 18)
                        .addComponent(txt_BUSCARCONTENIDO, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(cbox_CONSULTACONTENIDO, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGap(422, 422, 422)
                        .addComponent(jLabel87)
                        .addGap(18, 18, 18)
                        .addComponent(BTN_ELIMINAR)))
                .addContainerGap(114, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
                        .addComponent(btn_BUSCARCONTENIDO)
                        .addGap(494, 494, 494))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(133, 133, 133))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
                        .addComponent(jLabel62)
                        .addGap(443, 443, 443))))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_BUSCARCONTENIDO, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbox_CONSULTACONTENIDO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel61))
                .addGap(18, 18, 18)
                .addComponent(btn_BUSCARCONTENIDO)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel62)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                .addGap(24, 24, 24)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BTN_ELIMINAR)
                    .addComponent(jLabel87))
                .addGap(48, 48, 48))
        );

        jTabbedPane1.addTab("CONSULTA CONTENIDO", jPanel30);

        jPanel31.setBackground(new java.awt.Color(255, 255, 255));
        jPanel31.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        cbox_CURSO.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        cbox_CURSO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONAR", "MATEMATICA", "LECTURA CRITICA", "INGLES", "COMPETENCIAS CIUDADANAS", "BIOLOGÍA" }));
        cbox_CURSO.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btn_INGRESARCURSO.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        btn_INGRESARCURSO.setText("AGREGAR CURSO");
        btn_INGRESARCURSO.setBorderPainted(false);
        btn_INGRESARCURSO.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_INGRESARCURSO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_INGRESARCURSOActionPerformed(evt);
            }
        });

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/leer.png"))); // NOI18N

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lapiz.png"))); // NOI18N

        jLabel54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/anadir.png"))); // NOI18N

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel25)
                    .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel31Layout.createSequentialGroup()
                            .addGap(344, 344, 344)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cbox_CURSO, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel31Layout.createSequentialGroup()
                            .addGap(394, 394, 394)
                            .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btn_INGRESARCURSO))))
                .addContainerGap(439, Short.MAX_VALUE))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(cbox_CURSO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_INGRESARCURSO, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel54, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
        );

        jTabbedPane1.addTab("INGRESAR CURSO", jPanel31);

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));
        jPanel26.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel52.setFont(new java.awt.Font("Castellar", 1, 18)); // NOI18N
        jLabel52.setText("NOMBRE:");

        txt_NOMBRECONTENIDO.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N
        txt_NOMBRECONTENIDO.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_NOMBRECONTENIDO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NOMBRECONTENIDOActionPerformed(evt);
            }
        });

        jLabel53.setFont(new java.awt.Font("Castellar", 0, 24)); // NOI18N
        jLabel53.setText("MONTAR MATERIAL AUDIO-VISUAL");

        jLabel55.setFont(new java.awt.Font("Castellar", 1, 18)); // NOI18N
        jLabel55.setText("DESCRIPCIÓN");

        txt_DESCRIPCION.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N
        txt_DESCRIPCION.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        btn_ACTUALIZARCURSO.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        btn_ACTUALIZARCURSO.setText("ACTUALIZAR");
        btn_ACTUALIZARCURSO.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ACTUALIZARCURSO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ACTUALIZARCURSOActionPerformed(evt);
            }
        });

        cbox_CURSOMONTAR.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N
        cbox_CURSOMONTAR.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "..." }));
        cbox_CURSOMONTAR.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txt_LINK.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N
        txt_LINK.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabel66.setFont(new java.awt.Font("Castellar", 1, 18)); // NOI18N
        jLabel66.setText("LINK VIDEO");

        jLabel92.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/camara-de-video.png"))); // NOI18N

        jLabel93.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/actualizar-base-de-datos.png"))); // NOI18N

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap(143, Short.MAX_VALUE)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                        .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_ACTUALIZARCURSO)
                        .addGap(461, 461, 461))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                        .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel53)
                        .addGap(268, 268, 268))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel55)
                            .addComponent(jLabel66)
                            .addComponent(jLabel52))
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_LINK, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel26Layout.createSequentialGroup()
                                        .addComponent(txt_NOMBRECONTENIDO, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(37, 37, 37)
                                        .addComponent(cbox_CURSOMONTAR, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txt_DESCRIPCION, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(61, 61, 61))))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel53)
                    .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_NOMBRECONTENIDO, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel52)
                    .addComponent(cbox_CURSOMONTAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_LINK, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel66))
                .addGap(50, 50, 50)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_DESCRIPCION, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel55))
                .addGap(26, 26, 26)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_ACTUALIZARCURSO)
                    .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53))
        );

        jTabbedPane1.addTab("ACTUALIZACION CURSOS", jPanel26);

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));
        jPanel27.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel68.setFont(new java.awt.Font("Castellar", 0, 24)); // NOI18N
        jLabel68.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel68.setText("MODIFICACIÓN USUARIOS");

        jLabel69.setFont(new java.awt.Font("Castellar", 1, 14)); // NOI18N
        jLabel69.setText("CONTRASEÑA ANTIGUA:");

        txt_ContraseñaNueva2.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N
        txt_ContraseñaNueva2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_ContraseñaNueva2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ContraseñaNueva2ActionPerformed(evt);
            }
        });

        jLabel70.setFont(new java.awt.Font("Castellar", 1, 14)); // NOI18N
        jLabel70.setText("CONTRASEÑA NUEVA:");

        txt_ContraseñaAntigua.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N
        txt_ContraseñaAntigua.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        btnActualizar.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.setContentAreaFilled(false);
        btnActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        jLabel72.setFont(new java.awt.Font("Castellar", 1, 14)); // NOI18N
        jLabel72.setText("CONTRASEÑA NUEVA:");

        txt_ContraseñaNueva1.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N
        txt_ContraseñaNueva1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabel94.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/actualizar-base-de-datos.png"))); // NOI18N

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(243, 243, 243)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel69, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel72, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel70, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(68, 68, 68)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_ContraseñaAntigua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ContraseñaNueva1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ContraseñaNueva2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                .addContainerGap(351, Short.MAX_VALUE)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                        .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(317, 317, 317))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                        .addComponent(jLabel94, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnActualizar)
                        .addGap(475, 475, 475))))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_ContraseñaAntigua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel69))
                .addGap(74, 74, 74)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_ContraseñaNueva1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel72))
                .addGap(71, 71, 71)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel70)
                    .addComponent(txt_ContraseñaNueva2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel94, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67))
        );

        jTabbedPane1.addTab("MODIFICACION USUARIO", jPanel27);

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel13.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 1090, 520));

        jPanel15.setBackground(new java.awt.Color(0, 153, 153));

        jLabel13.setFont(new java.awt.Font("Castellar", 1, 18)); // NOI18N
        jLabel13.setText("BIENVENIDO **********");

        jLabel34.setBackground(new java.awt.Color(0, 153, 153));
        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/profesor.png"))); // NOI18N

        jLabel49.setFont(new java.awt.Font("Castellar", 1, 48)); // NOI18N
        jLabel49.setText("EDUFUTUME");
        jLabel49.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jButton10.setFont(new java.awt.Font("Castellar", 1, 14)); // NOI18N
        jButton10.setText("CERRAR SESIÓN");
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        Minimizar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_Expand_Arrow_32px.png"))); // NOI18N
        Minimizar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Minimizar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Minimizar2MouseClicked(evt);
            }
        });

        jLabel90.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_Multiply_32px.png"))); // NOI18N
        jLabel90.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel90.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel90MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel33)
                .addContainerGap(1023, Short.MAX_VALUE))
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105)
                .addComponent(jButton10)
                .addGap(55, 55, 55))
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Minimizar2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel90)
                .addGap(25, 25, 25))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Minimizar2)
                            .addComponent(jLabel90))
                        .addGap(18, 18, 18)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel49)))))
                .addGap(81, 81, 81)
                .addComponent(jLabel33)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel13.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 140));

        javax.swing.GroupLayout profesor2Layout = new javax.swing.GroupLayout(profesor2.getContentPane());
        profesor2.getContentPane().setLayout(profesor2Layout);
        profesor2Layout.setHorizontalGroup(
            profesor2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        profesor2Layout.setVerticalGroup(
            profesor2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Registro_profesor.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        Registro_profesor.setMinimumSize(null);
        Registro_profesor.setUndecorated(true);

        jPanel32.setBackground(new java.awt.Color(255, 255, 255));
        jPanel32.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, new java.awt.Color(204, 204, 204)));

        jLabel75.setFont(new java.awt.Font("Castellar", 1, 14)); // NOI18N
        jLabel75.setText("APELLIDOS:");

        jLabel76.setFont(new java.awt.Font("Castellar", 1, 14)); // NOI18N
        jLabel76.setText("NOMBRE(S):");

        jLabel77.setFont(new java.awt.Font("Castellar", 1, 14)); // NOI18N
        jLabel77.setText("USUARIO:");

        jLabel78.setFont(new java.awt.Font("Castellar", 1, 14)); // NOI18N
        jLabel78.setText("CONTRASEÑA:");

        jLabel79.setFont(new java.awt.Font("Castellar", 1, 14)); // NOI18N
        jLabel79.setText("DIRECCIÓN:");

        jLabel80.setFont(new java.awt.Font("Castellar", 1, 14)); // NOI18N
        jLabel80.setText("CORREO:");

        txt_CORREOREGISTRO1.setBackground(new java.awt.Color(204, 204, 204));
        txt_CORREOREGISTRO1.setFont(new java.awt.Font("Castellar", 1, 14)); // NOI18N
        txt_CORREOREGISTRO1.setBorder(null);
        txt_CORREOREGISTRO1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_CORREOREGISTRO1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_CORREOREGISTRO1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_CORREOREGISTRO1MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_CORREOREGISTRO1MousePressed(evt);
            }
        });
        txt_CORREOREGISTRO1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CORREOREGISTRO1ActionPerformed(evt);
            }
        });

        jLabel81.setFont(new java.awt.Font("Castellar", 1, 14)); // NOI18N
        jLabel81.setText("TELÉFONO:");

        jLabel82.setFont(new java.awt.Font("Castellar", 1, 18)); // NOI18N
        jLabel82.setText("REGISTRARSE");
        jLabel82.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel82.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel82MouseClicked(evt);
            }
        });

        jLabel83.setFont(new java.awt.Font("Castellar", 1, 24)); // NOI18N
        jLabel83.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel83.setText("REGISTRO");

        jLabel84.setFont(new java.awt.Font("Castellar", 1, 14)); // NOI18N
        jLabel84.setText("CORREO:");

        txt_CORREOREGISTRO2.setBackground(new java.awt.Color(204, 204, 204));
        txt_CORREOREGISTRO2.setFont(new java.awt.Font("Castellar", 1, 14)); // NOI18N
        txt_CORREOREGISTRO2.setBorder(null);
        txt_CORREOREGISTRO2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_CORREOREGISTRO2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_CORREOREGISTRO2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_CORREOREGISTRO2MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_CORREOREGISTRO2MousePressed(evt);
            }
        });
        txt_CORREOREGISTRO2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CORREOREGISTRO2ActionPerformed(evt);
            }
        });

        txt_TELEFONOREGISTRO1.setBackground(new java.awt.Color(204, 204, 204));
        txt_TELEFONOREGISTRO1.setFont(new java.awt.Font("Castellar", 1, 14)); // NOI18N
        txt_TELEFONOREGISTRO1.setBorder(null);
        txt_TELEFONOREGISTRO1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_TELEFONOREGISTRO1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_TELEFONOREGISTRO1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_TELEFONOREGISTRO1MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_TELEFONOREGISTRO1MousePressed(evt);
            }
        });
        txt_TELEFONOREGISTRO1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_TELEFONOREGISTRO1ActionPerformed(evt);
            }
        });
        txt_TELEFONOREGISTRO1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_TELEFONOREGISTRO1KeyTyped(evt);
            }
        });

        jLabel85.setFont(new java.awt.Font("Castellar", 1, 14)); // NOI18N
        jLabel85.setText("TELÉFONO:");

        txt_TELEFONOREGISTRO2.setBackground(new java.awt.Color(204, 204, 204));
        txt_TELEFONOREGISTRO2.setFont(new java.awt.Font("Castellar", 1, 14)); // NOI18N
        txt_TELEFONOREGISTRO2.setBorder(null);
        txt_TELEFONOREGISTRO2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_TELEFONOREGISTRO2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_TELEFONOREGISTRO2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_TELEFONOREGISTRO2MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_TELEFONOREGISTRO2MousePressed(evt);
            }
        });
        txt_TELEFONOREGISTRO2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_TELEFONOREGISTRO2ActionPerformed(evt);
            }
        });
        txt_TELEFONOREGISTRO2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_TELEFONOREGISTRO2KeyTyped(evt);
            }
        });

        txt_DIRECCIONREGISTRO1.setBackground(new java.awt.Color(204, 204, 204));
        txt_DIRECCIONREGISTRO1.setFont(new java.awt.Font("Castellar", 1, 14)); // NOI18N
        txt_DIRECCIONREGISTRO1.setBorder(null);
        txt_DIRECCIONREGISTRO1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_DIRECCIONREGISTRO1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_DIRECCIONREGISTRO1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_DIRECCIONREGISTRO1MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_DIRECCIONREGISTRO1MousePressed(evt);
            }
        });
        txt_DIRECCIONREGISTRO1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_DIRECCIONREGISTRO1ActionPerformed(evt);
            }
        });

        jLabel86.setFont(new java.awt.Font("Castellar", 1, 14)); // NOI18N
        jLabel86.setText("DIRECCIÓN:");

        txt_DIRECCIONREGISTRO2.setBackground(new java.awt.Color(204, 204, 204));
        txt_DIRECCIONREGISTRO2.setFont(new java.awt.Font("Castellar", 1, 14)); // NOI18N
        txt_DIRECCIONREGISTRO2.setBorder(null);
        txt_DIRECCIONREGISTRO2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_DIRECCIONREGISTRO2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_DIRECCIONREGISTRO2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_DIRECCIONREGISTRO2MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_DIRECCIONREGISTRO2MousePressed(evt);
            }
        });
        txt_DIRECCIONREGISTRO2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_DIRECCIONREGISTRO2ActionPerformed(evt);
            }
        });

        txt_APELLIDOSREGISTRO.setBackground(new java.awt.Color(204, 204, 204));
        txt_APELLIDOSREGISTRO.setFont(new java.awt.Font("Castellar", 1, 14)); // NOI18N
        txt_APELLIDOSREGISTRO.setBorder(null);
        txt_APELLIDOSREGISTRO.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_APELLIDOSREGISTRO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_APELLIDOSREGISTROMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_APELLIDOSREGISTROMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_APELLIDOSREGISTROMousePressed(evt);
            }
        });
        txt_APELLIDOSREGISTRO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_APELLIDOSREGISTROActionPerformed(evt);
            }
        });

        txt_CONTRASEÑAREGISTRO1.setBackground(new java.awt.Color(204, 204, 204));
        txt_CONTRASEÑAREGISTRO1.setFont(new java.awt.Font("Castellar", 1, 14)); // NOI18N
        txt_CONTRASEÑAREGISTRO1.setBorder(null);
        txt_CONTRASEÑAREGISTRO1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_CONTRASEÑAREGISTRO1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_CONTRASEÑAREGISTRO1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_CONTRASEÑAREGISTRO1MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_CONTRASEÑAREGISTRO1MousePressed(evt);
            }
        });
        txt_CONTRASEÑAREGISTRO1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CONTRASEÑAREGISTRO1ActionPerformed(evt);
            }
        });
        txt_CONTRASEÑAREGISTRO1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_CONTRASEÑAREGISTRO1KeyTyped(evt);
            }
        });

        txt_USUARIOREGISTRO.setBackground(new java.awt.Color(204, 204, 204));
        txt_USUARIOREGISTRO.setFont(new java.awt.Font("Castellar", 1, 14)); // NOI18N
        txt_USUARIOREGISTRO.setBorder(null);
        txt_USUARIOREGISTRO.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_USUARIOREGISTRO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_USUARIOREGISTROMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_USUARIOREGISTROMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_USUARIOREGISTROMousePressed(evt);
            }
        });
        txt_USUARIOREGISTRO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_USUARIOREGISTROActionPerformed(evt);
            }
        });
        txt_USUARIOREGISTRO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_USUARIOREGISTROKeyTyped(evt);
            }
        });

        txt_NOMBREREGISTRO.setBackground(new java.awt.Color(204, 204, 204));
        txt_NOMBREREGISTRO.setFont(new java.awt.Font("Castellar", 1, 14)); // NOI18N
        txt_NOMBREREGISTRO.setBorder(null);
        txt_NOMBREREGISTRO.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_NOMBREREGISTRO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_NOMBREREGISTROMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_NOMBREREGISTROMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_NOMBREREGISTROMousePressed(evt);
            }
        });
        txt_NOMBREREGISTRO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NOMBREREGISTROActionPerformed(evt);
            }
        });

        txt_CONTRASEÑAREGISTRO2.setBackground(new java.awt.Color(204, 204, 204));
        txt_CONTRASEÑAREGISTRO2.setFont(new java.awt.Font("Castellar", 1, 14)); // NOI18N
        txt_CONTRASEÑAREGISTRO2.setBorder(null);
        txt_CONTRASEÑAREGISTRO2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_CONTRASEÑAREGISTRO2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_CONTRASEÑAREGISTRO2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_CONTRASEÑAREGISTRO2MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_CONTRASEÑAREGISTRO2MousePressed(evt);
            }
        });
        txt_CONTRASEÑAREGISTRO2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CONTRASEÑAREGISTRO2ActionPerformed(evt);
            }
        });
        txt_CONTRASEÑAREGISTRO2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_CONTRASEÑAREGISTRO2KeyTyped(evt);
            }
        });

        Minimizar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_Expand_Arrow_32px.png"))); // NOI18N
        Minimizar3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Minimizar3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Minimizar3MouseClicked(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_Multiply_32px.png"))); // NOI18N
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jLabel95.setFont(new java.awt.Font("Castellar", 1, 14)); // NOI18N
        jLabel95.setText("OPCIONAL");

        jLabel96.setFont(new java.awt.Font("Castellar", 1, 14)); // NOI18N
        jLabel96.setText("OPCIONAL");

        jLabel97.setFont(new java.awt.Font("Castellar", 1, 14)); // NOI18N
        jLabel97.setText("OPCIONAL");

        jLabel98.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/registrado.png"))); // NOI18N

        jLabel99.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/actualizar-base-de-datos.png"))); // NOI18N

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel76, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel81, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel80, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel77, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel86, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6))
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_CORREOREGISTRO1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel32Layout.createSequentialGroup()
                                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txt_USUARIOREGISTRO, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_NOMBREREGISTRO, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_DIRECCIONREGISTRO1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_TELEFONOREGISTRO1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel32Layout.createSequentialGroup()
                                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel32Layout.createSequentialGroup()
                                                .addGap(235, 235, 235)
                                                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel32Layout.createSequentialGroup()
                                                        .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(txt_APELLIDOSREGISTRO, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel32Layout.createSequentialGroup()
                                                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(jLabel78, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                                            .addComponent(jLabel79, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(txt_CONTRASEÑAREGISTRO1, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                                                            .addComponent(txt_DIRECCIONREGISTRO2, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                                                            .addComponent(txt_TELEFONOREGISTRO2, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                                                            .addComponent(txt_CORREOREGISTRO2, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                                                            .addComponent(txt_CONTRASEÑAREGISTRO2, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)))
                                                    .addComponent(jLabel95)))
                                            .addGroup(jPanel32Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 589, Short.MAX_VALUE)
                                                .addComponent(Minimizar3)))
                                        .addGap(62, 62, 62))
                                    .addGroup(jPanel32Layout.createSequentialGroup()
                                        .addGap(240, 240, 240)
                                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel97)
                                            .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 349, Short.MAX_VALUE))))))
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel32Layout.createSequentialGroup()
                                .addGap(498, 498, 498)
                                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel96)))
                            .addGroup(jPanel32Layout.createSequentialGroup()
                                .addGap(273, 273, 273)
                                .addComponent(jLabel99)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel82))
                            .addGroup(jPanel32Layout.createSequentialGroup()
                                .addGap(270, 270, 270)
                                .addComponent(jLabel98)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 352, Short.MAX_VALUE))))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Minimizar3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel98)))
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel76)
                    .addComponent(txt_NOMBREREGISTRO, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel75)
                    .addComponent(txt_APELLIDOSREGISTRO, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel77)
                    .addComponent(txt_USUARIOREGISTRO, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel78)
                    .addComponent(txt_CONTRASEÑAREGISTRO1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_CONTRASEÑAREGISTRO2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel86)
                    .addComponent(txt_DIRECCIONREGISTRO1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel79)
                    .addComponent(txt_DIRECCIONREGISTRO2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel95)
                .addGap(54, 54, 54)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel81)
                    .addComponent(txt_TELEFONOREGISTRO1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel85)
                    .addComponent(txt_TELEFONOREGISTRO2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(jLabel96)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel84)
                            .addComponent(txt_CORREOREGISTRO2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel97)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel32Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel99))
                            .addGroup(jPanel32Layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_CORREOREGISTRO1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel80))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                                .addComponent(jLabel82)))
                        .addGap(57, 57, 57))))
        );

        javax.swing.GroupLayout Registro_profesorLayout = new javax.swing.GroupLayout(Registro_profesor.getContentPane());
        Registro_profesor.getContentPane().setLayout(Registro_profesorLayout);
        Registro_profesorLayout.setHorizontalGroup(
            Registro_profesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Registro_profesorLayout.setVerticalGroup(
            Registro_profesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(1090, 700));

        jPanel5.setBackground(new java.awt.Color(0, 204, 204));
        jPanel5.setMaximumSize(null);
        jPanel5.setPreferredSize(new java.awt.Dimension(1090, 700));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        titulo.setBackground(new java.awt.Color(255, 255, 255));
        titulo.setFont(new java.awt.Font("Castellar", 1, 36)); // NOI18N
        titulo.setForeground(new java.awt.Color(0, 153, 153));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("INGRESO");

        Estudiante.setBackground(new java.awt.Color(255, 255, 255));
        Estudiante.setForeground(new java.awt.Color(255, 255, 255));
        Estudiante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/estudiante off.jpg"))); // NOI18N
        Estudiante.setBorder(null);
        Estudiante.setBorderPainted(false);
        Estudiante.setContentAreaFilled(false);
        Estudiante.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Estudiante.setFocusPainted(false);
        Estudiante.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/estudiante (5).jpg"))); // NOI18N
        Estudiante.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/estudiante (5).jpg"))); // NOI18N
        Estudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EstudianteActionPerformed(evt);
            }
        });

        ADMI.setBackground(new java.awt.Color(255, 255, 255));
        ADMI.setForeground(new java.awt.Color(255, 255, 255));
        ADMI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Administrador off.jpg"))); // NOI18N
        ADMI.setBorder(null);
        ADMI.setBorderPainted(false);
        ADMI.setContentAreaFilled(false);
        ADMI.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ADMI.setFocusPainted(false);
        ADMI.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/administrador (1).png"))); // NOI18N
        ADMI.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/administrador (1).png"))); // NOI18N
        ADMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADMIActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Castellar", 0, 14)); // NOI18N
        jLabel1.setText("ADMINISTRADORES");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_Expand_Arrow_32px.png"))); // NOI18N
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_Multiply_32px.png"))); // NOI18N
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LOGO EDU.png"))); // NOI18N

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imagen profesor of (1).jpg"))); // NOI18N
        jButton6.setBorder(null);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.setFocusPainted(false);
        jButton6.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ICONO PROFESOR (1) (1) (1).jpg"))); // NOI18N
        jButton6.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ICONO PROFESOR (1) (1) (1).jpg"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Castellar", 0, 14)); // NOI18N
        jLabel11.setText("PROFESORES ");

        jLabel19.setFont(new java.awt.Font("Castellar", 0, 14)); // NOI18N
        jLabel19.setText("ESTUDIANTES");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(42, 42, 42))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ADMI, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(173, 173, 173)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(180, 180, 180)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(137, 137, 137)
                                .addComponent(Estudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)))))
                .addGap(0, 115, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(399, 399, 399)
                .addComponent(titulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(258, 258, 258))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(titulo)
                .addGap(86, 86, 86)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(ADMI, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(Estudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel11)
                    .addComponent(jLabel19))
                .addContainerGap(96, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        this.setState(Seleccion.ICONIFIED);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        int dialog = JOptionPane.YES_NO_OPTION;
        int results = JOptionPane.showConfirmDialog(null, "¿Desea salir?", "Exit", dialog);
        if (results == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_jLabel5MouseClicked

    private void ADMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADMIActionPerformed
        // TODO add your handling code here:
        ingadmin.show(true);
        this.show(false);
    }//GEN-LAST:event_ADMIActionPerformed

    private void EstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EstudianteActionPerformed
        // TODO add your handling code here:
        Ingreso ing = new Ingreso();
        ing.show(true);
        this.setVisible(false);

    }//GEN-LAST:event_EstudianteActionPerformed
    int x = 0;
    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        txt_NOMBREREGISTRO.requestFocus();
        Registro_profesor.show(true);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void txt_CONTRASEÑAPROFESORActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CONTRASEÑAPROFESORActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CONTRASEÑAPROFESORActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Seleccion se = new Seleccion();
        se.show(true);
        profesor.show(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Inicio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Inicio1ActionPerformed
        // TODO add your handling code here:
        int a = 0;
        String cad = "";
        if (txt_USERPROFESOR.getText().equals("")) {
            cad = "Campo 'Usuario' vacío.\n";
            a++;
        }
        if (txt_CONTRASEÑAPROFESOR.getText().equals("")) {
            cad += "Campo 'Contraseña' vacío.";
            a++;
        }
        if (a == 0) {
            int contraseña = MetodosSQL.ConsultaUser(Integer.parseInt(txt_USERPROFESOR.getText()), "CUENTA-PROFESOR", "PROFESOR");
            ResultSet Consulta;
            PreparedStatement Comando;
            if (Integer.parseInt(txt_CONTRASEÑAPROFESOR.getText()) == (contraseña)) {
                jLabel13.setText("BIENVENID@ " + txt_USERPROFESOR.getText());
                Userglob = Integer.parseInt(txt_USERPROFESOR.getText());
                Comando = MetodosSQL.BuscarCursoUser(Userglob, "PROFESOR");
                try {
                    Consulta = Comando.executeQuery();
                    while (Consulta.next()) {
                        cbox_CURSOMONTAR.addItem(Consulta.getString("NOMBRE_CURSO"));
                        cbox_CONSULTACONTENIDO.addItem(Consulta.getString("NOMBRE_CURSO"));
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
                profesor.show(false);
                profesor2.show(true);
                Limpiar_Profesor();
            } else {
                JOptionPane.showMessageDialog(null, "USUARIO O CONTRASEÑA INCORRECTA.");
            }
        } else {
            JOptionPane.showMessageDialog(null, cad);
        }


    }//GEN-LAST:event_Inicio1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        profesor.show(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void txt_CONTRASEÑA_ADMINISTRADORActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CONTRASEÑA_ADMINISTRADORActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CONTRASEÑA_ADMINISTRADORActionPerformed

    private void Inicio2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Inicio2ActionPerformed
        // TODO add your handling code here:      
        int a = 0;
        String cad = "";
        if (txt_USER_ADMINISTRADOR.getText().equals("")) {
            cad = "Campo 'Usuario' vacío.\n";
            a++;
        }
        if (txt_CONTRASEÑA_ADMINISTRADOR.getText().equals("")) {
            cad += "Campo 'Contraseña' vacío.";
            a++;
        }
        if (a == 0) {
            int contraseña = MetodosSQL.ConsultaUser(Integer.parseInt(txt_USER_ADMINISTRADOR.getText()), "ADMINISTRADOR", "ADMINISTRADOR");
            if (Integer.parseInt(txt_CONTRASEÑA_ADMINISTRADOR.getText()) == (contraseña)) {
                jLabel36.setText("BIENVENID@ " + txt_USER_ADMINISTRADOR.getText());
                LimpiarAdmin();
                Administrador.show(true);
                ingadmin.show(false);
            } else {
                JOptionPane.showMessageDialog(null, "USUARIO O CONTRASEÑA INCORRECTA.");
            }
        } else {
            JOptionPane.showMessageDialog(null, cad);
        }
    }//GEN-LAST:event_Inicio2ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        this.show(true);
        ingadmin.show(false);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        Panelpestaña.setSelectedIndex(1);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:

        Panelpestaña.setSelectedIndex(3);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Panelpestaña.setSelectedIndex(2);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Administrador.show(false);
        ingadmin.show(true);
        txt_USER_ADMINISTRADOR.setText("User");
        txt_CONTRASEÑA_ADMINISTRADOR.setText("CONTRASEÑA");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        profesor2.show(false);
        profesor.show(true);
        txt_USERPROFESOR.setText("User");
        txt_CONTRASEÑAPROFESOR.setText("CONTRASEÑA");
    }//GEN-LAST:event_jButton10ActionPerformed

    private void BUSCARDATOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUSCARDATOSActionPerformed
        // TODO add your handling code here:
        int index = cbox_CONSULTAPROFESOR.getSelectedIndex();
        switch (index) {
            case 0:
                JOptionPane.showMessageDialog(null, "Seleccione método de busqueda.");
                break;
            case 1:
                if (!txt_BUSCARESTUDIANTEPROFESOR.getText().equals("")) {
                    if (Cadnumerica(txt_BUSCARESTUDIANTEPROFESOR.getText())) {
                        ConsultaUsuarioDatos("ESTUDIANTE", "WHERE \"USUARIO-ESTUDIANTE\" = " + txt_BUSCARESTUDIANTEPROFESOR.getText());
                        TablaDatosProfesor.setModel(tcdatosglob);
                    } else {
                        JOptionPane.showMessageDialog(null, "Se esperaba entrada numerica.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Campo vacío.");
                }
                break;
            case 2:
                if (!txt_BUSCARESTUDIANTEPROFESOR.getText().equals("")) {
                    ConsultaUsuarioDatos("ESTUDIANTE", "WHERE \"NOMBRE(S)_USUARIO\" = '" + txt_BUSCARESTUDIANTEPROFESOR.getText() + "'");
                    TablaDatosProfesor.setModel(tcdatosglob);
                } else {
                    JOptionPane.showMessageDialog(null, "Campo vacío.");
                }
                break;
            case 3:
                if (!txt_BUSCARESTUDIANTEPROFESOR.getText().equals("")) {
                    ConsultaUsuarioDatos("ESTUDIANTE", "WHERE \"APELLIDO(S)_USUARIO\" = '" + txt_BUSCARESTUDIANTEPROFESOR.getText() + "'");
                    TablaDatosProfesor.setModel(tcdatosglob);
                } else {
                    JOptionPane.showMessageDialog(null, "Campo vacío.");
                }
                break;

            default:
                JOptionPane.showMessageDialog(null, "Seleccione método de busqueda.");
        }
    }//GEN-LAST:event_BUSCARDATOSActionPerformed

    private void btn_BUSCARCONTENIDOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BUSCARCONTENIDOActionPerformed
        // TODO add your handling code here:
        int count = 0;
        if (cbox_CONSULTACONTENIDO.getSelectedIndex() == 0) {
            count++;
        }
        if (count == 0) {
            ResultSet Consulta;
            PreparedStatement Comando;
            DefaultTableModel tcdatos = new DefaultTableModel();
            tcdatos.addColumn("CURSO");
            tcdatos.addColumn("NRO-CONTENIDO");
            tcdatos.addColumn("NOMBRE(S)_PROFESOR");
            tcdatos.addColumn("APELLIDO(S)_PROFESOR");
            tcdatos.addColumn("NOMBRE CONTENIDO");
            tcdatos.addColumn("CONTENIDO");
            tcdatos.addColumn("DESCRIPCIÓN");
            TablaDatosContenidoProfesor.setModel(tcdatos);
            String[] datos = new String[7];
            String index = cbox_CONSULTACONTENIDO.getItemAt(cbox_CONSULTACONTENIDO.getSelectedIndex());
            try {
                String buscar = "";
                if (!txt_BUSCARCONTENIDO.getText().equals("")) {
                    buscar = " AND \"NOMBRE-CONTENIDO\" = '" + txt_BUSCARCONTENIDO.getText() + "'";
                }
                Comando = MetodosSQL.ConsultaContenido(Userglob, index, buscar);
                Consulta = Comando.executeQuery();
                if (Consulta.next()) {
                    do {
                        datos[0] = Consulta.getString("NOMBRE_CURSO");
                        datos[1] = Consulta.getString("NRO-CONTENIDO");
                        datos[2] = Consulta.getString("NOMBRE(S)_USUARIO");
                        datos[3] = Consulta.getString("APELLIDO(S)_USUARIO");
                        datos[4] = Consulta.getString("NOMBRE-CONTENIDO");
                        datos[5] = Consulta.getString("CONTENIDO");
                        datos[6] = Consulta.getString("DESCRIPCION");
                        tcdatos.addRow(datos);
                        TablaDatosContenidoProfesor.setModel(tcdatos);
                        BTN_ELIMINAR.setEnabled(true);
                    } while (Consulta.next());
                    JOptionPane.showMessageDialog(null, "Tabla actualizada.");
                } else {
                    BTN_ELIMINAR.setEnabled(false);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona un curso.");
            BTN_ELIMINAR.setEnabled(false);
        }
    }//GEN-LAST:event_btn_BUSCARCONTENIDOActionPerformed

    private void btn_INGRESARCURSOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_INGRESARCURSOActionPerformed
        // TODO add your handling code here:

        if (cbox_CURSO.getSelectedIndex() != 0) {
            int ncurso = cbox_CURSO.getSelectedIndex();
            try {
                if (MetodosSQL.BuscarCurso(ncurso, Userglob, "PROFESOR") == false) {
                    PreparedStatement Comando;
                    ResultSet Consulta;
                    MetodosSQL.Matricular(ncurso, Userglob, "PROFESOR");
                    Comando = MetodosSQL.BuscarCursoUser(Userglob, "PROFESOR");
                    Consulta = Comando.executeQuery();
                    cbox_CURSOMONTAR.removeAllItems();
                    cbox_CONSULTACONTENIDO.removeAllItems();
                    cbox_CURSOMONTAR.addItem("...");
                    cbox_CONSULTACONTENIDO.addItem("...");
                    while (Consulta.next()) {
                        cbox_CURSOMONTAR.addItem(Consulta.getString("NOMBRE_CURSO"));
                        cbox_CONSULTACONTENIDO.addItem(Consulta.getString("NOMBRE_CURSO"));
                    }
                    cbox_CURSO.setSelectedIndex(0);
                    JOptionPane.showMessageDialog(null, "Te has unido al curso.");
                } else {
                    JOptionPane.showMessageDialog(null, "Ya existe el profesor con id: " + Userglob + " en este curso.");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccionar un curso.");
        }

    }//GEN-LAST:event_btn_INGRESARCURSOActionPerformed

    private void btn_ACTUALIZARCURSOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ACTUALIZARCURSOActionPerformed
        // TODO add your handling code here:
        int count = 0;
        if (txt_LINK.getText().equals("")) {
            count++;
        }
        if (txt_DESCRIPCION.getText().equals("")) {
            count++;
        }
        if (txt_NOMBRECONTENIDO.getText().equals("")) {
            count++;
        }
        if (cbox_CURSOMONTAR.getSelectedIndex() == 0) {
            count++;
        }
        if (count != 0) {
            JOptionPane.showMessageDialog(null, "Hay campos sin rellenar.");
        } else {
            ResultSet Consulta;
            PreparedStatement Comando;
            String cbox = cbox_CURSOMONTAR.getItemAt(cbox_CURSOMONTAR.getSelectedIndex());
            Comando = MetodosSQL.Consulta("SELECT \"NRO-CURSO\", \"NRO-MATRICULA\" FROM \"MATRICULA-PROFESOR\" JOIN CURSO USING (\"NRO-CURSO\") WHERE \"USUARIO-PROFESOR\" = " + Userglob + " AND CURSO.\"NOMBRE_CURSO\" = " + "'" + cbox + "'");
            int contenido = MetodosSQL.ConsultaConsecuente("CONTENIDO");
            try {
                Consulta = Comando.executeQuery();
                if (Consulta.next()) {
                    int nro_curso = Consulta.getInt("NRO-CURSO");
                    int mat = Consulta.getInt("NRO-MATRICULA");
                    MetodosSQL.AgregarContendio(contenido, txt_LINK.getText(), nro_curso, txt_DESCRIPCION.getText(), txt_NOMBRECONTENIDO.getText(), mat);
                    JOptionPane.showMessageDialog(null, "Contenido agregado.");
                    Eliminar_contenido();
                    MetodosSQL.Update("CONTENIDO", contenido + 1);
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }//GEN-LAST:event_btn_ACTUALIZARCURSOActionPerformed

    private void txt_NOMBRECONTENIDOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NOMBRECONTENIDOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NOMBRECONTENIDOActionPerformed

    private void txt_ContraseñaNueva2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ContraseñaNueva2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ContraseñaNueva2ActionPerformed

    private void BTN_ELIMINARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_ELIMINARActionPerformed
        // TODO add your handling code here:
        Eliminar_contenido_DB();
        JOptionPane.showMessageDialog(null, "Contenido eliminado de la base de datos.");

    }//GEN-LAST:event_BTN_ELIMINARActionPerformed

    private void txt_CREACIONCORREOADMIN1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CREACIONCORREOADMIN1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CREACIONCORREOADMIN1ActionPerformed

    private void txt_CREACIONCORREOADMIN1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CREACIONCORREOADMIN1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CREACIONCORREOADMIN1MousePressed

    private void txt_CREACIONCORREOADMIN1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CREACIONCORREOADMIN1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CREACIONCORREOADMIN1MouseEntered

    private void txt_CREACIONCORREOADMIN1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CREACIONCORREOADMIN1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CREACIONCORREOADMIN1MouseClicked

    private void txt_CREACIONTELEFONOADMIN1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CREACIONTELEFONOADMIN1KeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!numeros) {
            evt.consume();
        }

        if (txt_CREACIONTELEFONOADMIN1.getText().trim().length() == 10) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_CREACIONTELEFONOADMIN1KeyTyped

    private void txt_CREACIONTELEFONOADMIN1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CREACIONTELEFONOADMIN1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CREACIONTELEFONOADMIN1ActionPerformed

    private void txt_CREACIONTELEFONOADMIN1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CREACIONTELEFONOADMIN1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CREACIONTELEFONOADMIN1MousePressed

    private void txt_CREACIONTELEFONOADMIN1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CREACIONTELEFONOADMIN1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CREACIONTELEFONOADMIN1MouseEntered

    private void txt_CREACIONTELEFONOADMIN1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CREACIONTELEFONOADMIN1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CREACIONTELEFONOADMIN1MouseClicked

    private void txt_CREACIONDIRECCIONADMIN1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CREACIONDIRECCIONADMIN1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CREACIONDIRECCIONADMIN1ActionPerformed

    private void txt_CREACIONDIRECCIONADMIN1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CREACIONDIRECCIONADMIN1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CREACIONDIRECCIONADMIN1MousePressed

    private void txt_CREACIONDIRECCIONADMIN1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CREACIONDIRECCIONADMIN1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CREACIONDIRECCIONADMIN1MouseEntered

    private void txt_CREACIONDIRECCIONADMIN1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CREACIONDIRECCIONADMIN1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CREACIONDIRECCIONADMIN1MouseClicked

    private void REGISTRARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_REGISTRARActionPerformed
        // TODO add your handling code here:
        int count = 0;
        if (txt_CREACIONNOMBREADMIN.getText().equals("")) {
            count++;
        }
        if (txt_CREACIONAPELLIDOADMIN.getText().equals("")) {
            count++;
        }
        if (txt_CREACIONUSUARIOADMIN.getText().equals("")) {
            count++;
        }
        if (txt_CREACIONCONTRASEÑAADMIN.getText().equals("")) {
            count++;
        }
        if (txt_CREACIONCONTRASEÑA2ADMIN.getText().equals("")) {
            count++;
        }
        if (txt_CREACIONDIRECCIONADMIN.getText().equals("")) {
            count++;
        }
        if (txt_CREACIONTELEFONOADMIN.getText().equals("")) {
            count++;
        }
        if (txt_CREACIONCORREOADMIN.getText().equals("")) {
            count++;
        }
        if (TIPO_CUENTA.getSelectedIndex() == 0) {
            count++;
        }
        if (count != 0) {
            JOptionPane.showMessageDialog(null, "Hay campos sin rellenar.");
        } else if (txt_CREACIONCONTRASEÑAADMIN.getText().equals(txt_CREACIONCONTRASEÑA2ADMIN.getText())) {
            if (MetodosSQL.UserExis(Integer.parseInt(txt_CREACIONUSUARIOADMIN.getText()), TIPO_CUENTA.getItemAt(TIPO_CUENTA.getSelectedIndex())) == false) {
                String[] datos1 = new String[11];
                //STRING
                int Usuario = Integer.parseInt(txt_CREACIONUSUARIOADMIN.getText());
                datos1[0] = txt_CREACIONNOMBREADMIN.getText();
                datos1[1] = txt_CREACIONAPELLIDOADMIN.getText();
                datos1[2] = txt_CREACIONCONTRASEÑAADMIN.getText();
                datos1[3] = txt_CREACIONCONTRASEÑA2ADMIN.getText();
                datos1[4] = txt_CREACIONDIRECCIONADMIN.getText();
                if (txt_CREACIONDIRECCIONADMIN1.getText().equals("")) {
                    datos1[5] = "VACÍO";
                } else {
                    datos1[5] = txt_CREACIONDIRECCIONADMIN1.getText();
                }
                datos1[6] = txt_CREACIONCORREOADMIN.getText();
                if (txt_CREACIONCORREOADMIN1.getText().equals("")) {
                    datos1[7] = "VACÍO";
                } else {
                    datos1[7] = txt_CREACIONCORREOADMIN1.getText();
                }
                datos1[8] = TIPO_CUENTA.getItemAt(TIPO_CUENTA.getSelectedIndex());
                datos1[9] = txt_CREACIONTELEFONOADMIN.getText();
                if (txt_CREACIONTELEFONOADMIN1.getText().equals("")) {
                    datos1[10] = "VACÍO";
                } else {
                    datos1[10] = txt_CREACIONTELEFONOADMIN1.getText();
                }
                try {
                    MetodosSQL.InsertarUsuario(datos1, Usuario);
                    JOptionPane.showMessageDialog(null, "Cuenta creada.");
                    LimpiarCreacionUserAdmin();
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ya hay una cuenta " + TIPO_CUENTA.getItemAt(TIPO_CUENTA.getSelectedIndex()) + " existente con esta identificación.");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden.");
        }
    }//GEN-LAST:event_REGISTRARActionPerformed

    private void txt_CREACIONCORREOADMINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CREACIONCORREOADMINActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CREACIONCORREOADMINActionPerformed

    private void txt_CREACIONCORREOADMINMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CREACIONCORREOADMINMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CREACIONCORREOADMINMousePressed

    private void txt_CREACIONCORREOADMINMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CREACIONCORREOADMINMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CREACIONCORREOADMINMouseEntered

    private void txt_CREACIONCORREOADMINMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CREACIONCORREOADMINMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CREACIONCORREOADMINMouseClicked

    private void txt_CREACIONTELEFONOADMINKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CREACIONTELEFONOADMINKeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!numeros) {
            evt.consume();
        }

        if (txt_CREACIONTELEFONOADMIN.getText().trim().length() == 10) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_CREACIONTELEFONOADMINKeyTyped

    private void txt_CREACIONTELEFONOADMINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CREACIONTELEFONOADMINActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CREACIONTELEFONOADMINActionPerformed

    private void txt_CREACIONTELEFONOADMINMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CREACIONTELEFONOADMINMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CREACIONTELEFONOADMINMousePressed

    private void txt_CREACIONTELEFONOADMINMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CREACIONTELEFONOADMINMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CREACIONTELEFONOADMINMouseEntered

    private void txt_CREACIONTELEFONOADMINMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CREACIONTELEFONOADMINMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CREACIONTELEFONOADMINMouseClicked

    private void txt_CREACIONDIRECCIONADMINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CREACIONDIRECCIONADMINActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CREACIONDIRECCIONADMINActionPerformed

    private void txt_CREACIONDIRECCIONADMINMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CREACIONDIRECCIONADMINMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CREACIONDIRECCIONADMINMousePressed

    private void txt_CREACIONDIRECCIONADMINMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CREACIONDIRECCIONADMINMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CREACIONDIRECCIONADMINMouseEntered

    private void txt_CREACIONDIRECCIONADMINMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CREACIONDIRECCIONADMINMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CREACIONDIRECCIONADMINMouseClicked

    private void txt_CREACIONCONTRASEÑA2ADMINKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CREACIONCONTRASEÑA2ADMINKeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!numeros) {
            evt.consume();
        }

        if (txt_CREACIONCONTRASEÑA2ADMIN.getText().trim().length() == 10) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_CREACIONCONTRASEÑA2ADMINKeyTyped

    private void txt_CREACIONCONTRASEÑA2ADMINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CREACIONCONTRASEÑA2ADMINActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CREACIONCONTRASEÑA2ADMINActionPerformed

    private void txt_CREACIONCONTRASEÑAADMINKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CREACIONCONTRASEÑAADMINKeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!numeros) {
            evt.consume();
        }

        if (txt_CREACIONCONTRASEÑAADMIN.getText().trim().length() == 10) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_CREACIONCONTRASEÑAADMINKeyTyped

    private void txt_CREACIONCONTRASEÑAADMINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CREACIONCONTRASEÑAADMINActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CREACIONCONTRASEÑAADMINActionPerformed

    private void txt_CREACIONUSUARIOADMINKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CREACIONUSUARIOADMINKeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();
        boolean numeros = key >= 48 && key <= 57;
        if (!numeros) {
            evt.consume();
        }
        if (txt_CREACIONUSUARIOADMIN.getText().trim().length() == 10) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_CREACIONUSUARIOADMINKeyTyped

    private void txt_CREACIONUSUARIOADMINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CREACIONUSUARIOADMINActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CREACIONUSUARIOADMINActionPerformed

    private void txt_CREACIONUSUARIOADMINMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CREACIONUSUARIOADMINMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CREACIONUSUARIOADMINMousePressed

    private void txt_CREACIONUSUARIOADMINMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CREACIONUSUARIOADMINMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CREACIONUSUARIOADMINMouseEntered

    private void txt_CREACIONUSUARIOADMINMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CREACIONUSUARIOADMINMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CREACIONUSUARIOADMINMouseClicked

    private void txt_CREACIONAPELLIDOADMINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CREACIONAPELLIDOADMINActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CREACIONAPELLIDOADMINActionPerformed

    private void txt_CREACIONAPELLIDOADMINMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CREACIONAPELLIDOADMINMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CREACIONAPELLIDOADMINMousePressed

    private void txt_CREACIONAPELLIDOADMINMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CREACIONAPELLIDOADMINMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CREACIONAPELLIDOADMINMouseEntered

    private void txt_CREACIONAPELLIDOADMINMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CREACIONAPELLIDOADMINMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CREACIONAPELLIDOADMINMouseClicked

    private void txt_CREACIONNOMBREADMINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CREACIONNOMBREADMINActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CREACIONNOMBREADMINActionPerformed

    private void txt_CREACIONNOMBREADMINMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CREACIONNOMBREADMINMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CREACIONNOMBREADMINMousePressed

    private void txt_CREACIONNOMBREADMINMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CREACIONNOMBREADMINMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CREACIONNOMBREADMINMouseEntered

    private void txt_CREACIONNOMBREADMINMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CREACIONNOMBREADMINMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CREACIONNOMBREADMINMouseClicked

    private void jCOMBO_BUSCARADMIN2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCOMBO_BUSCARADMIN2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCOMBO_BUSCARADMIN2ActionPerformed

    private void CONSULTARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CONSULTARActionPerformed
        // TODO add your handling code here:
        int index = jCOMBO_BUSCARADMIN1.getSelectedIndex();
        int index2 = jCOMBO_BUSCARADMIN2.getSelectedIndex();

        switch (index2) {
            case 1:
                String cbox = jCOMBO_BUSCARADMIN1.getItemAt(index);
                if (index != 0) {
                    if (!txt_BUSCARADMINISTRADOR.getText().equals("")) {
                        if (Cadnumerica(txt_BUSCARADMINISTRADOR.getText())) {
                            ConsultaUsuarioDatos(cbox, "WHERE \"USUARIO-" + cbox + "\" = " + txt_BUSCARADMINISTRADOR.getText());
                            TablaDatosAdministrador.setModel(tcdatosglob);
                        } else {
                            JOptionPane.showMessageDialog(null, "Se esperaba entrada numerica.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Campo vacío.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione tipo de usuario");
                }
                break;
            case 2:
                cbox = jCOMBO_BUSCARADMIN1.getItemAt(index);
                if (index != 0) {
                    if (!txt_BUSCARADMINISTRADOR.getText().equals("")) {
                        if (Cadnumerica(txt_BUSCARADMINISTRADOR.getText())) {
                            ConsultaUsuarioDatos(cbox, "WHERE \"NOMBRE(S)_USUARIO\" = '" + txt_BUSCARADMINISTRADOR.getText() + "'");
                            TablaDatosAdministrador.setModel(tcdatosglob);
                        } else {
                            JOptionPane.showMessageDialog(null, "Se esperaba entrada numerica.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Campo vacío.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione tipo de usuario");
                }
                break;
            case 3:
                cbox = jCOMBO_BUSCARADMIN1.getItemAt(index);
                if (index != 0) {
                    if (!txt_BUSCARADMINISTRADOR.getText().equals("")) {
                        if (Cadnumerica(txt_BUSCARADMINISTRADOR.getText())) {
                            ConsultaUsuarioDatos(cbox, "WHERE \"APELLIDO(S)_USUARIO\" = '" + txt_BUSCARADMINISTRADOR.getText() + "'");
                            TablaDatosAdministrador.setModel(tcdatosglob);
                        } else {
                            JOptionPane.showMessageDialog(null, "Se esperaba entrada numerica.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Campo vacío.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione tipo de usuario");
                }
                break;

            default:
                JOptionPane.showMessageDialog(null, "Seleccione opciones");
                break;

        }
    }//GEN-LAST:event_CONSULTARActionPerformed

    private void txt_CORREO2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CORREO2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CORREO2ActionPerformed

    private void txt_CORREO2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CORREO2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CORREO2MousePressed

    private void txt_CORREO2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CORREO2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CORREO2MouseEntered

    private void txt_CORREO2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CORREO2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CORREO2MouseClicked

    private void txt_MODDIR2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_MODDIR2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_MODDIR2ActionPerformed

    private void txt_MODDIR2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_MODDIR2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_MODDIR2MousePressed

    private void txt_MODDIR2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_MODDIR2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_MODDIR2MouseEntered

    private void txt_MODDIR2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_MODDIR2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_MODDIR2MouseClicked

    private void txt_MODTELEFONO1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_MODTELEFONO1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_MODTELEFONO1ActionPerformed

    private void txt_MODTELEFONO1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_MODTELEFONO1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_MODTELEFONO1MousePressed

    private void txt_MODTELEFONO1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_MODTELEFONO1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_MODTELEFONO1MouseEntered

    private void txt_MODTELEFONO1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_MODTELEFONO1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_MODTELEFONO1MouseClicked

    private void btn_BUSCARMODIFICARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BUSCARMODIFICARActionPerformed
        // TODO add your handling code here:   
        if (!txt_BUSCARUSERMOD.getText().equals("")) {
            ResultSet Consulta;
            PreparedStatement Comando;
            int sw = 0;
            Cespeciales = 0;
            int user = Integer.parseInt(txt_BUSCARUSERMOD.getText());
            Comando = MetodosSQL.Comprobar(user);
            try {
                Consulta = Comando.executeQuery();
                if (Consulta.next()) {
                    jLabel71.setText("ESTUDIANTE");
                    jLabel73.setText("PROFESOR");
                    Datos(user, "PROFESOR");
                    sw = 1;
                    Cespeciales = 1;
                    ActivarMod();
                } else {
                    Comando = MetodosSQL.Profesor(user);
                    Consulta = Comando.executeQuery();
                    if (Consulta.next()) {
                        jLabel71.setText("PROFESOR");
                        jLabel73.setText("");
                        Datos(user, "PROFESOR");
                        sw = 1;
                        Cespeciales = 2;
                        ActivarMod();
                    } else {
                        Comando = MetodosSQL.Estudiante(user);
                        Consulta = Comando.executeQuery();
                        if (Consulta.next()) {
                            jLabel71.setText("ESTUDIANTE");
                            jLabel73.setText("");
                            Datos(user, "ESTUDIANTE");
                            sw = 1;
                            Cespeciales = 3;
                            ActivarMod();
                        } else {
                            JOptionPane.showMessageDialog(null, "Usuario no encontrado.");
                        }
                    }
                }
                if (sw == 1) {

                    UserAdminMod = user;
                    txt_MODUSER.setText("" + user);
                    txt_MODAPELLIDO.setText(Consulta.getString("APELLIDO(S)_USUARIO"));
                    txt_MODNOMBRE.setText(Consulta.getString("NOMBRE(S)_USUARIO"));
                    txt_CONTRASEÑAMOD.setText(Consulta.getString("CONTRASEÑA"));
                    try {
                        int i = 0, num1 = 0, num2 = 0;
                        String cor1 = "", cor2 = "";

                        /////CORREOOOOO
                        while (Correo.next()) {
                            if (i == 0) {
                                num1 = Correo.getInt("NRO-CORREO");
                                cor1 = Correo.getString("CORREO");
                                i++;
                            } else {
                                num2 = Correo.getInt("NRO-CORREO");
                                cor2 = Correo.getString("CORREO");
                            }
                        }
                        if (num1 > num2) {
                            txt_CORREO1.setText(cor2);
                            if (cor1.equals("VACÍO")) {
                                txt_CORREO2.setText("");
                            } else {
                                txt_CORREO2.setText(cor1);
                            }
                        } else {
                            txt_CORREO1.setText(cor1);
                            if (cor2.equals("VACÍO")) {
                                txt_CORREO2.setText("");
                            } else {
                                txt_CORREO2.setText(cor2);
                            }
                        }
                        /////////////////////////
                        /////DIRECCION
                        i = 0;
                        while (Dir.next()) {
                            if (i == 0) {
                                num1 = Dir.getInt("NRO-DIRECCION");
                                cor1 = Dir.getString("DIRECCION");
                                i++;
                            } else {
                                num2 = Dir.getInt("NRO-DIRECCION");
                                cor2 = Dir.getString("DIRECCION");
                            }
                        }
                        if (num1 > num2) {
                            txt_MODDIR1.setText(cor2);
                            if (cor1.equals("VACÍO")) {
                                txt_MODDIR2.setText("");
                            } else {
                                txt_MODDIR2.setText(cor1);
                            }
                        } else {
                            txt_MODDIR1.setText(cor1);
                            if (cor2.equals("VACÍO")) {
                                txt_MODDIR2.setText("");
                            } else {
                                txt_MODDIR2.setText(cor2);
                            }
                        }
                        /////////////////////////
                        /////TELEFONO
                        i = 0;
                        while (Tel.next()) {
                            if (i == 0) {
                                num1 = Tel.getInt("NRO-TELEFONO");
                                cor1 = Tel.getString("TELEFONO");
                                i++;
                            } else {
                                num2 = Tel.getInt("NRO-TELEFONO");
                                cor2 = Tel.getString("TELEFONO");
                            }
                        }
                        if (num1 > num2) {
                            txt_MODTELEFONO1.setText(cor2);
                            if (cor1.equals("VACÍO")) {
                                txt_MODTELEFONO2.setText("");
                            } else {
                                txt_MODTELEFONO2.setText(cor1);
                            }
                        } else {
                            System.out.println("ELSEEEEEETELEFONO");
                            txt_MODTELEFONO1.setText(cor1);
                            if (cor2.equals("VACÍO")) {
                                txt_MODTELEFONO2.setText("");
                            } else {
                                txt_MODTELEFONO2.setText(cor2);
                            }
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    JOptionPane.showMessageDialog(null, "Usuario encontrado.");
                }//END-IF

            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Campo vacío.");
        }
    }//GEN-LAST:event_btn_BUSCARMODIFICARActionPerformed

    private void txt_BUSCARUSERMODActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_BUSCARUSERMODActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_BUSCARUSERMODActionPerformed

    private void btn_ACTUALIZARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ACTUALIZARActionPerformed
        // TODO add your handling code here:
        int i = 0;
        if (txt_MODUSER.getText().equals("")) {
            i++;
        }
        if (txt_MODAPELLIDO.getText().equals("")) {
            i++;
        }
        if (txt_MODNOMBRE.getText().equals("")) {
            i++;
        }
        if (txt_CONTRASEÑAMOD.getText().equals("")) {
            i++;
        }
        if (txt_MODDIR1.getText().equals("")) {
            i++;
        }
        if (txt_MODTELEFONO1.getText().equals("")) {
            i++;
        }
        if (txt_CORREO1.getText().equals("")) {
            i++;
        }
        if (i == 0) {
            String[] datos = new String[10];

            datos[0] = txt_MODNOMBRE.getText();
            datos[1] = txt_MODAPELLIDO.getText();
            datos[2] = txt_CONTRASEÑAMOD.getText();
            datos[3] = txt_MODUSER.getText();
            datos[4] = txt_MODDIR1.getText();

            if (txt_MODDIR2.getText().equals("")) {
                datos[5] = "VACÍO";
            } else {
                datos[5] = txt_MODDIR2.getText();
            }

            datos[6] = txt_MODTELEFONO1.getText();
            if (txt_MODTELEFONO2.getText().equals("")) {
                datos[7] = "VACÍO";
            } else {
                datos[7] = txt_MODTELEFONO2.getText();
            }

            datos[8] = txt_CORREO1.getText();
            if (txt_CORREO2.getText().equals("")) {
                datos[9] = "VACÍO";
            } else {
                datos[9] = txt_CORREO2.getText();
            }
            switch (Cespeciales) {
                case 1:
                    MetodosSQL.ModificarUser(Integer.parseInt(txt_MODUSER.getText()), "ESTUDIANTE", datos);
                    MetodosSQL.ModificarUser(Integer.parseInt(txt_MODUSER.getText()), "PROFESOR", datos);
                    MetodosSQL.UpdateDatos(Integer.parseInt(txt_MODUSER.getText()), "ESTUDIANTE", datos[4], datos[5], datos[6], datos[7], datos[8], datos[9]);
                    MetodosSQL.UpdateDatos(Integer.parseInt(txt_MODUSER.getText()), "PROFESOR", datos[4], datos[5], datos[6], datos[7], datos[8], datos[9]);
                    break;
                case 2:
                    MetodosSQL.ModificarUser(Integer.parseInt(txt_MODUSER.getText()), "PROFESOR", datos);
                    MetodosSQL.UpdateDatos(Integer.parseInt(txt_MODUSER.getText()), "PROFESOR", datos[4], datos[5], datos[6], datos[7], datos[8], datos[9]);
                    break;
                default:
                    MetodosSQL.ModificarUser(Integer.parseInt(txt_MODUSER.getText()), "ESTUDIANTE", datos);
                    MetodosSQL.UpdateDatos(Integer.parseInt(txt_MODUSER.getText()), "ESTUDIANTE", datos[4], datos[5], datos[6], datos[7], datos[8], datos[9]);
                    break;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Campos obligatorios vacíos.");
        }


    }//GEN-LAST:event_btn_ACTUALIZARActionPerformed

    private void txt_CORREO1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CORREO1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CORREO1ActionPerformed

    private void txt_CORREO1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CORREO1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CORREO1MousePressed

    private void txt_CORREO1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CORREO1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CORREO1MouseEntered

    private void txt_CORREO1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CORREO1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CORREO1MouseClicked

    private void txt_MODTELEFONO2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_MODTELEFONO2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_MODTELEFONO2ActionPerformed

    private void txt_MODTELEFONO2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_MODTELEFONO2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_MODTELEFONO2MousePressed

    private void txt_MODTELEFONO2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_MODTELEFONO2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_MODTELEFONO2MouseEntered

    private void txt_MODTELEFONO2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_MODTELEFONO2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_MODTELEFONO2MouseClicked

    private void txt_MODDIR1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_MODDIR1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_MODDIR1ActionPerformed

    private void txt_MODDIR1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_MODDIR1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_MODDIR1MousePressed

    private void txt_MODDIR1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_MODDIR1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_MODDIR1MouseEntered

    private void txt_MODDIR1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_MODDIR1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_MODDIR1MouseClicked

    private void Ingresotxt18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ingresotxt18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Ingresotxt18ActionPerformed

    private void Ingresotxt18MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Ingresotxt18MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Ingresotxt18MousePressed

    private void Ingresotxt18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Ingresotxt18MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_Ingresotxt18MouseEntered

    private void Ingresotxt18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Ingresotxt18MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Ingresotxt18MouseClicked

    private void txt_MODUSERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_MODUSERActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_MODUSERActionPerformed

    private void txt_MODUSERMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_MODUSERMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_MODUSERMousePressed

    private void txt_MODUSERMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_MODUSERMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_MODUSERMouseEntered

    private void txt_MODUSERMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_MODUSERMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_MODUSERMouseClicked

    private void txt_MODAPELLIDOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_MODAPELLIDOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_MODAPELLIDOActionPerformed

    private void txt_MODAPELLIDOMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_MODAPELLIDOMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_MODAPELLIDOMousePressed

    private void txt_MODAPELLIDOMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_MODAPELLIDOMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_MODAPELLIDOMouseEntered

    private void txt_MODAPELLIDOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_MODAPELLIDOMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_MODAPELLIDOMouseClicked

    private void txt_MODNOMBREActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_MODNOMBREActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_MODNOMBREActionPerformed

    private void txt_MODNOMBREMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_MODNOMBREMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_MODNOMBREMousePressed

    private void txt_MODNOMBREMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_MODNOMBREMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_MODNOMBREMouseEntered

    private void txt_MODNOMBREMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_MODNOMBREMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_MODNOMBREMouseClicked

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        int i = 0;
        if (txt_ContraseñaAntigua.getText().equals("")) {
            i++;
        }
        if (txt_ContraseñaNueva1.getText().equals("")) {
            i++;
        }
        if (txt_ContraseñaNueva2.getText().equals("")) {
            i++;
        }
        if (i != 0) {
            JOptionPane.showMessageDialog(null, "Campos vacíos.");
        } else if (txt_ContraseñaNueva1.getText().equals(txt_ContraseñaNueva2.getText())) {
            if (MetodosSQL.ConsultaUser(Userglob, "CUENTA-PROFESOR", "PROFESOR") == Integer.parseInt(txt_ContraseñaAntigua.getText())) {
                MetodosSQL.ConsultaUpdate("UPDATE \"CUENTA-PROFESOR\" SET CONTRASEÑA = " + txt_ContraseñaNueva1.getText() + "WHERE \"USUARIO-PROFESOR\" = " + Userglob);
                JOptionPane.showMessageDialog(null, "Contraseña modificada.");
                Eliminar_Profesor_Contraseña();
            } else {
                JOptionPane.showMessageDialog(null, "Contraseña incorrecta.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden.");
        }

    }//GEN-LAST:event_btnActualizarActionPerformed

    private void txt_BUSCARCONTENIDOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_BUSCARCONTENIDOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_BUSCARCONTENIDOActionPerformed

    private void txt_MODUSERKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_MODUSERKeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!numeros) {
            evt.consume();
        }

        if (txt_MODUSER.getText().trim().length() == 10) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_MODUSERKeyTyped

    private void txt_CONTRASEÑAMODKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CONTRASEÑAMODKeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!numeros) {
            evt.consume();
        }

        if (txt_CONTRASEÑAMOD.getText().trim().length() == 10) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_CONTRASEÑAMODKeyTyped

    private void txt_MODTELEFONO1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_MODTELEFONO1KeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!numeros) {
            evt.consume();
        }

        if (txt_MODTELEFONO1.getText().trim().length() == 10) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_MODTELEFONO1KeyTyped

    private void txt_MODTELEFONO2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_MODTELEFONO2KeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!numeros) {
            evt.consume();
        }

        if (txt_MODTELEFONO2.getText().trim().length() == 10) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_MODTELEFONO2KeyTyped

    private void txt_TELEFONOREGISTRO2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_TELEFONOREGISTRO2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TELEFONOREGISTRO2ActionPerformed

    private void txt_TELEFONOREGISTRO2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_TELEFONOREGISTRO2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TELEFONOREGISTRO2MousePressed

    private void txt_TELEFONOREGISTRO2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_TELEFONOREGISTRO2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TELEFONOREGISTRO2MouseEntered

    private void txt_TELEFONOREGISTRO2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_TELEFONOREGISTRO2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TELEFONOREGISTRO2MouseClicked

    private void txt_TELEFONOREGISTRO1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_TELEFONOREGISTRO1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TELEFONOREGISTRO1ActionPerformed

    private void txt_TELEFONOREGISTRO1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_TELEFONOREGISTRO1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TELEFONOREGISTRO1MousePressed

    private void txt_TELEFONOREGISTRO1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_TELEFONOREGISTRO1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TELEFONOREGISTRO1MouseEntered

    private void txt_TELEFONOREGISTRO1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_TELEFONOREGISTRO1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TELEFONOREGISTRO1MouseClicked

    private void txt_CORREOREGISTRO2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CORREOREGISTRO2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CORREOREGISTRO2ActionPerformed

    private void txt_CORREOREGISTRO2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CORREOREGISTRO2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CORREOREGISTRO2MousePressed

    private void txt_CORREOREGISTRO2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CORREOREGISTRO2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CORREOREGISTRO2MouseEntered

    private void txt_CORREOREGISTRO2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CORREOREGISTRO2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CORREOREGISTRO2MouseClicked

    private void jLabel82MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel82MouseClicked
        // TODO add your handling code here:
        int count = 0;
        if (txt_USUARIOREGISTRO.getText().equals("")) {
            count++;
        }
        if (txt_NOMBREREGISTRO.getText().equals("")) {
            count++;
        }
        if (txt_APELLIDOSREGISTRO.getText().equals("")) {
            count++;
        }
        if (txt_DIRECCIONREGISTRO1.getText().equals("")) {
            count++;
        }
        if (txt_TELEFONOREGISTRO1.getText().equals("")) {
            count++;
        }
        if (txt_CORREOREGISTRO1.getText().equals("")) {
            count++;
        }
        if (txt_CONTRASEÑAREGISTRO1.getText().equals("")) {
            count++;
        }
        if (txt_CONTRASEÑAREGISTRO2.getText().equals("")) {
            count++;
        }
        if (txt_CORREOREGISTRO1.getText().equals("")) {
            count++;
        }
        if (count != 0) {
            JOptionPane.showMessageDialog(null, "Hay campos sin rellenar.");
        } else if (txt_CONTRASEÑAREGISTRO1.getText().equals(txt_CONTRASEÑAREGISTRO2.getText())) {
            if (MetodosSQL.UserExis(Integer.parseInt(txt_USUARIOREGISTRO.getText()), "PROFESOR") == false) {
                String[] datos1 = new String[11];
                //STRING
                int Usuario = Integer.parseInt(txt_USUARIOREGISTRO.getText());
                datos1[0] = txt_NOMBREREGISTRO.getText();
                datos1[1] = txt_APELLIDOSREGISTRO.getText();
                datos1[2] = txt_CONTRASEÑAREGISTRO1.getText();
                datos1[3] = txt_CONTRASEÑAREGISTRO2.getText();
                datos1[4] = txt_DIRECCIONREGISTRO1.getText();
                if (txt_DIRECCIONREGISTRO2.getText().equals("")) {
                    datos1[5] = "VACÍO";
                } else {
                    datos1[5] = txt_DIRECCIONREGISTRO2.getText();
                }
                datos1[6] = txt_CORREOREGISTRO1.getText();
                if (txt_CORREOREGISTRO2.getText().equals("")) {
                    datos1[7] = "VACÍO";
                } else {
                    datos1[7] = txt_CORREOREGISTRO2.getText();
                }
                datos1[8] = "PROFESOR";
                datos1[9] = txt_TELEFONOREGISTRO1.getText();
                if (txt_TELEFONOREGISTRO2.getText().equals("")) {
                    datos1[10] = "VACÍO";
                } else {
                    datos1[10] = txt_TELEFONOREGISTRO2.getText();
                }
                try {
                    MetodosSQL.InsertarUsuario(datos1, Usuario);
                    JOptionPane.showMessageDialog(null, "Cuenta creada.");
                    LimpiarRegistroProfesor();
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ya hay una cuenta PROFESOR existente con esta identificación.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden.");
        }
    }//GEN-LAST:event_jLabel82MouseClicked

    private void txt_CORREOREGISTRO1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CORREOREGISTRO1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CORREOREGISTRO1ActionPerformed

    private void txt_CORREOREGISTRO1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CORREOREGISTRO1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CORREOREGISTRO1MousePressed

    private void txt_CORREOREGISTRO1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CORREOREGISTRO1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CORREOREGISTRO1MouseEntered

    private void txt_CORREOREGISTRO1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CORREOREGISTRO1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CORREOREGISTRO1MouseClicked

    private void txt_DIRECCIONREGISTRO1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_DIRECCIONREGISTRO1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_DIRECCIONREGISTRO1MouseClicked

    private void txt_DIRECCIONREGISTRO1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_DIRECCIONREGISTRO1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_DIRECCIONREGISTRO1MouseEntered

    private void txt_DIRECCIONREGISTRO1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_DIRECCIONREGISTRO1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_DIRECCIONREGISTRO1MousePressed

    private void txt_DIRECCIONREGISTRO1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_DIRECCIONREGISTRO1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_DIRECCIONREGISTRO1ActionPerformed

    private void txt_DIRECCIONREGISTRO2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_DIRECCIONREGISTRO2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_DIRECCIONREGISTRO2MouseClicked

    private void txt_DIRECCIONREGISTRO2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_DIRECCIONREGISTRO2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_DIRECCIONREGISTRO2MouseEntered

    private void txt_DIRECCIONREGISTRO2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_DIRECCIONREGISTRO2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_DIRECCIONREGISTRO2MousePressed

    private void txt_DIRECCIONREGISTRO2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_DIRECCIONREGISTRO2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_DIRECCIONREGISTRO2ActionPerformed

    private void txt_APELLIDOSREGISTROMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_APELLIDOSREGISTROMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_APELLIDOSREGISTROMouseClicked

    private void txt_APELLIDOSREGISTROMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_APELLIDOSREGISTROMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_APELLIDOSREGISTROMouseEntered

    private void txt_APELLIDOSREGISTROMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_APELLIDOSREGISTROMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_APELLIDOSREGISTROMousePressed

    private void txt_APELLIDOSREGISTROActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_APELLIDOSREGISTROActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_APELLIDOSREGISTROActionPerformed

    private void txt_CONTRASEÑAREGISTRO1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CONTRASEÑAREGISTRO1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CONTRASEÑAREGISTRO1MouseClicked

    private void txt_CONTRASEÑAREGISTRO1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CONTRASEÑAREGISTRO1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CONTRASEÑAREGISTRO1MouseEntered

    private void txt_CONTRASEÑAREGISTRO1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CONTRASEÑAREGISTRO1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CONTRASEÑAREGISTRO1MousePressed

    private void txt_CONTRASEÑAREGISTRO1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CONTRASEÑAREGISTRO1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CONTRASEÑAREGISTRO1ActionPerformed

    private void txt_USUARIOREGISTROMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_USUARIOREGISTROMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_USUARIOREGISTROMouseClicked

    private void txt_USUARIOREGISTROMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_USUARIOREGISTROMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_USUARIOREGISTROMouseEntered

    private void txt_USUARIOREGISTROMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_USUARIOREGISTROMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_USUARIOREGISTROMousePressed

    private void txt_USUARIOREGISTROActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_USUARIOREGISTROActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_USUARIOREGISTROActionPerformed

    private void txt_NOMBREREGISTROMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_NOMBREREGISTROMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NOMBREREGISTROMouseClicked

    private void txt_NOMBREREGISTROMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_NOMBREREGISTROMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NOMBREREGISTROMouseEntered

    private void txt_NOMBREREGISTROMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_NOMBREREGISTROMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NOMBREREGISTROMousePressed

    private void txt_NOMBREREGISTROActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NOMBREREGISTROActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NOMBREREGISTROActionPerformed

    private void txt_CONTRASEÑAREGISTRO2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CONTRASEÑAREGISTRO2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CONTRASEÑAREGISTRO2MouseClicked

    private void txt_CONTRASEÑAREGISTRO2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CONTRASEÑAREGISTRO2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CONTRASEÑAREGISTRO2MouseEntered

    private void txt_CONTRASEÑAREGISTRO2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CONTRASEÑAREGISTRO2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CONTRASEÑAREGISTRO2MousePressed

    private void txt_CONTRASEÑAREGISTRO2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CONTRASEÑAREGISTRO2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CONTRASEÑAREGISTRO2ActionPerformed

    private void MinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinimizarMouseClicked
        // TODO add your handling code here:
        ingadmin.setState(ingadmin.ICONIFIED);
    }//GEN-LAST:event_MinimizarMouseClicked

    private void jLabel88MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel88MouseClicked
        // TODO add your handling code here:
        int dialog = JOptionPane.YES_NO_OPTION;
        int results = JOptionPane.showConfirmDialog(null, "¿Desea salir?", "Exit", dialog);
        if (results == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_jLabel88MouseClicked

    private void txt_USER_ADMINISTRADORMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_USER_ADMINISTRADORMouseClicked
        // TODO add your handling code here:
        txt_USER_ADMINISTRADOR.setText("");
    }//GEN-LAST:event_txt_USER_ADMINISTRADORMouseClicked

    private void txt_CONTRASEÑA_ADMINISTRADORMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CONTRASEÑA_ADMINISTRADORMouseClicked
        // TODO add your handling code here:
        txt_CONTRASEÑA_ADMINISTRADOR.setText("");
    }//GEN-LAST:event_txt_CONTRASEÑA_ADMINISTRADORMouseClicked

    private void Minimizar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Minimizar1MouseClicked
        // TODO add your handling code here:
        profesor.setState(profesor.ICONIFIED);
    }//GEN-LAST:event_Minimizar1MouseClicked

    private void jLabel89MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel89MouseClicked
        // TODO add your handling code here:
        int dialog = JOptionPane.YES_NO_OPTION;
        int results = JOptionPane.showConfirmDialog(null, "¿Desea salir?", "Exit", dialog);
        if (results == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_jLabel89MouseClicked

    private void txt_USERPROFESORMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_USERPROFESORMouseClicked
        // TODO add your handling code here:
        txt_USERPROFESOR.setText("");
    }//GEN-LAST:event_txt_USERPROFESORMouseClicked

    private void txt_CONTRASEÑAPROFESORMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CONTRASEÑAPROFESORMouseClicked
        // TODO add your handling code here:
        txt_CONTRASEÑAPROFESOR.setText("");
    }//GEN-LAST:event_txt_CONTRASEÑAPROFESORMouseClicked

    private void Minimizar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Minimizar2MouseClicked
        // TODO add your handling code here:
        profesor2.setState(profesor2.ICONIFIED);
    }//GEN-LAST:event_Minimizar2MouseClicked

    private void jLabel90MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel90MouseClicked
        // TODO add your handling code here:
        int dialog = JOptionPane.YES_NO_OPTION;
        int results = JOptionPane.showConfirmDialog(null, "¿Desea salir?", "Exit", dialog);
        if (results == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_jLabel90MouseClicked

    private void Minimizar3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Minimizar3MouseClicked
        // TODO add your handling code here:
        Registro_profesor.setState(Registro_profesor.ICONIFIED);
    }//GEN-LAST:event_Minimizar3MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        int dialog = JOptionPane.YES_NO_OPTION;
        int results = JOptionPane.showConfirmDialog(null, "¿Desea cerrar?", "Exit", dialog);
        if (results == 0) {
            LimpiarRegistroProfesor();
            Registro_profesor.show(false);
            profesor.show(true);
        }
    }//GEN-LAST:event_jLabel6MouseClicked

    private void Minimizar4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Minimizar4MouseClicked
        // TODO add your handling code here:
        Administrador.setState(Administrador.ICONIFIED);
    }//GEN-LAST:event_Minimizar4MouseClicked

    private void jLabel91MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel91MouseClicked
        // TODO add your handling code here:
        int dialog = JOptionPane.YES_NO_OPTION;
        int results = JOptionPane.showConfirmDialog(null, "¿Desea salir?", "Exit", dialog);
        if (results == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_jLabel91MouseClicked

    private void txt_USER_ADMINISTRADORActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_USER_ADMINISTRADORActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_USER_ADMINISTRADORActionPerformed

    private void txt_USUARIOREGISTROKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_USUARIOREGISTROKeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!numeros) {
            evt.consume();
        }

        if (txt_USUARIOREGISTRO.getText().trim().length() == 9) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_USUARIOREGISTROKeyTyped

    private void txt_CONTRASEÑAREGISTRO1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CONTRASEÑAREGISTRO1KeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!numeros) {
            evt.consume();
        }

        if (txt_CONTRASEÑAREGISTRO1.getText().trim().length() == 9) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_CONTRASEÑAREGISTRO1KeyTyped

    private void txt_CONTRASEÑAREGISTRO2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CONTRASEÑAREGISTRO2KeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!numeros) {
            evt.consume();
        }

        if (txt_CONTRASEÑAREGISTRO2.getText().trim().length() == 9) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_CONTRASEÑAREGISTRO2KeyTyped

    private void txt_TELEFONOREGISTRO1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_TELEFONOREGISTRO1KeyTyped
        // TODO add your handling code here:int key = evt.getKeyChar();
        int key = evt.getKeyChar();
        boolean numeros = key >= 48 && key <= 57;

        if (!numeros) {
            evt.consume();
        }

        if (txt_TELEFONOREGISTRO1.getText().trim().length() == 9) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_TELEFONOREGISTRO1KeyTyped

    private void txt_TELEFONOREGISTRO2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_TELEFONOREGISTRO2KeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();
        boolean numeros = key >= 48 && key <= 57;

        if (!numeros) {
            evt.consume();
        }

        if (txt_TELEFONOREGISTRO2.getText().trim().length() == 9) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_TELEFONOREGISTRO2KeyTyped

    private void txt_USERPROFESORKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_USERPROFESORKeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!numeros) {
            evt.consume();
        }

        if (txt_USERPROFESOR.getText().trim().length() == 9) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_USERPROFESORKeyTyped

    private void txt_CONTRASEÑAPROFESORKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CONTRASEÑAPROFESORKeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!numeros) {
            evt.consume();
        }

        if (txt_CONTRASEÑAPROFESOR.getText().trim().length() == 9) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_CONTRASEÑAPROFESORKeyTyped

    private void txt_USER_ADMINISTRADORKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_USER_ADMINISTRADORKeyTyped
        // TODO add your handling code here:
         int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!numeros) {
            evt.consume();
        }

        if (txt_USER_ADMINISTRADOR.getText().trim().length() == 9) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_USER_ADMINISTRADORKeyTyped

    private void txt_CONTRASEÑA_ADMINISTRADORKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CONTRASEÑA_ADMINISTRADORKeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!numeros) {
            evt.consume();
        }

        if (txt_CONTRASEÑA_ADMINISTRADOR.getText().trim().length() == 9) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_CONTRASEÑA_ADMINISTRADORKeyTyped

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Seleccion.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Seleccion.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Seleccion.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Seleccion.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Seleccion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADMI;
    private javax.swing.JFrame Administrador;
    private javax.swing.JPanel BIENVENIDA;
    private javax.swing.JButton BTN_ELIMINAR;
    private javax.swing.JButton BUSCARDATOS;
    private javax.swing.JButton CONSULTAR;
    private javax.swing.JButton Estudiante;
    private javax.swing.JTextField Ingresotxt18;
    private javax.swing.JButton Inicio1;
    private javax.swing.JButton Inicio2;
    private javax.swing.JLabel Minimizar;
    private javax.swing.JLabel Minimizar1;
    private javax.swing.JLabel Minimizar2;
    private javax.swing.JLabel Minimizar3;
    private javax.swing.JLabel Minimizar4;
    private javax.swing.JTabbedPane Panelpestaña;
    private javax.swing.JButton REGISTRAR;
    private javax.swing.JFrame Registro_profesor;
    private javax.swing.JComboBox<String> TIPO_CUENTA;
    private javax.swing.JTable TablaDatosAdministrador;
    private javax.swing.JTable TablaDatosContenidoProfesor;
    private javax.swing.JTable TablaDatosProfesor;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btn_ACTUALIZAR;
    private javax.swing.JButton btn_ACTUALIZARCURSO;
    private javax.swing.JButton btn_BUSCARCONTENIDO;
    private javax.swing.JButton btn_BUSCARMODIFICAR;
    private javax.swing.JButton btn_INGRESARCURSO;
    private javax.swing.JComboBox<String> cbox_CONSULTACONTENIDO;
    private javax.swing.JComboBox<String> cbox_CONSULTAPROFESOR;
    private javax.swing.JComboBox<String> cbox_CURSO;
    private javax.swing.JComboBox<String> cbox_CURSOMONTAR;
    private javax.swing.JFrame ingadmin;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<String> jCOMBO_BUSCARADMIN1;
    private javax.swing.JComboBox<String> jCOMBO_BUSCARADMIN2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel label_PERTENECE;
    private javax.swing.JFrame profesor;
    private javax.swing.JFrame profesor2;
    private javax.swing.JLabel titulo;
    private javax.swing.JTextField txt_APELLIDOSREGISTRO;
    private javax.swing.JTextField txt_BUSCARADMINISTRADOR;
    private javax.swing.JTextField txt_BUSCARCONTENIDO;
    private javax.swing.JTextField txt_BUSCARESTUDIANTEPROFESOR;
    private javax.swing.JTextField txt_BUSCARUSERMOD;
    private javax.swing.JTextField txt_CONTRASEÑAMOD;
    private javax.swing.JPasswordField txt_CONTRASEÑAPROFESOR;
    private javax.swing.JTextField txt_CONTRASEÑAREGISTRO1;
    private javax.swing.JTextField txt_CONTRASEÑAREGISTRO2;
    private javax.swing.JPasswordField txt_CONTRASEÑA_ADMINISTRADOR;
    private javax.swing.JTextField txt_CORREO1;
    private javax.swing.JTextField txt_CORREO2;
    private javax.swing.JTextField txt_CORREOREGISTRO1;
    private javax.swing.JTextField txt_CORREOREGISTRO2;
    private javax.swing.JTextField txt_CREACIONAPELLIDOADMIN;
    private javax.swing.JPasswordField txt_CREACIONCONTRASEÑA2ADMIN;
    private javax.swing.JPasswordField txt_CREACIONCONTRASEÑAADMIN;
    private javax.swing.JTextField txt_CREACIONCORREOADMIN;
    private javax.swing.JTextField txt_CREACIONCORREOADMIN1;
    private javax.swing.JTextField txt_CREACIONDIRECCIONADMIN;
    private javax.swing.JTextField txt_CREACIONDIRECCIONADMIN1;
    private javax.swing.JTextField txt_CREACIONNOMBREADMIN;
    private javax.swing.JTextField txt_CREACIONTELEFONOADMIN;
    private javax.swing.JTextField txt_CREACIONTELEFONOADMIN1;
    private javax.swing.JTextField txt_CREACIONUSUARIOADMIN;
    private javax.swing.JTextField txt_ContraseñaAntigua;
    private javax.swing.JTextField txt_ContraseñaNueva1;
    private javax.swing.JTextField txt_ContraseñaNueva2;
    private javax.swing.JTextField txt_DESCRIPCION;
    private javax.swing.JTextField txt_DIRECCIONREGISTRO1;
    private javax.swing.JTextField txt_DIRECCIONREGISTRO2;
    private javax.swing.JTextField txt_LINK;
    private javax.swing.JTextField txt_MODAPELLIDO;
    private javax.swing.JTextField txt_MODDIR1;
    private javax.swing.JTextField txt_MODDIR2;
    private javax.swing.JTextField txt_MODNOMBRE;
    private javax.swing.JTextField txt_MODTELEFONO1;
    private javax.swing.JTextField txt_MODTELEFONO2;
    private javax.swing.JTextField txt_MODUSER;
    private javax.swing.JTextField txt_NOMBRECONTENIDO;
    private javax.swing.JTextField txt_NOMBREREGISTRO;
    private javax.swing.JTextField txt_TELEFONOREGISTRO1;
    private javax.swing.JTextField txt_TELEFONOREGISTRO2;
    private javax.swing.JTextField txt_USERPROFESOR;
    private javax.swing.JTextField txt_USER_ADMINISTRADOR;
    private javax.swing.JTextField txt_USUARIOREGISTRO;
    // End of variables declaration//GEN-END:variables
}
