package com.newsproutsmedia.sfgpetclinic.services;

import com.newsproutsmedia.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {


    Owner findByLastName(String lastName);


}
