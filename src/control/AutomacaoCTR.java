/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import bean.ClienteBean;
import bean.DadosCarregBean;
import bean.UltViagemBean;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import persistence.ClientePST;
import persistence.DadosRetornoPST;
import persistence.MsgPST;
import persistence.ReimpressaoPST;
import persistence.UltCarregPST;
import util.CNP;
import util.TCPIP;
import util.TP650;

/**
 *
 * @author anderson
 */
public class AutomacaoCTR {
    
    private String textoCPF;
    private String textoPlaca;
    private String textoCelular;
    private int qtde = 0;
    private UltViagemBean ultViagemBean;
    private DadosCarregBean dadosCarregBean;
    
    public AutomacaoCTR() {
        dadosCarregBean = new DadosCarregBean();
        ultViagemBean = new UltViagemBean();
    }
    
    ////////////////////////TelaCPFJPanel///////////////////////////////////////
    
    public String preencherCPF(String texto) {
        String textoRet;
        switch (qtde) {
            case 0:
                qtde++;
                textoCPF = textoCPF + texto;
                textoRet = textoCPF + "__.___.___-__";
                break;
            case 1:
                qtde++;
                textoCPF = textoCPF + texto;
                textoRet = textoCPF + "_.___.___-__";
                break;
            case 2:
                qtde++;
                textoCPF = textoCPF + texto;
                textoRet = textoCPF + ".___.___-__";
                break;
            case 3:
                qtde++;
                textoCPF = textoCPF + '.' + texto;
                textoRet = textoCPF + "__.___-__";
                break;
            case 4:
                qtde++;
                textoCPF = textoCPF + texto;
                textoRet = textoCPF + "_.___-__";
                break;
            case 5:
                qtde++;
                textoCPF = textoCPF + texto;
                textoRet = textoCPF + ".___-__";
                break;
            case 6:
                qtde++;
                textoCPF = textoCPF + '.' + texto;
                textoRet = textoCPF + "__-__";
                break;
            case 7:
                qtde++;
                textoCPF = textoCPF + texto;
                textoRet = textoCPF + "_-__";
                break;
            case 8:
                qtde++;
                textoCPF = textoCPF + texto;
                textoRet = textoCPF + "-__";
                break;
            case 9:
                qtde++;
                textoCPF = textoCPF + '-' + texto;
                textoRet = textoCPF + "_";
                break;
            case 10:
                qtde++;
                textoCPF = textoCPF + texto;
                textoRet = textoCPF;
                break;
            default:
                textoRet = textoCPF;
                break;
        }
        return textoRet;
    }
    
    public String apagarCPF() {
        String textoRet;
        switch (qtde) {
            case 1:
                qtde--;
                textoCPF = textoCPF.substring(0, textoCPF.length() - 1);
                textoRet = textoCPF + "___.___.___-__";
                break;
            case 2:
                qtde--;
                textoCPF = textoCPF.substring(0, textoCPF.length() - 1);
                textoRet = textoCPF + "__.___.___-__";
                break;
            case 3:
                qtde--;
                textoCPF = textoCPF.substring(0, textoCPF.length() - 1);
                textoRet = textoCPF + "_.___.___-__";
                break;
            case 4:
                qtde--;
                textoCPF = textoCPF.substring(0, textoCPF.length() - 2);
                textoRet = textoCPF + ".___.___-__";
                break;
            case 5:
                qtde--;
                textoCPF = textoCPF.substring(0, textoCPF.length() - 1);
                textoRet = textoCPF + "__.___-__";
                break;
            case 6:
                qtde--;
                textoCPF = textoCPF.substring(0, textoCPF.length() - 1);
                textoRet = textoCPF + "_.___-__";
                break;
            case 7:
                qtde--;
                textoCPF = textoCPF.substring(0, textoCPF.length() - 2);
                textoRet = textoCPF + ".___-__";
                break;
            case 8:
                qtde--;
                textoCPF = textoCPF.substring(0, textoCPF.length() - 1);
                textoRet = textoCPF + "__-__";
                break;
            case 9:
                qtde--;
                textoCPF = textoCPF.substring(0, textoCPF.length() - 1);
                textoRet = textoCPF + "_-__";
                break;
            case 10:
                qtde--;
                textoCPF = textoCPF.substring(0, textoCPF.length() - 2);
                textoRet = textoCPF + "-__";
                break;
            case 11:
                qtde--;
                textoCPF = textoCPF.substring(0, textoCPF.length() - 1);
                textoRet = textoCPF + "_";
                break;
            default:
                textoRet = "___.___.___-__";
                break;
        }
        return textoRet;
    }

