package com.shutter.springserver.mapper;

import com.shutter.springserver.model.UserDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<UserDTO> {

    @Override
    public UserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(rs.getString("email"));
        userDTO.setPassword(rs.getString("passwordHash"));
        userDTO.setActive(rs.getBoolean("active"));
        return userDTO;
    }
}
