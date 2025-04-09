package com.ssafy.board.model.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ssafy.board.model.dto.Place;
import com.ssafy.board.model.dto.User;

import jakarta.servlet.ServletContext;

public class BoardRepositoryImpl implements BoardRepository {
    private ServletContext application;
    private Map<String, String> userDatabase;
    private Map<String, Set<String>> likesDatabase;
    private List<Place> placesList;
    
    // Singleton pattern
    private static BoardRepositoryImpl instance;
    
    private BoardRepositoryImpl(ServletContext application) {
        this.application = application;
        initializeData();
    }
    
    public static BoardRepositoryImpl getInstance(ServletContext application) {
        if (instance == null) {
            instance = new BoardRepositoryImpl(application);
        }
        return instance;
    }
    
    @SuppressWarnings("unchecked")
    private void initializeData() {
        // Initialize user database
        userDatabase = (Map<String, String>) application.getAttribute("userDatabase");
        if (userDatabase == null) {
            userDatabase = new HashMap<>();
            // Add default admin account
            userDatabase.put("admin", "1234");
            application.setAttribute("userDatabase", userDatabase);
        }
        
        // Initialize likes database
        likesDatabase = (Map<String, Set<String>>) application.getAttribute("likesDatabase");
        if (likesDatabase == null) {
            likesDatabase = new HashMap<>();
            application.setAttribute("likesDatabase", likesDatabase);
        }
        
        // Initialize place data (this would ideally come from a DB)
        placesList = new ArrayList<>();
        placesList.add(new Place("place1", "서울숲공원산책길", "서울 성동구 성수동1가", "숲속 산책길", "3.4km", "약 2시간", "서울숲.jpg", "https://kko.kakao.com/HzeJphE4p9"));
        placesList.add(new Place("place2", "흥인지문공원 ~ 낙산공원", "서울 종로구 종로 285", "야경 산책길", "2.3km", "약 40분", "낙산공원.jpg", "https://www.durunubi.kr/4-2-1-1-walk-mobility-view-detail.do?crs_idx=T_CRS_MNG0000003307&brd_div=DNWW"));
        placesList.add(new Place("place3", "청계천", "서울 중구 태평로1가 1", "도심 속 산책로", "3.7km", "약 2시간", "청계천야경.jpg", "https://www.durunubi.kr/4-2-1-1-walk-mobility-view-detail.do?crs_idx=T_CRS_MNG0000000874&brd_div=DNWW"));
        placesList.add(new Place("place4", "인왕산 둘레길", "서울 종로구 사직동 산 1-25", "자연 속 산책", "3.2km", "약 1시간 30분", "인왕산둘레길.jpg", "https://map.kakao.com/?map_type=TYPE_MAP&itemId=26564580&q=%EC%9D%B8%EC%99%95%EC%82%B0%EB%91%98%EB%A0%88%EA%B8%B8&urlLevel=4&urlX=493051&urlY=1135123"));
        placesList.add(new Place("place5", "서울한양도성 남산구간 3코스", "서울 중구 예장동", "경치 좋은 산책", "4.2km", "약 3시간", "남산구간3코스.jpg", "https://kko.kakao.com/FPdZNkQUC-"));
        placesList.add(new Place("place6", "서울둘레길 1코스 속세를 떠나지 않은 옛사람의 길", "서울 노원구 상계동 산 44-113", "자연 속의 산책", "6.4km", "약 2시간 50분", "서울둘레길1코스_수락산.JPG", "https://kko.kakao.com/br8LMsJbgn"));
        placesList.add(new Place("place7", "송파둘레길 성내천길", "서울 송파구 방이동 88-6", "하천 주변 산책길", "6km", "약 1시간 30분", "img/songpa_seongnaecheon.jpg", "https://kko.kakao.com/c-_BzmQD6r"));
        placesList.add(new Place("place8", "석촌호수산책길", "서울 송파구 송파동", "호수 주변 산책길", "4.1km", "약 2시간", "img/seokchon.jpg", "https://kko.kakao.com/0KZGI72ecZ"));
        placesList.add(new Place("place9", "양재천산책길", "서울 서초구 양재동", "하천 주변 산책길", "4km", "약 1시간", "img/yanjaecheon.png", "https://kko.kakao.com/RDgWK5Unqk"));
        placesList.add(new Place("place10", "서울테마산책길 포이산책길", "서울 강남구 개포동 1271", "공원 산책길", "3.5km", "약 1시간 30분", "img/poi.png", "https://kko.kakao.com/j250sKOOp2"));
        placesList.add(new Place("place11", "서울테마산책길 국사봉길", "서울 관악구 봉천동 1712-4", "공원, 산 산책길", "2.5km", "약 1시간 30분", "img/guksabongil.png", "https://kko.kakao.com/sqlT4RBz9r"));
        placesList.add(new Place("place12", "서울테마산책길 인재개발원 잣나무숲길", "서울 서초구 서초동 산 36-6", "숲 산책길", "3km", "약 1시간", "img/jattree_forest.png", "https://kko.kakao.com/1EhKU7YtnY"));
    }
    
    @Override
    public boolean addUser(User user) {
        if (userDatabase.containsKey(user.getUsername())) {
            return false; // User already exists
        }
        userDatabase.put(user.getUsername(), user.getPassword());
        application.setAttribute("userDatabase", userDatabase);
        return true;
    }
    
    @Override
    public User getUser(String username) {
        if (userDatabase.containsKey(username)) {
            return new User(username, userDatabase.get(username));
        }
        return null;
    }
    
    @Override
    public boolean isValidUser(String username, String password) {
        return userDatabase.containsKey(username) && userDatabase.get(username).equals(password);
    }
    
    @Override
    public List<Place> getAllPlaces() {
        return placesList;
    }
    
    @Override
    public Place getPlaceById(String id) {
        for (Place place : placesList) {
            if (place.getId().equals(id)) {
                return place;
            }
        }
        return null;
    }
    
    @Override
    public boolean toggleLike(String username, String placeId) {
        Set<String> userLikes = likesDatabase.get(username);
        if (userLikes == null) {
            userLikes = new HashSet<>();
            likesDatabase.put(username, userLikes);
        }
        
        boolean result;
        if (userLikes.contains(placeId)) {
            userLikes.remove(placeId);
            result = false; // Unlike
        } else {
            userLikes.add(placeId);
            result = true; // Like
        }
        
        application.setAttribute("likesDatabase", likesDatabase);
        return result;
    }
    
    @Override
    public Set<String> getUserLikes(String username) {
        Set<String> userLikes = likesDatabase.get(username);
        if (userLikes == null) {
            return new HashSet<>();
        }
        return userLikes;
    }
    
    @Override
    public boolean isPlaceLiked(String username, String placeId) {
        Set<String> userLikes = likesDatabase.get(username);
        if (userLikes == null) {
            return false;
        }
        return userLikes.contains(placeId);
    }
}