package com.example.gestionAchat.controller.API;

import com.example.gestionAchat.Dto.ArticleDto;
import com.example.gestionAchat.Dto.LigneCommandeDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.gestionAchat.util.constant.APP_ROOT;

@Api(APP_ROOT + "/ligneCommande")
@RequestMapping(value = APP_ROOT + "/ligneCommande", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public interface LigneCommandeApi {

    @GetMapping(path = "/findUtlisateur/{id}")
    List<LigneCommandeDto> findByUtilisateur(@PathVariable Integer id) ;

    @PostMapping(value =  "/create")
    LigneCommandeDto create(@RequestBody LigneCommandeDto dto) ;
}
