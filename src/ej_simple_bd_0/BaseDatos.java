/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej_simple_bd_0;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import static sun.security.jgss.GSSUtil.login;

/*
drop table productos;
create table productos(
id integer NOT NULL,
nombre varchar(50),
categoria varchar(20),
PRIMARY KEY(id)

)
*/


/*
 * @author julio
 */
public class BaseDatos {

    Connection conn;
    public String urlPostgres = "jdbc:postgresql://127.0.0.1/isp_ventas?charSet=UTF-8&amp;locale=es_ES&amp;lc_messages=es_ES";

    public void desconectar() throws SQLException {
        conn.close();
    }

    public String conectar() throws Exception {

        try {
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection(urlPostgres, "postgres", "carcajada");
           
        } catch (Exception ex) {
            
        }

        return "";
    }

    public void leerProductos() {
        Statement stmt = null;
        ResultSet rs = null;
        String cadenasql = "";

        try {

            cadenasql = "select * from productos;";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(cadenasql);

            while(rs.next()) {
                   System.out.println( rs.getString("nombre") );
            }

            stmt.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        
    }

    public void insertaProducto(String id, String nombre, String categoria) throws Exception {
        Statement stmt = null;
        String cadenasql = "";

        try {

            cadenasql = "insert into productos (id,nombre,categoria) values (";
            cadenasql += id + ", ";
            cadenasql += "'" + nombre + "', ";
            cadenasql += "'" + categoria+ "' ";
            cadenasql += ");";

            stmt = conn.createStatement();
            stmt.execute(cadenasql);
        } catch (Exception e) {
            throw e;   
        }

    }
}
