
import Conexion.ConexionDB;
import Conexion.MetodosSQL;
import static Conexion.MetodosSQL.Consulta;
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Ingreso extends javax.swing.JFrame {

    /**
     * Creates new form Diseño
     */
    int Userglob = 0;

    public Ingreso() {
        initComponents();
        jp_CURSOS.setEnabledAt(1, false);
        jp_CURSOS.setEnabledAt(2, false);
        jp_CURSOS.setEnabledAt(3, false);
        jp_CURSOS.setEnabledAt(4, false);
        jp_CURSOS.setEnabledAt(5, false);
        this.setLocationRelativeTo(null);
        this.setSize(1090, 700);
        Registro.setLocationRelativeTo(null);
        Registro.setResizable(false);
        Estudiante.setLocationRelativeTo(null);
        Estudiante.setResizable(false);
        biologia.setSize(1090, 700);
        Matematicas.setSize(1090, 700);
        competencias.setSize(1090, 700);
        Ingles.setSize(1090, 700);
        Lectura_critica.setSize(1090, 700);
        biologia.setLocationRelativeTo(null);
        Matematicas.setLocationRelativeTo(null);
        Ingles.setLocationRelativeTo(null);
        competencias.setLocationRelativeTo(null);
        Lectura_critica.setLocationRelativeTo(null);
        biologia.setResizable(false);
        Matematicas.setResizable(false);
        competencias.setResizable(false);
        Ingles.setResizable(false);
        Lectura_critica.setResizable(false);

    }

    public void Buscar_Cursos(String tipo) {
        try {
            PreparedStatement Comando;
            ResultSet Consulta;
            Comando = MetodosSQL.BuscarCursoUser(Userglob, tipo);
            Consulta = Comando.executeQuery();
            while (Consulta.next()) {
                if (Consulta.getString("NOMBRE_CURSO").equals("MATEMATICA")) {
                    jp_CURSOS.setEnabledAt(1, true);
                }
                if (Consulta.getString("NOMBRE_CURSO").equals("LECTURA CRITICA")) {
                    jp_CURSOS.setEnabledAt(2, true);
                }
                if (Consulta.getString("NOMBRE_CURSO").equals("INGLES")) {
                    jp_CURSOS.setEnabledAt(3, true);
                }
                if (Consulta.getString("NOMBRE_CURSO").equals("COMPETENCIAS CIUDADANAS")) {
                    jp_CURSOS.setEnabledAt(4, true);
                }
                if (Consulta.getString("NOMBRE_CURSO").equals("BIOLOGÍA")) {
                    jp_CURSOS.setEnabledAt(5, true);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void LimpiarEstudiante() {
        jp_CURSOS.setEnabledAt(1, false);
        jp_CURSOS.setEnabledAt(2, false);
        jp_CURSOS.setEnabledAt(3, false);
        jp_CURSOS.setEnabledAt(4, false);
        jp_CURSOS.setEnabledAt(5, false);
        cbox_AGREGARCURSOESTUDIANTE.setSelectedIndex(0);
        cbox_MATEMATICAS.setSelectedIndex(0);
        cbox_LECTURACRITICA.setSelectedIndex(0);
        cbox_INGLES.setSelectedIndex(0);
        cbox_COMPETENCIAS.setSelectedIndex(0);
        cbox_BIOLOGIA.setSelectedIndex(0);
        txt_BUSCARMATEMATICA.setText("");
        txt_LECTURACRITICA.setText("");
        txt_INGLES.setText("");
        txt_COMPETENCIAS.setText("");
        txt_BIOLOGIA.setText("");
        txt_INGRESOESTUDIANTE.setText("");
        txt_CONTRASEÑAESTUDIANTE.setText("");
        //JTABLE "MATEMATICAS"
        try {
            DefaultTableModel temp;
            temp = (DefaultTableModel) MATEMATICAS.getModel();
            int a = temp.getRowCount() - 1;
            for (int i = 0; i <= a; i++) {
                temp.removeRow(0);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        //////////////////////////////////////////////////
        //JTABLE "LECTURACRITICA"
        try {
            DefaultTableModel temp;
            temp = (DefaultTableModel) LECTURACRITICA.getModel();
            int a = temp.getRowCount() - 1;
            for (int i = 0; i <= a; i++) {
                temp.removeRow(0);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        //////////////////////////////////////////////////
        //JTABLE "INGLES"
        try {
            DefaultTableModel temp;
            temp = (DefaultTableModel) INGLES.getModel();
            int a = temp.getRowCount() - 1;
            for (int i = 0; i <= a; i++) {
                temp.removeRow(0);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        //////////////////////////////////////////////////
        //JTABLE "COMPETENCIAS"
        try {
            DefaultTableModel temp;
            temp = (DefaultTableModel) COMPETENCIAS.getModel();
            int a = temp.getRowCount() - 1;
            for (int i = 0; i <= a; i++) {
                temp.removeRow(0);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        //////////////////////////////////////////////////
        //JTABLE "BIOLOGIA"
        try {
            DefaultTableModel temp;
            temp = (DefaultTableModel) BIOLOGIA.getModel();
            int a = temp.getRowCount() - 1;
            for (int i = 0; i <= a; i++) {
                temp.removeRow(0);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        //////////////////////////////////////////////////
    }

    public void Eliminar_estudiante_Contraseña() {
        txt_ContraseñaAntiguaEsudiante.setText("");
        txt_ContraseñaNueva1Esudiante.setText("");
        txt_ContraseñaNueva2Esudiante.setText("");
    }

    public boolean Cadnumerica(String cad) {
        boolean isNumeric = cad.matches("[+-]?\\d*(\\.\\d+)?");
        return isNumeric;
    }

    public void Abrir_link() {
        String link = null;
        int fila = MATEMATICAS.getSelectedRow();
        String valor = MATEMATICAS.getValueAt(fila, 0).toString();
        PreparedStatement buscar;

        try {
            String sentencia = ("SELECT CONTENIDO FROM CONTENIDO WHERE  \"NRO-CONTENIDO\"= '" + valor + "'");
            buscar = ConexionDB.conectar().prepareStatement(sentencia);
            Consulta = buscar.executeQuery();
            if (Consulta.next()) {
                link = Consulta.getNString("CONTENIDO");
            }
            if (java.awt.Desktop.isDesktopSupported()) {
                java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
                if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
                    try {
                        java.net.URI uri = new java.net.URI(link);
                        desktop.browse(uri);
                    } catch (URISyntaxException | IOException ex) {
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("ERRORRRRRRRR");
        }
    }

    public void Abrir_link_lecturac() {
        String link = null;
        int fila = LECTURACRITICA.getSelectedRow();
        String valor = LECTURACRITICA.getValueAt(fila, 0).toString();
        PreparedStatement buscar;

        try {
            String sentencia = ("SELECT CONTENIDO FROM CONTENIDO WHERE  \"NRO-CONTENIDO\"= '" + valor + "'");
            buscar = ConexionDB.conectar().prepareStatement(sentencia);
            Consulta = buscar.executeQuery();
            if (Consulta.next()) {
                link = Consulta.getNString("CONTENIDO");
            }
            if (java.awt.Desktop.isDesktopSupported()) {
                java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
                if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
                    try {
                        java.net.URI uri = new java.net.URI(link);
                        desktop.browse(uri);
                    } catch (URISyntaxException | IOException ex) {
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("ERRORRRRRRRR");
        }
    }

    public void Abrir_link_ingles() {
        String link = null;
        int fila = INGLES.getSelectedRow();
        String valor = INGLES.getValueAt(fila, 0).toString();
        PreparedStatement buscar;

        try {
            String sentencia = ("SELECT CONTENIDO FROM CONTENIDO WHERE  \"NRO-CONTENIDO\"= '" + valor + "'");
            buscar = ConexionDB.conectar().prepareStatement(sentencia);
            Consulta = buscar.executeQuery();
            if (Consulta.next()) {
                link = Consulta.getNString("CONTENIDO");
            }
            if (java.awt.Desktop.isDesktopSupported()) {
                java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
                if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
                    try {
                        java.net.URI uri = new java.net.URI(link);
                        desktop.browse(uri);
                    } catch (URISyntaxException | IOException ex) {
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("ERRORRRRRRRR");
        }
    }

    public void Abrir_link_competencias() {
        String link = null;
        int fila = COMPETENCIAS.getSelectedRow();
        String valor = COMPETENCIAS.getValueAt(fila, 0).toString();
        PreparedStatement buscar;

        try {
            String sentencia = ("SELECT CONTENIDO FROM CONTENIDO WHERE  \"NRO-CONTENIDO\"= '" + valor + "'");
            buscar = ConexionDB.conectar().prepareStatement(sentencia);
            Consulta = buscar.executeQuery();
            if (Consulta.next()) {
                link = Consulta.getNString("CONTENIDO");
            }
            if (java.awt.Desktop.isDesktopSupported()) {
                java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
                if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
                    try {
                        java.net.URI uri = new java.net.URI(link);
                        desktop.browse(uri);
                    } catch (URISyntaxException | IOException ex) {
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("ERRORRRRRRRR");
        }
    }

    public void Abrir_link_Biologia() {
        String link = null;
        int fila = BIOLOGIA.getSelectedRow();
        String valor = BIOLOGIA.getValueAt(fila, 0).toString();
        PreparedStatement buscar;

        try {
            String sentencia = ("SELECT CONTENIDO FROM CONTENIDO WHERE  \"NRO-CONTENIDO\"= '" + valor + "'");
            buscar = ConexionDB.conectar().prepareStatement(sentencia);
            Consulta = buscar.executeQuery();
            if (Consulta.next()) {
                link = Consulta.getNString("CONTENIDO");
            }
            if (java.awt.Desktop.isDesktopSupported()) {
                java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
                if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
                    try {
                        java.net.URI uri = new java.net.URI(link);
                        desktop.browse(uri);
                    } catch (URISyntaxException | IOException ex) {
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("ERRORRRRRRRR");
        }
    }

    public void LimpiarRegistroEstudiante() {
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Registro = new javax.swing.JFrame();
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
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        Estudiante = new javax.swing.JFrame();
        jPanel5 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        SIGUIENTE1 = new javax.swing.JButton();
        jLabel49 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jp_CURSOS = new javax.swing.JTabbedPane();
        jp_AÑADIRCURSO = new javax.swing.JPanel();
        cbox_AGREGARCURSOESTUDIANTE = new javax.swing.JComboBox<>();
        jLabel35 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jp_MATEMATICAS = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jp_LECTURACRITICA = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jp_INGLES = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jp_COMPETENCIAS = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jp_BIOLOGIA = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        btnActualizarEsudiante = new javax.swing.JButton();
        jLabel72 = new javax.swing.JLabel();
        txt_ContraseñaAntiguaEsudiante = new javax.swing.JPasswordField();
        txt_ContraseñaNueva1Esudiante = new javax.swing.JPasswordField();
        txt_ContraseñaNueva2Esudiante = new javax.swing.JPasswordField();
        Matematicas = new javax.swing.JFrame();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        MATEMATICAS = new javax.swing.JTable();
        jLabel28 = new javax.swing.JLabel();
        btn_BUSCARMATEMATICAS = new javax.swing.JButton();
        txt_BUSCARMATEMATICA = new javax.swing.JTextField();
        cbox_MATEMATICAS = new javax.swing.JComboBox<>();
        salir = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        Lectura_critica = new javax.swing.JFrame();
        jPanel21 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        LECTURACRITICA = new javax.swing.JTable();
        jLabel29 = new javax.swing.JLabel();
        btn_LECTURACRITICA = new javax.swing.JButton();
        cbox_LECTURACRITICA = new javax.swing.JComboBox<>();
        txt_LECTURACRITICA = new javax.swing.JTextField();
        salir1 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        Ingles = new javax.swing.JFrame();
        jPanel22 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        INGLES = new javax.swing.JTable();
        jLabel30 = new javax.swing.JLabel();
        txt_INGLES = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        cbox_INGLES = new javax.swing.JComboBox<>();
        salir2 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        Abrir_Ingles = new javax.swing.JButton();
        competencias = new javax.swing.JFrame();
        jPanel23 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        COMPETENCIAS = new javax.swing.JTable();
        jLabel31 = new javax.swing.JLabel();
        btn_COMPETENCIAS = new javax.swing.JButton();
        txt_COMPETENCIAS = new javax.swing.JTextField();
        cbox_COMPETENCIAS = new javax.swing.JComboBox<>();
        salir3 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        Abrir_Ingles1 = new javax.swing.JButton();
        biologia = new javax.swing.JFrame();
        jPanel24 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        BIOLOGIA = new javax.swing.JTable();
        jLabel32 = new javax.swing.JLabel();
        txt_BIOLOGIA = new javax.swing.JTextField();
        cbox_BIOLOGIA = new javax.swing.JComboBox<>();
        btn_BIOLOGIA = new javax.swing.JButton();
        salir4 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        Abrir_Ingles2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Ingreso = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_INGRESOESTUDIANTE = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        txt_CONTRASEÑAESTUDIANTE = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Inicio1 = new javax.swing.JButton();
        Btnregistro = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        Registro.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        Registro.setUndecorated(true);
        Registro.setSize(new java.awt.Dimension(1081, 603));
        Registro.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_Expand_Arrow_32px.png"))); // NOI18N
        jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_Multiply_32px.png"))); // NOI18N
        jLabel16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Castellar", 1, 14)); // NOI18N
        jLabel19.setText("OPCIONAL");

        jLabel50.setFont(new java.awt.Font("Castellar", 1, 14)); // NOI18N
        jLabel50.setText("OPCIONAL");

        jLabel51.setFont(new java.awt.Font("Castellar", 1, 14)); // NOI18N
        jLabel51.setText("OPCIONAL");

        jLabel98.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/registrado.png"))); // NOI18N

        jLabel99.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/actualizar-base-de-datos.png"))); // NOI18N

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel98)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(377, 377, 377)
                .addComponent(jLabel15)
                .addGap(50, 50, 50))
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                                    .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18))
                                .addComponent(jLabel77, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel86, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel16))
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel32Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
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
                                                .addGap(235, 235, 235)
                                                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(jPanel32Layout.createSequentialGroup()
                                                        .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(txt_APELLIDOSREGISTRO, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel32Layout.createSequentialGroup()
                                                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jLabel79, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(txt_CONTRASEÑAREGISTRO1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(txt_DIRECCIONREGISTRO2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(txt_TELEFONOREGISTRO2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(txt_CORREOREGISTRO2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(txt_CONTRASEÑAREGISTRO2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addComponent(jLabel19)))
                                            .addGroup(jPanel32Layout.createSequentialGroup()
                                                .addGap(240, 240, 240)
                                                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel50)))))))
                            .addGroup(jPanel32Layout.createSequentialGroup()
                                .addGap(476, 476, 476)
                                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel51)))))
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addGap(390, 390, 390)
                        .addComponent(jLabel99)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel98)))
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_NOMBREREGISTRO, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel76)
                    .addComponent(jLabel75)
                    .addComponent(txt_APELLIDOSREGISTRO, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel77)
                    .addComponent(txt_USUARIOREGISTRO, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel78)
                    .addComponent(txt_CONTRASEÑAREGISTRO1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_CONTRASEÑAREGISTRO2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel86)
                    .addComponent(txt_DIRECCIONREGISTRO1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel79)
                    .addComponent(txt_DIRECCIONREGISTRO2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addGap(57, 57, 57)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel81)
                    .addComponent(txt_TELEFONOREGISTRO1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel85)
                    .addComponent(txt_TELEFONOREGISTRO2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(jLabel51)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel84)
                            .addComponent(txt_CORREOREGISTRO2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel50))
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel82)
                            .addGroup(jPanel32Layout.createSequentialGroup()
                                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_CORREOREGISTRO1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel80))
                                .addGap(44, 44, 44)
                                .addComponent(jLabel99)))))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        Registro.getContentPane().add(jPanel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 630));

        Estudiante.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        Estudiante.setUndecorated(true);
        Estudiante.setSize(new java.awt.Dimension(1090, 690));
        Estudiante.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel15.setBackground(new java.awt.Color(0, 155, 155));

        jLabel14.setFont(new java.awt.Font("Castellar", 1, 18)); // NOI18N
        jLabel14.setText("BIENVENIDO **********");

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/escribir (2).png"))); // NOI18N

        SIGUIENTE1.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        SIGUIENTE1.setText("CERRAR SESIÓN");
        SIGUIENTE1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SIGUIENTE1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SIGUIENTE1ActionPerformed(evt);
            }
        });

        jLabel49.setFont(new java.awt.Font("Castellar", 1, 48)); // NOI18N
        jLabel49.setText("EDUFUTUME");
        jLabel49.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_Expand_Arrow_32px.png"))); // NOI18N
        jLabel17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_Multiply_32px.png"))); // NOI18N
        jLabel18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel34)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel49)
                        .addGap(117, 117, 117)
                        .addComponent(SIGUIENTE1)
                        .addGap(82, 82, 82))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18)))
                .addGap(45, 45, 45))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel49))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(SIGUIENTE1))))
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(jLabel33)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1090, 150));

        jPanel19.setBackground(new java.awt.Color(0, 204, 204));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 1090, 20));

        jp_CURSOS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jp_CURSOS.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N

        jp_AÑADIRCURSO.setBackground(new java.awt.Color(255, 255, 255));
        jp_AÑADIRCURSO.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        cbox_AGREGARCURSOESTUDIANTE.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N
        cbox_AGREGARCURSOESTUDIANTE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONAR", "MATEMATICA", "LECTURA CRITICA", "INGLES", "COMPETENCIAS CIUDADANAS", "BIOLOGÍA" }));
        cbox_AGREGARCURSOESTUDIANTE.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel35.setFont(new java.awt.Font("Castellar", 0, 24)); // NOI18N
        jLabel35.setText("AGREGAR CURSO");

        jButton8.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        jButton8.setText("AGREGAR");
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lapiz.png"))); // NOI18N

        jLabel54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/anadir.png"))); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/libro (1).png"))); // NOI18N

        javax.swing.GroupLayout jp_AÑADIRCURSOLayout = new javax.swing.GroupLayout(jp_AÑADIRCURSO);
        jp_AÑADIRCURSO.setLayout(jp_AÑADIRCURSOLayout);
        jp_AÑADIRCURSOLayout.setHorizontalGroup(
            jp_AÑADIRCURSOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_AÑADIRCURSOLayout.createSequentialGroup()
                .addGap(364, 364, 364)
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jp_AÑADIRCURSOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jp_AÑADIRCURSOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(cbox_AGREGARCURSOESTUDIANTE, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jp_AÑADIRCURSOLayout.createSequentialGroup()
                            .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton8)
                            .addGap(69, 69, 69)))
                    .addComponent(jLabel35))
                .addGap(1106, 1247, Short.MAX_VALUE))
        );
        jp_AÑADIRCURSOLayout.setVerticalGroup(
            jp_AÑADIRCURSOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_AÑADIRCURSOLayout.createSequentialGroup()
                .addGroup(jp_AÑADIRCURSOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_AÑADIRCURSOLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jp_AÑADIRCURSOLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbox_AGREGARCURSOESTUDIANTE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_AÑADIRCURSOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton8)
                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );

        jp_CURSOS.addTab("AÑADIR CURSO", jp_AÑADIRCURSO);

        jp_MATEMATICAS.setBackground(new java.awt.Color(255, 255, 255));
        jp_MATEMATICAS.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel22.setFont(new java.awt.Font("Castellar", 1, 24)); // NOI18N
        jLabel22.setText("INGRESO");
        jLabel22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/calculadora (2).png"))); // NOI18N

        javax.swing.GroupLayout jp_MATEMATICASLayout = new javax.swing.GroupLayout(jp_MATEMATICAS);
        jp_MATEMATICAS.setLayout(jp_MATEMATICASLayout);
        jp_MATEMATICASLayout.setHorizontalGroup(
            jp_MATEMATICASLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_MATEMATICASLayout.createSequentialGroup()
                .addGroup(jp_MATEMATICASLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_MATEMATICASLayout.createSequentialGroup()
                        .addGap(395, 395, 395)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jp_MATEMATICASLayout.createSequentialGroup()
                        .addGap(460, 460, 460)
                        .addComponent(jLabel22)))
                .addContainerGap(1199, Short.MAX_VALUE))
        );
        jp_MATEMATICASLayout.setVerticalGroup(
            jp_MATEMATICASLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_MATEMATICASLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jLabel22)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        jp_CURSOS.addTab("MATEMÁTICAS", jp_MATEMATICAS);

        jp_LECTURACRITICA.setBackground(new java.awt.Color(255, 255, 255));
        jp_LECTURACRITICA.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel26.setFont(new java.awt.Font("Castellar", 1, 24)); // NOI18N
        jLabel26.setText("INGRESO");
        jLabel26.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel26MouseClicked(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/estante-para-libros.png"))); // NOI18N

        javax.swing.GroupLayout jp_LECTURACRITICALayout = new javax.swing.GroupLayout(jp_LECTURACRITICA);
        jp_LECTURACRITICA.setLayout(jp_LECTURACRITICALayout);
        jp_LECTURACRITICALayout.setHorizontalGroup(
            jp_LECTURACRITICALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_LECTURACRITICALayout.createSequentialGroup()
                .addGroup(jp_LECTURACRITICALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_LECTURACRITICALayout.createSequentialGroup()
                        .addGap(450, 450, 450)
                        .addComponent(jLabel26))
                    .addGroup(jp_LECTURACRITICALayout.createSequentialGroup()
                        .addGap(392, 392, 392)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(1215, Short.MAX_VALUE))
        );
        jp_LECTURACRITICALayout.setVerticalGroup(
            jp_LECTURACRITICALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_LECTURACRITICALayout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel26)
                .addGap(81, 81, 81))
        );

        jp_CURSOS.addTab("LECTURA CRÍTICA", jp_LECTURACRITICA);

        jp_INGLES.setBackground(new java.awt.Color(255, 255, 255));
        jp_INGLES.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel24.setFont(new java.awt.Font("Castellar", 1, 24)); // NOI18N
        jLabel24.setText("INGRESO");
        jLabel24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eng.png"))); // NOI18N

        javax.swing.GroupLayout jp_INGLESLayout = new javax.swing.GroupLayout(jp_INGLES);
        jp_INGLES.setLayout(jp_INGLESLayout);
        jp_INGLESLayout.setHorizontalGroup(
            jp_INGLESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_INGLESLayout.createSequentialGroup()
                .addGroup(jp_INGLESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_INGLESLayout.createSequentialGroup()
                        .addGap(475, 475, 475)
                        .addComponent(jLabel24))
                    .addGroup(jp_INGLESLayout.createSequentialGroup()
                        .addGap(414, 414, 414)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(1232, Short.MAX_VALUE))
        );
        jp_INGLESLayout.setVerticalGroup(
            jp_INGLESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_INGLESLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addGap(85, 85, 85))
        );

        jp_CURSOS.addTab("INGLÉS", jp_INGLES);

        jp_COMPETENCIAS.setBackground(new java.awt.Color(255, 255, 255));
        jp_COMPETENCIAS.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel36.setFont(new java.awt.Font("Castellar", 1, 24)); // NOI18N
        jLabel36.setText("INGRESO");
        jLabel36.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel36MouseClicked(evt);
            }
        });
        jLabel36.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel36KeyPressed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/derechos-civiles.png"))); // NOI18N

        javax.swing.GroupLayout jp_COMPETENCIASLayout = new javax.swing.GroupLayout(jp_COMPETENCIAS);
        jp_COMPETENCIAS.setLayout(jp_COMPETENCIASLayout);
        jp_COMPETENCIASLayout.setHorizontalGroup(
            jp_COMPETENCIASLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_COMPETENCIASLayout.createSequentialGroup()
                .addGroup(jp_COMPETENCIASLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_COMPETENCIASLayout.createSequentialGroup()
                        .addGap(487, 487, 487)
                        .addComponent(jLabel36))
                    .addGroup(jp_COMPETENCIASLayout.createSequentialGroup()
                        .addGap(426, 426, 426)
                        .addComponent(jLabel38)))
                .addContainerGap(1245, Short.MAX_VALUE))
        );
        jp_COMPETENCIASLayout.setVerticalGroup(
            jp_COMPETENCIASLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_COMPETENCIASLayout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(jLabel36)
                .addGap(83, 83, 83))
        );

        jp_CURSOS.addTab("COMPETENCIAS CIUDADANAS", jp_COMPETENCIAS);

        jp_BIOLOGIA.setBackground(new java.awt.Color(255, 255, 255));
        jp_BIOLOGIA.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel37.setFont(new java.awt.Font("Castellar", 1, 24)); // NOI18N
        jLabel37.setText("INGRESO");
        jLabel37.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel37MouseClicked(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/biologia.png"))); // NOI18N

        javax.swing.GroupLayout jp_BIOLOGIALayout = new javax.swing.GroupLayout(jp_BIOLOGIA);
        jp_BIOLOGIA.setLayout(jp_BIOLOGIALayout);
        jp_BIOLOGIALayout.setHorizontalGroup(
            jp_BIOLOGIALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_BIOLOGIALayout.createSequentialGroup()
                .addGroup(jp_BIOLOGIALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_BIOLOGIALayout.createSequentialGroup()
                        .addGap(480, 480, 480)
                        .addComponent(jLabel37))
                    .addGroup(jp_BIOLOGIALayout.createSequentialGroup()
                        .addGap(420, 420, 420)
                        .addComponent(jLabel39)))
                .addContainerGap(1251, Short.MAX_VALUE))
        );
        jp_BIOLOGIALayout.setVerticalGroup(
            jp_BIOLOGIALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_BIOLOGIALayout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel37)
                .addGap(69, 69, 69))
        );

        jp_CURSOS.addTab("BIOLOGÍA", jp_BIOLOGIA);

        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));

        jLabel68.setFont(new java.awt.Font("Castellar", 0, 24)); // NOI18N
        jLabel68.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel68.setText("MODIFICACION USUARIOS");

        jLabel69.setFont(new java.awt.Font("Castellar", 1, 14)); // NOI18N
        jLabel69.setText("CONTRASEÑA ANTIGUA:");

        jLabel70.setFont(new java.awt.Font("Castellar", 1, 14)); // NOI18N
        jLabel70.setText("CONTRASEÑA NUEVA:");

        btnActualizarEsudiante.setFont(new java.awt.Font("Castellar", 1, 14)); // NOI18N
        btnActualizarEsudiante.setText("ACTUALIZAR");
        btnActualizarEsudiante.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizarEsudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarEsudianteActionPerformed(evt);
            }
        });

        jLabel72.setFont(new java.awt.Font("Castellar", 1, 14)); // NOI18N
        jLabel72.setText("CONTRASEÑA NUEVA:");

        txt_ContraseñaAntiguaEsudiante.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N
        txt_ContraseñaAntiguaEsudiante.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        txt_ContraseñaNueva1Esudiante.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N
        txt_ContraseñaNueva1Esudiante.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        txt_ContraseñaNueva2Esudiante.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N
        txt_ContraseñaNueva2Esudiante.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_ContraseñaNueva1Esudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel69, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                                    .addComponent(jLabel72, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel70, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel27Layout.createSequentialGroup()
                                        .addGap(48, 48, 48)
                                        .addComponent(txt_ContraseñaAntiguaEsudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_ContraseñaNueva2Esudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGap(285, 285, 285)
                        .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGap(453, 453, 453)
                        .addComponent(btnActualizarEsudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(527, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel69)
                            .addComponent(txt_ContraseñaAntiguaEsudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(167, 167, 167)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel70)
                            .addComponent(txt_ContraseñaNueva2Esudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel72)
                            .addComponent(txt_ContraseñaNueva1Esudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(btnActualizarEsudiante)
                .addGap(53, 53, 53))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 680, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jp_CURSOS.addTab("MODIFICAR CONTRASEÑA", jPanel4);

        jPanel5.add(jp_CURSOS, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, -1, 530));
        jp_CURSOS.getAccessibleContext().setAccessibleDescription("");

        Estudiante.getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1090, 710));

        Matematicas.setUndecorated(true);
        Matematicas.setSize(new java.awt.Dimension(1090, 700));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        MATEMATICAS.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(MATEMATICAS);

        jLabel28.setFont(new java.awt.Font("Castellar", 1, 24)); // NOI18N
        jLabel28.setText("CONTENIDOS MATEMATICAS");

        btn_BUSCARMATEMATICAS.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        btn_BUSCARMATEMATICAS.setText("BUSCAR");
        btn_BUSCARMATEMATICAS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_BUSCARMATEMATICAS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BUSCARMATEMATICASActionPerformed(evt);
            }
        });

        txt_BUSCARMATEMATICA.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N

        cbox_MATEMATICAS.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        cbox_MATEMATICAS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...", "USUARIO PROFESOR", "NOMBRE CONTENIDO", "NUMERO CONTENIDO" }));
        cbox_MATEMATICAS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cerrar-sesion.png"))); // NOI18N
        salir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salirMouseClicked(evt);
            }
        });

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/camara-de-video.png"))); // NOI18N

        jButton2.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        jButton2.setText("ABRIR LINK");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel20)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txt_BUSCARMATEMATICA, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cbox_MATEMATICAS, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btn_BUSCARMATEMATICAS, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(salir)
                            .addGap(227, 227, 227)
                            .addComponent(jLabel21)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel28)
                            .addGap(193, 193, 193)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 802, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(422, 422, 422)
                        .addComponent(jButton2)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel28))))
                .addGap(35, 35, 35)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_BUSCARMATEMATICAS)
                        .addComponent(cbox_MATEMATICAS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_BUSCARMATEMATICA, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel20))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout MatematicasLayout = new javax.swing.GroupLayout(Matematicas.getContentPane());
        Matematicas.getContentPane().setLayout(MatematicasLayout);
        MatematicasLayout.setHorizontalGroup(
            MatematicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        MatematicasLayout.setVerticalGroup(
            MatematicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));

        LECTURACRITICA.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N
        jScrollPane2.setViewportView(LECTURACRITICA);

        jLabel29.setFont(new java.awt.Font("Castellar", 1, 24)); // NOI18N
        jLabel29.setText("CONTENIDOS LECTURA CRÍTICA");

        btn_LECTURACRITICA.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        btn_LECTURACRITICA.setText("BUSCAR");
        btn_LECTURACRITICA.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_LECTURACRITICA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LECTURACRITICAActionPerformed(evt);
            }
        });

        cbox_LECTURACRITICA.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        cbox_LECTURACRITICA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...", "USUARIO PROFESOR", "NOMBRE CONTENIDO", "NUMERO CONTENIDO" }));
        cbox_LECTURACRITICA.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txt_LECTURACRITICA.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N

        salir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cerrar-sesion.png"))); // NOI18N
        salir1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        salir1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salir1MouseClicked(evt);
            }
        });

        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/camara-de-video.png"))); // NOI18N

        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N

        jButton3.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        jButton3.setText("ABRIR LINK");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(salir1)
                        .addGap(250, 250, 250)
                        .addComponent(jLabel41)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel29)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                        .addGap(0, 149, Short.MAX_VALUE)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                                .addComponent(jLabel42)
                                .addGap(37, 37, 37)
                                .addComponent(txt_LECTURACRITICA, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(cbox_LECTURACRITICA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(btn_LECTURACRITICA)
                                .addGap(89, 89, 89))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 824, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(133, 133, 133))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(474, 474, 474))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel29)
                    .addComponent(salir1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41))
                .addGap(35, 35, 35)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbox_LECTURACRITICA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_LECTURACRITICA)
                        .addComponent(txt_LECTURACRITICA, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel42))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButton3)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Lectura_criticaLayout = new javax.swing.GroupLayout(Lectura_critica.getContentPane());
        Lectura_critica.getContentPane().setLayout(Lectura_criticaLayout);
        Lectura_criticaLayout.setHorizontalGroup(
            Lectura_criticaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Lectura_criticaLayout.setVerticalGroup(
            Lectura_criticaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));

        INGLES.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N
        jScrollPane3.setViewportView(INGLES);

        jLabel30.setFont(new java.awt.Font("Castellar", 1, 24)); // NOI18N
        jLabel30.setText("CONTENIDOS INGLÉS");

        txt_INGLES.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N

        jButton7.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        jButton7.setText("BUSCAR");
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        cbox_INGLES.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        cbox_INGLES.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...", "USUARIO PROFESOR", "NOMBRE CONTENIDO", "NUMERO CONTENIDO" }));
        cbox_INGLES.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        salir2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cerrar-sesion.png"))); // NOI18N
        salir2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        salir2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salir2MouseClicked(evt);
            }
        });

        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N

        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/camara-de-video.png"))); // NOI18N

        Abrir_Ingles.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        Abrir_Ingles.setText("ABRIR LINK");
        Abrir_Ingles.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Abrir_Ingles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Abrir_InglesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(salir2)
                                .addGap(313, 313, 313)
                                .addComponent(jLabel44)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel30))
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addGap(137, 137, 137)
                                .addComponent(jLabel43)
                                .addGap(18, 18, 18)
                                .addComponent(txt_INGLES, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(cbox_INGLES, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton7))))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 802, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(480, 480, 480)
                        .addComponent(Abrir_Ingles)))
                .addContainerGap(137, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(salir2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                                .addGap(0, 30, Short.MAX_VALUE)
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel44)
                                    .addComponent(jLabel30))
                                .addGap(72, 72, 72))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_INGLES, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbox_INGLES, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton7))
                            .addComponent(jLabel43))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(Abrir_Ingles)
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout InglesLayout = new javax.swing.GroupLayout(Ingles.getContentPane());
        Ingles.getContentPane().setLayout(InglesLayout);
        InglesLayout.setHorizontalGroup(
            InglesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        InglesLayout.setVerticalGroup(
            InglesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));

        COMPETENCIAS.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N
        jScrollPane4.setViewportView(COMPETENCIAS);

        jLabel31.setFont(new java.awt.Font("Castellar", 1, 24)); // NOI18N
        jLabel31.setText("CONTENIDOS COMPETENCIAS CIUDADANAS");

        btn_COMPETENCIAS.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        btn_COMPETENCIAS.setText("BUSCAR");
        btn_COMPETENCIAS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_COMPETENCIAS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_COMPETENCIASActionPerformed(evt);
            }
        });

        txt_COMPETENCIAS.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N

        cbox_COMPETENCIAS.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        cbox_COMPETENCIAS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...", "USUARIO PROFESOR", "NOMBRE CONTENIDO", "NUMERO CONTENIDO" }));
        cbox_COMPETENCIAS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        salir3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cerrar-sesion.png"))); // NOI18N
        salir3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        salir3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salir3MouseClicked(evt);
            }
        });

        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N

        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/camara-de-video.png"))); // NOI18N

        Abrir_Ingles1.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        Abrir_Ingles1.setText("ABRIR LINK");
        Abrir_Ingles1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Abrir_Ingles1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Abrir_Ingles1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(salir3)
                        .addGap(164, 164, 164)
                        .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel31)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                        .addGap(0, 165, Short.MAX_VALUE)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_COMPETENCIAS, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(cbox_COMPETENCIAS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_COMPETENCIAS)
                                .addGap(156, 156, 156))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 802, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(166, 166, 166))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Abrir_Ingles1)
                .addGap(490, 490, 490))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addComponent(salir3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel31))
                                .addGap(30, 30, 30)))
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_COMPETENCIAS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbox_COMPETENCIAS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_COMPETENCIAS)))
                    .addComponent(jLabel45))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(Abrir_Ingles1)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout competenciasLayout = new javax.swing.GroupLayout(competencias.getContentPane());
        competencias.getContentPane().setLayout(competenciasLayout);
        competenciasLayout.setHorizontalGroup(
            competenciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        competenciasLayout.setVerticalGroup(
            competenciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));

        BIOLOGIA.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N
        jScrollPane5.setViewportView(BIOLOGIA);

        jLabel32.setFont(new java.awt.Font("Castellar", 1, 24)); // NOI18N
        jLabel32.setText("CONTENIDOS BIOLOGIA");

        txt_BIOLOGIA.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N

        cbox_BIOLOGIA.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        cbox_BIOLOGIA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...", "USUARIO PROFESOR", "NOMBRE CONTENIDO", "NUMERO CONTENIDO" }));
        cbox_BIOLOGIA.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbox_BIOLOGIA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_BIOLOGIAActionPerformed(evt);
            }
        });

        btn_BIOLOGIA.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        btn_BIOLOGIA.setText("BUSCAR");
        btn_BIOLOGIA.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_BIOLOGIA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BIOLOGIAActionPerformed(evt);
            }
        });

        salir4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cerrar-sesion.png"))); // NOI18N
        salir4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        salir4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salir4MouseClicked(evt);
            }
        });

        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N

        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/camara-de-video.png"))); // NOI18N

        Abrir_Ingles2.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        Abrir_Ingles2.setText("ABRIR LINK");
        Abrir_Ingles2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Abrir_Ingles2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Abrir_Ingles2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_BIOLOGIA, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbox_BIOLOGIA, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(salir4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(269, 269, 269)
                                .addComponent(jLabel48)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(btn_BIOLOGIA))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 796, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(152, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Abrir_Ingles2)
                .addGap(489, 489, 489))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel32)
                            .addComponent(jLabel48)))
                    .addComponent(salir4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_BIOLOGIA, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbox_BIOLOGIA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_BIOLOGIA))
                    .addComponent(jLabel47))
                .addGap(43, 43, 43)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(Abrir_Ingles2)
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout biologiaLayout = new javax.swing.GroupLayout(biologia.getContentPane());
        biologia.getContentPane().setLayout(biologiaLayout);
        biologiaLayout.setHorizontalGroup(
            biologiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        biologiaLayout.setVerticalGroup(
            biologiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1090, 700));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(1090, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_Expand_Arrow_32px.png"))); // NOI18N
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_Multiply_32px.png"))); // NOI18N
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(983, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addGap(43, 43, 43))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 30));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(760, 530));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LOGO EDU.png"))); // NOI18N

        jLabel13.setFont(new java.awt.Font("Castellar", 0, 18)); // NOI18N
        jLabel13.setText("\"La educación es el arma más poderosa ");

        jLabel10.setFont(new java.awt.Font("Castellar", 0, 18)); // NOI18N
        jLabel10.setText("-Nelson Mandela");

        jLabel11.setFont(new java.awt.Font("Castellar", 0, 18)); // NOI18N
        jLabel11.setText("que puedes usar para cambiar el mundo\"");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(122, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel10)
                                .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGap(122, 122, 122))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(105, 105, 105)))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addContainerGap(213, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, 710, 640));

        Ingreso.setBackground(new java.awt.Color(255, 255, 255));
        Ingreso.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        Ingreso.setPreferredSize(new java.awt.Dimension(290, 580));
        Ingreso.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Castellar", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setText("Contraseña:");
        Ingreso.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, -1, -1));

        jLabel2.setFont(new java.awt.Font("Castellar", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("Usuario:");
        Ingreso.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/estudiante off.jpg"))); // NOI18N
        Ingreso.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 140, 120));

        txt_INGRESOESTUDIANTE.setFont(new java.awt.Font("Castellar", 1, 14)); // NOI18N
        txt_INGRESOESTUDIANTE.setForeground(new java.awt.Color(153, 153, 153));
        txt_INGRESOESTUDIANTE.setText("User");
        txt_INGRESOESTUDIANTE.setBorder(null);
        txt_INGRESOESTUDIANTE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_INGRESOESTUDIANTEMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_INGRESOESTUDIANTEMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_INGRESOESTUDIANTEMousePressed(evt);
            }
        });
        txt_INGRESOESTUDIANTE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_INGRESOESTUDIANTEActionPerformed(evt);
            }
        });
        txt_INGRESOESTUDIANTE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_INGRESOESTUDIANTEKeyTyped(evt);
            }
        });
        Ingreso.add(txt_INGRESOESTUDIANTE, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 220, 20));
        Ingreso.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 420, 220, 20));
        Ingreso.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, 220, 20));

        txt_CONTRASEÑAESTUDIANTE.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_CONTRASEÑAESTUDIANTE.setForeground(new java.awt.Color(153, 153, 153));
        txt_CONTRASEÑAESTUDIANTE.setText("contraseña");
        txt_CONTRASEÑAESTUDIANTE.setBorder(null);
        txt_CONTRASEÑAESTUDIANTE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_CONTRASEÑAESTUDIANTEMouseClicked(evt);
            }
        });
        txt_CONTRASEÑAESTUDIANTE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CONTRASEÑAESTUDIANTEActionPerformed(evt);
            }
        });
        txt_CONTRASEÑAESTUDIANTE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_CONTRASEÑAESTUDIANTEKeyTyped(evt);
            }
        });
        Ingreso.add(txt_CONTRASEÑAESTUDIANTE, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, 220, 20));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/password.png"))); // NOI18N
        Ingreso.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 30, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/descarga (1) (1).jpg"))); // NOI18N
        Ingreso.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, -1));

        jLabel12.setFont(new java.awt.Font("Castellar", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Ingreso Estudiantes");
        Ingreso.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, -1));

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
        Ingreso.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

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
        Ingreso.add(Inicio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 530, 60, 60));

        Btnregistro.setBackground(new java.awt.Color(0, 153, 153));
        Btnregistro.setFont(new java.awt.Font("Castellar", 1, 14)); // NOI18N
        Btnregistro.setForeground(new java.awt.Color(0, 153, 153));
        Btnregistro.setText("Registrarse");
        Btnregistro.setBorder(null);
        Btnregistro.setBorderPainted(false);
        Btnregistro.setContentAreaFilled(false);
        Btnregistro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Btnregistro.setFocusPainted(false);
        Btnregistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnregistroMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BtnregistroMousePressed(evt);
            }
        });
        Btnregistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnregistroActionPerformed(evt);
            }
        });
        Ingreso.add(Btnregistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 150, 30));

        getContentPane().add(Ingreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 390, 640));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 670, 1100, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_INGRESOESTUDIANTEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_INGRESOESTUDIANTEActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_INGRESOESTUDIANTEActionPerformed

    private void txt_CONTRASEÑAESTUDIANTEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CONTRASEÑAESTUDIANTEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CONTRASEÑAESTUDIANTEActionPerformed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        this.setState(Seleccion.ICONIFIED);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        int dialog = JOptionPane.YES_NO_OPTION;
        int results = JOptionPane.showConfirmDialog(null, "¿Desea salir?", "Exit", dialog);
        if (results == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_jLabel8MouseClicked

    private void txt_INGRESOESTUDIANTEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_INGRESOESTUDIANTEMouseClicked
        // TODO add your handling code here:
        txt_INGRESOESTUDIANTE.setText("");
        txt_INGRESOESTUDIANTE.requestFocus();
        txt_INGRESOESTUDIANTE.setForeground(Color.BLACK);
        Font fuente = new Font("Dubai light", 0, 18);
        txt_INGRESOESTUDIANTE.setFont(fuente);

    }//GEN-LAST:event_txt_INGRESOESTUDIANTEMouseClicked

    private void txt_INGRESOESTUDIANTEMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_INGRESOESTUDIANTEMouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_INGRESOESTUDIANTEMouseEntered

    private void txt_INGRESOESTUDIANTEMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_INGRESOESTUDIANTEMousePressed

    }//GEN-LAST:event_txt_INGRESOESTUDIANTEMousePressed

    private void txt_CONTRASEÑAESTUDIANTEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CONTRASEÑAESTUDIANTEMouseClicked
        // TODO add your handling code here:
        txt_CONTRASEÑAESTUDIANTE.setText(null);
        txt_CONTRASEÑAESTUDIANTE.requestFocus();
        txt_CONTRASEÑAESTUDIANTE.setForeground(Color.darkGray);
    }//GEN-LAST:event_txt_CONTRASEÑAESTUDIANTEMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Seleccion se = new Seleccion();
        se.show(true);
        this.show(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Inicio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Inicio1ActionPerformed
        // TODO add your handling code here:
        int a = 0;
        String cad = "";
        if (txt_INGRESOESTUDIANTE.getText().equals("")) {
            cad = "Campo 'Usuario' vacío.\n";
            a++;
        }
        if (txt_CONTRASEÑAESTUDIANTE.getText().equals("")) {
            cad += "Campo 'Contraseña' vacío.";
            a++;
        }
        if (a == 0) {
            int contraseña = MetodosSQL.ConsultaUser(Integer.parseInt(txt_INGRESOESTUDIANTE.getText()), "CUENTA-ESTUDIANTE", "ESTUDIANTE");
            if (Integer.parseInt(txt_CONTRASEÑAESTUDIANTE.getText()) == (contraseña)) {
                jLabel14.setText("BIENVENID@ " + txt_INGRESOESTUDIANTE.getText());
                Estudiante.show(true);
                this.show(false);
                Userglob = Integer.parseInt(txt_INGRESOESTUDIANTE.getText());
                Buscar_Cursos("ESTUDIANTE");
                jLabel14.setText("BIENVENID@ " + Userglob);
            } else {
                JOptionPane.showMessageDialog(null, "USUARIO O CONTRASEÑA INCORRECTA.");
            }
        } else {
            JOptionPane.showMessageDialog(null, cad);
        }


    }//GEN-LAST:event_Inicio1ActionPerformed

    private void BtnregistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnregistroActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_BtnregistroActionPerformed

    private void BtnregistroMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnregistroMousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_BtnregistroMousePressed

    private void SIGUIENTE1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SIGUIENTE1ActionPerformed
        // TODO add your handling code here:      
        Estudiante.show(false);
        LimpiarEstudiante();
        this.show(true);
        txt_INGRESOESTUDIANTE.setText("User");
        txt_CONTRASEÑAESTUDIANTE.setText("mmmmmmmmmmmm");
    }//GEN-LAST:event_SIGUIENTE1ActionPerformed

    private void btn_BIOLOGIAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BIOLOGIAActionPerformed
        // TODO add your handling code here:
        int sw = 0;
        String cad1 = "", cad2 = "";
        String[] datos = new String[8];
        if (txt_BIOLOGIA.getText().equals("")) {
            cad1 = "BIOLOGÍA";
            cad2 = "";
        } else if (cbox_BIOLOGIA.getSelectedIndex() == 1) {
            cad1 = "BIOLOGÍA";
            if (Cadnumerica(txt_BIOLOGIA.getText())) {
                cad2 = " AND \"USUARIO-PROFESOR\" = '" + txt_BIOLOGIA.getText() + "'";
            } else {
                JOptionPane.showMessageDialog(null, "Se esperaba entrada numerica.");
                sw++;
            }
        } else if (cbox_BIOLOGIA.getSelectedIndex() == 2) {
            cad1 = "BIOLOGÍA";
            cad2 = " AND \"NOMBRE-CONTENIDO\" = '" + txt_BIOLOGIA.getText() + "'";
        } else if (cbox_BIOLOGIA.getSelectedIndex() == 3) {
            cad1 = "BIOLOGÍA";
            if (Cadnumerica(txt_BIOLOGIA.getText())) {
                cad2 = " AND \"NRO-CONTENIDO\" = '" + txt_BIOLOGIA.getText() + "'";
            } else {
                JOptionPane.showMessageDialog(null, "Se esperaba entrada numerica.");
                sw++;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un método de busqueda.");
            sw++;
        }
        if (sw == 0) {
            ResultSet Consulta = null;
            PreparedStatement Comando;
            DefaultTableModel tcdatos = new DefaultTableModel();
            tcdatos.addColumn("CURSO");
            tcdatos.addColumn("NOMBRE CURSO");
            tcdatos.addColumn("USUARIO PROFESOR");
            tcdatos.addColumn("NOMBRE(S)_PROFESOR");
            tcdatos.addColumn("APELLIDO(S)_PROFESOR");
            tcdatos.addColumn("NOMBRE CONTENIDO");
            tcdatos.addColumn("CONTENIDO");
            tcdatos.addColumn("DESCRIPCIÓN");
            BIOLOGIA.setModel(tcdatos);
            try {
                Comando = MetodosSQL.ConsultaContenidoEstudiantes(cad1, cad2);
                Consulta = Comando.executeQuery();
                if (Consulta.next()) {
                    do {
                        datos[0] = Consulta.getString("NRO-CONTENIDO");
                        datos[1] = Consulta.getString("NOMBRE_CURSO");
                        datos[2] = Consulta.getString("USUARIO-PROFESOR");
                        datos[3] = Consulta.getString("NOMBRE(S)_USUARIO");
                        datos[4] = Consulta.getString("APELLIDO(S)_USUARIO");
                        datos[5] = Consulta.getString("NOMBRE-CONTENIDO");
                        datos[6] = Consulta.getString("CONTENIDO");
                        datos[7] = Consulta.getString("DESCRIPCION");
                        tcdatos.addRow(datos);
                        BIOLOGIA.setModel(tcdatos);
                    } while (Consulta.next());
                    JOptionPane.showMessageDialog(null, "Tabla actualizada.");
                } else {
                    JOptionPane.showMessageDialog(null, "Datos no encontrados.");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_btn_BIOLOGIAActionPerformed

    private void cbox_BIOLOGIAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_BIOLOGIAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbox_BIOLOGIAActionPerformed

    private void btn_BUSCARMATEMATICASActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BUSCARMATEMATICASActionPerformed
        // TODO add your handling code here:
        int sw = 0;
        String cad1 = "", cad2 = "";
        String[] datos = new String[8];
        if (txt_BUSCARMATEMATICA.getText().equals("")) {
            cad1 = "MATEMATICA";
            cad2 = "";
        } else if (cbox_MATEMATICAS.getSelectedIndex() == 1) {
            cad1 = "MATEMATICA";
            if (Cadnumerica(txt_BUSCARMATEMATICA.getText())) {
                cad2 = " AND \"USUARIO-PROFESOR\" = '" + txt_BUSCARMATEMATICA.getText() + "'";
            } else {
                JOptionPane.showMessageDialog(null, "Se esperaba entrada numerica.");
                sw++;
            }
        } else if (cbox_MATEMATICAS.getSelectedIndex() == 2) {
            cad1 = "MATEMATICA";
            cad2 = " AND \"NOMBRE-CONTENIDO\" = '" + txt_BUSCARMATEMATICA.getText() + "'";
        } else if (cbox_MATEMATICAS.getSelectedIndex() == 3) {
            cad1 = "MATEMATICA";
            if (Cadnumerica(txt_BUSCARMATEMATICA.getText())) {
                cad2 = " AND \"NRO-CONTENIDO\" = '" + txt_BUSCARMATEMATICA.getText() + "'";
            } else {
                JOptionPane.showMessageDialog(null, "Se esperaba entrada numerica.");
                sw++;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un método de busqueda.");
            sw++;
        }
        if (sw == 0) {
            ResultSet Consulta = null;
            PreparedStatement Comando;
            DefaultTableModel tcdatos = new DefaultTableModel();
            tcdatos.addColumn("CURSO");
            tcdatos.addColumn("NOMBRE CURSO");
            tcdatos.addColumn("USUARIO PROFESOR");
            tcdatos.addColumn("NOMBRE(S)_PROFESOR");
            tcdatos.addColumn("APELLIDO(S)_PROFESOR");
            tcdatos.addColumn("NOMBRE CONTENIDO");
            tcdatos.addColumn("CONTENIDO");
            tcdatos.addColumn("DESCRIPCIÓN");
            MATEMATICAS.setModel(tcdatos);
            try {
                Comando = MetodosSQL.ConsultaContenidoEstudiantes(cad1, cad2);
                Consulta = Comando.executeQuery();
                if (Consulta.next()) {
                    do {
                        datos[0] = Consulta.getString("NRO-CONTENIDO");
                        datos[1] = Consulta.getString("NOMBRE_CURSO");
                        datos[2] = Consulta.getString("USUARIO-PROFESOR");
                        datos[3] = Consulta.getString("NOMBRE(S)_USUARIO");
                        datos[4] = Consulta.getString("APELLIDO(S)_USUARIO");
                        datos[5] = Consulta.getString("NOMBRE-CONTENIDO");
                        datos[6] = Consulta.getString("CONTENIDO");
                        datos[7] = Consulta.getString("DESCRIPCION");
                        tcdatos.addRow(datos);
                        MATEMATICAS.setModel(tcdatos);
                    } while (Consulta.next());
                    JOptionPane.showMessageDialog(null, "Tabla actualizada.");
                } else {
                    JOptionPane.showMessageDialog(null, "Datos no encontrados.");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_btn_BUSCARMATEMATICASActionPerformed

    private void btn_LECTURACRITICAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LECTURACRITICAActionPerformed
        // TODO add your handling code here:
        int sw = 0;
        String cad1 = "", cad2 = "";
        String[] datos = new String[8];
        if (txt_LECTURACRITICA.getText().equals("")) {
            cad1 = "LECTURA CRITICA";
            cad2 = "";
        } else if (cbox_LECTURACRITICA.getSelectedIndex() == 1) {
            cad1 = "LECTURA CRITICA";
            if (Cadnumerica(txt_LECTURACRITICA.getText())) {
                cad2 = " AND \"USUARIO-PROFESOR\" = '" + txt_LECTURACRITICA.getText() + "'";
            } else {
                JOptionPane.showMessageDialog(null, "Se esperaba entrada numerica.");
                sw++;
            }
        } else if (cbox_LECTURACRITICA.getSelectedIndex() == 2) {
            cad1 = "LECTURA CRITICA";
            cad2 = " AND \"NOMBRE-CONTENIDO\" = '" + txt_LECTURACRITICA.getText() + "'";
        } else if (cbox_LECTURACRITICA.getSelectedIndex() == 3) {
            cad1 = "LECTURA CRITICA";
            if (Cadnumerica(txt_LECTURACRITICA.getText())) {
                cad2 = " AND \"NRO-CONTENIDO\" = '" + txt_LECTURACRITICA.getText() + "'";
            } else {
                JOptionPane.showMessageDialog(null, "Se esperaba entrada numerica.");
                sw++;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un método de busqueda.");
            sw++;
        }
        if (sw == 0) {
            ResultSet Consulta = null;
            PreparedStatement Comando;
            DefaultTableModel tcdatos = new DefaultTableModel();
            tcdatos.addColumn("CURSO");
            tcdatos.addColumn("NOMBRE CURSO");
            tcdatos.addColumn("USUARIO PROFESOR");
            tcdatos.addColumn("NOMBRE(S)_PROFESOR");
            tcdatos.addColumn("APELLIDO(S)_PROFESOR");
            tcdatos.addColumn("NOMBRE CONTENIDO");
            tcdatos.addColumn("CONTENIDO");
            tcdatos.addColumn("DESCRIPCIÓN");
            LECTURACRITICA.setModel(tcdatos);
            try {
                Comando = MetodosSQL.ConsultaContenidoEstudiantes(cad1, cad2);
                Consulta = Comando.executeQuery();
                if (Consulta.next()) {
                    do {
                        datos[0] = Consulta.getString("NRO-CONTENIDO");
                        datos[1] = Consulta.getString("NOMBRE_CURSO");
                        datos[2] = Consulta.getString("USUARIO-PROFESOR");
                        datos[3] = Consulta.getString("NOMBRE(S)_USUARIO");
                        datos[4] = Consulta.getString("APELLIDO(S)_USUARIO");
                        datos[5] = Consulta.getString("NOMBRE-CONTENIDO");
                        datos[6] = Consulta.getString("CONTENIDO");
                        datos[7] = Consulta.getString("DESCRIPCION");
                        tcdatos.addRow(datos);
                        LECTURACRITICA.setModel(tcdatos);
                    } while (Consulta.next());
                    JOptionPane.showMessageDialog(null, "Tabla actualizada.");
                } else {
                    JOptionPane.showMessageDialog(null, "Datos no encontrados.");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_btn_LECTURACRITICAActionPerformed

    private void btn_COMPETENCIASActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_COMPETENCIASActionPerformed
        // TODO add your handling code here:
        int sw = 0;
        String cad1 = "", cad2 = "";
        String[] datos = new String[8];
        if (txt_COMPETENCIAS.getText().equals("")) {
            cad1 = "COMPETENCIAS CIUDADANAS";
            cad2 = "";
        } else if (cbox_COMPETENCIAS.getSelectedIndex() == 1) {
            cad1 = "COMPETENCIAS CIUDADANAS";
            if (Cadnumerica(txt_COMPETENCIAS.getText())) {
                cad2 = " AND \"USUARIO-PROFESOR\" = '" + txt_COMPETENCIAS.getText() + "'";
            } else {
                JOptionPane.showMessageDialog(null, "Se esperaba entrada numerica.");
                sw++;
            }
        } else if (cbox_COMPETENCIAS.getSelectedIndex() == 2) {
            cad1 = "COMPETENCIAS CIUDADANAS";
            cad2 = " AND \"NOMBRE-CONTENIDO\" = '" + txt_COMPETENCIAS.getText() + "'";
        } else if (cbox_COMPETENCIAS.getSelectedIndex() == 3) {
            cad1 = "COMPETENCIAS CIUDADANAS";
            if (Cadnumerica(txt_COMPETENCIAS.getText())) {
                cad2 = " AND \"NRO-CONTENIDO\" = '" + txt_COMPETENCIAS.getText() + "'";
            } else {
                JOptionPane.showMessageDialog(null, "Se esperaba entrada numerica.");
                sw++;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un método de busqueda.");
            sw++;
        }
        if (sw == 0) {
            ResultSet Consulta = null;
            PreparedStatement Comando;
            DefaultTableModel tcdatos = new DefaultTableModel();
            tcdatos.addColumn("CURSO");
            tcdatos.addColumn("NOMBRE CURSO");
            tcdatos.addColumn("USUARIO PROFESOR");
            tcdatos.addColumn("NOMBRE(S)_PROFESOR");
            tcdatos.addColumn("APELLIDO(S)_PROFESOR");
            tcdatos.addColumn("NOMBRE CONTENIDO");
            tcdatos.addColumn("CONTENIDO");
            tcdatos.addColumn("DESCRIPCIÓN");
            COMPETENCIAS.setModel(tcdatos);
            try {
                Comando = MetodosSQL.ConsultaContenidoEstudiantes(cad1, cad2);
                Consulta = Comando.executeQuery();
                if (Consulta.next()) {
                    do {
                        datos[0] = Consulta.getString("NRO-CONTENIDO");
                        datos[1] = Consulta.getString("NOMBRE_CURSO");
                        datos[2] = Consulta.getString("USUARIO-PROFESOR");
                        datos[3] = Consulta.getString("NOMBRE(S)_USUARIO");
                        datos[4] = Consulta.getString("APELLIDO(S)_USUARIO");
                        datos[5] = Consulta.getString("NOMBRE-CONTENIDO");
                        datos[6] = Consulta.getString("CONTENIDO");
                        datos[7] = Consulta.getString("DESCRIPCION");
                        tcdatos.addRow(datos);
                        COMPETENCIAS.setModel(tcdatos);
                    } while (Consulta.next());
                    JOptionPane.showMessageDialog(null, "Tabla actualizada.");
                } else {
                    JOptionPane.showMessageDialog(null, "Datos no encontrados.");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_btn_COMPETENCIASActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        int sw = 0;
        String cad1 = "", cad2 = "";
        String[] datos = new String[8];
        if (txt_INGLES.getText().equals("")) {
            cad1 = "INGLES";
            cad2 = "";
        } else if (cbox_INGLES.getSelectedIndex() == 1) {
            cad1 = "INGLES";
            if (Cadnumerica(txt_INGLES.getText())) {
                cad2 = " AND \"USUARIO-PROFESOR\" = '" + txt_INGLES.getText() + "'";
            } else {
                JOptionPane.showMessageDialog(null, "Se esperaba entrada numerica.");
                sw++;
            }
        } else if (cbox_INGLES.getSelectedIndex() == 2) {
            cad1 = "INGLES";
            cad2 = " AND \"NOMBRE-CONTENIDO\" = '" + txt_INGLES.getText() + "'";
        } else if (cbox_INGLES.getSelectedIndex() == 3) {
            cad1 = "INGLES";
            if (Cadnumerica(txt_COMPETENCIAS.getText())) {
                cad2 = " AND \"NRO-CONTENIDO\" = '" + txt_INGLES.getText() + "'";
            } else {
                JOptionPane.showMessageDialog(null, "Se esperaba entrada numerica.");
                sw++;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un método de busqueda.");
            sw++;
        }
        if (sw == 0) {
            ResultSet Consulta = null;
            PreparedStatement Comando;
            DefaultTableModel tcdatos = new DefaultTableModel();
            tcdatos.addColumn("CURSO");
            tcdatos.addColumn("NOMBRE CURSO");
            tcdatos.addColumn("USUARIO PROFESOR");
            tcdatos.addColumn("NOMBRE(S)_PROFESOR");
            tcdatos.addColumn("APELLIDO(S)_PROFESOR");
            tcdatos.addColumn("NOMBRE CONTENIDO");
            tcdatos.addColumn("CONTENIDO");
            tcdatos.addColumn("DESCRIPCIÓN");
            INGLES.setModel(tcdatos);
            try {
                Comando = MetodosSQL.ConsultaContenidoEstudiantes(cad1, cad2);
                Consulta = Comando.executeQuery();
                if (Consulta.next()) {
                    do {
                        datos[0] = Consulta.getString("NRO-CONTENIDO");
                        datos[1] = Consulta.getString("NOMBRE_CURSO");
                        datos[2] = Consulta.getString("USUARIO-PROFESOR");
                        datos[3] = Consulta.getString("NOMBRE(S)_USUARIO");
                        datos[4] = Consulta.getString("APELLIDO(S)_USUARIO");
                        datos[5] = Consulta.getString("NOMBRE-CONTENIDO");
                        datos[6] = Consulta.getString("CONTENIDO");
                        datos[7] = Consulta.getString("DESCRIPCION");
                        tcdatos.addRow(datos);
                        INGLES.setModel(tcdatos);
                    } while (Consulta.next());
                    JOptionPane.showMessageDialog(null, "Tabla actualizada.");
                } else {
                    JOptionPane.showMessageDialog(null, "Datos no encontrados.");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        if (cbox_AGREGARCURSOESTUDIANTE.getSelectedIndex() != 0) {

            int ncurso = cbox_AGREGARCURSOESTUDIANTE.getSelectedIndex();
            try {
                if (MetodosSQL.BuscarCurso(ncurso, Userglob, "ESTUDIANTE") == false) {
                    MetodosSQL.Matricular(ncurso, Userglob, "ESTUDIANTE");
                    Buscar_Cursos("ESTUDIANTE");
                    cbox_AGREGARCURSOESTUDIANTE.setSelectedIndex(0);
                } else {
                    JOptionPane.showMessageDialog(null, "Ya existe un estudiante con id: " + Userglob + " en este curso.");
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Seleccionar un curso.");
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        // TODO add your handling code here:
        Matematicas.show(true);
        Estudiante.show(false);
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseClicked
        // TODO add your handling code here:
        Lectura_critica.show(true);
        Estudiante.show(false);
    }//GEN-LAST:event_jLabel26MouseClicked

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
        // TODO add your handling code here:
        Ingles.show(true);
        Estudiante.show(false);
    }//GEN-LAST:event_jLabel24MouseClicked

    private void jLabel36KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel36KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel36KeyPressed

    private void jLabel36MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel36MouseClicked
        // TODO add your handling code here:
        competencias.show(true);
        Estudiante.show(false);
    }//GEN-LAST:event_jLabel36MouseClicked

    private void jLabel37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel37MouseClicked
        // TODO add your handling code here:
        biologia.show(true);
        Estudiante.show(false);
    }//GEN-LAST:event_jLabel37MouseClicked

    private void txt_CORREOREGISTRO1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CORREOREGISTRO1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CORREOREGISTRO1MouseClicked

    private void txt_CORREOREGISTRO1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CORREOREGISTRO1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CORREOREGISTRO1MouseEntered

    private void txt_CORREOREGISTRO1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CORREOREGISTRO1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CORREOREGISTRO1MousePressed

    private void txt_CORREOREGISTRO1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CORREOREGISTRO1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CORREOREGISTRO1ActionPerformed

    private void jLabel82MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel82MouseClicked
        // TODO add your handling code here:
        int i = 0;
        if (txt_NOMBREREGISTRO.getText().equals("")) {
            i++;
        }
        if (txt_APELLIDOSREGISTRO.getText().equals("")) {
            i++;
        }
        if (txt_USUARIOREGISTRO.getText().equals("")) {
            i++;
        }
        if (txt_DIRECCIONREGISTRO1.getText().equals("")) {
            i++;
        }
        if (txt_CORREOREGISTRO1.getText().equals("")) {
            i++;
        }
        if (txt_TELEFONOREGISTRO1.getText().equals("")) {
            i++;
        }
        if (txt_CONTRASEÑAREGISTRO1.getText().equals("")) {
            i++;
        }
        if (txt_CONTRASEÑAREGISTRO2.getText().equals("")) {
            i++;
        }
        if (i != 0) {
            JOptionPane.showMessageDialog(null, "Hay campos sin rellenar.");
        } else if (txt_CONTRASEÑAREGISTRO1.getText().equals(txt_CONTRASEÑAREGISTRO2.getText())) {
            if (MetodosSQL.UserExis(Integer.parseInt(txt_USUARIOREGISTRO.getText()), "ESTUDIANTE") == false) {
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
                datos1[8] = "ESTUDIANTE";
                datos1[9] = txt_TELEFONOREGISTRO1.getText();
                if (txt_TELEFONOREGISTRO2.getText().equals("")) {
                    datos1[10] = "VACÍO";
                } else {
                    datos1[10] = txt_TELEFONOREGISTRO2.getText();
                }
                try {
                    MetodosSQL.InsertarUsuario(datos1, Usuario);
                    JOptionPane.showMessageDialog(null, "Cuenta creada.");
                    txt_NOMBREREGISTRO.requestFocus();
                    LimpiarRegistroEstudiante();
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ya hay una cuenta ESTUDIANTE existente con esta identificación.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden.");
        }

    }//GEN-LAST:event_jLabel82MouseClicked

    private void txt_CORREOREGISTRO2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CORREOREGISTRO2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CORREOREGISTRO2MouseClicked

    private void txt_CORREOREGISTRO2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CORREOREGISTRO2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CORREOREGISTRO2MouseEntered

    private void txt_CORREOREGISTRO2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CORREOREGISTRO2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CORREOREGISTRO2MousePressed

    private void txt_CORREOREGISTRO2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CORREOREGISTRO2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CORREOREGISTRO2ActionPerformed

    private void txt_TELEFONOREGISTRO1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_TELEFONOREGISTRO1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TELEFONOREGISTRO1MouseClicked

    private void txt_TELEFONOREGISTRO1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_TELEFONOREGISTRO1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TELEFONOREGISTRO1MouseEntered

    private void txt_TELEFONOREGISTRO1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_TELEFONOREGISTRO1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TELEFONOREGISTRO1MousePressed

    private void txt_TELEFONOREGISTRO1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_TELEFONOREGISTRO1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TELEFONOREGISTRO1ActionPerformed

    private void txt_TELEFONOREGISTRO2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_TELEFONOREGISTRO2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TELEFONOREGISTRO2MouseClicked

    private void txt_TELEFONOREGISTRO2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_TELEFONOREGISTRO2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TELEFONOREGISTRO2MouseEntered

    private void txt_TELEFONOREGISTRO2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_TELEFONOREGISTRO2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TELEFONOREGISTRO2MousePressed

    private void txt_TELEFONOREGISTRO2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_TELEFONOREGISTRO2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TELEFONOREGISTRO2ActionPerformed

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

    private void BtnregistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnregistroMouseClicked
        // TODO add your handling code here:
        txt_NOMBREREGISTRO.requestFocus();
        Registro.show(true);
    }//GEN-LAST:event_BtnregistroMouseClicked

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

    private void btnActualizarEsudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarEsudianteActionPerformed
        // TODO add your handling code here:
        int i = 0;
        if (txt_ContraseñaAntiguaEsudiante.getText().equals("")) {
            i++;
        }
        if (txt_ContraseñaNueva1Esudiante.getText().equals("")) {
            i++;
        }
        if (txt_ContraseñaNueva2Esudiante.getText().equals("")) {
            i++;
        }
        if (i != 0) {
            JOptionPane.showMessageDialog(null, "Campos vacíos.");
        } else if (txt_ContraseñaNueva1Esudiante.getText().equals(txt_ContraseñaNueva2Esudiante.getText())) {

            if (MetodosSQL.ConsultaUser(Userglob, "CUENTA-ESTUDIANTE", "ESTUDIANTE") == Integer.parseInt(txt_ContraseñaAntiguaEsudiante.getText())) {
                MetodosSQL.ConsultaUpdate("UPDATE \"CUENTA-ESTUDIANTE\" SET CONTRASEÑA = " + txt_ContraseñaNueva1Esudiante.getText() + "WHERE \"USUARIO-ESTUDIANTE\" = " + Userglob);
                JOptionPane.showMessageDialog(null, "Contraseña modificada.");
                Eliminar_estudiante_Contraseña();
            } else {
                JOptionPane.showMessageDialog(null, "Contraseña incorrecta.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden.");
        }
    }//GEN-LAST:event_btnActualizarEsudianteActionPerformed

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        // TODO add your handling code here:
        Registro.setState(Registro.ICONIFIED);
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        // TODO add your handling code here:
        int dialog = JOptionPane.YES_NO_OPTION;
        int results = JOptionPane.showConfirmDialog(null, "¿Desea cerrar?", "Exit", dialog);
        if (results == 0) {
            LimpiarRegistroEstudiante();
            Registro.show(false);
            this.show(true);
        }
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        // TODO add your handling code here:
        Estudiante.setState(Estudiante.ICONIFIED);
    }//GEN-LAST:event_jLabel17MouseClicked

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        // TODO add your handling code here:
        int dialog = JOptionPane.YES_NO_OPTION;
        int results = JOptionPane.showConfirmDialog(null, "¿Desea cerrar?", "Exit", dialog);
        if (results == 0) {
            LimpiarRegistroEstudiante();
            System.exit(0);
        }
    }//GEN-LAST:event_jLabel18MouseClicked

    private void salirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirMouseClicked
        // TODO add your handling code here:
        Matematicas.show(false);
        Estudiante.show(true);
    }//GEN-LAST:event_salirMouseClicked

    private void salir1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salir1MouseClicked
        // TODO add your handling code here:
        Lectura_critica.show(false);
        Estudiante.show(true);
    }//GEN-LAST:event_salir1MouseClicked

    private void salir2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salir2MouseClicked
        // TODO add your handling code here:
        Ingles.show(false);
        Estudiante.show(true);
    }//GEN-LAST:event_salir2MouseClicked

    private void salir3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salir3MouseClicked
        // TODO add your handling code here:
        competencias.show(false);
        Estudiante.show(true);
    }//GEN-LAST:event_salir3MouseClicked

    private void salir4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salir4MouseClicked
        // TODO add your handling code here:
        biologia.show(false);
        Estudiante.show(true);
    }//GEN-LAST:event_salir4MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Abrir_link();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Abrir_link_lecturac();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void Abrir_InglesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Abrir_InglesActionPerformed
        // TODO add your handling code here:
        Abrir_link_ingles();
    }//GEN-LAST:event_Abrir_InglesActionPerformed

    private void Abrir_Ingles1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Abrir_Ingles1ActionPerformed
        // TODO add your handling code here:
        Abrir_link_competencias();
    }//GEN-LAST:event_Abrir_Ingles1ActionPerformed

    private void Abrir_Ingles2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Abrir_Ingles2ActionPerformed
        // TODO add your handling code here:
        Abrir_link_Biologia();
    }//GEN-LAST:event_Abrir_Ingles2ActionPerformed

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
        // TODO add your handling code here:
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

    private void txt_INGRESOESTUDIANTEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_INGRESOESTUDIANTEKeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!numeros) {
            evt.consume();
        }

        if (txt_INGRESOESTUDIANTE.getText().trim().length() == 9) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_INGRESOESTUDIANTEKeyTyped

    private void txt_CONTRASEÑAESTUDIANTEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CONTRASEÑAESTUDIANTEKeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!numeros) {
            evt.consume();
        }

        if (txt_CONTRASEÑAESTUDIANTE.getText().trim().length() == 9) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_CONTRASEÑAESTUDIANTEKeyTyped

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
            java.util.logging.Logger.getLogger(Ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ingreso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Abrir_Ingles;
    private javax.swing.JButton Abrir_Ingles1;
    private javax.swing.JButton Abrir_Ingles2;
    private javax.swing.JTable BIOLOGIA;
    private javax.swing.JButton Btnregistro;
    private javax.swing.JTable COMPETENCIAS;
    private javax.swing.JFrame Estudiante;
    private javax.swing.JTable INGLES;
    private javax.swing.JFrame Ingles;
    private javax.swing.JPanel Ingreso;
    private javax.swing.JButton Inicio1;
    private javax.swing.JTable LECTURACRITICA;
    private javax.swing.JFrame Lectura_critica;
    private javax.swing.JTable MATEMATICAS;
    private javax.swing.JFrame Matematicas;
    private javax.swing.JFrame Registro;
    private javax.swing.JButton SIGUIENTE1;
    private javax.swing.JFrame biologia;
    private javax.swing.JButton btnActualizarEsudiante;
    private javax.swing.JButton btn_BIOLOGIA;
    private javax.swing.JButton btn_BUSCARMATEMATICAS;
    private javax.swing.JButton btn_COMPETENCIAS;
    private javax.swing.JButton btn_LECTURACRITICA;
    private javax.swing.JComboBox<String> cbox_AGREGARCURSOESTUDIANTE;
    private javax.swing.JComboBox<String> cbox_BIOLOGIA;
    private javax.swing.JComboBox<String> cbox_COMPETENCIAS;
    private javax.swing.JComboBox<String> cbox_INGLES;
    private javax.swing.JComboBox<String> cbox_LECTURACRITICA;
    private javax.swing.JComboBox<String> cbox_MATEMATICAS;
    private javax.swing.JFrame competencias;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
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
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel72;
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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel jp_AÑADIRCURSO;
    private javax.swing.JPanel jp_BIOLOGIA;
    private javax.swing.JPanel jp_COMPETENCIAS;
    private javax.swing.JTabbedPane jp_CURSOS;
    private javax.swing.JPanel jp_INGLES;
    private javax.swing.JPanel jp_LECTURACRITICA;
    private javax.swing.JPanel jp_MATEMATICAS;
    private javax.swing.JLabel salir;
    private javax.swing.JLabel salir1;
    private javax.swing.JLabel salir2;
    private javax.swing.JLabel salir3;
    private javax.swing.JLabel salir4;
    private javax.swing.JTextField txt_APELLIDOSREGISTRO;
    private javax.swing.JTextField txt_BIOLOGIA;
    private javax.swing.JTextField txt_BUSCARMATEMATICA;
    private javax.swing.JTextField txt_COMPETENCIAS;
    private javax.swing.JPasswordField txt_CONTRASEÑAESTUDIANTE;
    private javax.swing.JTextField txt_CONTRASEÑAREGISTRO1;
    private javax.swing.JTextField txt_CONTRASEÑAREGISTRO2;
    private javax.swing.JTextField txt_CORREOREGISTRO1;
    private javax.swing.JTextField txt_CORREOREGISTRO2;
    private javax.swing.JPasswordField txt_ContraseñaAntiguaEsudiante;
    private javax.swing.JPasswordField txt_ContraseñaNueva1Esudiante;
    private javax.swing.JPasswordField txt_ContraseñaNueva2Esudiante;
    private javax.swing.JTextField txt_DIRECCIONREGISTRO1;
    private javax.swing.JTextField txt_DIRECCIONREGISTRO2;
    private javax.swing.JTextField txt_INGLES;
    private javax.swing.JTextField txt_INGRESOESTUDIANTE;
    private javax.swing.JTextField txt_LECTURACRITICA;
    private javax.swing.JTextField txt_NOMBREREGISTRO;
    private javax.swing.JTextField txt_TELEFONOREGISTRO1;
    private javax.swing.JTextField txt_TELEFONOREGISTRO2;
    private javax.swing.JTextField txt_USUARIOREGISTRO;
    // End of variables declaration//GEN-END:variables
}
