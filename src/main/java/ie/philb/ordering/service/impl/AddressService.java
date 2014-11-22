/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.philb.ordering.service.impl;

import ie.philb.ordering.dao.AddressDao;
import ie.philb.ordering.dao.DaoException;
import ie.philb.ordering.dao.NoSuchEntityDaoException;
import ie.philb.ordering.model.Address;
import ie.philb.ordering.service.IAddressService;
import ie.philb.ordering.service.ServiceException;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.sql.DataSource;

@Stateless
@WebService
public class AddressService implements IAddressService {

    @Resource(name = "jdbc/ordering")
    private DataSource ds;

    private final AddressDao addressDao = new AddressDao(ds);

    @Override
    public List<Address> list() throws ServiceException {
        try {
            return addressDao.list();
        } catch (DaoException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public Address get(Long id) throws ServiceException {
        try {
            return addressDao.get(id);
        } catch (DaoException | NoSuchEntityDaoException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public int delete(Long id) throws ServiceException {
        try {
            return addressDao.delete(id);
        } catch (DaoException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public long create(Address country) throws ServiceException {
        try {
            return addressDao.create(country);
        } catch (DaoException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public int update(Address country) throws ServiceException {
        try {
            return addressDao.update(country);
        } catch (DaoException | NoSuchEntityDaoException ex) {
            throw new ServiceException(ex);
        }
    }

}
