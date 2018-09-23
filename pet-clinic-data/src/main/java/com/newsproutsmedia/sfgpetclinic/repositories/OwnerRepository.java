package com.newsproutsmedia.sfgpetclinic.repositories;

import com.newsproutsmedia.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);

}
