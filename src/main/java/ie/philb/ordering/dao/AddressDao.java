/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.philb.ordering.dao;

import ie.philb.ordering.jdbc.EntityMapper;
import ie.philb.ordering.jdbc.JdbcException;
import ie.philb.ordering.jdbc.JdbcParameterSet;
import ie.philb.ordering.jdbc.NoSuchEntityException;
import ie.philb.ordering.jdbc.RowMapper;
import ie.philb.ordering.model.Address;
import ie.philb.ordering.model.Country;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author philb
 */
public class AddressDao extends AbstractDao<Address> {

    private final AddressMapper addressMapper = new AddressMapper();

    public AddressDao(DataSource ds) {
        super(ds);
    }

    @Override
    public Address get(Long id) throws DaoException, NoSuchEntityDaoException {
        try {
            JdbcParameterSet params = new JdbcParameterSet();
            params.add("id", id);

            return getJdbcTemplate().querySingleResult("SELECT * FROM address WHERE id = :id", params, addressMapper);
        } catch (JdbcException jdx) {
            throw new DaoException(("Failed to get address " + id), jdx);
        } catch (NoSuchEntityException nx) {
            throw new NoSuchEntityDaoException("Failed to get address " + id);
        }
    }

    @Override
    public long count() throws DaoException {
        try {
            return getJdbcTemplate().querySingleResult("SELECT count(*) FROM address", (ResultSet rs) -> rs.getLong(1));
        } catch (JdbcException | NoSuchEntityException jdx) {
            throw new DaoException("Failed to get address count", jdx);
        }
    }

    @Override
    public long create(Address address) throws DaoException {

        String sql = "INSERT INTO address (STREET1, STREET2, STATE, ZIPCODE, COUNTRYID) ";
        sql += " VALUES (:STREET1, :STREET2, :STATE, :ZIPCODE, :COUNTRYID) ";

        try {
            return getJdbcTemplate().executeInsert(sql, addressMapper.getParameterSet(address));
        } catch (JdbcException jdx) {
            throw new DaoException("Failed to insert address", jdx);
        }
    }

    @Override
    public int update(Address address) throws DaoException, NoSuchEntityDaoException {

        String sql = "UPDATE address SET ";
        sql += "STREET1 = :STREET1, ";
        sql += "STREET2 = :STREET2, ";
        sql += "STATE = :STATE, ";
        sql += "ZIPCODE = :ZIPCODE, ";
        sql += "COUNTRYID = :COUNTRYID, ";
        sql += "WHERE ID = :ID ";

        try {
            return getJdbcTemplate().executeUpdate(sql, addressMapper.getParameterSet(address));
        } catch (JdbcException jdx) {
            throw new DaoException("Failed to update address", jdx);
        }
    }

    @Override
    public int delete(Long id) throws DaoException {
        String sql = "DELETE FROM address WHERE id = :ID";

        JdbcParameterSet params = new JdbcParameterSet();
        params.add("id", id);

        try {
            return getJdbcTemplate().executeUpdate(sql, params);
        } catch (JdbcException jdx) {
            throw new DaoException("Failed to delete address", jdx);
        }
    }

    @Override
    public List<Address> list() throws DaoException {
        try {
            return getJdbcTemplate().queryResultList("SELECT * FROM address", addressMapper);
        } catch (JdbcException jdx) {
            throw new DaoException("Failed to get addresses", jdx);
        }
    }

    class AddressMapper implements RowMapper<Address>, EntityMapper<Address> {

        @Override
        public Address mapRow(ResultSet rs) throws SQLException {
            Address address = new Address();
            address.setId(rs.getLong("ID"));
            address.setVersion(rs.getInt("VERSION"));
            address.setStreet1(rs.getString("STREET1"));
            address.setStreet1(rs.getString("STREET2"));
            address.setState(rs.getString("STATE"));
            address.setZipcode(rs.getString("ZIPCODE"));
            address.setCountryId(rs.getLong("COUNTRYID"));
            return address;
        }

        @Override
        public JdbcParameterSet getParameterSet(Address address) {
            JdbcParameterSet parameters = new JdbcParameterSet();
            parameters.add("ID", address.getId());
            parameters.add("VERSION", address.getVersion());
            parameters.add("STREET1", address.getStreet1());
            parameters.add("STREET2", address.getStreet2());
            parameters.add("STATE", address.getState());
            parameters.add("ZIPCODE", address.getZipcode());
            parameters.add("COUNTRYID", address.getCountryId());

            return parameters;
        }

    }

}
