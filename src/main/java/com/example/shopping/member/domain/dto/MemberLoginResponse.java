package com.example.shopping.member.domain.dto;

import com.example.shopping.delivery.domain.entity.Delivery;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class MemberLoginResponse {
    private String id;
    private String address;
    private String username;
    private List<Delivery> deliveries;
    private Boolean isLogin;
}