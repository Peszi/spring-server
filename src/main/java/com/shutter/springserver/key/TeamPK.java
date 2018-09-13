package com.shutter.springserver.key;

import lombok.*;

import java.io.Serializable;

@Deprecated
@Data
public class TeamPK implements Serializable {
    String alias;
    Long roomId;
}
