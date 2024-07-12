package com.example.smspr.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

public class CommonDto {

    @Builder //모든 멤버 필드에 대해 parameter를 받는 constructor를 만듦
    @Schema
    @Getter //lombok으로 getter setter 자동으로 생성
    @Setter
    @AllArgsConstructor //모든 필드 값(여기에선 id, title, content, title2)을 파라미터로 받는 constructor 생성
    @NoArgsConstructor //파라미터가 없는 default constructor 생성
    public static class PostDetailResDto {
        String id;
        String title;
        String content;
        String title2;
    }

    @Builder
    @Schema
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class TbboardDetailResDto {
        String id;
        String title;
        String content;
        String writer;
    }


}
