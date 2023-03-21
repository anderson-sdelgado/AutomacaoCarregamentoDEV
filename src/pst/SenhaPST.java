/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pst;

import dbutil.Conn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anderson
 */
public class SenhaPST {

    public SenhaPST() {
    }

    public String retornaSenha(){

        String sql = "";
        String senha = "";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rSet = null;

        try
        {

            System.gc();

            conn = Conn.getInstance().getConnection();
            stmt = conn.createStatement();
            rSet = stmt.executeQuery("SELECT SENHA FROM INTERFACE.AUTO_PATIO_SENHA");

            while(rSet.next())
            {
                senha = rSet.getString(1);
            }

            try {
                if (rSet != null)
                    rSet.close();
                if (stmt != null)
                    stmt.close();
//                if (conn != null)
//                    conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }catch(Exception e){
            System.out.println("Erro2 = " + e);
        }

        return senha;

    }
    
}
