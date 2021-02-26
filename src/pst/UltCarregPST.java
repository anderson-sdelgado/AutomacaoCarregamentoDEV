/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pst;

import java.sql.CallableStatement;
import java.sql.Connection;
import to.UltViagemTO;

/**
 *
 * @author anderson
 */
public class UltCarregPST {

    public UltCarregPST() {
    }

    public UltViagemTO retUltViagem(String cpf) {

        UltViagemTO ultViagemTO = new UltViagemTO();
        ultViagemTO.setNomeMotorista("0");
        ultViagemTO.setMsgErro("0");
        ultViagemTO.setIdPreOrdCarreg("0");
        Connection conn = null;
        CallableStatement callableStatement = null;
        String sql = "{call usinas.pk_pre_oc_totem.pb_ult_carreg(?,?,?,?,?,"
                + "?,?,?,?,?,"
                + "?,?,?,?,?,"
                + "?,?,?,?,?,"
                + "?,?,?,?,?,?)}";

        try {

            conn = ConnectionPST.getInstance().getConnection();
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

                ultViagemTO.setNomeMotorista(callableStatement.getString(3));
                ultViagemTO.setRgMotorista(callableStatement.getString(4));
                ultViagemTO.setCnhMotorista(callableStatement.getString(5));
                ultViagemTO.setValCnhMotorista(callableStatement.getString(6));
                
                ultViagemTO.setIdCliente(callableStatement.getString(8));
                ultViagemTO.setDescrCliente(callableStatement.getString(9));
                ultViagemTO.setRuaCliente(callableStatement.getString(10));
                ultViagemTO.setNumCliente(callableStatement.getString(11));
                ultViagemTO.setBairroCliente(callableStatement.getString(12));
                if (callableStatement.getString(13) == null) {
                    ultViagemTO.setComplCliente("");
                }else{
                    ultViagemTO.setComplCliente(callableStatement.getString(13));
                }
                ultViagemTO.setCidadeCliente(callableStatement.getString(14));
                ultViagemTO.setEstadoCliente(callableStatement.getString(15));
                
                ultViagemTO.setNomeTransp(callableStatement.getString(17));
                ultViagemTO.setIdTercTransp(callableStatement.getString(18));
                ultViagemTO.setIdProdCarreg(callableStatement.getString(19));
                ultViagemTO.setDescrProdCarreg(callableStatement.getString(20));
                ultViagemTO.setPlaca1(callableStatement.getString(21));
                if (callableStatement.getString(22) == null) {
                    ultViagemTO.setPlaca2("");
                }
                else{
                    ultViagemTO.setPlaca2(callableStatement.getString(22));
                }
                if (callableStatement.getString(23) == null) {
                    ultViagemTO.setPlaca3("");
                }
                else{
                    ultViagemTO.setPlaca3(callableStatement.getString(23));
                }
                if (callableStatement.getString(24) == null) {
                    ultViagemTO.setCapacidade("");
                }
                else{
                    ultViagemTO.setCapacidade(callableStatement.getString(24));
                }
                
            }

            if (callableStatement.getString(25) != null) {
                ultViagemTO.setIdPreOrdCarreg(callableStatement.getString(25));
            }
            
            if (callableStatement.getString(26) != null) {
                ultViagemTO.setMsgErro(callableStatement.getString(26));
            }

        } catch (Exception e) {
            System.out.println("Erro = " + e);
        }

        return ultViagemTO;
    }

}
