package gustavomotamacedo.javabizzarecrud.services;

import gustavomotamacedo.javabizzarecrud.models.Jojo;

public interface JojoService {

    Iterable<Jojo> buscarTodos();

    Jojo buscarPorId(Long id);

    void inserir(Jojo cliente);

    void atualizar(Long id, Jojo cliente);

    void deletar(Long id);

}
