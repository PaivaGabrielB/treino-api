package br.com.treino.api.service;

import br.com.treino.model.entity.Role;
import br.com.treino.model.input.RoleInput;
import br.com.treino.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {

    @Autowired
    private final RoleRepository roleRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Role findById(Long id) {
        return roleRepository.findById(id).orElseThrow(() -> new RuntimeException("Role não encontrado"));
    }

    public List<Role> listAllRole() {
        return roleRepository.findAll();
    }

    public Role save(RoleInput roleInput) {
        Role role = modelMapper.map(roleInput, Role.class);
        role.setRole(roleInput.getRole().toUpperCase());
        return roleRepository.save(role);
    }

    public Role updateById(Long id, RoleInput roleInput) {
        Role role = findById(id);
        modelMapper.map(roleInput, role);
        role.setRole(roleInput.getRole().toUpperCase());
        return roleRepository.save(role);
    }

    public void  deactivateById(Long id) {
        Role role = findById(id);
        roleRepository.delete(role);
    }
}
