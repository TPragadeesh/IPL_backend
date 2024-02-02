package com.example.cricket.controller;

import com.example.cricket.dto.ManagerRequestDTO;
import com.example.cricket.dto.ManagerSignUpRequestDTO;
import com.example.cricket.entity.Manager;
import com.example.cricket.exception.ManagerNotFoundException;
import com.example.cricket.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @PostMapping("/signup")
    ResponseEntity<Manager> signUp(@RequestBody ManagerSignUpRequestDTO body) {
        System.out.println(body.getImage());
        Manager manager = managerService.addManager(body.getTeamName(), body.getPassword(), body.getImage(), body.getColor());
        if(manager == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(manager);
    }

    @PostMapping("/login")
    ResponseEntity<Manager> login(@RequestBody ManagerRequestDTO body) throws ManagerNotFoundException {

            Manager manager = managerService.findManager(body.getTeamName(), body.getPassword());
            if (manager == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(manager);

    }
    @GetMapping("")
    ResponseEntity<List<Manager>> getAll(){
        List<Manager> managers = managerService.findAll();
        if(managers == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(managers);
    }
    @GetMapping("/{id}")
    ResponseEntity<Manager> findById(@PathVariable("id") String id){
        Manager manager = managerService.findById(id);
        if(manager == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(manager);
    }
    @DeleteMapping("")
    ResponseEntity<String> deleteAll() {
        managerService.deleteAll();
        return ResponseEntity.ok("deleted");
    }



}
