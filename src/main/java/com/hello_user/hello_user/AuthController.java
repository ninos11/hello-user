package com.hello_user.hello_user;

import java.util.UUID;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller


public class AuthController {

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam String username,
                          @RequestParam String password,
                          HttpSession session,
                          RedirectAttributes redirectAttrs) {
        
        if ("admin".equals(username) && "admin".equals(password)) {
            session.setAttribute("username", "admin");
            session.setAttribute("userToken", UUID.randomUUID().toString());
            redirectAttrs.addFlashAttribute("success", "Inloggad som admin");
            return "redirect:/"; 
        }

        redirectAttrs.addFlashAttribute("error", "Fel användarnamn eller lösenord");
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session, RedirectAttributes redirectAttrs) {
        session.invalidate();
        redirectAttrs.addFlashAttribute("success", "Utloggad");
        return "redirect:/";
    }
}
