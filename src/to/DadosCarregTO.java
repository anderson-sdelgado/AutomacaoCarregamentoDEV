/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package to;

/**
 *
 * @author anderson
 */
public class DadosCarregTO extends UltViagemTO {

    private String cpf;
    private String celular;
    private int confirmaDados;
    private String senha;
    private String idEtapa;
    private String descrEtapa;
    private String msg;
    private String idCarreg;
    
    public DadosCarregTO() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public int getConfirmaDados() {
        return confirmaDados;
    }

    public void setConfirmaDados(int confirmaDados) {
        this.confirmaDados = confirmaDados;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getIdEtapa() {
        return idEtapa;
    }

    public void setIdEtapa(String idEtapa) {
        this.idEtapa = idEtapa;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getIdCarreg() {
        return idCarreg;
    }

    public void setIdCarreg(String idCarreg) {
        this.idCarreg = idCarreg;
    }

    public String getDescrEtapa() {
        return descrEtapa;
    }

    public void setDescrEtapa(String descrEtapa) {
        this.descrEtapa = descrEtapa;
    }

    
}
