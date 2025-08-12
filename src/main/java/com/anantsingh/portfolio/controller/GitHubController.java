package com.anantsingh.portfolio.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class GitHubController {
    
    private final RestTemplate restTemplate = new RestTemplate();
    private static final String GITHUB_API_URL = "https://api.github.com/users/Anant0325/repos";
    
    @GetMapping("/github/repos")
    public ResponseEntity<?> getGitHubRepos() {
        try {
            String response = restTemplate.getForObject(GITHUB_API_URL, String.class);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(500)
                    .body("{\"success\": false, \"message\": \"Failed to fetch GitHub repositories\", \"error\": \"" + e.getMessage() + "\"}");
        }
    }
    
    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("{\"status\": \"UP\", \"service\": \"Anant Singh Portfolio Backend\"}");
    }
}