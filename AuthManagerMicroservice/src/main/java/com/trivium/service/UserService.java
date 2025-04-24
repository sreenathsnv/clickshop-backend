package com.trivium.service;

import com.trivium.entity.Address;
import com.trivium.entity.User;
import com.trivium.repo.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired 
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Registers a new user along with address.
     */
    public User registerUser(String username, String password, String email, String role,
                             String houseName, String street, String district, String state, String zipcode) {

        Address address = new Address(houseName, street, district, state, zipcode);

        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setEmail(email);
        user.setRole(role != null ? role : "CUSTOMER");
        user.setAddress(address);

        return userRepository.save(user);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User updateUser(User user) {
        // Make sure user exists
        User existingUser = userRepository.findById(user.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Check if the new email is already taken by a different user
        Optional<User> userWithSameEmail = userRepository.findByEmail(user.getEmail());
        System.out.println("Trying to update user ID: " + user.getId());
        System.out.println("New email: " + user.getEmail());

        userWithSameEmail.ifPresent(conflictUser -> {
            System.out.println("Conflicting user ID: " + conflictUser.getId());
        });
        
        if (userWithSameEmail.isPresent() && !userWithSameEmail.get().getId().equals(user.getId())) {
            throw new RuntimeException("Email already in use by another user.");
        }
       

        // Proceed with the update
        existingUser.setEmail(user.getEmail());
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());
        existingUser.setRole(user.getRole());
        existingUser.setAddress(user.getAddress());

        return userRepository.save(existingUser);
    }
    

    public void resetPassword(String email, String newPassword) {
        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found"));
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        return org.springframework.security.core.userdetails.User
            .withUsername(user.getUsername())
            .password(user.getPassword())
            .roles(user.getRole())
            .build();
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
