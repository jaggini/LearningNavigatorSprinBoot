package com.example.LearninigNavigatorSpringSecurityAuth;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.LearninigNavigatorSpringSecurityAuth.controller.StudentController;
import com.example.LearninigNavigatorSpringSecurityAuth.serviece.ExamService;

@WebMvcTest(StudentController.class)
class LearninigNavigatorSpringSecurityAuthApplicationTests {

    @Autowired
    private MockMvc mockMvc;

   @MockitoBean
    private ExamService examService;

    @Test
    public void testHiddenFeatur() throws Exception {
        Mockito.when(examService.getNumberFact(5)).thenReturn("5 is the number");
        mockMvc.perform(get("/exams/hidden-feature/5")).andExpect(status().isOk())
                .andExpect(content().string(
                        "5 is the number"));

    }

    @Test
    void contextLoads() {
    }

}
