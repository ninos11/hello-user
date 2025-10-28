package com.hello_user.hello_user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model; 

@Controller
public class AddMembers {
    private List<Members> members = new ArrayList<>();    

    @GetMapping("/addmembers")
    public String addmembers(Model model) {
        model.addAttribute("newMember", new Members());
        return "addmembers";    
    }

    @PostMapping("/addmembers")
    public String saveMember(@ModelAttribute("newMember") Members newMember, RedirectAttributes redirectAttrs) {
        members.add(newMember);
        System.out.println("Saved member: " + newMember.getFirstName() + " " + newMember.getLastName() + " " + newMember.getPhoneNumber() + " " + newMember.getRole() + " " + newMember.getEmail() + " " + newMember.getBirthDate() + " (total=" + members.size() + ")");
        redirectAttrs.addFlashAttribute("success", "Medlem sparad!");
        return "redirect:/addmembers";
    }
}
