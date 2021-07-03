package com.example.gestionAchat.controller.API;

import com.example.gestionAchat.Dto.ArticleDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.gestionAchat.util.constant.APP_ROOT;
import  com.example.gestionAchat.Dto.auth.AuthRequest;
import  com.example.gestionAchat.Dto.auth.AuthResponse;

import java.util.List;

@Api(value = APP_ROOT + "/authenticate")
@RequestMapping(value = APP_ROOT + "/authenticate", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public interface AuthenticationApi {

  @PostMapping("/authenticate")
  public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthRequest request);

  @GetMapping(path = "/msg")
  public String msg() ;

}
