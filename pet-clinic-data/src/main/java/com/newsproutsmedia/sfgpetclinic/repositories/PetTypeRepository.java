package com.newsproutsmedia.sfgpetclinic.repositories;

import com.newsproutsmedia.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
