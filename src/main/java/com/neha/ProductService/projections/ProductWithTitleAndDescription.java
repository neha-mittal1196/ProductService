package com.neha.ProductService.projections;

public interface ProductWithTitleAndDescription {
    //In the query we need to give aliases else null will come
    //Projections are needed to add getter method for each field
    String getTitle();
    String getDescription();
}
