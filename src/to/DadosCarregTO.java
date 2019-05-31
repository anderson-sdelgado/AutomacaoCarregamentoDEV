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
    private String etapa;
    private String descrStatus;
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

    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
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

    public String getDescrStatus() {
        return descrStatus;
    }

    public void setDescrStatus(String descrStatus) {
        this.descrStatus = descrStatus;
    }

    
}
