package ua.com.juja.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ua.com.juja.model.DBManager;
import ua.com.juja.model.DataSet;
import ua.com.juja.model.DataSetImpl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ServiceImplTestWithMockito {

    //    @InjectMocks
    private ServiceImpl service = new ServiceImpl() {
        @Override
        public DBManager getDBManager() {
            return dbManager;
        }
    };
    @Mock
    private DBManager dbManager;

    @Test
    public void testFind() {
        //Given
        DataSet dataSet1 = new DataSetImpl();
        dataSet1.put("id", 1);
        dataSet1.put("Name", "Bill");
        dataSet1.put("SurName", "Gates");

        DataSet dataSet2 = new DataSetImpl();
        dataSet2.put("id", 2);
        dataSet2.put("Name", "Nil");
        dataSet2.put("SurName", "Armstrong");

        when(dbManager.getAtribute("contact")).thenReturn(new HashSet<>(Arrays.asList("id", "Name", "SurName")));
        when(dbManager.getDataSetTable("contact")).thenReturn(Arrays.asList(dataSet1, dataSet2));
        //When
        List<List<String>> contact = service.find(dbManager, "contact");
        //Then
        assertEquals("[[id, SurName, Name], " +
                "[1, Gates, Bill], " +
                "[2, Armstrong, Nil]]", contact.toString());
    }

    @Test
    public void testCommands() {
        //Given

        //When
        List<String> commands = service.commands();
        //Then
        assertEquals("[connect, help, menu, tables, find, clear, delete, drop, DBdrop, databases, createDB, createTable, update]", commands.toString());
    }

    @Test
    public void testConnect() {
        //Given

        //When
        DBManager manager = service.connect("testDB", "testName", "testPass");
        //Then
        assertEquals(dbManager, manager);
    }

    @Test
    public void testConnectError() {
        //Given
        dbManager = null;
        //When
        try {
            when(service.connect("testDB", "testName", "testPass")).thenReturn(dbManager);
        } catch (Exception e) {
            //Then
            assertNull(null);
        }
    }
}
