package com.example.careercounseling.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class CareerAdviceService {

    private static final String AI_API_URL = "https://api.openai.com/v1/chat/completions";

    private final RestTemplate restTemplate = new RestTemplate();

    public String getCareerAdvice(String skills, String goals) {
        String prompt = buildPrompt(skills, goals);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth("YOUR_OPENAI_API_KEY_HERE");

        Map<String, Object> requestBody = Map.of(
                "model", "gpt-4.1-mini",
                "messages", new Object[]{
                        Map.of(
                                "role", "system",
                                "content", "You are a helpful career counselor for university students."
                        ),
                        Map.of(
                                "role", "user",
                                "content", prompt
                        )
                }
        );

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestBody, headers);

        
        String response = restTemplate.postForObject(AI_API_URL, request, String.class);
        return response != null ? response : "";
    }

    private String buildPrompt(String skills, String goals) {
        return "The student has the following skills: " + skills + ". "
                + "Their career goals are: " + goals + ". "
                + "Suggest 3 concrete next steps (courses, projects, or internships) that can help them progress.";
    }
}
