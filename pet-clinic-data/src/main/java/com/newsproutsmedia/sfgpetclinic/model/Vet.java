package com.newsproutsmedia.sfgpetclinic.model;

import java.util.HashSet;
import java.util.Set;

public class Vet extends Person {

    // make sure to initialize sets with "new" and type of set, otherwise you'll end up with problems
    private Set<Specialty> specialties = new HashSet<>();

    public Set<Specialty> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(Set<Specialty> specialties) {
        this.specialties = specialties;
    }
}
