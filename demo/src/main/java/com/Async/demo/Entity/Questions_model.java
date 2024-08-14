package com.Async.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity

@Data
public class Questions_model {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String questionTitle;
    private String Option1;
    private String Option2;
    private String Option3;
    private String Option4;
    private String rightAnswer;
    private String diffaculatyLevel;
    private String category;
}
