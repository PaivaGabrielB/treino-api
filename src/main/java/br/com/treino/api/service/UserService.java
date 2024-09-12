package br.com.treino.api.service;

import br.com.treino.model.entity.User;
import br.com.treino.model.input.UserInput;
import br.com.treino.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private final RoleService roleService;

    public User save(UserInput userInput) {
        userInput.setPassword(passwordEncoder.encode(userInput.getPassword()));
        User user = modelMapper.map(userInput, User.class);
        user.setRole(roleService.findById(userInput.getRole()));
        return userRepository.save(user);
    }

    public List<User> listAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found!"));
    }

    public User updatedByid(Long id, UserInput userInput) {
        User user = findById(id);
        String password = "";
        if (userInput.getPassword() == null || userInput.getPassword().isEmpty()) {
            password = user.getPassword();
        } else {
            if (userInput.getPassword().equals(user.getPassword())) {
                password = userInput.getPassword();
            } else {
                password = passwordEncoder.encode(userInput.getPassword());
            }
        }

        user.setName(userInput.getName());
        user.setEmail(userInput.getEmail());
        user.setPassword(password);
        user.setRole(roleService.findById(userInput.getRole()));
        user.setEndereco(userInput.getEndereco());
        user.setTelefone(userInput.getTelefone());
        user.setCpf(userInput.getCpf());
        return userRepository.save(user);
    }

    public User deactivateById(Long id) {
        User user = findById(id);
        user.setActivated(false);
        return userRepository.save(user);
    }

}
