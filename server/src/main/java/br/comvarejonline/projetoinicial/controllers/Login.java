package br.comvarejonline.projetoinicial.controllers;


import br.comvarejonline.projetoinicial.dto.LoginForm;
import br.comvarejonline.projetoinicial.dto.TokenDto;
import br.comvarejonline.projetoinicial.model.Perfil;
import br.comvarejonline.projetoinicial.repository.PerfilRepository;
import br.comvarejonline.projetoinicial.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/login")
public class Login {



    @Autowired
    private TokenService tokenService;


    @Autowired
    private PerfilRepository perfilRepository;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity<TokenDto> autenticar(@RequestBody LoginForm form) {
        UsernamePasswordAuthenticationToken dadosLogin = form.converter();
        try {
            Authentication authentication = authenticationManager.authenticate(dadosLogin);
            String token = tokenService.gerarToken(authentication);

            return ResponseEntity.ok(new TokenDto(token, "Bearer"));
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return  ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public List<Perfil> perfils () {
        return perfilRepository.findAll();
    }
}
