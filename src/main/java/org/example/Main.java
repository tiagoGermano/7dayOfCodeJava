package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        var token = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxZTk1NzA2ZGFjY2ZkZDg4M2UzYjQwMTI0ZDU0YzQzNiIsInN1YiI6IjY1NzdjOTllNTY0ZWM3MDExYjIwNWQ0ZiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.lqIUF5574-s6NOfHvWeoCgqM2VELhXy_NFQtwAzF0ts";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.themoviedb.org/3/movie/popular?language=en-US&page=1"))
                .header("accept", "application/json")
                .header("Authorization", "Bearer " + token)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        var json = response.body();
        System.out.println(json);
    }
}