    public String okCPF(){
        if (qtde == 11) {
            String cpfLimpo = textoCPF.replace(".", "").replace("-", "");
            if (isCPF(textoCPF.toString().trim())) {
//            if (true) {
                UltCarregPST carregPST = new UltCarregPST();
                ultViagemBean = carregPST.retUltViagem(cpfLimpo);
                dadosCarregBean = new DadosCarregBean();
                dadosCarregBean.setCpf(cpfLimpo);
                dadosCarregBean.setNomeMotorista(ultViagemBean.getNomeMotorista());
                if (ultViagemBean.getMsgErro().equals("0")) {
                    if (ultViagemBean.getNomeMotorista().equals("0")) {
                        dadosCarregBean.setConfirmaDados(0);
                        dadosCarregBean.setRgMotorista(null);
                        dadosCarregBean.setCnhMotorista(null);
                        dadosCarregBean.setValCnhMotorista(null);
                        dadosCarregBean.setIdCliente("0");
                        return "TelaDadosNEnc";
                    } else {
                        dadosCarregBean.setConfirmaDados(1);
                        dadosCarregBean.setCapacidade(ultViagemBean.getCapacidade());
                        dadosCarregBean.setCnhMotorista(ultViagemBean.getCnhMotorista());
                        dadosCarregBean.setDescrProdCarreg(ultViagemBean.getDescrProdCarreg());
                        dadosCarregBean.setIdProdCarreg(ultViagemBean.getIdProdCarreg());
                        dadosCarregBean.setIdTercTransp(ultViagemBean.getIdTercTransp());
                        dadosCarregBean.setNomeTransp(ultViagemBean.getNomeTransp());
                        dadosCarregBean.setPlaca1(ultViagemBean.getPlaca1());
                        dadosCarregBean.setPlaca2(ultViagemBean.getPlaca2());
                        dadosCarregBean.setPlaca3(ultViagemBean.getPlaca3());
                        dadosCarregBean.setRgMotorista(ultViagemBean.getRgMotorista());
                        dadosCarregBean.setValCnhMotorista(ultViagemBean.getValCnhMotorista());
                        dadosCarregBean.setIdCliente(ultViagemBean.getIdCliente());
                        dadosCarregBean.setDescrCliente(ultViagemBean.getDescrCliente());
                        dadosCarregBean.setRuaCliente(ultViagemBean.getRuaCliente());
                        dadosCarregBean.setNumCliente(ultViagemBean.getNumCliente());
                        dadosCarregBean.setBairroCliente(ultViagemBean.getBairroCliente());
                        dadosCarregBean.setComplCliente(ultViagemBean.getComplCliente());
                        dadosCarregBean.setCidadeCliente(ultViagemBean.getCidadeCliente());
                        dadosCarregBean.setEstadoCliente(ultViagemBean.getEstadoCliente());
                        return "TelaDadosUltCarreg";
                    }
                } else {
                    dadosCarregBean.setMsgErro(ultViagemBean.getMsgErro());
                    dadosCarregBean.setIdPreOrdCarreg(ultViagemBean.getIdPreOrdCarreg());
                    return "TelaCamCPreOrdem";
                }
            } else {
                return "CPF INVÁLIDO";
            }
        } else {
            return "CPF ABERTO";
        }
    }
    
    ////////////////////////////////////////////////////////////////////////////
    
    ///////////////////////////////TelaCamCPreOrdem/////////////////////////////
    
