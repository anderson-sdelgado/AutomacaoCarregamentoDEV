/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author anderson
 */
public class TelaProdutoCarregJPanel extends javax.swing.JPanel {

    private final Image image;
    private final BaseJFrame baseJFrame;

    /**
     * Creates new form TelaProdutoCarregJPanel
     */
    public TelaProdutoCarregJPanel(BaseJFrame baseJFrame) {
        this.baseJFrame = baseJFrame;
        initComponents();
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/util/layout_totem.jpg"));
        this.image = imageIcon.getImage();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jButtonCancelar = new javax.swing.JButton();
        jButtonRetornar = new javax.swing.JButton();
        jLabelPerg = new javax.swing.JLabel();
        jButtonAcucar = new javax.swing.JButton();
        jButtonEtanol = new javax.swing.JButton();
        jButtonBagaco = new javax.swing.JButton();
        jButtonOutros = new javax.swing.JButton();

        setOpaque(false);
        setLayout(new java.awt.GridBagLayout());

        jButtonCancelar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonCancelar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButtonCancelar.setForeground(new java.awt.Color(28, 88, 199));
        jButtonCancelar.setText("CANCELAR");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.ipady = 70;
        add(jButtonCancelar, gridBagConstraints);

        jButtonRetornar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonRetornar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButtonRetornar.setForeground(new java.awt.Color(28, 88, 199));
        jButtonRetornar.setText("RETORNAR");
        jButtonRetornar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRetornarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.ipady = 70;
        add(jButtonRetornar, gridBagConstraints);

        jLabelPerg.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabelPerg.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPerg.setText("Qual o produto a ser carregado?");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(150, 0, 100, 0);
        add(jLabelPerg, gridBagConstraints);

        jButtonAcucar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonAcucar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButtonAcucar.setForeground(new java.awt.Color(28, 88, 199));
        jButtonAcucar.setText("AÇÚCAR");
        jButtonAcucar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcucarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 70;
        gridBagConstraints.ipady = 70;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 10, 10);
        add(jButtonAcucar, gridBagConstraints);

        jButtonEtanol.setBackground(new java.awt.Color(255, 255, 255));
        jButtonEtanol.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButtonEtanol.setForeground(new java.awt.Color(28, 88, 199));
        jButtonEtanol.setText("ETANOL");
        jButtonEtanol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEtanolActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 70;
        gridBagConstraints.ipady = 70;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 30);
        add(jButtonEtanol, gridBagConstraints);

        jButtonBagaco.setBackground(new java.awt.Color(255, 255, 255));
        jButtonBagaco.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButtonBagaco.setForeground(new java.awt.Color(28, 88, 199));
        jButtonBagaco.setText("BAGAÇO");
        jButtonBagaco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBagacoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 70;
        gridBagConstraints.ipady = 70;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 10, 10);
        add(jButtonBagaco, gridBagConstraints);

        jButtonOutros.setBackground(new java.awt.Color(255, 255, 255));
        jButtonOutros.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButtonOutros.setForeground(new java.awt.Color(28, 88, 199));
        jButtonOutros.setText("OUTROS");
        jButtonOutros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOutrosActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 70;
        gridBagConstraints.ipady = 70;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 30);
        add(jButtonOutros, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAcucarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAcucarActionPerformed

        this.baseJFrame.getAutomacaoCTR().getDadosCarregBean().setIdProdCarreg("acucar");
        this.baseJFrame.mudarTela("TelaClassifProdCarregJPanel");

    }//GEN-LAST:event_jButtonAcucarActionPerformed

    private void jButtonEtanolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEtanolActionPerformed

        this.baseJFrame.getAutomacaoCTR().getDadosCarregBean().setIdProdCarreg("etanol");
        this.baseJFrame.mudarTela("TelaClassifProdCarregJPanel");

    }//GEN-LAST:event_jButtonEtanolActionPerformed

    private void jButtonBagacoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBagacoActionPerformed

        this.baseJFrame.getAutomacaoCTR().getDadosCarregBean().setIdProdCarreg("5");
        if (this.baseJFrame.getAutomacaoCTR().getDadosCarregBean().getNomeMotorista().equals("0")) {
            this.baseJFrame.mudarTela("TelaListaClienteJPanel");
        } else {
            this.baseJFrame.mudarTela("TelaClienteUltCarregJPanel");
        }

    }//GEN-LAST:event_jButtonBagacoActionPerformed

    private void jButtonOutrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOutrosActionPerformed

        this.baseJFrame.getAutomacaoCTR().getDadosCarregBean().setIdProdCarreg("6");
        if (this.baseJFrame.getAutomacaoCTR().getDadosCarregBean().getNomeMotorista().equals("0")) {
            this.baseJFrame.mudarTela("TelaPlacaJPanel");
        } else {
            this.baseJFrame.mudarTela("TelaTranspUltCarregJPanel");
        }

    }//GEN-LAST:event_jButtonOutrosActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed

        this.baseJFrame.mudarTela("TelaCPFJPanel");

    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonRetornarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRetornarActionPerformed

        this.baseJFrame.retornarTela();

    }//GEN-LAST:event_jButtonRetornarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAcucar;
    private javax.swing.JButton jButtonBagaco;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEtanol;
    private javax.swing.JButton jButtonOutros;
    private javax.swing.JButton jButtonRetornar;
    private javax.swing.JLabel jLabelPerg;
    // End of variables declaration//GEN-END:variables

    @Override
    public Dimension getPreferredSize() {
        Dimension superSize = super.getPreferredSize();
        if (isPreferredSizeSet() || image == null) {
            return superSize;
        }
        int prefW = Math.max(image.getWidth(null), superSize.width);
        int prefH = Math.max(image.getHeight(null), superSize.height);
        return new Dimension(prefW, prefH);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, null);
        }
    }

}
