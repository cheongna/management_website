package com.manager.website.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

@Controller
public class RedirectController {

    @GetMapping("/")
    public String index() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            return "redirect:/loginSuccess";
        }
        return "login";
    }

    @GetMapping("/loginSuccess")
    public String successPage() {
        return "loginsuccess";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @GetMapping("/findId")
    public String findIdPage() {
        return "findId";
    }

    @GetMapping("/findPw")
    public String findPwPage() {
        return "findPw";
    }

    @GetMapping("/foundId")
    public String foundIdPage(HttpSession session, Model model) {
        String username = (String) session.getAttribute("username");
        model.addAttribute("username", username);
        return "foundId";  // foundId 페이지로 이동
    }
}
