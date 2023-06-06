/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import dbutil.Conn;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import bean.ClienteBean;

/**
 *
 * @author anderson
 */
public class ClientePST {

    public ClientePST() {
    }

    public ArrayList retornaListCliente() {

        String sql = "";
        String msg = "";
        ArrayList arrayList = new ArrayList();

        Connection conn = null;
        Statement stmt = null;
        ResultSet rSet = null;

        try {

            System.gc();

            conn = Conn.getInstance().getConnection();
            stmt = conn.createStatement();
            rSet = stmt.executeQuery("SELECT "
                    + " CLIENT_ID "
                    + " , NOME_FANT "
                    + " FROM "
                    + " USINAS.V_CLIENT_BAGACO "
                    + " ORDER BY NOME_FANT ASC");

            while (rSet.next()) {
                ClienteBean clienteTO = new ClienteBean();
                clienteTO.setIdCliente(rSet.getString(1));
                clienteTO.setDescrCliente(rSet.getString(2));
                arrayList.add(clienteTO);
            }

            ClienteBean clienteSOTO = new ClienteBean();
            clienteSOTO.setIdCliente("0");
            clienteSOTO.setDescrCliente("NENHUMA DAS OPÇÕES");
            arrayList.add(clienteSOTO);

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

        return arrayList;

    }

}
