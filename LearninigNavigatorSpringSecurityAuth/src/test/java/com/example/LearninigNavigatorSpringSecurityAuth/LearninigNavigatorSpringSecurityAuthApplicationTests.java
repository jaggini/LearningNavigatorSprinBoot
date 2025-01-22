package com.example.LearninigNavigatorSpringSecurityAuth;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.LearninigNavigatorSpringSecurityAuth.controller.EsterController;
import com.example.LearninigNavigatorSpringSecurityAuth.serviece.ExamService;

@WebMvcTest(EsterController.class)
class LearninigNavigatorSpringSecurityAuthApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ExamService examService;

    @Test
    public void testHiddenFeature() throws Exception {
        Mockito.when(examService.getNumberFact(5)).thenReturn("5 is the number");
        mockMvc.perform(get("/exams/hidden-feature/5")).andExpect(status().isOk())
                .andExpect(content().string(
                        "5 is the number"));

    }


    // @Test
    // public void testExam() throws Exception {
    //     Mackito.doNothing().when(examService).register(1L, 1L);
    //     mockMvc.perform(post("/exams/1").param("studentId", "1")).andExpect(status().isOk())
    //             .andExpect(content().string("Student registered for exam Successfully"));

    // }

    @Test
    void contextLoads() {
    }

}
