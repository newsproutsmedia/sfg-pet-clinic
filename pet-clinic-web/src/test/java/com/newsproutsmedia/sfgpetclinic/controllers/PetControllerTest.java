package com.newsproutsmedia.sfgpetclinic.controllers;

import com.newsproutsmedia.sfgpetclinic.model.Owner;
import com.newsproutsmedia.sfgpetclinic.model.Pet;
import com.newsproutsmedia.sfgpetclinic.model.PetType;
import com.newsproutsmedia.sfgpetclinic.services.OwnerService;
import com.newsproutsmedia.sfgpetclinic.services.PetService;
import com.newsproutsmedia.sfgpetclinic.services.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class PetControllerTest {

    @Mock
    PetService petService;

    @Mock
    OwnerService ownerService;

    @Mock
    PetTypeService petTypeService;

    @InjectMocks
    PetController petController;

    MockMvc mockMvc;

    Owner owner;
    Set<PetType> petTypes;

    @BeforeEach
    void setUp() {
        owner = Owner.builder().id(1L).build();

        petTypes = new HashSet<>();
        petTypes.add(PetType.builder().id(1L).name("Dog").build());
        petTypes.add(PetType.builder().id(2L).name("Cat").build());

        mockMvc = MockMvcBuilders
                .standaloneSetup(petController)
                .build();

    }

    @Test
    void initCreationForm() throws Exception {
        // when the "findById" method is called with any Long value, return the owner object (with mock data)
        when(ownerService.findById(anyLong())).thenReturn(owner);

        // when the "findAll" method is called, return petTypes with mock data
        when(petTypeService.findAll()).thenReturn(petTypes);

        // sed data via GET to /owners/1/pets/new
        mockMvc.perform(get("/owners/1/pets/new"))
                // expect that the page is reachable
                .andExpect(status().isOk())
                // expect that the model attribute of "owner" is available
                .andExpect(model().attributeExists("owner"))
                // expect that the model attribute of "pet" is available
                .andExpect(model().attributeExists("pet"))
                // expect that the page "pets/createOrUpdatePetForm" will be returned
                .andExpect(view().name("pets/createOrUpdatePetForm"));
    }

    @Test
    void processCreationForm() throws Exception {
        // when the "findById" method is called with any Long value, return the owner object (with mock data)
        when(ownerService.findById(anyLong())).thenReturn(owner);

        // when the "findAll" method is called, return petTypes with mock data
        when(petTypeService.findAll()).thenReturn(petTypes);

        // send data via POST to /owners/1/pets/new
        mockMvc.perform(post("/owners/1/pets/new"))
                // expect that the status to redirect
                .andExpect(status().is3xxRedirection())
                // expect that the view name of redirect:/owners/1 will be returned
                .andExpect(view().name("redirect:/owners/1"));

        // check that a pet object was saved
        verify(petService).save(any());

    }

    @Test
    void initUpdateForm() throws Exception {
        when(ownerService.findById(anyLong())).thenReturn(owner);
        when(petTypeService.findAll()).thenReturn(petTypes);
        when(petService.findById(anyLong())).thenReturn(Pet.builder().id(2L).build());

        mockMvc.perform(get("/owners/1/pets/2/edit"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("owner"))
                .andExpect(model().attributeExists("pet"))
                .andExpect(view().name("pets/createOrUpdatePetForm"));
    }

    @Test
    void processUpdateForm() throws Exception {
        when(ownerService.findById(anyLong())).thenReturn(owner);
        when(petTypeService.findAll()).thenReturn(petTypes);

        mockMvc.perform(post("/owners/1/pets/2/edit"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1"));

        verify(petService).save(any());
    }

    @Test
    void populatePetTypes() {
        //todo impl
    }

    @Test
    void findOwner() {
        //todo impl
    }

    @Test
    void initOwnerBinder() {
        //todo impl
    }

}
