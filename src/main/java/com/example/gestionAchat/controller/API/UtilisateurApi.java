package com.example.gestionAchat.controller.API;


import static com.example.gestionAchat.util.constant.APP_ROOT;
import com.example.gestionAchat.Dto.UtilisateurDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(APP_ROOT +"utilisateur")
@RequestMapping(value = APP_ROOT + "/utilisateur", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public interface UtilisateurApi {

  @PostMapping("/create")
  UtilisateurDto save(@RequestBody UtilisateurDto dto);


  @GetMapping("/{id}")
  UtilisateurDto findById(@PathVariable  Integer id);

  @GetMapping("/getUtilisateur/{email}/{motDePasse}")
  UtilisateurDto getUtilisateur(@PathVariable("email") String email,@PathVariable("motDePasse") String motDePasse);


  @GetMapping("/find/{email}")
  UtilisateurDto findUtilisateur(@PathVariable("email") String email);

  @DeleteMapping("/delete/{idUtilisateur}")
  void delete(@PathVariable("idUtilisateur") Integer id);

}
