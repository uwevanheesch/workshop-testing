package net.vanheesch.persistence;

import net.vanheesch.domain.Item;
import org.h2.tools.RunScript;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import java.io.File;
import java.io.FileReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doThrow;

public class ItemDAOMySQLTest {

    private ItemDAOMySQL sut; // system under test

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        IDBConnectionFactory idbConnectionFactory = new DBConnectionFactoryMock();
        sut = new ItemDAOMySQL();
        sut.dbConnectionFactory = idbConnectionFactory;

        File sqlScriptFile = new File(getClass().getResource("/testDB_Create.sql").getFile());
        RunScript.execute(idbConnectionFactory.getConnection(),new FileReader(sqlScriptFile));
    }

    @Test
    public void testItemSize() throws Exception {
        List<Item> items = sut.getItems();
        assertEquals(2, items.size());
    }

    @Test
    public void testItemListFilledWithCorrectObjects() throws Exception {
        Item expectedItem = new Item("Item1","Item1Description");
        assertEquals("Item1",sut.getItems().get(0).getName());
        assertEquals("Item2",sut.getItems().get(1).getName());
    }

    @Test
    public void testItemConstructedCorrectly() throws Exception {
        Item actualItem = sut.findItemByName("Item1");
        assertEquals("Item1",actualItem.getName());
        assertEquals("Item1Description",actualItem.getDescription());
    }

    @Test
    public void testRuntimeExceptionOnSQLError() throws Exception {
        TestBackdoor testBackdoorMock = Mockito.mock(TestBackdoor.class);
        sut.testBackdoor = testBackdoorMock;
        doThrow(new SQLException()).when(testBackdoorMock).mayThrowSQLException();

        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("Values could not be retrieved due to database problem.");

        sut.getItems();
    }

    @Test
    public void testRuntimeExceptionInFindItemByName() throws Exception {
        IDBConnectionFactory connectionFactoryMock = Mockito.mock(IDBConnectionFactory.class);
        sut.dbConnectionFactory = connectionFactoryMock;
        doThrow(new SQLException()).when(connectionFactoryMock).getConnection();
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("Values could not be retrieved due to database problem.");
        sut.findItemByName("Uwe");
    }

    @Test
    public void testReturnNullInFindByName() throws Exception {
        IDBConnectionFactory idbConnectionFactory = new DBConnectionFactoryMock();
        File sqlScriptFile = new File(getClass().getResource("/testDB_CreateEmptyTables.sql").getFile());
        RunScript.execute(idbConnectionFactory.getConnection(),new FileReader(sqlScriptFile));
        assertNull(sut.findItemByName("Uwe"));
    }
}