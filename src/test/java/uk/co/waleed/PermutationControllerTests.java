/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package uk.co.waleed;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PermutationControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void noParamPermutationShouldReturnDefaultMessage() throws Exception {

        this.mockMvc.perform(get("/permutation")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("The permuted value is, 632,623,362,326,263,236!"));
    }

    @Test
    public void paramPermutationShouldReturnTailoredMessage() throws Exception {

        this.mockMvc.perform(get("/permutation").param("permuteInt", "369"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("The permuted value is, 963,936,693,639,396,369!"));
    }

}
