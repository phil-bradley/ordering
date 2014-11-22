/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.philb.ordering.service.impl;

import ie.philb.ordering.dao.CountryDao;
import ie.philb.ordering.dao.DaoException;
import ie.philb.ordering.dao.NoSuchEntityDaoException;
import ie.philb.ordering.model.Country;
import ie.philb.ordering.service.ICountryService;
import ie.philb.ordering.service.ServiceException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.sql.DataSource;

@Stateless
@WebService
public class CountryService implements ICountryService {

    @Resource(name = "jdbc/ordering")
    private DataSource ds;

    private final CountryDao countryDao = new CountryDao(ds);

    @Override
    public List<Country> list() throws ServiceException {
        try {
            return countryDao.list();
        } catch (DaoException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public Country get(Long id) throws ServiceException {
        try {
            return countryDao.get(id);
        } catch (DaoException | NoSuchEntityDaoException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public int delete(Long id) throws ServiceException {
        try {
            return countryDao.delete(id);
        } catch (DaoException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public long create(Country country) throws ServiceException {
        try {
            return countryDao.create(country);
        } catch (DaoException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public int update(Country country) throws ServiceException {
        try {
            return countryDao.update(country);
        } catch (DaoException | NoSuchEntityDaoException ex) {
            throw new ServiceException(ex);
        }
    }

}
