/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import control.AutomacaoCTR;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import util.Const;

/**
 *
 * @author anderson
 */
public final class BaseJFrame extends javax.swing.JFrame {

    private AutomacaoCTR automacaoCTR;
    private ArrayList<String> telas;

    public BaseJFrame() {

        automacaoCTR = new AutomacaoCTR();
        automacaoCTR.imprimirTeste();
//        telaInicial();
    }

    private void telaInicial() {
        automacaoCTR.abrirCamera();
        TelaCPFJPanel telaCPFPanel = new TelaCPFJPanel(this);
        this.add(telaCPFPanel);
        telas = new ArrayList<>();
        telas.add(Const.TELA_CPF);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setUndecorated(true);
        this.setVisible(true);
        this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        this.pack();
    }

    public void mudarTela(String telaProxima) {
        if (telaProxima.equals(Const.TELA_CPF)) {
            telas.clear();
        }
        telas.add(telaProxima);
        this.getContentPane().removeAll();
        this.getContentPane().revalidate();
        this.getContentPane().repaint();
        tela(telaProxima);
        this.pack();
    }

    public void retornarTela() {
        telas.remove(telas.size() - 1);
        this.getContentPane().removeAll();
        this.getContentPane().revalidate();
        this.getContentPane().repaint();
        tela(telas.get(telas.size() - 1));
        this.pack();
    }

    private void tela(String telaProxima) {
        this.pack();
        switch (telaProxima) {
            case Const.TELA_CPF:
                TelaCPFJPanel telaCPFJPanel = new TelaCPFJPanel(this);
                this.getContentPane().add(telaCPFJPanel);
                break;
            case Const.TELA_REIMPRIMIR:
                TelaReimprimirJPanel telaCamCPreOrdemJPanel = new TelaReimprimirJPanel(this);
                this.getContentPane().add(telaCamCPreOrdemJPanel);
                break;
            case Const.TELA_CAMERA:
                TelaCameraJPanel telaCameraJPanel = new TelaCameraJPanel(this);
                this.getContentPane().add(telaCameraJPanel);
                break;
            case Const.TELA_CLASSIF_PROD_CARREG:
                TelaClassifProdCarregJPanel telaClassifProdCarregJPanel = new TelaClassifProdCarregJPanel(this);
                this.getContentPane().add(telaClassifProdCarregJPanel);
                break;
            case Const.TELA_ULT_CLIENTE_CARREG:
                TelaUltClienteCarregJPanel telaClienteUltCarregJPanel = new TelaUltClienteCarregJPanel(this);
                this.getContentPane().add(telaClienteUltCarregJPanel);
                break;
            case Const.TELA_MOTO_NAO_ENC:
                TelaMotoNaoEncJPanel telaDadosNEncJPanel = new TelaMotoNaoEncJPanel(this);
                this.getContentPane().add(telaDadosNEncJPanel);
                break;
            case Const.TELA_ULT_DADOS_CARREG_MOTO:
                TelaUltDadosCarregMotoJPanel telaDadosUltCarregJPanel = new TelaUltDadosCarregMotoJPanel(this);
                this.getContentPane().add(telaDadosUltCarregJPanel);
                break;
            case Const.TELA_IMPRIMIR_SENHA:
                TelaImprimirSenhaJPanel telaImprimirSenhaJPanel = new TelaImprimirSenhaJPanel(this);
                this.getContentPane().add(telaImprimirSenhaJPanel);
                break;
            case Const.TELA_LISTA_CLIENTE:
                TelaListaClienteJPanel telaListaClienteJPanel = new TelaListaClienteJPanel(this);
                this.getContentPane().add(telaListaClienteJPanel);
                break;
            case Const.TELA_PLACA:
                TelaPlacaJPanel telaPlacaJPanel = new TelaPlacaJPanel(this);
                this.getContentPane().add(telaPlacaJPanel);
                break;
            case Const.TELA_PRODUTO_CARREG:
                TelaProdutoCarregJPanel telaProdutoCarregJPanel = new TelaProdutoCarregJPanel(this);
                this.getContentPane().add(telaProdutoCarregJPanel);
                break;
            case Const.TELA_ULT_PRODUTO_CARREG:
                TelaUltProdutoCarregJPanel telaProdutoUltCarregJPanel = new TelaUltProdutoCarregJPanel(this);
                this.getContentPane().add(telaProdutoUltCarregJPanel);
                break;
            case Const.TELA_ULT_TRANSP_CARREG:
                TelaUltTranspCarregJPanel telaTranspUltCarregJPanel = new TelaUltTranspCarregJPanel(this);
                this.getContentPane().add(telaTranspUltCarregJPanel);
                break;
            case Const.TELA_ULT_VEIC_CARREG:
                TelaUltVeicCarregJPanel telaVeicUltCarregJPanel = new TelaUltVeicCarregJPanel(this);
                this.getContentPane().add(telaVeicUltCarregJPanel);
                break;
            case Const.TELA_WHATSAPP:
                TelaWhatsappJPanel telaWhatsappJPanel = new TelaWhatsappJPanel(this);
                this.getContentPane().add(telaWhatsappJPanel);
                break;
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BaseJFrame().setVisible(true);
            }
        });
    }

    public AutomacaoCTR getAutomacaoCTR() {
        return automacaoCTR;
    }

    public void setAutomacaoCTR(AutomacaoCTR automacaoCTR) {
        this.automacaoCTR = automacaoCTR;
    }

}
