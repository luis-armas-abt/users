package com.bcp.backend.controller;

import com.bcp.backend.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping ("/bcp/users")
public class UserController {

    @GetMapping
    public ResponseEntity<List<UserDto>>  getUsers (){
        List<UserDto> users = findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id){
        UserDto result = null;
        List<UserDto> users = findAll();
        for (UserDto u: users ){
            if (id.equals(u.getId())){
                result = u;
                break;
            }
        }

        if (result == null) {
             return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    private List<UserDto> findAll() {
        UserDto user1 = new UserDto();
        user1.setId(1l);
        user1.setName("Luis");

        UserDto user2 = new UserDto();
        user2.setId(2l);
        user2.setName("Miguel");

        List<UserDto> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        return users;
    }


}
