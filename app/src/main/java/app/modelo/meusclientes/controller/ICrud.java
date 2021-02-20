package app.modelo.meusclientes.controller;

import java.util.List;

public interface ICrud<T> {
    //Métodos para persistência de dados no banco
    //Include
    public boolean incluir(T obj);

    //Alterar
    public boolean alter(T obj);

    //Deletar
    public boolean deletar(int id);

    //Listar
    public List<T> listar();
}
