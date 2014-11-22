/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.philb.ordering.service;

import ie.philb.ordering.model.Address;
import java.util.List;

/**
 *
 * @author philb
 */
public interface IAddressService {

    public List<Address> list() throws ServiceException;

    public Address get(Long id) throws ServiceException;

    public int delete(Long id) throws ServiceException;

    public long create(Address country) throws ServiceException;

    public int update(Address country) throws ServiceException;
}
