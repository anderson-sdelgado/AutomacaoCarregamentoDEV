/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pst;

import java.sql.CallableStatement;
import java.sql.Connection;
import to.DadosCarregTO;

/**
 *
 * @author anderson
 */
public class DadosRetornoPST {

    public DadosRetornoPST() {
    }
    
    public DadosCarregTO retDadosCarreg(DadosCarregTO dadosCarregTO) {

        Connection conn = null;
        CallableStatement callableStatement = null;
        String sql = "{call usinas.pk_pre_oc_totem.pb_ins_pre_oc(?,?,?,"
                + "?,?,?,?,"
                + "?,?,?,?,?,?,?)}";

        try {

            conn = ConnectionPST.getInstance().getConnection();
            callableStatement = conn.prepareCall(sql);
            
            callableStatement.setString(1, dadosCarregTO.getIdProdCarreg());
            callableStatement.setString(2, dadosCarregTO.getCpf());
            callableStatement.setString(4, dadosCarregTO.getIdCliente());
            callableStatement.setString(3, dadosCarregTO.getCelular().replace("-", "").replace("(", "").replace(")", "").replace(" ", ""));
            callableStatement.setString(5, dadosCarregTO.getIdTercTransp());
            callableStatement.setString(6, dadosCarregTO.getPlaca1().replace("-", ""));
            callableStatement.setString(7, dadosCarregTO.getPlaca2());
            callableStatement.setString(8, dadosCarregTO.getPlaca3());
            callableStatement.setInt(9, dadosCarregTO.getConfirmaDados());
            callableStatement.registerOutParameter(10, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(11, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(12, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(13, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(14, java.sql.Types.VARCHAR);

            callableStatement.executeUpdate();

            dadosCarregTO.setSenha(callableStatement.getString(10));
            dadosCarregTO.setEtapa(callableStatement.getString(11));
            dadosCarregTO.setDescrStatus(callableStatement.getString(12));
            dadosCarregTO.setIdCarreg(callableStatement.getString(13));
            dadosCarregTO.setMsg(callableStatement.getString(14));
            

        } catch (Exception e) {
            System.out.println("Erro = " + e);
        }

        return dadosCarregTO;
    }
    
}
