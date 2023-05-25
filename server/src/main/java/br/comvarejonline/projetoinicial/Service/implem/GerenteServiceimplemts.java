package br.comvarejonline.projetoinicial.Service.implem;

import br.comvarejonline.projetoinicial.dto.GerenteCadastroDto;
import br.comvarejonline.projetoinicial.dto.GerenteDto;
import br.comvarejonline.projetoinicial.model.Gerente;
import br.comvarejonline.projetoinicial.model.Perfil;
import br.comvarejonline.projetoinicial.model.Usuario;
import br.comvarejonline.projetoinicial.repository.GerenteRepository;
import br.comvarejonline.projetoinicial.repository.PerfilRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class GerenteServiceimplemts {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private GerenteRepository gerenteRepository;

    @Autowired
    private PerfilRepository perfilRepository;


    public GerenteDto cadastrarGerente(GerenteCadastroDto dto) {

        Gerente gerente = modelMapper.map(dto, Gerente.class);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        Perfil perfil = perfilRepository.getById(dto.getPerfilId());

        String encode = bCryptPasswordEncoder.encode(gerente.getSenha());
        gerente.setSenha(encode);
        gerente.setPerfil(Collections.singletonList(perfil));


        gerenteRepository.save(gerente);

        return modelMapper.map(gerente, GerenteDto.class);

    }
}
