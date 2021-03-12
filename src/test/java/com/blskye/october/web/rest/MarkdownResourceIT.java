package com.blskye.october.web.rest;

import com.blskye.october.OctoberApp;
import com.blskye.october.RedisTestContainerExtension;
import com.blskye.october.service.MarkdownService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * Test class for the MarkdownResource REST controller.
 *
 * @see MarkdownResource
 */
@SpringBootTest(classes = OctoberApp.class)
@ExtendWith(RedisTestContainerExtension.class)
public class MarkdownResourceIT {

    private MockMvc restMockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

    }

    /**
     * Test createMarkdownFile
     */
    @Test
    public void testCreateMarkdownFile() throws Exception {
        restMockMvc.perform(post("/api/markdown/create-markdown-file"))
            .andExpect(status().isOk());
    }

    /**
     * Test readMarkdownFile
     */
    @Test
    public void testReadMarkdownFile() throws Exception {
        restMockMvc.perform(get("/api/markdown/read-markdown-file"))
            .andExpect(status().isOk());
    }

    /**
     * Test updateMarkdownFile
     */
    @Test
    public void testUpdateMarkdownFile() throws Exception {
        restMockMvc.perform(put("/api/markdown/update-markdown-file"))
            .andExpect(status().isOk());
    }

    /**
     * Test removeMarkdownFile
     */
    @Test
    public void testRemoveMarkdownFile() throws Exception {
        restMockMvc.perform(delete("/api/markdown/remove-markdown-file"))
            .andExpect(status().isOk());
    }
}
