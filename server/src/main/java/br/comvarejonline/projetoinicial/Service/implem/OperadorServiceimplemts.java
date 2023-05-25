package br.comvarejonline.projetoinicial.Service.implem;

import br.comvarejonline.projetoinicial.dto.CadastroOperadorDto;
import br.comvarejonline.projetoinicial.dto.OperadorDto;
import br.comvarejonline.projetoinicial.model.Operador;
import br.comvarejonline.projetoinicial.model.Perfil;
import br.comvarejonline.projetoinicial.repository.OperadorRepository;
import br.comvarejonline.projetoinicial.repository.PerfilRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class OperadorServiceimplemts {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private OperadorRepository operadorRepository;

    @Autowired
    private PerfilRepository perfilRepository;


    public OperadorDto cadastrarOperador(CadastroOperadorDto dto) {

        Operador operador = modelMapper.map(dto, Operador.class);

        Perfil perfil = perfilRepository.getById(dto.getPerfilId());

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        String encode = bCryptPasswordEncoder.encode(operador.getSenha());
        operador.setSenha(encode);
        operador.setPerfil(Collections.singletonList(perfil));


        operadorRepository.save(operador);

        return modelMapper.map(operador, OperadorDto.class);

    }
}
