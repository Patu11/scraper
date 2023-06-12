package com.github.patu11.backend.service;

import com.github.patu11.backend.model.common.Episode;

public interface CommonService {
    Episode getNextEpisode(String id);
}
