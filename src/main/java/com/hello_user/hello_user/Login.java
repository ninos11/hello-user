package com.hello_user.hello_user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class Login {
@GetMapping("/login")
public String login() {
    return "login";
}

}
