package com.shutter.springserver.mapper;

//@Deprecated
//public class UserRowMapper implements RowMapper<UserDTO> {
//
//    @Override
//    public UserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
//        UserDTO userDTO = new UserDTO();
//        userDTO.setId(rs.getInt("id"));
//        userDTO.setEmail(rs.getString("email"));
//        userDTO.setPasswordHash(rs.getString("passwordHash"));
//        userDTO.setActive(rs.getBoolean("active"));
//        return userDTO;
//    }
//}

//    private UserDTO getUserByEmail(String email) {
//        return this.jdbcTemplate.queryForObject("SELECT `id`,`email`,`passwordHash`,`active` FROM `users` WHERE `email`=?", new Object[]{email}, new UserRowMapper());
//    }
