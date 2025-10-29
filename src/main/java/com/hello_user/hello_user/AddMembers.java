package com.hello_user.hello_user;

import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;


@Controller
public class AddMembers {
    private List<Members> members = new ArrayList<>();

    private boolean isAdmin(HttpSession session) {
        return session != null
            && "admin".equals(session.getAttribute("username"))
            && session.getAttribute("userToken") != null;
    }

    @GetMapping("/addmembers")
    public String addmembers(Model model, HttpSession session, RedirectAttributes ra) {
        if (!isAdmin(session)) {
            ra.addFlashAttribute("error", "Du måste vara inloggad som admin för att lägga till medlemmar.");
            return "redirect:/login";
        }
        model.addAttribute("newMember", new Members());
        return "addmembers";
    }

    @PostMapping("/addmembers")
    public String saveMember(@ModelAttribute("newMember") Members newMember, RedirectAttributes redirectAttrs, HttpSession session) {
        if (!isAdmin(session)) {
            redirectAttrs.addFlashAttribute("error", "Otillåten åtgärd");
            return "redirect:/login";
        }
        members.add(newMember);
        System.out.println("Saved member: " + newMember.getFirstName() + " " + newMember.getLastName() + " (total=" + members.size() + ")");
        redirectAttrs.addFlashAttribute("success", "Medlem sparad!");
        return "redirect:/members";
    }

    @GetMapping("/members")
    public String viewMembers(Model model, HttpSession session) {
        model.addAttribute("members", members);
        // session är tillgänglig i Thymeleaf via ${session}
        return "members";
    }

    @GetMapping("/remove-member/{memberId}")
    public String removeMember(@PathVariable("memberId") int memberId, HttpSession session, RedirectAttributes ra) {
        if (!isAdmin(session)) {
            ra.addFlashAttribute("error", "Otillåten åtgärd");
            return "redirect:/login";
        }
        members.removeIf(member -> member.getMemberID() == memberId);
        ra.addFlashAttribute("success", "Medlem borttagen");
        return "redirect:/members";
    }

    
   
}
