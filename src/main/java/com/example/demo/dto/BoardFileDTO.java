package com.example.demo.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BoardFileDTO {

    private BoardDTO boardDTO;
    private List<FileDTO> fileList;
}
