package com.blskye.october.web.rest;

import com.blskye.october.service.MarkdownService;
import com.blskye.october.service.dto.MarkdownDTO;
import io.github.jhipster.web.util.HeaderUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * MarkdownResource controller
 */
@RestController
@RequestMapping("/api/markdown")
public class MarkdownResource {

    private final Logger log = LoggerFactory.getLogger(MarkdownResource.class);
    @Value("${jhipster.clientApp.name}")
    private String applicationName;
    private final MarkdownService markdownService;

    public MarkdownResource(MarkdownService markdownService) {
        this.markdownService = markdownService;
    }

    /**
    * POST createMarkdownFile
    */
    @PostMapping
    public ResponseEntity<MarkdownDTO> createMarkdownFile(@RequestBody MarkdownDTO markdownDTO) throws URISyntaxException {
         markdownService.createMarkdownFile(markdownDTO);
         return ResponseEntity.created(new URI("/api/markdown"))
             .body(markdownDTO);
    }

    /**
    * GET readMarkdownFile
    */
    @GetMapping
    public String readMarkdownFile() {
        return "readMarkdownFile";
    }

    /**
    * PUT updateMarkdownFile
    */
    @PutMapping
    public String updateMarkdownFile() {
        return "updateMarkdownFile";
    }

    /**
    * DELETE removeMarkdownFile
    */
    @DeleteMapping
    public String removeMarkdownFile() {
        return "removeMarkdownFile";
    }

}
