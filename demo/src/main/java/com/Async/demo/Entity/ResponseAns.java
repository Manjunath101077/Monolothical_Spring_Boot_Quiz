package com.Async.demo.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
//Which will give both the construcutor
@RequiredArgsConstructor
public class ResponseAns {
    private Integer id;
    private String response;
}
