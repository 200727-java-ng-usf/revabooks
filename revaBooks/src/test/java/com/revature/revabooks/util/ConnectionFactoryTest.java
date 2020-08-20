package com.revature.revabooks.util;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

public class ConnectionFactoryTest {

    private ConnectionFactory sut;

    @Before
    public void setup() {
        sut = ConnectionFactory.getConnFactory();
    }

    @After
    public void tearDown() {
        sut = null;
    }

    @Test
    public void ensureConnectionFactoryIsValid() {
        ConnectionFactory c1 = ConnectionFactory.getConnFactory();
        ConnectionFactory c2 = ConnectionFactory.getConnFactory();

        assertSame(c1, c2);

    }

    @Test
    public void ensureThatAConnectionIsObtained() {
        Connection conn = ConnectionFactory.getConnFactory().getConnection();
        assertNotNull(conn);
    }

}
