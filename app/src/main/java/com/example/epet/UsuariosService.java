package com.example.epet;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UsuariosService {
    @FormUrlEncoded
    @POST("api/[controller]/UsuarioCadastro") // Altere para o caminho correto
    Call<String> cadastrarUsuario(
            @Field("nome") String nome,
            @Field("telefone") String telefone,
            @Field("cep") String cep,
            @Field("cidade") String cidade,
            @Field("bairro") String bairro,
            @Field("rua") String rua,
            @Field("complemento") String complemento,
            @Field("cpf") String cpf,
            @Field("email") String email,
            @Field("dataNasc") String dataNasc,
            @Field("senha") String senha,
            @Field("isAdm") String isAdm
    );
}