    public String reimprimir() {

        if(!dadosCarregBean.getIdPreOrdCarreg().equals("0")){

            ReimpressaoPST reimpressaoPST = new ReimpressaoPST();
            dadosCarregBean = reimpressaoPST.retReimpressao(dadosCarregBean);

            if(dadosCarregBean.getMsg().equals("")){

                reimpressaoPST.addReimpressao(dadosCarregBean);

                try {
                    TCPIP s = new TCPIP();
                    TP650 tp = new TP650();
                    s.connect();
                    s.write(tp.textoNormal(""));
                    s.write(tp.textoNormal("USINA SANTA FE S.A."));
                    s.write("\n");
                    s.write("\n");
                    s.write(tp.textoNormal("TICKET DE CARREGAMENTO"));
                    s.write("\n");
                    s.write(tp.textoNegrito(dadosCarregBean.getSenha()));
                    s.write("\n");
                    s.write("\n");
                    s.write(tp.textoNormal("PLACAS: " + dadosCarregBean.getPlaca1()
                                            + " | " + dadosCarregBean.getPlaca2()
                                            + " | " + dadosCarregBean.getPlaca3() + ""));
                    s.write("\n");
                    if(!dadosCarregBean.getNomeMotorista().equals("0")){
                        s.write(tp.textoNormal(dadosCarregBean.getNomeMotorista()));
                    }
                    s.write("\n");
                    s.write("\n");
                    s.write(tp.qrcode(8, dadosCarregBean.getSenha()));
                    s.write("\n");
                    s.write("\n");
                    s.write("\n");
                    s.write("\n");
                    s.write(tp.abreGaveta(0, 4));
                    s.write("\n\n\n\n");
                    s.write(tp.cortePapel());
                    s.close();

                } catch (IOException ex) {
                    JOptionPane.showConfirmDialog(null, "Error: " + ex);
                }
                return "Retorno";
            }
            else{
                return "MSG";
            }
            
        }
        else{
            return "NãoContemPreOrdem";
        }
        
    }

    ////////////////////////////////////////////////////////////////////////////
    
    //////////////////////////////////TelaCamera////////////////////////////////

    public void atualizarDadosRetorno() throws Exception{
        DadosRetornoPST senhaRetornoPST = new DadosRetornoPST();
        if (!dadosCarregBean.getIdProdCarreg().equals("5")) {
            dadosCarregBean.setIdCliente("0");
        }
        dadosCarregBean = senhaRetornoPST.retDadosCarreg(dadosCarregBean);
    }
    
    ////////////////////////////////////////////////////////////////////////////
        
    ///////////////////////////TelaClassifProdCarreg////////////////////////////
    
    public void classif1(){
        if (dadosCarregBean.getIdProdCarreg().equals("acucar")) {
            dadosCarregBean.setIdProdCarreg("2");
        } else {
            dadosCarregBean.setIdProdCarreg("3");
        }
    }
    
    public void classif2(){
        if (dadosCarregBean.getIdProdCarreg().equals("acucar")) {
            dadosCarregBean.setIdProdCarreg("1");
        } else {
            dadosCarregBean.setIdProdCarreg("4");
        }
    }
    
    ////////////////////////////////////////////////////////////////////////////
        
    ///////////////////////////TelaImprimirSenha////////////////////////////////
    
    public String msgImprimir(){
        MsgPST msgPST = new MsgPST();
        String tipo;
        if (dadosCarregBean.getIdProdCarreg().equals("1")
                || dadosCarregBean.getIdProdCarreg().equals("2")) {
            tipo = "1";
        } else {
            tipo = "2";
        }
        if(dadosCarregBean.getIdEtapa() != null){
            if (dadosCarregBean.getIdEtapa().trim().equals("2")) {
                dadosCarregBean.setConfirmaDados(0);
            }
        }
        return msgPST.retornaMsg(tipo, dadosCarregBean.getConfirmaDados());
    }
    
    public void imprimir(){
        try {
            TCPIP s = new TCPIP();
            TP650 tp = new TP650();
            s.connect();
            s.write(tp.textoNormal(""));
            s.write(tp.textoNormal("USINA SANTA FE S.A."));
            s.write("\n");
            s.write("\n");
            s.write(tp.textoNormal("TICKET DE CARREGAMENTO"));
            s.write("\n");
            s.write(tp.textoNegrito(dadosCarregBean.getSenha()));
            s.write("\n");
            s.write("\n");
            s.write(tp.textoNormal("PLACAS: " + dadosCarregBean.getPlaca1()
                                    + " | " + dadosCarregBean.getPlaca2()
                                    + " | " + dadosCarregBean.getPlaca3() + ""));
            s.write("\n");
            if(!dadosCarregBean.getNomeMotorista().equals("0")){
                s.write(tp.textoNormal(dadosCarregBean.getNomeMotorista()));
            }
            s.write("\n");
            s.write("\n");
            s.write(tp.qrcode(8, dadosCarregBean.getSenha()));
            s.write("\n");
            s.write("\n");
            s.write("\n");
            s.write("\n");
            s.write(tp.abreGaveta(0, 4));
            s.write("\n\n\n\n");
            s.write(tp.cortePapel());
            s.close();
        } catch (IOException ex) {
            JOptionPane.showConfirmDialog(null, "Error: " + ex);
        }
    }
    
