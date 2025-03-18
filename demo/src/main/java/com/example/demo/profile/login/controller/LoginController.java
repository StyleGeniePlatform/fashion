package com.example.demo.profile.login.controller;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import java.util.Map;

@Controller
public class LoginController {

    @GetMapping("/home")
    public String home(OAuth2AuthenticationToken token, Model model) {
        var attributes = token.getPrincipal().getAttributes();
        model.addAttribute("nickname", attributes.get("properties") instanceof Map<?, ?> props ? props.get("nickname") : "");
        return "home";
    }
}
