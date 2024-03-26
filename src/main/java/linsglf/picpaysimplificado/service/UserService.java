package linsglf.picpaysimplificado.service;

import linsglf.picpaysimplificado.domain.user.User;
import linsglf.picpaysimplificado.domain.user.UserMerchant;
import linsglf.picpaysimplificado.domain.user.UserType;
import linsglf.picpaysimplificado.domain.user.dto.UserDTO;
import linsglf.picpaysimplificado.repository.UserMerchantRepository;
import linsglf.picpaysimplificado.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMerchantRepository userMerchantRepository;

    @Transactional
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void createUserMerchant(UserMerchant user) {
        userMerchantRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
