package br.com.bonatto.steticar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bonatto.steticar.domain.Usuario;
import br.com.bonatto.steticar.dto.autenticacao.AutenticacaoDados;
import br.com.bonatto.steticar.infra.security.TokenJwtDados;
import br.com.bonatto.steticar.infra.security.TokenService;
import jakarta.validation.Valid;



@RestController
@RequestMapping("/login")
public class AutenticacaoController {
    
    @Autowired
    private AuthenticationManager manager;


    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<TokenJwtDados> login( @Valid @RequestBody AutenticacaoDados dados)
    {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        org.springframework.security.core.Authentication autentication = manager.authenticate(authenticationToken);

        String token = tokenService.gerarToken((Usuario)autentication.getPrincipal());
        return ResponseEntity.ok(new TokenJwtDados(token));
    }
}
