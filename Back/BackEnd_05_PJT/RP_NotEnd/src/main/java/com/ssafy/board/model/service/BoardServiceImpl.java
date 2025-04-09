package com.ssafy.board.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.ssafy.board.model.dto.Place;
import com.ssafy.board.model.dto.User;
import com.ssafy.board.model.repository.BoardRepository;

public class BoardServiceImpl implements BoardService {
    private BoardRepository repository;
    
    // Singleton pattern
    private static BoardServiceImpl instance;
    
    private BoardServiceImpl(BoardRepository repository) {
        this.repository = repository;
    }
    
    public static BoardServiceImpl getInstance(BoardRepository repository) {
        if (instance == null) {
            instance = new BoardServiceImpl(repository);
        }
        return instance;
    }
    
    @Override
    public boolean register(String username, String password, String confirmPassword) {
        // Validation logic
        if (username == null || username.trim().isEmpty()) {
            return false;
        }
        if (password == null || password.trim().isEmpty()) {
            return false;
        }
        if (!password.equals(confirmPassword)) {
            return false;
        }
        
        User user = new User(username, password);
        return repository.addUser(user);
    }
    
    @Override
    public boolean login(String username, String password) {
        return repository.isValidUser(username, password);
    }
    
    @Override
    public User getUser(String username) {
        return repository.getUser(username);
    }
    
    @Override
    public List<Place> getAllPlaces() {
        return repository.getAllPlaces();
    }
    
    @Override
    public Place getPlaceById(String id) {
        return repository.getPlaceById(id);
    }
    
    @Override
    public boolean toggleLike(String username, String placeId) {
        return repository.toggleLike(username, placeId);
    }
    
    @Override
    public Set<String> getUserLikes(String username) {
        return repository.getUserLikes(username);
    }
    
    @Override
    public List<Place> getLikedPlaces(String username) {
        List<Place> likedPlaces = new ArrayList<>();
        Set<String> likedIds = repository.getUserLikes(username);
        
        for (String id : likedIds) {
            Place place = repository.getPlaceById(id);
            if (place != null) {
                likedPlaces.add(place);
            }
        }
        
        return likedPlaces;
    }
}