/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.philb.ordering.dao;

/**
 *
 * @author philb
 */
public class DaoException extends Exception {
    
    public DaoException(String message, Throwable t) {
        super(message, t);
    }
}
