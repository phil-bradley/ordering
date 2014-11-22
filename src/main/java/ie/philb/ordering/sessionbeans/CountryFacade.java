/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.philb.ordering.sessionbeans;

import ie.philb.ordering.dao.CountryDao;
import ie.philb.ordering.dao.DaoException;
import ie.philb.ordering.dao.NoSuchEntityDaoException;
import ie.philb.ordering.model.Country;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityNotFoundException;
import javax.sql.DataSource;

/**
 *
 * @author philb
 */
@Stateless
@WebService
public class CountryFacade {

    @Resource(name = "jdbc/ordering")
    private DataSource ds;

    private final CountryDao countryDao = new CountryDao(ds);

    public void create(Country entity) throws DaoException {
        countryDao.create(entity);
    }

    public void update(Country entity) throws DaoException, NoSuchEntityDaoException {
        countryDao.update(entity);
    }

    public void delete(Country entity) throws DaoException, NoSuchEntityDaoException {
        countryDao.delete(entity.getId());
    }

    public Country get(Long id) throws DaoException, NoSuchEntityDaoException {
        return countryDao.get(id);
    }

    public List<Country> list() throws DaoException {
        return countryDao.list();
    }

    public long count() throws DaoException {
        return countryDao.count();
    }

}
