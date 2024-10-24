package com.neha.ProductService.representingInheritance.TablePerClass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TA extends User {
    private int noOfSessions;
    private double avgRating;
}
