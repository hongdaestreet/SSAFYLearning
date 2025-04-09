package com.ssafy.board.controller;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import com.ssafy.board.model.dto.Place;
import com.ssafy.board.model.repository.BoardRepositoryImpl;
import com.ssafy.board.model.service.BoardService;
import com.ssafy.board.model.service.BoardServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/board/*")
public class BoardController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BoardService service;
    
    @Override
    public void init() throws ServletException {
        super.init();
        BoardRepositoryImpl repository = BoardRepositoryImpl.getInstance(getServletContext());
        service = BoardServiceImpl.getInstance(repository);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        process(request, response);
    }
    
    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();
        
        if (path == null || path.equals("/") || path.equals("/list")) {
            listPlaces(request, response);
        } else if (path.equals("/login")) {
            login(request, response);
        } else if (path.equals("/logout")) {
            logout(request, response);
        } else if (path.equals("/register")) {
            register(request, response);
        } else if (path.equals("/like")) {
            toggleLike(request, response);
        } else if (path.equals("/likedList")) {
            likedList(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/board/list");
        }
    }
    
    private void listPlaces(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Place> places = service.getAllPlaces();
        request.setAttribute("places", places);
        
        // Get user likes if logged in
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if (username != null) {
            Set<String> userLikes = service.getUserLikes(username);
            request.setAttribute("userLikes", userLikes);
        }
        
        request.getRequestDispatcher("/WEB-INF/board/list.jsp").forward(request, response);
    }
    
    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ("POST".equalsIgnoreCase(request.getMethod())) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String rememberMe = request.getParameter("rememberMe");
            
            if (service.login(username, password)) {
                // Set session
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                
                // Set cookie if remember me is checked
                if (rememberMe != null) {
                    Cookie loginCookie = new Cookie("loginStatus", "true");
                    loginCookie.setMaxAge(60 * 60 * 24 * 30); // 30 days
                    response.addCookie(loginCookie);
                }
                
                response.sendRedirect(request.getContextPath() + "/board/list");
            } else {
                request.setAttribute("loginErrorMessage", "아이디 또는 비밀번호가 올바르지 않습니다.");
                request.getRequestDispatcher("/WEB-INF/board/list.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/board/list");
        }
    }
    
    private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Invalidate session
        HttpSession session = request.getSession();
        session.invalidate();
        
        // Delete cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("loginStatus")) {
                    cookie.setValue("");
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
        }
        
        response.sendRedirect(request.getContextPath() + "/board/list");
    }
    
    private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ("POST".equalsIgnoreCase(request.getMethod())) {
            String newUsername = request.getParameter("newUsername");
            String newPassword = request.getParameter("newPassword");
            String confirmPassword = request.getParameter("confirmPassword");
            
            if (service.register(newUsername, newPassword, confirmPassword)) {
                request.setAttribute("registerSuccessMessage", "회원가입이 완료되었습니다. 이제 로그인할 수 있습니다.");
            } else {
                if (newUsername == null || newUsername.trim().isEmpty()) {
                    request.setAttribute("registerErrorMessage", "아이디를 입력해주세요.");
                } else if (newPassword == null || newPassword.trim().isEmpty()) {
                    request.setAttribute("registerErrorMessage", "비밀번호를 입력해주세요.");
                } else if (!newPassword.equals(confirmPassword)) {
                    request.setAttribute("registerErrorMessage", "비밀번호가 일치하지 않습니다.");
                } else {
                    request.setAttribute("registerErrorMessage", "이미 사용 중인 아이디입니다.");
                }
            }
            
            request.getRequestDispatcher("/WEB-INF/board/list.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/board/list");
        }
    }
    
    private void toggleLike(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        
        if (username != null) {
            String placeId = request.getParameter("placeId");
            if (placeId != null) {
                service.toggleLike(username, placeId);
            }
        }
        
        response.sendRedirect(request.getContextPath() + "/board/list");
    }
    
    private void likedList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        
        if (username != null) {
            List<Place> likedPlaces = service.getLikedPlaces(username);
            request.setAttribute("likedPlaces", likedPlaces);
        }
        
        request.getRequestDispatcher("/WEB-INF/board/likedList.jsp").forward(request, response);
    }
}