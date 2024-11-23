package Conexion;

import java.sql.*;
import Conexion.ConexionDB;

public class MetodosSQL {

    public static ConexionDB datos = new ConexionDB();

    public static PreparedStatement Comando;
    public static ResultSet Consulta;

    public static int ConsultaUser(int User, String cad, String cad2) {
        int Contra = 0;
        Connection conexion = null;

        try {
            conexion = ConexionDB.conectar();
            String Sentencia = ("SELECT CONTRASEÑA FROM \"" + cad + "\" WHERE \"USUARIO-" + cad2 + "\" = '" + User + "'");
            Comando = conexion.prepareStatement(Sentencia);
            Consulta = Comando.executeQuery();
            if (Consulta.next()) {
                Contra = Consulta.getInt("CONTRASEÑA");
            }
            Comando.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return Contra;
    }

    public static boolean InsertarUsuario(String[] datos, int user) {
        Connection conexion = null;
        String Sentencia = ("INSERT INTO \"CUENTA-" + datos[8] + "\" VALUES (" + user + ", '" + datos[0]
                + "', '" + datos[1] + "', '" + datos[2] + "')");
        try {
            conexion = ConexionDB.conectar();
            Comando = conexion.prepareStatement(Sentencia);
            Comando.executeQuery();
            InsertarCorreo(datos[8], datos[6], user);
            InsertarCorreo(datos[8], datos[7], user);
            InsertarDireccion(datos[8], datos[4], user);
            InsertarDireccion(datos[8], datos[5], user);
            InsertarTelefono(datos[8], datos[9], user);
            InsertarTelefono(datos[8], datos[10], user);

            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public static void InsertarCorreo(String tipo, String correo, long user) {
        Connection conexion = null;
        int cons = ConsultaConsecuente("CORREO" + tipo);
        String Sentencia = ("INSERT INTO \"CORREO-" + tipo + "\" VALUES (" + cons + ", '" + correo + "', " + user + ")");
        try {
            conexion = ConexionDB.conectar();
            Comando = conexion.prepareStatement(Sentencia);
            Comando.executeQuery();
            Update("CORREO" + tipo, cons + 1);
        } catch (Exception e) {
            System.out.println(e + "CORREOOOOOOO");
        }
    }

    public static void InsertarDireccion(String tipo, String dir, long user) {
        Connection conexion = null;
        int cons = ConsultaConsecuente("DIRECCION" + tipo);
        String Sentencia = ("INSERT INTO \"DIRECCION-" + tipo + "\" VALUES (" + cons + ", '" + dir + "', " + user + ")");
        try {
            conexion = ConexionDB.conectar();
            Comando = conexion.prepareStatement(Sentencia);
            Comando.executeQuery();
            Update("DIRECCION" + tipo, cons + 1);
        } catch (Exception e) {
            System.out.println(e + "DIRECCIOOOON");
        }
    }

    public static void InsertarTelefono(String tipo, String tel, long user) {
        Connection conexion = null;
        int cons = ConsultaConsecuente("TELEFONO" + tipo);
        String Sentencia = ("INSERT INTO \"TELEFONO-" + tipo + "\" VALUES (" + cons + ", '" + tel + "', " + user + ")");
        try {
            conexion = ConexionDB.conectar();
            Comando = conexion.prepareStatement(Sentencia);
            Comando.executeQuery();
            Update("TELEFONO" + tipo, cons + 1);
        } catch (Exception e) {
            System.out.println(e + "TELEFONOOOOOO");
        }
    }

    public static int ConsultaConsecuente(String cad) {
        Connection conexion = null;
        int dato = 0;
        String Sentencia = ("SELECT \"NRO-" + cad + "\" a FROM PARAMETROS");
        System.out.println(Sentencia);
        try {
            conexion = ConexionDB.conectar();
            System.out.println(Sentencia);
            Comando = conexion.prepareStatement(Sentencia);
            Consulta = Comando.executeQuery();
            Consulta.next();
            dato = Consulta.getInt("a");
        } catch (Exception e) {
            System.out.println(e + "CONCECUENTEEEEEEE");
        }
        return dato;
    }

    public static void Update(String cad, int valor) {
        Connection conexion = null;
        try {
            conexion = ConexionDB.conectar();
            String Sentencia = ("UPDATE PARAMETROS set \"NRO-" + cad + "\" = " + valor);
            System.out.println(Sentencia);
            Comando = conexion.prepareStatement(Sentencia);
            Comando.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static boolean BuscarCurso(int curso, int user, String matricula) {
        Connection conexion = null;
        try {
            conexion = ConexionDB.conectar();
            String Sentencia = ("SELECT \"NRO-CURSO\" FROM \"MATRICULA-" + matricula + "\" JOIN \"CUENTA-" + matricula + "\" USING (\"USUARIO-" + matricula + "\") WHERE \"NRO-CURSO\" = " + curso + " AND \"USUARIO-" + matricula + "\" = " + user);
            System.out.println(Sentencia);
            Comando = conexion.prepareStatement(Sentencia);
            Consulta = Comando.executeQuery();
            if (Consulta.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public static void Matricular(int curso, int user, String tipo) {
        Connection conexion = null;
        try {
            conexion = ConexionDB.conectar();
            int cons = ConsultaConsecuente("MATRICULA" + tipo);
            String Sentencia = ("INSERT INTO \"MATRICULA-" + tipo + "\" VALUES (" + cons + ", '" + curso + "', " + user + ")");
            System.out.println(Sentencia);
            Comando = conexion.prepareStatement(Sentencia);
            Comando.executeQuery();
            Update("MATRICULA" + tipo, cons + 1);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static PreparedStatement BuscarCursoUser(int user, String user1) {
        Connection conexion = null;
        String Sentencia = ("SELECT \"NOMBRE_CURSO\" FROM CURSO JOIN \"MATRICULA-" + user1 + "\" USING (\"NRO-CURSO\") WHERE \"USUARIO-" + user1 + "\" = " + user);
        System.out.println(Sentencia);
        try {
            conexion = ConexionDB.conectar();
            Comando = conexion.prepareStatement(Sentencia);
        } catch (Exception e) {
            System.out.println(e);
        }
        return Comando;
    }

    public static void AgregarContendio(int nro, String link, int nrocur, String desc, String nombre, int nromatri) {
        Connection conexion = null;
        String Sentencia = ("INSERT INTO CONTENIDO VALUES(" + nro + ", '" + link + "', " + nrocur + ", '" + desc + "'" + ", '" + nombre + "', '" + nromatri + "')");
        System.out.println(Sentencia);
        try {
            conexion = ConexionDB.conectar();
            Comando = conexion.prepareStatement(Sentencia);
            Comando.executeQuery();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static PreparedStatement Consulta(String Sentencia) {
        Connection conexion = null;
        try {
            conexion = ConexionDB.conectar();
            Comando = conexion.prepareStatement(Sentencia);
        } catch (Exception e) {
            System.out.println(e);
        }
        return Comando;
    }

    public static void ConsultaUpdate(String Sentencia) {
        Connection conexion = null;
        try {
            conexion = ConexionDB.conectar();
            Comando = conexion.prepareStatement(Sentencia);
            Comando.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static PreparedStatement ConsultaContenido(int user, String materia, String buscar) {
        Connection conexion = null;
        String Sentencia = ("SELECT \"NOMBRE(S)_USUARIO\", \"APELLIDO(S)_USUARIO\", \"NOMBRE-CONTENIDO\", CONTENIDO, DESCRIPCION, \"NOMBRE_CURSO\",\"NRO-CONTENIDO\" "
                + " FROM CURSO JOIN CONTENIDO USING(\"NRO-CURSO\") JOIN \"MATRICULA-PROFESOR\" USING (\"NRO-MATRICULA\") JOIN \"CUENTA-PROFESOR\" USING (\"USUARIO-PROFESOR\") WHERE \"USUARIO-PROFESOR\" = " + user + " AND"
                + " \"NOMBRE_CURSO\" = '" + materia + "'" + buscar);
        try {
            conexion = ConexionDB.conectar();
            Comando = conexion.prepareStatement(Sentencia);
        } catch (Exception e) {
            System.out.println(e);
        }
        return Comando;
    }

    public static PreparedStatement ConsultaContenidoEstudiantes(String curso, String cad) {
        Connection conexion = null;
        String Sentencia = ("SELECT \"NOMBRE(S)_USUARIO\", \"APELLIDO(S)_USUARIO\", \"NOMBRE-CONTENIDO\", CONTENIDO, DESCRIPCION, \"NOMBRE_CURSO\", \"NRO-CONTENIDO\", \"USUARIO-PROFESOR\""
                + "FROM CURSO JOIN CONTENIDO USING(\"NRO-CURSO\") JOIN \"MATRICULA-PROFESOR\" USING (\"NRO-MATRICULA\") JOIN \"CUENTA-PROFESOR\" USING (\"USUARIO-PROFESOR\") WHERE \"NOMBRE_CURSO\" = '" + curso + "'" + cad);
        System.out.println(Sentencia);
        try {
            conexion = ConexionDB.conectar();
            Comando = conexion.prepareStatement(Sentencia);
        } catch (Exception e) {
            System.out.println(e);
        }
        return Comando;
    }

    public static PreparedStatement Comprobar(int user) {
        Connection conexion = null;
        String Sentencia = ("SELECT \"CUENTA-PROFESOR\".\"NOMBRE(S)_USUARIO\", \"CUENTA-PROFESOR\".\"APELLIDO(S)_USUARIO\", \"CUENTA-PROFESOR\".CONTRASEÑA FROM \"CUENTA-PROFESOR\""
                + " JOIN \"CUENTA-ESTUDIANTE\" ON \"USUARIO-ESTUDIANTE\" = \"USUARIO-PROFESOR\" WHERE \"USUARIO-PROFESOR\" = " + user);
        System.out.println(Sentencia);
        try {
            conexion = ConexionDB.conectar();
            Comando = conexion.prepareStatement(Sentencia);
        } catch (Exception e) {
            System.out.println(e);
        }
        return Comando;
    }

    public static PreparedStatement Estudiante(int user) {
        Connection conexion = null;
        String Sentencia = ("SELECT \"NOMBRE(S)_USUARIO\", \"APELLIDO(S)_USUARIO\", CONTRASEÑA FROM \"CUENTA-ESTUDIANTE\" WHERE \"USUARIO-ESTUDIANTE\" = " + user);
        try {
            conexion = ConexionDB.conectar();
            Comando = conexion.prepareStatement(Sentencia);
        } catch (Exception e) {
            System.out.println(e);
        }
        return Comando;
    }

    public static PreparedStatement Profesor(int user) {
        Connection conexion = null;
        String Sentencia = ("SELECT \"NOMBRE(S)_USUARIO\", \"APELLIDO(S)_USUARIO\", CONTRASEÑA FROM \"CUENTA-PROFESOR\" WHERE \"USUARIO-PROFESOR\" = " + user);
        try {
            conexion = ConexionDB.conectar();
            Comando = conexion.prepareStatement(Sentencia);
        } catch (Exception e) {
            System.out.println(e);
        }
        return Comando;
    }

    public static PreparedStatement ConsultaCorreo(int user, String tipo) {
        Connection conexion = null;
        String Sentencia = ("SELECT CORREO, \"NRO-CORREO\" FROM \"CORREO-" + tipo + "\" WHERE USUARIO = " + user);
        try {
            conexion = ConexionDB.conectar();
            Comando = conexion.prepareStatement(Sentencia);
        } catch (Exception e) {
            System.out.println(e);
        }
        return Comando;
    }

    public static PreparedStatement ConsultaDireccion(int user, String tipo) {
        Connection conexion = null;
        String Sentencia = ("SELECT DIRECCION, \"NRO-DIRECCION\" FROM \"DIRECCION-" + tipo + "\"  WHERE USUARIO = " + user);
        try {
            conexion = ConexionDB.conectar();
            Comando = conexion.prepareStatement(Sentencia);
        } catch (Exception e) {
            System.out.println(e);
        }
        return Comando;
    }

    public static PreparedStatement ConsultaTelefono(int user, String tipo) {
        Connection conexion = null;
        String Sentencia = ("SELECT TELEFONO, \"NRO-TELEFONO\" FROM \"TELEFONO-" + tipo + "\"  WHERE USUARIO = " + user);
        try {
            conexion = ConexionDB.conectar();
            Comando = conexion.prepareStatement(Sentencia);
        } catch (Exception e) {
            System.out.println(e);
        }
        return Comando;
    }

    public static void ModificarUser(int user, String tipo, String[] datos) {
        Connection conexion = null;

        try {
            conexion = ConexionDB.conectar();
            String Sentencia = ("UPDATE \"CUENTA-" + tipo + "\" SET \"NOMBRE(S)_USUARIO\" = '" + datos[0] + "', \"APELLIDO(S)_USUARIO\" = '" + datos[1] + "', CONTRASEÑA = '" + datos[2] + "' "+"WHERE \"USUARIO-"+tipo+"\" = " + user);
            System.out.println(Sentencia);
            Comando = conexion.prepareStatement(Sentencia);
            Comando.executeUpdate();           

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static boolean UserExis(int user, String cad) {
        Connection conexion = null;
        boolean cun = false;
        String Sentencia = ("SELECT \"USUARIO-" + cad + "\" FROM \"CUENTA-" + cad + "\" WHERE \"USUARIO-" + cad + "\" = " + user);
        System.out.println(Sentencia);
        try {
            conexion = ConexionDB.conectar();
            Comando = conexion.prepareStatement(Sentencia);
            Consulta = Comando.executeQuery();
            if (Consulta.next()) {
                cun = true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return cun;
    }

    public static void UpdateDatos(int user, String tipo, String correo1, String correo2, String tel1, String tel2, String dir1, String dir2) {
        Connection conexion = null;
        try {
            int[] id = new int[2];
            Comando = ConsultaCorreo(user, tipo);
            Consulta = Comando.executeQuery();
            int i = 0;
            while (Consulta.next()) {
                id[i] = Consulta.getInt(2);
                i++;
            }
            if (id[0] < id[1]) {
                int temp = id[0];
                id[0] = id[1];
                id[1] = temp;
            }
            String Sentencia = ("UPDATE \"CORREO-" + tipo + "\" SET CORREO = '" + correo1 + "' WHERE \"NRO-CORREO\" = " + id[0]);
            System.out.println(Sentencia);
            conexion = ConexionDB.conectar();
            Comando = conexion.prepareStatement(Sentencia);
            Comando.executeUpdate();
            Sentencia = ("UPDATE \"CORREO-" + tipo + "\" SET CORREO = '" + correo2 + "' WHERE \"NRO-CORREO\" = " + id[1]);
            System.out.println(Sentencia);
            conexion = ConexionDB.conectar();
            Comando = conexion.prepareStatement(Sentencia);
            Comando.executeUpdate();
            
            
            //DIRRECION          
            Comando = ConsultaDireccion(user, tipo);
            Consulta = Comando.executeQuery();
            i = 0;
            while (Consulta.next()) {
                id[i] = Consulta.getInt(2);
                i++;
            }
            if (id[0] < id[1]) {
                int temp = id[0];
                id[0] = id[1];
                id[1] = temp;
            }
            Sentencia = ("UPDATE \"DIRECCION-" + tipo + "\" SET DIRECCION = '" + dir1 + "' WHERE \"NRO-DIRECCION\" = " + id[0]);
            System.out.println(Sentencia);
            conexion = ConexionDB.conectar();
            Comando = conexion.prepareStatement(Sentencia);
            Comando.executeUpdate();
            Sentencia = ("UPDATE \"DIRECCION-" + tipo + "\" SET DIRECCION = '" + dir2 + "' WHERE \"NRO-DIRECCION\" = " + id[1]);
            System.out.println(Sentencia);
            conexion = ConexionDB.conectar();
            Comando = conexion.prepareStatement(Sentencia);
            Comando.executeUpdate();
            
            
            ///TELEFONO
            Comando = ConsultaTelefono(user, tipo);
            Consulta = Comando.executeQuery();
            i = 0;
            while (Consulta.next()) {
                id[i] = Consulta.getInt(2);
                i++;
            }
            if (id[0] < id[1]) {
                int temp = id[0];
                id[0] = id[1];
                id[1] = temp;
            }
            Sentencia = ("UPDATE \"TELEFONO-" + tipo + "\" SET TELEFONO = '" + dir1 + "' WHERE \"NRO-TELEFONO\" = " + id[0]);
            System.out.println(Sentencia);
            conexion = ConexionDB.conectar();
            Comando = conexion.prepareStatement(Sentencia);
            Comando.executeUpdate();
            Sentencia = ("UPDATE \"TELEFONO-" + tipo + "\" SET TELEFONO = '" + dir2 + "' WHERE \"NRO-TELEFONO\" = " + id[1]);
            System.out.println(Sentencia);
            conexion = ConexionDB.conectar();
            Comando = conexion.prepareStatement(Sentencia);
            Comando.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
