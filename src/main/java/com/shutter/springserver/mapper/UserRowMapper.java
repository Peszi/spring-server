package com.shutter.springserver.mapper;

//@Deprecated
//public class UserRowMapper implements RowMapper<UserAttribute> {
//
//    @Override
//    public UserAttribute mapRow(ResultSet rs, int rowNum) throws SQLException {
//        UserAttribute userDTO = new UserAttribute();
//        userDTO.setId(rs.getInt("id"));
//        userDTO.setEmail(rs.getString("email"));
//        userDTO.setPasswordHash(rs.getString("passwordHash"));
//        userDTO.setActive(rs.getBoolean("active"));
//        return userDTO;
//    }
//}

//    private UserAttribute getUserByEmail(String email) {
//        return this.jdbcTemplate.queryForObject("SELECT `id`,`email`,`passwordHash`,`active` FROM `users` WHERE `email`=?", new Object[]{email}, new UserRowMapper());
//    }
