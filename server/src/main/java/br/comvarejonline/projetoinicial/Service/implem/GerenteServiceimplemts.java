package br.comvarejonline.projetoinicial.Service.implem;

import br.comvarejonline.projetoinicial.dto.EstoqueDto;
import br.comvarejonline.projetoinicial.dto.GerenteDto;
import br.comvarejonline.projetoinicial.model.Gerente;
import br.comvarejonline.projetoinicial.repository.GerenteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;

@Service
public class GerenteServiceimplemts {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private GerenteRepository gerenteRepository;

    public GerenteDto cadastrarGerente(GerenteDto dto) {

        Gerente gerente = modelMapper.map(dto, Gerente.class);

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode(gerente.getSenha());
        gerente.setSenha(encode);


        gerenteRepository.save(gerente);

        return modelMapper.map(gerente, GerenteDto.class);

    }
}