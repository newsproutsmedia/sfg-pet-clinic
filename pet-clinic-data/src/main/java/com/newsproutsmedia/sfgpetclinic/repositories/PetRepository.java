package com.newsproutsmedia.sfgpetclinic.repositories;

import com.newsproutsmedia.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
