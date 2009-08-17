package com.wee.mvc;

/**
 * User: weejulius
 * Date: 2009-7-30
 * Time: 11:58:54
 */
public class InvalidRequestURI extends RuntimeException {
    public InvalidRequestURI(String message) {    
           super(message);
    }
}
