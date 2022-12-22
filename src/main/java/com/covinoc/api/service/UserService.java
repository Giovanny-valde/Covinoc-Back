package com.covinoc.api.service;

import com.covinoc.api.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserDTO register (UserDTO userDTO);

    UserDTO update (UserDTO userDTO);

    List<UserDTO> getAll();

    Optional<UserDTO> getById(Integer id);

    void delete (Integer id);
}
