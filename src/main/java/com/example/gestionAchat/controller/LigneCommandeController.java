package com.example.gestionAchat.controller;

import com.example.gestionAchat.Dto.LigneCommandeDto;
import com.example.gestionAchat.Service.LigneCommandeService;
import com.example.gestionAchat.controller.API.LigneCommandeApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LigneCommandeController implements LigneCommandeApi {
    LigneCommandeService ligneCommandeService;

    @Autowired
    public LigneCommandeController(LigneCommandeService ligneCommandeService) {
        this.ligneCommandeService = ligneCommandeService;
    }

    @Override
    public List<LigneCommandeDto> findByUtilisateur(Integer id) {
        return ligneCommandeService.findByUtilisateur(id);
    }

    @Override
    public LigneCommandeDto create(LigneCommandeDto dto) {
        return ligneCommandeService.create(dto);
    }

}
