package tech.klok.kear.hub.infrastructure.security.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tech.klok.kear.hub.domain.adesao.model.UserModel;
import tech.klok.kear.hub.infrastructure.persistence.repository.user.UserRepository;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserModel> foundedUser = userRepository.findByUsername(username);

        if(foundedUser == null)
            return null;

        return new User(foundedUser.get().getUserName(), foundedUser.get().getPassword(), new ArrayList<>());
    }
    
}
