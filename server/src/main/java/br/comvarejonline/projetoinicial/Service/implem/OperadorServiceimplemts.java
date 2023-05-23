package br.comvarejonline.projetoinicial.Service.implem;

import br.comvarejonline.projetoinicial.dto.GerenteDto;
import br.comvarejonline.projetoinicial.dto.OperadorDto;
import br.comvarejonline.projetoinicial.model.Operador;
import br.comvarejonline.projetoinicial.repository.GerenteRepository;
import br.comvarejonline.projetoinicial.repository.OperadorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class OperadorServiceimplemts {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private OperadorRepository operadorRepository;

    public OperadorDto cadastrarOperador(OperadorDto operadorDto) {

        Operador operador = modelMapper.map(operadorDto, Operador.class);

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode(operador.getSenha());
        operador.setSenha(encode);

        operadorRepository.save(operador);

        return modelMapper.map(operador,OperadorDto.class);

    }
}
