package com.covinoc.api.service.impl;

import com.covinoc.api.dto.UserDTO;
import com.covinoc.api.exception.ModeloNotFoundException;
import com.covinoc.api.mapper.UserMapper;
import com.covinoc.api.model.UserEntity;
import com.covinoc.api.repository.UserRepository;
import com.covinoc.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserMapper mapper;

    @Override
    public UserDTO register(UserDTO userDTO) {
        userDTO.setCreationDate(LocalDateTime.now());
        return mapper.toDto(repository.save(mapper.toEntity(userDTO)));
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        Optional<UserEntity> user = repository.findById(userDTO.getId());

        if (user.isEmpty()) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + userDTO.getId());
        }

        userDTO.setCreationDate(user.get().getCreationDate());
        userDTO.setModificationDate(LocalDateTime.now());
        return mapper.toDto(repository.save(mapper.toEntity(userDTO)));
    }

    @Override
    public List<UserDTO> getAll() {
        return mapper.toDtos(repository.findAll());
    }

    @Override
    public Optional<UserDTO> getById(Integer id) {
        Optional<UserEntity> entity = repository.findById(id);
        if(entity.isEmpty()){
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
        }
        return Optional.ofNullable(mapper.toDto(entity.get()));
    }

    @Override
    public void delete(Integer id) {
        Optional<UserEntity> entity = repository.findById(id);
        if(entity.isEmpty()){
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
        }
        repository.deleteById(id);
    }
}
