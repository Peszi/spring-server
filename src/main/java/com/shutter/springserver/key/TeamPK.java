package com.shutter.springserver.key;

import lombok.*;

import java.io.Serializable;

@Data
public class TeamPK implements Serializable {
    Integer id;
    Long roomId;
}
