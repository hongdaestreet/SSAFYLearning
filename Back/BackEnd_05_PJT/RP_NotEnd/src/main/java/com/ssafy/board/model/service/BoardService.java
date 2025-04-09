package com.ssafy.board.model.service;

import java.util.List;
import java.util.Set;

import com.ssafy.board.model.dto.Place;
import com.ssafy.board.model.dto.User;

public interface BoardService {
    // User related methods
    boolean register(String username, String password, String confirmPassword);
    boolean login(String username, String password);
    User getUser(String username);
    
    // Place related methods
    List<Place> getAllPlaces();
    Place getPlaceById(String id);
    
    // Like related methods
    boolean toggleLike(String username, String placeId);
    Set<String> getUserLikes(String username);
    List<Place> getLikedPlaces(String username);
}