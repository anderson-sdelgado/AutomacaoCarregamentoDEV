/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pst;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author anderson
 */
public class MsgPST {

    public MsgPST() {
    }

    public String retornaMsg(String tipo, int confirmacao) {

        String sql = "";
        String msg = "";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rSet = null;

        try {

            System.gc();

            conn = ConnectionPST.getInstance().getConnection();
            stmt = conn.createStatement();
            rSet = stmt.executeQuery("SELECT MSG FROM INTERFACE.AUTO_PATIO_MSG WHERE TIPO_PRODUTO = " + tipo + " AND CONFIRMACAO = " + confirmacao);

            while (rSet.next()) {
                msg = rSet.getString(1);
            }

            try {
                if (rSet != null) {
                    rSet.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Erro2 = " + e);
        }

        return msg;

    }

}
