package com.covinoc.api.mapper;

import com.covinoc.api.dto.UserDTO;
import com.covinoc.api.model.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMapper implements GenericMapper<UserEntity, UserDTO>{

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserEntity toEntity(UserDTO dto) {
        return modelMapper.map(dto, UserEntity.class);
    }

    @Override
    public UserDTO toDto(UserEntity entity) {
        return modelMapper.map(entity, UserDTO.class);
    }

    @Override
    public List<UserEntity> toEntities(List<UserDTO> dtos) {
        return dtos.stream().map(x -> modelMapper.map(x, UserEntity.class)).toList();
    }

    @Override
    public List<UserDTO> toDtos(List<UserEntity> entities) {
        return entities.stream().map(x -> modelMapper.map(x, UserDTO.class)).toList();
    }
}
