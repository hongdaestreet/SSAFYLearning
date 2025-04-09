package com.ssafy.board.model.repository;

import java.util.List;
import java.util.Set;

import com.ssafy.board.model.dto.Place;
import com.ssafy.board.model.dto.User;

public interface BoardRepository {
    // User related methods
    boolean addUser(User user);
    User getUser(String username);
    boolean isValidUser(String username, String password);
    
    // Place related methods
    List<Place> getAllPlaces();
    Place getPlaceById(String id);
    
    // Like related methods
    boolean toggleLike(String username, String placeId);
    Set<String> getUserLikes(String username);
    boolean isPlaceLiked(String username, String placeId);
}