    ////////////////////////////////////////////////////////////////////////////
        
    ///////////////////////////TelaListaCliente/////////////////////////////////
        
    public DefaultListModel preencherListaCliente(){
        ClientePST clientePST = new ClientePST();
        ArrayList clienteList = clientePST.retornaListCliente();
        DefaultListModel modelo = new DefaultListModel();
        for (int i = 0; i < clienteList.size(); i++) {
            ClienteBean clienteTO = (ClienteBean) clienteList.get(i);
            modelo.addElement(clienteTO.getDescrCliente());
        }
        clienteList.clear();
        return modelo;
    }
    
    public void ajusterCliente(int posLista){
        ClientePST clientePST = new ClientePST();
        ArrayList clienteList = clientePST.retornaListCliente();
        ClienteBean clienteTO = (ClienteBean) clienteList.get(posLista);
        clienteList.clear();
        dadosCarregBean.setIdCliente(clienteTO.getIdCliente());
    }
    
    ////////////////////////////////////////////////////////////////////////////
        
    /////////////////////////////TelaPlaca//////////////////////////////////////
    
    public String preencherPlaca(String texto) {
        String textoRet;
        switch (qtde) {
            case 0:
                qtde++;
                textoPlaca = textoPlaca + texto;
                textoRet = textoPlaca + "__-____";
                break;
            case 1:
                qtde++;
                textoPlaca = textoPlaca + texto;
                textoRet = textoPlaca + "_-____";
                break;
            case 2:
                qtde++;
                textoPlaca = textoPlaca + texto;
                textoRet = textoPlaca + "-____";
                break;
            case 3:
                qtde++;
                textoPlaca = textoPlaca + '-' + texto;
                textoRet = textoPlaca + "___";
                break;
            case 4:
                qtde++;
                textoPlaca = textoPlaca + texto;
                textoRet = textoPlaca + "__";
                break;
            case 5:
                qtde++;
                textoPlaca = textoPlaca + texto;
                textoRet = textoPlaca + "_";
                break;
            case 6:
                qtde++;
                textoPlaca = textoPlaca + texto;
                textoRet = textoPlaca;
                break;
            default:
                textoRet = textoPlaca;
                break;
        }
        return textoRet;
    }

    public String apagarPlaca() {
        String textoRet;
        switch (qtde) {
            case 1:
                qtde--;
                textoPlaca = textoPlaca.substring(0, textoPlaca.length() - 1);
                textoRet = textoPlaca + "___-____";
                break;
            case 2:
                qtde--;
                textoPlaca = textoPlaca.substring(0, textoPlaca.length() - 1);
                textoRet = textoPlaca + "__-____";
                break;
            case 3:
                qtde--;
                textoPlaca = textoPlaca.substring(0, textoPlaca.length() - 1);
                textoRet = textoPlaca + "_-____";
                break;
            case 4:
                qtde--;
                textoPlaca = textoPlaca.substring(0, textoPlaca.length() - 2);
                textoRet = textoPlaca + "-____";
                break;
            case 5:
                qtde--;
                textoPlaca = textoPlaca.substring(0, textoPlaca.length() - 1);
                textoRet = textoPlaca + "___";
                break;
            case 6:
                qtde--;
                textoPlaca = textoPlaca.substring(0, textoPlaca.length() - 1);
                textoRet = textoPlaca + "__";
                break;
            case 7:
                qtde--;
                textoPlaca = textoPlaca.substring(0, textoPlaca.length() - 1);
                textoRet = textoPlaca + "_";
                break;
            default:
                textoRet = "___-____";
                break;
        }
        return textoRet;
    }
    
    ////////////////////////////////////////////////////////////////////////////
        
    /////////////////////////////TelaWhatsapp///////////////////////////////////
    
