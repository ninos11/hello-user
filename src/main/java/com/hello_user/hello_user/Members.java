package com.hello_user.hello_user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class Members {
@GetMapping("/members")
public String members() {
    return "members";
}

}
