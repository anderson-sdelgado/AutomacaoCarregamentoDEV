/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import dbutil.Conn;
import java.sql.CallableStatement;
import java.sql.Connection;
import bean.DadosCarregBean;

/**
 *
 * @author anderson
 */
public class DadosRetornoPST {

    public DadosRetornoPST() {
    }

    public DadosCarregBean retDadosCarreg(DadosCarregBean dadosCarregTO) {

        Connection conn = null;
        CallableStatement callableStatement = null;
        String sql = "{call usinas.pk_pre_oc_totem.pb_ins_pre_oc(?,?,?,"
                + "?,?,?,?,"
                + "?,?,?,?,?,?,?)}";

        try {

            conn = Conn.getInstance().getConnection();
            callableStatement = conn.prepareCall(sql);

            System.out.println("dadosCarregTO.getIdProdCarreg() = " + dadosCarregTO.getIdProdCarreg());
            System.out.println("dadosCarregTO.getCpf() = " + dadosCarregTO.getCpf().replace(".", "").replace("-", ""));
            System.out.println("dadosCarregTO.getIdCliente() = " + dadosCarregTO.getIdCliente());
            System.out.println("dadosCarregTO.getCelular() = " + dadosCarregTO.getCelular().replace("-", "").replace("(", "").replace(")", "").replace(" ", ""));
            System.out.println("dadosCarregTO.getIdTercTransp() = " + dadosCarregTO.getIdTercTransp());
            System.out.println("dadosCarregTO.getPlaca1() = " + dadosCarregTO.getPlaca1().replace("-", ""));
            System.out.println("dadosCarregTO.getPlaca2() = " + dadosCarregTO.getPlaca2());
            System.out.println("dadosCarregTO.getPlaca3() = " + dadosCarregTO.getPlaca3());
            System.out.println("dadosCarregTO.getConfirmaDados() = " + dadosCarregTO.getConfirmaDados());
            
            callableStatement.setString(1, dadosCarregTO.getIdProdCarreg()); //
            callableStatement.setString(2, dadosCarregTO.getCpf().replace(".", "").replace("-", "")); //
            callableStatement.setString(4, dadosCarregTO.getIdCliente()); //
            callableStatement.setString(3, dadosCarregTO.getCelular().replace("-", "").replace("(", "").replace(")", "").replace(" ", "")); //
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
            dadosCarregTO.setIdEtapa(callableStatement.getString(11));
            dadosCarregTO.setDescrEtapa(callableStatement.getString(12));
            dadosCarregTO.setIdCarreg(callableStatement.getString(13));
            dadosCarregTO.setMsg(callableStatement.getString(14));

            System.out.println("dadosCarregTO.setSenha = " + callableStatement.getString(10));
            System.out.println("dadosCarregTO.setEtapa = " + callableStatement.getString(11));
            System.out.println("dadosCarregTO.setDescrStatus = " + callableStatement.getString(12));
            System.out.println("dadosCarregTO.setIdCarreg = " + callableStatement.getString(13));
            System.out.println("dadosCarregTO.setMsg = " + callableStatement.getString(14));
            
        } catch (Exception e) {
            System.out.println("Erro = " + e);
        }

        return dadosCarregTO;
    }

}
