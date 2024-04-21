package linsglf.picpaysimplificado.controller;

import jakarta.validation.Valid;
import linsglf.picpaysimplificado.assembler.UserAssembler;
import linsglf.picpaysimplificado.domain.response.UserResponse;
import linsglf.picpaysimplificado.domain.user.UserType;
import linsglf.picpaysimplificado.domain.user.dto.UserDTO;
import linsglf.picpaysimplificado.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserAssembler userAssembler;

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody @Valid UserDTO userDTO) {
        if (userDTO.userType().equals(UserType.COMMON)) {
            userService.createUser(userDTO);
            return ResponseEntity.created(null).body(userAssembler.toResponse(userDTO));
        }
        if (userDTO.userType().equals(UserType.MERCHANT)) {
            userService.createUserMerchant(userDTO);
            return ResponseEntity.created(null).body(userAssembler.toResponse(userDTO));
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return ResponseEntity.ok().body(userAssembler.toResponseList(
                userService.getAllUsers()
        ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok().body(userAssembler.toResponse(
                userService.getUserById(id)
        ));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id, @RequestBody @Valid UserDTO userDTO) {
        if (userDTO.userType().equals(UserType.COMMON)) {
            userService.updateUser(id, userDTO);
            return ResponseEntity.ok().body(userAssembler.toResponse(userDTO));
        }
        if (userDTO.userType().equals(UserType.MERCHANT)) {
            userService.updateUser(id, userDTO);
            return ResponseEntity.ok().body(userAssembler.toResponse(userDTO));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/activate/{id}")
    public ResponseEntity<Void> activateUser(@PathVariable Long id) {
        userService.activateUser(id);
        return ResponseEntity.noContent().build();
    }
}

