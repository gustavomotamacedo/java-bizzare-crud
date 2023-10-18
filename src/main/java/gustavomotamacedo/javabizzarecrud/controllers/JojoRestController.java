package gustavomotamacedo.javabizzarecrud.controllers;

import gustavomotamacedo.javabizzarecrud.models.Jojo;
import gustavomotamacedo.javabizzarecrud.services.JojoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("jojos")
public class JojoRestController {

    @Autowired
    private JojoService jojoService;

    @GetMapping
    public ResponseEntity<Iterable<Jojo>> buscarTodos() {
        return ResponseEntity.ok(jojoService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jojo> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(jojoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Jojo> inserir(@RequestBody Jojo jojo) {
        jojoService.inserir(jojo);
        return ResponseEntity.ok(jojo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jojo> atualizar(@PathVariable Long id, @RequestBody Jojo jojo) {
        jojoService.atualizar(id, jojo);
        return ResponseEntity.ok(jojo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        jojoService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
