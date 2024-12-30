package com.lfng7.ChallengeAluraForo.controller;

import com.lfng7.ChallengeAluraForo.domain.user.UserService;
import com.lfng7.ChallengeAluraForo.domain.user.dto.UserCreateDto;
import com.lfng7.ChallengeAluraForo.domain.user.dto.UserGetDto;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@SecurityRequirement(name = "bearer-key")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /*
     *  METODOS
     */

    //Obtener todos
    @GetMapping("/all")
    public ResponseEntity<Page<UserGetDto>> getAllUsers(Pageable pagination) {
        return ResponseEntity.ok(userService.getAllUsers(pagination));
    }

    //Obtener registro por id
    @GetMapping("/{id}")
    public ResponseEntity<UserGetDto> getUserById(@NotNull @PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    //Insertar registro
    @PostMapping("/create")
    @Transactional
    public void createUser(@RequestBody UserCreateDto user) {

    }

    //Actualizar registro
    @PutMapping("/update/{id}")
    @Transactional
    public void updateUser(@PathVariable(name = "id") Long id, @RequestBody UserCreateDto user) {

    }

    //Eliminar registro
    @DeleteMapping("/delete/{id}")
    @Transactional
    public void deleteUser(@PathVariable(name = "id") Long id) {

    }
}