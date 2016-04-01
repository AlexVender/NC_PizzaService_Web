package unc.group16.controller.managers.oracle;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import unc.group16.controller.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


public class OracleDrinksManagerTest {
    private OracleDrinksManager manager;
    private Connection mockedConnection;

    @Before
    public void setUp() throws Exception {
        manager = new OracleDrinksManager();
        JDBC spyJdbc = spy(new JDBC());
        manager.setJDBC(spyJdbc);

        mockedConnection = mock(Connection.class);
        doReturn(mockedConnection).when(spyJdbc).getConnection();
    }

    @After
    public void tearDown() throws Exception {
        mockedConnection.close();
    }

   /* @Test
    public void testCreate() throws Exception {
        doAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            Connection connection = new JDBC().getConnection();
            PreparedStatement spyPS = spy(connection.prepareStatement((String) args[0], (int[])args[1]));
            connection.close();

            assertEquals("INSERT INTO DRINKS VALUES (null, ?, ?, ?, ?)", args[0]);

            doReturn(0).when(spyPS).executeUpdate();
            return spyPS;
        }).when(mockedConnection).prepareStatement(anyString(), any(int[].class));

        final Drink drink = new Drink(null, 2, BigDecimal.TEN, "Drink", "");
        manager.create(drink);
    }*/

    @Test
    public void testRead() throws Exception {
        final Long ID = 42L;
        doAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            Connection connection = new JDBC().getConnection();
            PreparedStatement spyPS = spy(connection.prepareStatement((String) args[0]));
            connection.close();

            assertEquals("SELECT * FROM DRINKS WHERE DRNK_ID=" + ID, args[0]);

            return spyPS;
        }).when(mockedConnection).prepareStatement(anyString());

        manager.read(ID);
    }

  /*  @Test
    public void testUpdate() throws Exception {
        final long ID = 42L;
        doAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            Connection connection = new JDBC().getConnection();
            PreparedStatement spyPS = spy(connection.prepareStatement((String) args[0]));
            connection.close();

            assertEquals("UPDATE DRINKS SET VOLUME=?, PRICE=?, TITLE=?, DESCRIPTION=? WHERE DRNK_ID=" + ID, args[0]);

            doReturn(1).when(spyPS).executeUpdate();
            return spyPS;
        }).when(mockedConnection).prepareStatement(anyString());


        final Drink drink = new Drink(ID, 2, BigDecimal.TEN, "Drink", "");
        manager.update(drink);
    }*/
/*
    @Test
    public void testDelete() throws Exception {
        final long ID = 42L;
        doAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            Connection connection = new JDBC().getConnection();
            PreparedStatement spyPS = spy(connection.prepareStatement((String) args[0]));
            connection.close();

            assertEquals("DELETE FROM DRINKS WHERE DRNK_ID=" + ID, args[0]);

            doReturn(1).when(spyPS).executeUpdate();
            return spyPS;
        }).when(mockedConnection).prepareStatement(anyString());

        final Drink drink = new Drink(ID, 2, BigDecimal.TEN, "Drink", "");
        manager.delete(ID);
    }*/
}