package me.diisk.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import me.diisk.api.domain.usuario.DadosAutenticacao;
import me.diisk.api.domain.usuario.Usuario;
import me.diisk.api.infra.security.DadosTokenJWT;
import me.diisk.api.infra.security.TokenService;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<DadosTokenJWT> efetuarLogin(@RequestBody @Valid DadosAutenticacao dados){
        var authToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = manager.authenticate(authToken);
        
        var jwtToken = tokenService.gerarToken((Usuario) authentication.getPrincipal());
        
        return ResponseEntity.ok(new DadosTokenJWT(jwtToken));
    }
}
