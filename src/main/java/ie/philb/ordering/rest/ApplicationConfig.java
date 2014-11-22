/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.philb.ordering.rest;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author philb
 */
@javax.ws.rs.ApplicationPath("rest")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(ie.philb.ordering.rest.AddressEndpoint.class);
        resources.add(ie.philb.ordering.rest.CountryEndpoint.class);
    }
}
