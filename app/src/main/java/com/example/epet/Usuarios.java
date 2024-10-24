package com.example.epet;

public class Usuarios {

    private String nome, telefone, cep, cidade, bairro, rua, complemento, cpf, email, dataNasc, senha, isAdm;

    public Usuarios(String nome, String telefone, String cep, String cidade, String bairro, String rua, String complemento, String cpf, String email, String dataNasc, String senha, String isAdm) {
        this.nome = nome;
        this.telefone = telefone;
        this.cep = cep;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.complemento = complemento;
        this.cpf = cpf;
        this.email = email;
        this.dataNasc = dataNasc;
        this.senha = senha;
        this.isAdm = isAdm;
    }
    @Override
    public String toString() {
        return "Usuarios{" +
                "nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", cep='" + cep + '\'' +
                ", cidade='" + cidade + '\'' +
                ", bairro='" + bairro + '\'' +
                ", rua='" + rua + '\'' +
                ", complemento='" + complemento + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", dataNasc='" + dataNasc + '\'' +
                ", senha='" + senha + '\'' +
                ", isAdm='" + isAdm + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getIsAdm() {
        return isAdm;
    }

    public void setIsAdm(String isAdm) {
        this.isAdm = isAdm;
    }
}

