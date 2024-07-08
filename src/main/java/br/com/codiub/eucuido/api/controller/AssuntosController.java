package br.com.codiub.eucuido.api.controller;

import br.com.codiub.eucuido.api.service.AssuntosService;
import br.com.codiub.eucuido.model.entity.Assuntos;
import br.com.codiub.eucuido.model.output.AssuntosOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/assuntos")
public class AssuntosController {

    @Autowired
    private AssuntosService assuntosService;

    @GetMapping
    public ResponseEntity<List<AssuntosOutput>> listAll() {
        List<Assuntos> assuntos = assuntosService.listAllAssuntos();
        List<AssuntosOutput> responseDTOS = assuntos.stream()
                .map(AssuntosOutput::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssuntosOutput> getById(@PathVariable Long id) {
        Assuntos assuntos = assuntosService.findbyId(id);
        AssuntosOutput assuntosOutput = new AssuntosOutput(assuntos);
        return ResponseEntity.ok(assuntosOutput);
    }


}
