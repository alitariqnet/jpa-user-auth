package dev.ali.JPAUserAuth.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HomeController {

    @GetMapping("/")
    public String hello(){
        return "Hello!";
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/user")
    public String helloUser(){
        return "Hello user!";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin")
    public String helloAdmin(){
        return "Hello admin!";
    }
    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping(value = "/unamewithprincipal")
    public String currentUserName(Principal principal) {
        return principal.getName();
    }
    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping(value = "/unamewithauth")
    public String currentUserName(Authentication authentication) {
        return authentication.getName();
    }
    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping(value = "/unamewithservletreq")
    public String currentUserNameSimple(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        return principal.getName();
    }
    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/userdetails")
    public String getUser(@AuthenticationPrincipal UserDetails userDetails) {
        return "User Details: " + userDetails.getUsername();

}
