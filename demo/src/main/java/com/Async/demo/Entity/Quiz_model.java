package com.Async.demo.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Quiz_model {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;
        private String title;
        @ManyToMany
        private List<Questions_model> questionsModels;
}
