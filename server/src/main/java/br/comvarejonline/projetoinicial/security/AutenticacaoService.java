package br.comvarejonline.projetoinicial.security;

import br.comvarejonline.projetoinicial.model.Usuario;
import br.comvarejonline.projetoinicial.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Usuario> usuario = usuarioRepository.findByEmail(username);

        if (usuario.isPresent()){
            return usuario.get();
        }
        throw new UsernameNotFoundException("dadosInvalidos");
    }
}
