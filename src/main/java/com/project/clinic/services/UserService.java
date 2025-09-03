package com.project.clinic.services;

import com.project.clinic.model.dtos.UserRequestDTO;
import com.project.clinic.model.user.UserModel;
import com.project.clinic.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(UserModel user){
        this.userRepository.save(user);
    }
    public UserModel createUser(UserRequestDTO userRequestDTO){
        UserModel newUser = new UserModel(userRequestDTO);

        newUser.setUserName(userRequestDTO.userName());
        newUser.setPassword(userRequestDTO.password());
        newUser.setCreateBy(userRequestDTO.CreateBy());
        newUser.setCreateAt(LocalDateTime.now());
        newUser.setRole(userRequestDTO.role());
        return userRepository.save(newUser);

    }

    public List<UserModel> findAllUser(){
        return this.userRepository.findAll();
    }

    public UserModel findUserById(UUID id){
        return this.userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Transactional
    public boolean deleteUser(UUID id){
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public UserModel updateUser(UUID id, UserRequestDTO userRequestDTO){
        UserModel newUser = new UserModel(userRequestDTO);

        newUser.setUserName(userRequestDTO.userName());
        newUser.setPassword(userRequestDTO.password());
        newUser.setUpdateBy(userRequestDTO.updateBy());
        newUser.setUpdateAt(LocalDateTime.now());
        newUser.setRole(userRequestDTO.role());

        return userRepository.save(newUser);

    }

}
