package com.newsproutsmedia.sfgpetclinic.controllers;

import com.newsproutsmedia.sfgpetclinic.model.Owner;
import com.newsproutsmedia.sfgpetclinic.model.PetType;
import com.newsproutsmedia.sfgpetclinic.services.OwnerService;
import com.newsproutsmedia.sfgpetclinic.services.PetService;
import com.newsproutsmedia.sfgpetclinic.services.PetTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
@RequestMapping("/owners/{ownerId}")
public class PetController {


    private static final String VIEWS_PETS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm";

    private final PetService petService;
    private final OwnerService ownerService;
    private final PetTypeService petTypeService;

    public PetController(PetService petService, OwnerService ownerService, PetTypeService petTypeService) {
        this.petService = petService;
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
    }

    // @ModelAttribute can be used when certain objects or model attributes are going to be used many times across
    // a number of methods within a controller class
    // in this case, pet types and owner will be used many times

    // returns a list of pet types to a model attribute called "types" that will be used to populate a dropdown
    @ModelAttribute("types")
    public Collection<PetType> populatePetTypes() {
        return petTypeService.findAll();
    }

    // returns an owner object to be made available to the view
    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable Long ownerId) {
        return ownerService.findById(ownerId);
    }

    @InitBinder("owner")
    public void initOwnerBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

}
