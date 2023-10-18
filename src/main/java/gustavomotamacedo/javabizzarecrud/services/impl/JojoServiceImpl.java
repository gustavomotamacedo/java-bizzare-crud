package gustavomotamacedo.javabizzarecrud.services.impl;

import gustavomotamacedo.javabizzarecrud.models.Endereco;
import gustavomotamacedo.javabizzarecrud.models.EnderecoRepository;
import gustavomotamacedo.javabizzarecrud.models.Jojo;
import gustavomotamacedo.javabizzarecrud.models.JojoRepository;
import gustavomotamacedo.javabizzarecrud.services.JojoService;
import gustavomotamacedo.javabizzarecrud.services.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JojoServiceImpl implements JojoService {
    @Autowired
    private JojoRepository jojoRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Jojo> buscarTodos() {
        return jojoRepository.findAll();
    }

    @Override
    public Jojo buscarPorId(Long id) {
        Optional<Jojo> jojo = jojoRepository.findById(id);
        return jojo.get();
    }

    @Override
    public void inserir(Jojo jojo) {
        salvarClienteComCep(jojo);
    }

    @Override
    public void atualizar(Long id, Jojo jojo) {
        Optional<Jojo> clienteBd = jojoRepository.findById(id);
        if (clienteBd.isPresent()) {
            salvarClienteComCep(jojo);
        }
    }

    @Override
    public void deletar(Long id) {
        jojoRepository.deleteById(id);
    }

    private void salvarClienteComCep(Jojo jojo) {
        String cep = jojo.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        jojo.setEndereco(endereco);
        jojoRepository.save(jojo);
    }
}
