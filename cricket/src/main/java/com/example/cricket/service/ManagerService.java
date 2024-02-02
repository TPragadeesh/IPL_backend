package com.example.cricket.service;

import com.example.cricket.entity.Manager;
import com.example.cricket.exception.ManagerNotFoundException;
import com.example.cricket.repo.ManagerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ManagerService {

    @Autowired
    private ManagerRepo managerRepo;

    public Manager addManager(String teamName, String password, String image, String color) {
        Manager manager = new Manager();
        manager.setTeamName(teamName);
        manager.setPassword(password);
        manager.setImage(image);
        manager.setColor(color);
        return managerRepo.save(manager);
    }

    public Manager findManager(String teamName, String password) {
        Manager manager = null;
        if(managerRepo.findById(teamName).isPresent()){
            manager = managerRepo.findById(teamName).get();
            if(manager.getPassword().compareTo(password)  == 0){
                return manager;
            }
        }

        return null;
    }
    public List<Manager> findAll(){
        Iterable<Manager> managers = managerRepo.findAll();
        List<Manager> managers1 = new ArrayList<>();
        for(Manager manager: managers){
            managers1.add(manager);
        }
        return managers1;
    }
    public void deleteAll() {
        managerRepo.deleteAll();
    }

    public Manager findById(String id){
        return managerRepo.findById(id).get();
    }
}
