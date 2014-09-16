package net.dehora.dropwizard.statsd;

import io.dropwizard.jackson.DiscoverableSubtypeResolver;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class StatsdReporterFactoryTest {

    @Test
    public void isDiscoverable() throws Exception {
        boolean found = false;
        final DiscoverableSubtypeResolver discoverableSubtypeResolver = new DiscoverableSubtypeResolver();
        for (Class<?> subtype : discoverableSubtypeResolver.getDiscoveredSubtypes()) {
            if (subtype.equals(StatsdReporterFactory.class)) {
                found = true;
            }
        }
        assertTrue("the statsd reporter class was not found, check META-INF/services", found);
    }

}