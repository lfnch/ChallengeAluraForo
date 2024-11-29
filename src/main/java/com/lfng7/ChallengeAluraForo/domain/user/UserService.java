package com.lfng7.ChallengeAluraForo.domain.user;

import com.lfng7.ChallengeAluraForo.domain.user.dto.UserGetDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /*
    *  METODOS
    */

    //Obtener todos
    public Page<UserGetDto> getAllUsers(Pageable pagination) {
        return userRepository.findAll(pagination).map(UserGetDto::new);
    }

    //Obtener registro por id
    public UserGetDto findById(Long id) {
        Optional<UserEntity> userSearch = userRepository.findById(id);
        if(userSearch.isEmpty()) throw new EntityNotFoundException();
        return userSearch.map(UserGetDto::new).get();
    }

    //Obtener por email
    public UserDetails findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    //Insertar registro

    //Actualizar registro

    //Eliminar registro
}
