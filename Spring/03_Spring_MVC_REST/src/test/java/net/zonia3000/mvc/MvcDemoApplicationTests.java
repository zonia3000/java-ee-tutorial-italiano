package net.zonia3000.mvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MvcDemoApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGET() throws Exception {
        mockMvc.perform(get("/base/saluta/pippo"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("pippo"))
                .andExpect(jsonPath("$.createdAt").isNotEmpty());
    }

    @Test
    public void testPOST() throws Exception {

        Utente utente = new Utente();
        utente.setNome("altro utente");

        ObjectMapper mapper = new ObjectMapper();
        String jsonBody = mapper.writeValueAsString(utente);

        mockMvc.perform(post("/base")
                .content(jsonBody)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nome").value("altro utente"))
                .andExpect(jsonPath("$.createdAt").isNotEmpty());
    }

    @Test
    public void testPOSTUsernameNull() throws Exception {

        Utente utente = new Utente();

        ObjectMapper mapper = new ObjectMapper();
        String jsonBody = mapper.writeValueAsString(utente);

        mockMvc.perform(post("/base")
                .content(jsonBody)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void testXML() throws Exception {

        mockMvc.perform(get("/base/xml"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
