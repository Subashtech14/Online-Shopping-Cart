package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    public void SiginupTestCode(){

        new Validator("Subash","Subash27@","Buyer","hi","1234567890","Subashtech14@gmail.com").validate();
    }

}