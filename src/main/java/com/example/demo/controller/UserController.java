package com.example.demo.controller;


import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.net.http.HttpRequest;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/user/*")
@Slf4j
@Controller
public class UserController {
    private final UserService userService;

    @GetMapping("/join")
    public void join(){}

    @GetMapping("/login")
    public void login(HttpServletRequest request,
                      Model model){
        String email = (String)request.getSession().getAttribute("email");
        String errMsg = (String)request.getSession().getAttribute("errMsg");
        log.info(">>> errMsg >> {}", errMsg);
        if(errMsg != null){
            log.info(">>> errMsg >> {}", errMsg);
            model.addAttribute("email", email);
            model.addAttribute("errMsg", errMsg);
        }

        request.getSession().removeAttribute("email");
        request.getSession().removeAttribute("errMsg");
    }

    @PostMapping("join")
    public String join(UserDTO userDTO){
        String email = userService.register(userDTO);
        log.info(">>> email >> {}", email);
        return "index";
    }

    @GetMapping("/modify")
    public void modify(){}

    @PostMapping("/modify")
    public String modify(UserDTO userDTO,
                        HttpServletRequest request,
                         HttpServletResponse response,
                        RedirectAttributes redirectAttributes){
        String email = userService.modify(userDTO);
        if(email != null) {
            redirectAttributes.addFlashAttribute("modify_msg", "ok");
        }else {
            redirectAttributes.addFlashAttribute("modify_msg", "fail");
        }
        logout(request, response);
        return "redirect:/";
    }

    @GetMapping("/list")
    public void list(){}

    @PostMapping("/list")
    public String list(Model model) {
        List<UserDTO> userList = userService.getList();

        return "redirect:/user/list";
    }

    @GetMapping("/remove")
    public String remove(UserDTO userDTO,
                         http)

    private void logout(HttpServletRequest req, HttpServletResponse res) {
        // 내가 로그인 할 때 사용한 시큐리티의 authentication 객체
        Authentication authenication =
                SecurityContextHolder.getContext().getAuthentication();
        new SecurityContextLogoutHandler().logout(req, res, authenication);
    }
}
