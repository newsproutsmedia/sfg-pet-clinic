package com.newsproutsmedia.sfgpetclinic.controllers;

import com.newsproutsmedia.sfgpetclinic.model.Pet;
import com.newsproutsmedia.sfgpetclinic.model.Visit;
import com.newsproutsmedia.sfgpetclinic.services.PetService;
import com.newsproutsmedia.sfgpetclinic.services.VisitService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
public class VisitControllerTest {

    @Mock
    PetService petService;

    @Mock
    VisitService visitService;

    @InjectMocks
    VisitController visitController;

    MockMvc mockMvc;

    Pet pet;
    Visit visit;

    @BeforeEach
    void setUp() {

        pet = Pet.builder().id(1L).build();
        visit = Visit.builder().id(Pet.builder().id(1L).build().getId()).build();


        mockMvc = MockMvcBuilders
                .standaloneSetup(visitController)
                .build();

    }

    @Test
    void initNewVisitForm() throws Exception {

        // to do
    }

    @Test
    void processNewVisitForm() throws Exception {
        // to do
    }

}
