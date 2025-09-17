package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Team {
    @Id @GeneratedValue
    private Long id;

    private String name;

    // 양방향 매핑
    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<>();//멤버여러명 들어 올 수 o

}