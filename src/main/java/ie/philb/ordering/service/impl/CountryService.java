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
import static java.rmi.server.LogStream.log;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

@Stateless
@WebService
public class CountryService implements ICountryService {

    private static final Logger logger = Logger.getLogger(CountryService.class.getSimpleName());
    private final CountryDao countryDao;

    public CountryService() throws NamingException {
        logger.info("Getting initial context");
        InitialContext cxt = new InitialContext();

        logger.info("Getting datasource");
        DataSource ds = (DataSource) cxt.lookup("jdbc/ordering");

        logger.info("Creating dao");
        countryDao = new CountryDao(ds);
    }

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
