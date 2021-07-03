package com.example.gestionAchat.controller.API;

import static com.example.gestionAchat.util.constant.APP_ROOT;

import com.example.gestionAchat.Dto.ArticleDto;
import com.example.gestionAchat.Dto.CategorieDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(APP_ROOT + "/categorie")
@RequestMapping(value = APP_ROOT + "/categorie", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public interface CatergorieApi {

    @GetMapping(path = "id/{id}")
    @ApiOperation(value = "rechercher une catgorie", notes = "cette methode rechercher une categorie par ID", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "categorie trouve")
    })
    CategorieDto findById(@PathVariable Integer id);

    @PostMapping(value = "/create")
    @ApiOperation(value = "Ajouter une categorie", notes = "cette methode ajouter une categorie", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "categorie ajouter")
    })
    CategorieDto create(@RequestBody CategorieDto dto);

    @PostMapping(value = "/update")
    @ApiOperation(value = "modifier un article", notes = "cette methode modifier un article", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "article trouve")
    })
    CategorieDto update(@RequestBody CategorieDto dto);

    @GetMapping(path = "/findAll")
    @ApiOperation(value = "rechercher tout les categorie", notes = "cette methode recherhcer tout categorie", response = ArticleDto.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "les categories trouve")
    })
    List<CategorieDto> findAll();

    @DeleteMapping(value = "/delete/{id}")
    @ApiOperation(value = "rechercher un ctegorie", notes = "cette methode rechercher un categorie par ID", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "categorie supprimer")
    })
    void delete(@PathVariable("id") Integer id);

}
