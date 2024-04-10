package com.amaap.trooptrainingsimulator.controller.dto;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

class ResponseTest {

    @Test
    void shouldReturnTrueWhenObjectsAreEqual() {
        // arrange
        Response response = new Response(HttpStatus.OK, "XYZ");
        Response response1 = new Response(HttpStatus.OK, "XYZ");

        // act & assert
        assertTrue(response1.equals(response));
        assertEquals(response1.hashCode(), response.hashCode());

    }

    @Test
    public void shouldReturnFalseWhenDifferentHttpsStatusPassed() {
        // arrange
        Response response = new Response(HttpStatus.OK, "XYZ");
        Response response1 = new Response(HttpStatus.BADREQUEST, "XYZ");

        // act & assert
        assertFalse(response1.equals(response));
        assertNotEquals(response1.hashCode(), response.hashCode());
    }
    @Test
    public void shouldReturnFalseWhenDifferentHttpsStatusPass() {
        // arrange
        Response response = new Response(HttpStatus.OK, "XYZ");
        Response response1 = new Response(HttpStatus.BADREQUEST, "XYZ");

        // act & assert
        assertFalse(response1.equals(response));
        assertNotEquals(response1.hashCode(), response.hashCode());
    }

}