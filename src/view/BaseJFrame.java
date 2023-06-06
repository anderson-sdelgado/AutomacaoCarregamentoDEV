/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import control.AutomacaoCTR;
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

/**
 *
 * @author anderson
 */
public class BaseJFrame extends javax.swing.JFrame {

    private AutomacaoCTR automacaoCTR;
    private ArrayList<String> telas;

    public BaseJFrame() {

        automacaoCTR = new AutomacaoCTR();

        TelaCPFJPanel telaCPFPanel = new TelaCPFJPanel(this);
        this.getContentPane().add(telaCPFPanel);
//        TelaCameraJPanel telaCameraJPanel = new TelaCameraJPanel(this);;
//        this.getContentPane().add(telaCameraJPanel);

        telas = new ArrayList<>();
        telas.add("TelaCPFJPanel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);

    }

    public void mudarTela(String telaProxima) {
        if (telaProxima.equals("TelaCPFJPanel")) {
            telas.clear();
        }
        telas.add(telaProxima);
        tela(telaProxima);
    }

    public void retornarTela() {
        telas.remove(telas.size() - 1);
        tela(telas.get(telas.size() - 1));
    }

    private void tela(String telaProxima) {
        this.getContentPane().removeAll();
        switch (telaProxima) {
            case "TelaCPFJPanel":
                TelaCPFJPanel telaCPFJPanel = new TelaCPFJPanel(this);
                this.getContentPane().add(telaCPFJPanel);
                this.pack();
                break;
            case "TelaCamCPreOrdemJPanel":
                TelaCamCPreOrdemJPanel telaCamCPreOrdemJPanel = new TelaCamCPreOrdemJPanel(this);
                this.getContentPane().add(telaCamCPreOrdemJPanel);
                this.pack();
                break;
            case "TelaCameraJPanel":
                TelaCameraJPanel telaCameraJPanel = new TelaCameraJPanel(this);
                this.getContentPane().add(telaCameraJPanel);
                this.pack();
                break;
            case "TelaClassifProdCarregJPanel":
                TelaClassifProdCarregJPanel telaClassifProdCarregJPanel = new TelaClassifProdCarregJPanel(this);
                this.getContentPane().add(telaClassifProdCarregJPanel);
                this.pack();
                break;
            case "TelaClienteUltCarregJPanel":
                TelaClienteUltCarregJPanel telaClienteUltCarregJPanel = new TelaClienteUltCarregJPanel(this);
                this.getContentPane().add(telaClienteUltCarregJPanel);
                this.pack();
                break;
            case "TelaDadosNEncJPanel":
                TelaDadosNEncJPanel telaDadosNEncJPanel = new TelaDadosNEncJPanel(this);
                this.getContentPane().add(telaDadosNEncJPanel);
                this.pack();
                break;
            case "TelaDadosUltCarregJPanel":
                TelaDadosUltCarregJPanel telaDadosUltCarregJPanel = new TelaDadosUltCarregJPanel(this);
                this.getContentPane().add(telaDadosUltCarregJPanel);
                this.pack();
                break;
            case "TelaImprimirSenhaJPanel":
                TelaImprimirSenhaJPanel telaImprimirSenhaJPanel = new TelaImprimirSenhaJPanel(this);
                this.getContentPane().add(telaImprimirSenhaJPanel);
                this.pack();
                break;
            case "TelaListaClienteJPanel":
                TelaListaClienteJPanel telaListaClienteJPanel = new TelaListaClienteJPanel(this);
                this.getContentPane().add(telaListaClienteJPanel);
                this.pack();
                break;
            case "TelaPlacaJPanel":
                TelaPlacaJPanel telaPlacaJPanel = new TelaPlacaJPanel(this);
                this.getContentPane().add(telaPlacaJPanel);
                this.pack();
                break;
            case "TelaProdutoCarregJPanel":
                TelaProdutoCarregJPanel telaProdutoCarregJPanel = new TelaProdutoCarregJPanel(this);
                this.getContentPane().add(telaProdutoCarregJPanel);
                this.pack();
                break;
            case "TelaProdutoUltCarregJPanel":
                TelaProdutoUltCarregJPanel telaProdutoUltCarregJPanel = new TelaProdutoUltCarregJPanel(this);
                this.getContentPane().add(telaProdutoUltCarregJPanel);
                this.pack();
                break;
            case "TelaTranspUltCarregJPanel":
                TelaTranspUltCarregJPanel telaTranspUltCarregJPanel = new TelaTranspUltCarregJPanel(this);
                this.getContentPane().add(telaTranspUltCarregJPanel);
                this.pack();
                break;
            case "TelaVeicUltCarregJPanel":
                TelaVeicUltCarregJPanel telaVeicUltCarregJPanel = new TelaVeicUltCarregJPanel(this);
                this.getContentPane().add(telaVeicUltCarregJPanel);
                this.pack();
                break;
            case "TelaWhatsappJPanel":
                TelaWhatsappJPanel telaWhatsappJPanel = new TelaWhatsappJPanel(this);
                this.getContentPane().add(telaWhatsappJPanel);
                this.pack();
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
