package com.football.service;

//import com.football.domain.PasswordResetToken;
import com.football.domain.Role;
import com.football.domain.User;
//import com.football.repository.PasswordResetTokenRepository;
import com.football.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /*@Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;
*/
    public void createUser(User user){
        //criptam parola si o setam user-ului
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));

        Role userRole = new Role("USER");
        List<Role> roles = new ArrayList<>();
        roles.add(userRole);
        user.setRoles(roles);
        userRepository.save(user);

    }

    public void createAdmin(User user){
        //criptam parola si o setam user-ului
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));

        Role userRole = new Role("ADMIN");
        List<Role> roles = new ArrayList<>();
        roles.add(userRole);
        user.setRoles(roles);
        userRepository.save(user);

    }

    public User findById(String email){
        return userRepository.findById(email).orElse(null);
    }

    public  List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    public List<User> findByName(String name) {
        return userRepository.findByLastnameLike(name);
    }

    public boolean isUserPresent(String email) {
        User u = userRepository.findById(email).orElse(null);
        if(u!= null)
            return  true;
        return false;
    }

/*
    public PasswordResetToken getPasswordResetToken(final String token) {
        return passwordResetTokenRepository.findByToken(token);
    }



    public void createPasswordResetTokenForUser(final User user, final String token) {

        final PasswordResetToken myToken = new PasswordResetToken(token,user);
        passwordResetTokenRepository.save(myToken);

    }*/
}
