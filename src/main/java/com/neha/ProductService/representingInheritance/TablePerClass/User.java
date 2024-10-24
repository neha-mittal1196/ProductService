package com.neha.ProductService.representingInheritance.TablePerClass;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class User {
    private String name;
    private String email;
    private String password;
}
