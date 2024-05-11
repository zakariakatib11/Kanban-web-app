package com.example.kanbansystem.Response;

import com.example.kanbansystem.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor



public class AuthenticationResponse {

    private User user;

    private String message;

}