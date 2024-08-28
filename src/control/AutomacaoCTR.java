/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import util.Const;
import bean.ClienteBean;
import bean.DadosCarregBean;
import bean.UltCarregBean;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
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
    private UltCarregBean ultViagemBean;
    private DadosCarregBean dadosCarregBean;
    
    private Webcam webcam = null;
    private WebcamPanel webcamPanel = null;
    private Executor executor = Executors.newSingleThreadExecutor();
    private AtomicBoolean initialized = new AtomicBoolean(false);
    
    private boolean motoristaExistente;
    private boolean dadosConfirmado;
    private boolean confirmarMotorista;
    private boolean confirmarProduto;
    private boolean confirmarCliente;
    private boolean confirmarTransp;
    private boolean confirmarVeic;
    
    private TipoProduto tipoProduto;
    
    private String idProduto;
    private String idCliente;
    
    public enum TipoProduto {
        AÇUCAR, ETANOL;
    }

    public AutomacaoCTR() {
        ultViagemBean = new UltCarregBean();
    }

    /////////////////////////////////CAMERA/////////////////////////////////////
    
    public void abrirCamera(){
        webcam = Webcam.getDefault();
        webcam.setViewSize(WebcamResolution.VGA.getSize());
        webcamPanel = new WebcamPanel(webcam, false);
        webcamPanel.setPreferredSize(webcam.getViewSize());
        webcamPanel.setOpaque(true);
        webcamPanel.setBackground(Color.BLACK);
        webcamPanel.setBounds(0, 0, 640, 480);
        if (initialized.compareAndSet(false, true)) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    webcamPanel.start();
                }
            });
        }
    }
    
    ////////////////////////////////////////////////////////////////////////////
    
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

    public String okCPF() {
        if (qtde == 11) {
            String cpfLimpo = textoCPF.replace(".", "").replace("-", "");
            if (isCPF(textoCPF.trim())) {
                UltCarregPST carregPST = new UltCarregPST();
                ultViagemBean = carregPST.retUltViagem(cpfLimpo);
                motoristaExistente = true;
                dadosConfirmado = true;
                confirmarMotorista = true;
                confirmarProduto = true;
                confirmarCliente = true;
                confirmarTransp = true;
                confirmarVeic = true;
                if (ultViagemBean.getMsgErro().equals("0")) {
                    if (ultViagemBean.getNomeMotorista().equals("-")) {
                        motoristaExistente = false;
                        dadosConfirmado = false;
                        return Const.TELA_MOTO_NAO_ENC;
                    } else {
                        motoristaExistente = true;
                        dadosConfirmado = true;
                        return Const.TELA_ULT_DADOS_CARREG_MOTO;
                    }
                } else {
                    return Const.TELA_REIMPRIMIR;
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

        if (!ultViagemBean.getIdPreOrdCarreg().equals("0")) {

            ReimpressaoPST reimpressaoPST = new ReimpressaoPST();
            dadosCarregBean = reimpressaoPST.retReimpressao(ultViagemBean.getIdPreOrdCarreg());

            if (dadosCarregBean.getMsg().equals("")) {

                reimpressaoPST.addReimpressao(ultViagemBean.getIdPreOrdCarreg());
                imprimir();
                
                return "Retorno";
            } else {
                return "MSG";
            }

        } else {
            return "NãoContemPreOrdem";
        }

    }

    ////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////TelaCamera////////////////////////////////
    
    public void salvarDadosCarreg() {
        DadosCarregBean dadosCarregBean = new DadosCarregBean();
        dadosCarregBean.setCpf(textoCPF);            
        dadosCarregBean.setCelular(textoCelular);
        dadosCarregBean.setUltCarregBean(ultViagemBean);
        if(motoristaExistente){
            dadosCarregBean.setConfirmaDados(1);
            if(!confirmarMotorista){
                dadosCarregBean.setConfirmaDados(0);
            }
            if(!confirmarProduto){
                dadosCarregBean.getUltCarregBean().setIdProdCarreg(idProduto);
                dadosCarregBean.setConfirmaDados(0);
            }
            if(!confirmarCliente){
                dadosCarregBean.getUltCarregBean().setIdCliente(idCliente);
            }
            if(!confirmarTransp){
                dadosCarregBean.setConfirmaDados(0);
            }
            if(!confirmarVeic){
                dadosCarregBean.getUltCarregBean().setPlaca1(textoPlaca);
                dadosCarregBean.setConfirmaDados(0);
            }
        } else {
            dadosCarregBean.getUltCarregBean().setIdProdCarreg(idProduto);
            dadosCarregBean.getUltCarregBean().setIdCliente(idCliente);
            dadosCarregBean.getUltCarregBean().setPlaca1(textoPlaca);
            dadosCarregBean.setConfirmaDados(0);
        }
        DadosRetornoPST senhaRetornoPST = new DadosRetornoPST();
        if (!dadosCarregBean.getUltCarregBean().getIdProdCarreg().equals("5")) {
            dadosCarregBean.getUltCarregBean().setIdCliente(null);
        } else {
            if (dadosCarregBean.getUltCarregBean().getIdCliente().equals("0")) {
                dadosCarregBean.getUltCarregBean().setIdCliente(null);
            }    
        }
        
        this.dadosCarregBean = senhaRetornoPST.retDadosCarreg(dadosCarregBean);
    }

    ////////////////////////////////////////////////////////////////////////////
    
    ///////////////////////////TelaClassifProdCarreg////////////////////////////
    
    public void setProduto1() {
        if (tipoProduto == TipoProduto.AÇUCAR) {
            idProduto = "2";
        } else {
            idProduto = "3";
        }
    }

    public void setProduto2() {
        if (tipoProduto == TipoProduto.AÇUCAR) {
            idProduto = "1";
        } else {
            idProduto = "9";
        }
    }

    ////////////////////////////////////////////////////////////////////////////
  
    ///////////////////////////TelaImprimirSenha////////////////////////////////
    
    public String msgImprimir() {
        MsgPST msgPST = new MsgPST();
        String tipo;
        if (dadosCarregBean.getUltCarregBean().getIdProdCarreg().equals("1")
                || dadosCarregBean.getUltCarregBean().getIdProdCarreg().equals("2")) {
            tipo = "1";
        } else {
            tipo = "2";
        }
        if ((dadosCarregBean.getIdEtapa() != null) && (dadosCarregBean.getIdEtapa().trim().equals("2"))) {
            dadosCarregBean.setConfirmaDados(0);
        }
        return msgPST.retornaMsg(tipo, dadosCarregBean.getConfirmaDados());
    }

    public void imprimir() {
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
            s.write(tp.textoNormal("PLACAS: " + dadosCarregBean.getUltCarregBean().getPlaca1()
                    + " | " + dadosCarregBean.getUltCarregBean().getPlaca2()
                    + " | " + dadosCarregBean.getUltCarregBean().getPlaca3() + ""));
            s.write("\n");
            if (dadosCarregBean.getUltCarregBean().getNomeMotorista() != null) {
                s.write(tp.textoNormal(dadosCarregBean.getUltCarregBean().getNomeMotorista()));
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
    
    public void imprimirTeste() {
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
            s.write(tp.textoNegrito("TES0001"));
            s.write("\n");
            s.write("\n");
            s.write(tp.textoNormal("PLACAS: AAA1111 " 
                    + " | BBB2222"
                    + " | CCC3333"));
            s.write("\n");
//            if (!dadosCarregBean.getNomeMotorista().equals("0")) {
                s.write(tp.textoNormal("ANDERSON DA SILVA DELGADO"));
//            }
            s.write("\n");
            s.write("\n");
            s.write(tp.qrcode(8, "TES0001"));
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
    
    public DefaultListModel preencherListaCliente() {
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

    public void ajusterCliente(int posLista) {
        ClientePST clientePST = new ClientePST();
        ArrayList clienteList = clientePST.retornaListCliente();
        ClienteBean clienteTO = (ClienteBean) clienteList.get(posLista);
        clienteList.clear();
        idCliente = clienteTO.getIdCliente();
    }

    ////////////////////////////////////////////////////////////////////////////
    
    /////////////////////////////TelaPlaca//////////////////////////////////////
    
    public void iniciarDadosTelaPlaca(){
        qtde = 0;
        textoPlaca = "";
    }
    
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

    public Webcam getWebcam() {
        return webcam;
    }
    
    public WebcamPanel getWebcamPanel() {
        return webcamPanel;
    }

    public String getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(String idProduto) {
        this.idProduto = idProduto;
    }

    public boolean isMotoristaExistente() {
        return motoristaExistente;
    }

    public boolean isConfirmarMotorista() {
        return confirmarMotorista;
    }

    public void setConfirmarMotorista(boolean confirmarMotorista) {
        this.confirmarMotorista = confirmarMotorista;
    }

    public boolean isConfirmarProduto() {
        return confirmarProduto;
    }

    public void setConfirmarProduto(boolean confirmarProduto) {
        this.confirmarProduto = confirmarProduto;
    }

    public boolean isConfirmarCliente() {
        return confirmarCliente;
    }

    public void setConfirmarCliente(boolean confirmarCliente) {
        this.confirmarCliente = confirmarCliente;
    }

    public boolean isConfirmarTransp() {
        return confirmarTransp;
    }

    public void setConfirmarTransp(boolean confirmarTransp) {
        this.confirmarTransp = confirmarTransp;
    }

    public boolean isConfirmarVeic() {
        return confirmarVeic;
    }

    public void setConfirmarVeic(boolean confirmarVeic) {
        this.confirmarVeic = confirmarVeic;
    }

    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(TipoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
    }
    
    public boolean isDadosConfirmado() {
        return dadosConfirmado;
    }

    public void setDadosConfirmado(boolean dadosConfirmado) {
        this.dadosConfirmado = dadosConfirmado;
    }

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

    public UltCarregBean getUltViagemBean() {
        return ultViagemBean;
    }

    public void setUltViagemBean(UltCarregBean ultViagemBean) {
        this.ultViagemBean = ultViagemBean;
    }

    public String getIdCarreg(){
        return dadosCarregBean.getIdCarreg();
    }
       
    public String getSenha(){
        return dadosCarregBean.getSenha();
    } 
           
    public String getDescrEtapa(){
        return dadosCarregBean.getDescrEtapa();
    }
               
    public String getMsg(){
        return dadosCarregBean.getMsg();
    } 
}
