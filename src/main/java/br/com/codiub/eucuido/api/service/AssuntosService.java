package br.com.codiub.eucuido.api.service;

import br.com.codiub.eucuido.model.entity.Assuntos;
import br.com.codiub.eucuido.model.input.AssuntosInput;
import br.com.codiub.eucuido.repository.AssuntosRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssuntosService {

    @Autowired
    private AssuntosRepository assuntosRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Assuntos findbyId(Long id) {
        return assuntosRepository.findById(id).orElseThrow(() -> new RuntimeException("Assunto não encontrado"));
    }

    public List<Assuntos> listAllAssuntos() {
        return assuntosRepository.findAll();
    }

    public Assuntos save(AssuntosInput assuntosInput) {
        Assuntos assuntos = modelMapper.map(assuntosInput, Assuntos.class);
        return assuntosRepository.save(assuntos);
    }

    public Assuntos updateById(Long id, AssuntosInput assuntosInput) {
        Assuntos assuntos = findbyId(id);
        modelMapper.map(assuntosInput, assuntos);
        return assuntosRepository.save(assuntos);
    }

    public void deleteById(Long id) {
        Assuntos assuntos = findbyId(id);
        assuntosRepository.delete(assuntos);
    }
}
