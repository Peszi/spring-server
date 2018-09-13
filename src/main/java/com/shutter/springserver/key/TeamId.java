package com.shutter.springserver.key;

import javax.persistence.Embeddable;

@Deprecated
@Embeddable
public class TeamId {
    Integer id;
    Long roomId;
}
