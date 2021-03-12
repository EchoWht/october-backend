package com.blskye.october.service;

import com.blskye.october.service.dto.MarkdownDTO;
import com.blskye.october.utils.FileHandleUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MarkdownService {

    private final Logger log = LoggerFactory.getLogger(MarkdownService.class);

    public boolean createMarkdownFile(MarkdownDTO markdownDTO) {
        String pathname=System.currentTimeMillis()+".md";
        return FileHandleUtils.write(pathname,markdownDTO.getContent());
    }

}
