package com.shutter.springserver.game.dto.utility;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class GameResultModel {

    private List<ResultModel> results;

    public GameResultModel() {
        this.results = new ArrayList<>();
    }
}
