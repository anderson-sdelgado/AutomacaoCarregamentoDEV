/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import dbutil.Conn;
import java.sql.CallableStatement;
import java.sql.Connection;
import bean.UltCarregBean;

/**
 *
 * @author anderson
 */
public class UltCarregPST {

    public UltCarregPST() {
    }

    public UltCarregBean retUltViagem(String cpf) {

        UltCarregBean ultCarregBean = new UltCarregBean();
        ultCarregBean.setNomeMotorista("-");
        ultCarregBean.setMsgErro("0");
        ultCarregBean.setIdPreOrdCarreg("0");
        Connection conn = null;
        CallableStatement callableStatement = null;
        String sql = "{call usinas.pk_pre_oc_totem.pb_ult_carreg(?,?,?,?,?,"
                + "?,?,?,?,?,"
                + "?,?,?,?,?,"
                + "?,?,?,?,?,"
                + "?,?,?,?,?,?)}";

        try {

            conn = Conn.getInstance().getConnection();
            callableStatement = conn.prepareCall(sql);

            callableStatement.setString(1, cpf);
            callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(4, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(5, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(6, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(7, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(8, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(9, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(10, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(11, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(12, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(13, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(14, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(15, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(16, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(17, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(18, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(19, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(20, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(21, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(22, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(23, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(24, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(25, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(26, java.sql.Types.VARCHAR);
            
            callableStatement.executeUpdate();

            if (callableStatement.getString(3) != null) {

                ultCarregBean.setNomeMotorista(callableStatement.getString(3));
                ultCarregBean.setRgMotorista(callableStatement.getString(4));
                ultCarregBean.setCnhMotorista(callableStatement.getString(5));
                ultCarregBean.setValCnhMotorista(callableStatement.getString(6));
                
                ultCarregBean.setIdCliente(callableStatement.getString(8));
                ultCarregBean.setDescrCliente(callableStatement.getString(9));
                ultCarregBean.setRuaCliente(callableStatement.getString(10));
                ultCarregBean.setNumCliente(callableStatement.getString(11));
                ultCarregBean.setBairroCliente(callableStatement.getString(12));
                if (callableStatement.getString(13) == null) {
                    ultCarregBean.setComplCliente("");
                } else{
                    ultCarregBean.setComplCliente(callableStatement.getString(13));
                }
                ultCarregBean.setCidadeCliente(callableStatement.getString(14));
                ultCarregBean.setEstadoCliente(callableStatement.getString(15));
                
                ultCarregBean.setNomeTransp(callableStatement.getString(17));
                ultCarregBean.setIdTercTransp(callableStatement.getString(18));
                ultCarregBean.setIdProdCarreg(callableStatement.getString(19));
                ultCarregBean.setDescrProdCarreg(callableStatement.getString(20));
                ultCarregBean.setPlaca1(callableStatement.getString(21));
                if (callableStatement.getString(22) == null) {
                    ultCarregBean.setPlaca2("");
                } else{
                    ultCarregBean.setPlaca2(callableStatement.getString(22));
                }
                if (callableStatement.getString(23) == null) {
                    ultCarregBean.setPlaca3("");
                } else{
                    ultCarregBean.setPlaca3(callableStatement.getString(23));
                }
                if (callableStatement.getString(24) == null) {
                    ultCarregBean.setCapacidade("");
                } else{
                    ultCarregBean.setCapacidade(callableStatement.getString(24));
                }
                
            }

            if (callableStatement.getString(25) != null) {
                ultCarregBean.setIdPreOrdCarreg(callableStatement.getString(25));
            }
            
            if (callableStatement.getString(26) != null) {
                ultCarregBean.setMsgErro(callableStatement.getString(26));
            }

        } catch (Exception e) {
            System.out.println("Erro = " + e);
        }

        return ultCarregBean;
    }

}
