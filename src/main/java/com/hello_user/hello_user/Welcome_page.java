package com.hello_user.hello_user;

import org.springframework.web.bind.annotation.GetMapping;

public class Welcome_page {
@GetMapping("/")
public String welcome() {
    return "index";
}
}

