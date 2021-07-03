package com.example.gestionAchat.controller.API;

import static com.example.gestionAchat.util.constant.APP_ROOT;

import com.example.gestionAchat.Dto.ArticleDto;
import com.flickr4java.flickr.FlickrException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;
import java.util.List;

@Api(APP_ROOT + "/article")
@RequestMapping(value = APP_ROOT + "/article", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public interface articleApi {

    @GetMapping(path = "/id/{id}")
    @ApiOperation(value = "rechercher un article" ,notes = "cette methode rechercher un article par ID",response = ArticleDto.class)
    @ApiResponses(value= {
        @ApiResponse(code = 200 ,message = "article trouve")
    })
    ArticleDto findById(@PathVariable Integer id) ;


    @GetMapping(path = "/code/{code}" )
    @ApiOperation(value = "rechercher un article" ,notes = "cette methode rechercher un article par CODE",response = ArticleDto.class)
    @ApiResponses(value= {
            @ApiResponse(code = 200 ,message = "article trouve")
    })
    ArticleDto findByCode(@RequestBody String code) ;

    @PostMapping(value = "/savePhoto")
    ArticleDto savePhoto(@RequestBody Integer id, InputStream photo, String titre) throws FlickrException;

    @PostMapping(value = "/create")
    @ApiOperation(value = "Ajouter un article" ,notes = "cette methode ajouter un article",response = ArticleDto.class)
    @ApiResponses(value= {
            @ApiResponse(code = 200 ,message = "article ajouter")
    })
    ArticleDto create(@RequestBody ArticleDto dto);

    @PostMapping(value = "/update")
    @ApiOperation(value = "modifier un article" ,notes = "cette methode modifier un article",response = ArticleDto.class)
    @ApiResponses(value= {
            @ApiResponse(code = 200 ,message = "article trouve")
    })
    ArticleDto update(@RequestBody ArticleDto dto);


    @GetMapping(path = "/designation/{designation}")
    @ApiOperation(value = "supprimer un article" ,notes = "cette methode rechercher un article par ID",response = ArticleDto.class)
    @ApiResponses(value= {
            @ApiResponse(code = 200 ,message = "article trouve")
    })
    List<ArticleDto> findByDesignation(@PathVariable String designation) ;


    @GetMapping(path = "/findAll")
    @ApiOperation(value = "rechercher tout les article" ,notes = "cette methode recherhcer tout article ",response = ArticleDto.class)
    @ApiResponses(value= {
            @ApiResponse(code = 200 ,message = "article trouve")
    })
     List<ArticleDto> findAll() ;

    @GetMapping(path = "/findEtat/{etat}")
    List<ArticleDto> findEtat(@PathVariable("etat") String etat) ;

    @DeleteMapping(value = "/delete/{id}")
    @ApiOperation(value = "rechercher un article" ,notes = "cette methode rechercher un article par ID",response = ArticleDto.class)
    @ApiResponses(value= {
            @ApiResponse(code = 200 ,message = "article trouve")
    })
    void delete (@PathVariable("id") Integer id );

}
