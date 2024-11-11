package com.lucassilveira.receitario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucassilveira.receitario.model.Role;
import com.lucassilveira.receitario.repository.RoleRepository;

@Service
public class RoleService {

    @Autowired
    public RoleRepository roleRepository;

    public List<Role> getAllRoles(){
        return roleRepository.findAll();
    }
}
