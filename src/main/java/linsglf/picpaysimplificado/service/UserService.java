package linsglf.picpaysimplificado.service;

import jakarta.persistence.EntityNotFoundException;
import linsglf.picpaysimplificado.assembler.UserAssembler;
import linsglf.picpaysimplificado.domain.response.UserResponse;
import linsglf.picpaysimplificado.domain.user.User;
import linsglf.picpaysimplificado.domain.user.UserMerchant;
import linsglf.picpaysimplificado.domain.user.dto.UserDTO;
import linsglf.picpaysimplificado.repository.UserMerchantRepository;
import linsglf.picpaysimplificado.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMerchantRepository userMerchantRepository;

    @Autowired
    private UserAssembler userAssembler;

    @Transactional
    public void createUser(UserDTO userDTO) {
        if (userRepository.findByCpf(userDTO.cpf()) != null)
            throw new DataIntegrityViolationException("CPF already registered: " + userDTO.cpf());
        if (userRepository.findByEmail(userDTO.email()) != null)
            throw new DataIntegrityViolationException("Email already registered: " + userDTO.email());
        User user = userAssembler.toEntityCommon(userDTO);
        userRepository.save(user);
    }

    @Transactional
    public void createUserMerchant(UserDTO userDTO) {
        UserMerchant userMerchant = userAssembler.toEntityMerchant(userDTO);
        userMerchantRepository.save(userMerchant);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found: " + id));
        return userAssembler.toDTO(user);
    }

    @Transactional
    public void updateUser(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found: " + id));
        userAssembler.toEntityCommon(userDTO);
        userRepository.save(user);
    }

    @Transactional
    public void updateUserMerchant(Long id, UserDTO userDTO) {
        UserMerchant userMerchant = userMerchantRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found: " + id));
        userAssembler.toEntityMerchant(userDTO);
        userMerchantRepository.save(userMerchant);
    }

    @Transactional
    public void deleteUser(Long id) {
        userRepository.logicalDeleteById(id);
    }

    @Transactional
    public void activateUser(Long id) {
        userRepository.logicalActivateById(id);
    }
}