    public String preencherCelular(String texto) {
        String textoRet;
        switch (qtde) {
            case 0:
                qtde++;
                textoCelular = textoCelular + "(" + texto;
                textoRet = textoCelular + "_) _____-____";
                break;
            case 1:
                qtde++;
                textoCelular = textoCelular + texto;
                textoRet = textoCelular + ") _____-____";
                break;
            case 2:
                qtde++;
                textoCelular = textoCelular + ") " + texto;
                textoRet = textoCelular + "____-____";
                break;
            case 3:
                qtde++;
                textoCelular = textoCelular + texto;
                textoRet = textoCelular + "___-____";
                break;
            case 4:
                qtde++;
                textoCelular = textoCelular + texto;
                textoRet = textoCelular + "__-____";
                break;
            case 5:
                qtde++;
                textoCelular = textoCelular + texto;
                textoRet = textoCelular + "_-____";
                break;
            case 6:
                qtde++;
                textoCelular = textoCelular + texto;
                textoRet = textoCelular + "-____";
                break;
            case 7:
                qtde++;
                textoCelular = textoCelular + '-' + texto;
                textoRet = textoCelular + "___";
                break;
            case 8:
                qtde++;
                textoCelular = textoCelular + texto;
                textoRet = textoCelular + "__";
                break;
            case 9:
                qtde++;
                textoCelular = textoCelular + texto;
                textoRet = textoCelular + "_";
                break;
            case 10:
                qtde++;
                textoCelular = textoCelular + texto;
                textoRet = textoCelular;
                break;
            default:
                textoRet = textoCelular;
                break;
        }
        return textoRet;
    }

    public String apagarCelular() {
        String textoRet;
        switch (qtde) {
            case 1:
                qtde--;
                textoCelular = textoCelular.substring(0, textoCelular.length() - 2);
                textoRet = textoCelular + "(__) _____-____";
                break;
            case 2:
                qtde--;
                textoCelular = textoCelular.substring(0, textoCelular.length() - 1);
                textoRet = textoCelular + "_) _____-____";
                break;
            case 3:
                qtde--;
                textoCelular = textoCelular.substring(0, textoCelular.length() - 3);
                textoRet = textoCelular + ") _____-____";
                break;
            case 4:
                qtde--;
                textoCelular = textoCelular.substring(0, textoCelular.length() - 1);
                textoRet = textoCelular + "____-____";
                break;
            case 5:
                qtde--;
                textoCelular = textoCelular.substring(0, textoCelular.length() - 1);
                textoRet = textoCelular + "___-____";
                break;
            case 6:
                qtde--;
                textoCelular = textoCelular.substring(0, textoCelular.length() - 1);
                textoRet = textoCelular + "__-____";
                break;
            case 7:
                qtde--;
                textoCelular = textoCelular.substring(0, textoCelular.length() - 1);
                textoRet = textoCelular + "_-____";
                break;
            case 8:
                qtde--;
                textoCelular = textoCelular.substring(0, textoCelular.length() - 2);
                textoRet = textoCelular + "-____";
                break;
            case 9:
                qtde--;
                textoCelular = textoCelular.substring(0, textoCelular.length() - 1);
                textoRet = textoCelular + "___";
                break;
            case 10:
                qtde--;
                textoCelular = textoCelular.substring(0, textoCelular.length() - 1);
                textoRet = textoCelular + "__";
                break;
            case 11:
                qtde--;
                textoCelular = textoCelular.substring(0, textoCelular.length() - 1);
                textoRet = textoCelular + "_";
                break;
            default:
                textoRet = "(__) _____-____";
                break;
        }
        return textoRet;
    }
    
    ////////////////////////////////////////////////////////////////////////////
    
    public boolean isCPF(String cpf) {
        CNP cnp = new CNP();
        return cnp.isValidCPF(cpf);
    }

    public String getTextoCPF() {
        return textoCPF;
    }

    public void setTextoCPF(String textoCPF) {
        this.textoCPF = textoCPF;
    }

    public String getTextoPlaca() {
        return textoPlaca;
    }

    public void setTextoPlaca(String textoPlaca) {
        this.textoPlaca = textoPlaca;
    }

    public String getTextoCelular() {
        return textoCelular;
    }

    public void setTextoCelular(String textoCelular) {
        this.textoCelular = textoCelular;
    }
    
    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public UltViagemBean getUltViagemBean() {
        return ultViagemBean;
    }

    public void setUltViagemBean(UltViagemBean ultViagemBean) {
        this.ultViagemBean = ultViagemBean;
    }

    public DadosCarregBean getDadosCarregBean() {
        return dadosCarregBean;
    }

    public void setDadosCarregBean(DadosCarregBean dadosCarregBean) {
        this.dadosCarregBean = dadosCarregBean;
    }

}
