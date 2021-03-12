package com.blskye.october.service.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author wanghaotian
 * @version 1.0
 * @date 2021/3/13 12:00 上午
 */
public class MarkdownDTO {

    @NotBlank
    @Size(max = 500000)
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MarkdownDTO{" +
            "content='" + content + '\'' +
            '}';
    }
}
