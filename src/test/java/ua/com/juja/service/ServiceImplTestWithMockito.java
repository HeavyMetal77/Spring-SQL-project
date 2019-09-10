package ua.com.juja.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ua.com.juja.model.DBManager;
import ua.com.juja.model.DataSet;
import ua.com.juja.model.DataSetImpl;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ServiceImplTestWithMockito {

    //    @InjectMocks
    private Service service = new ServiceImpl() {
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
        dataSet1.put("Name", "William");
        dataSet1.put("SurName", "Smith");

        DataSet dataSet2 = new DataSetImpl();
        dataSet2.put("id", 2);
        dataSet2.put("Name", "Michael");
        dataSet2.put("SurName", "Johnson");

        when(dbManager.getAtribute("contact")).thenReturn(new LinkedHashSet<>(Arrays.asList("id", "Name", "SurName")));
        when(dbManager.getDataSetTable("contact")).thenReturn(Arrays.asList(dataSet1, dataSet2));
        //When
        List<List<String>> contact = service.find(dbManager, "contact");
        //Then
        assertEquals("[[id, Name, SurName], " +
                "[1, William, Smith], " +
                "[2, Michael, Johnson]]", contact.toString());
    }

    @Test
    public void testCommands() {
        //Given

        //When
        List<String> commands = service.commands();
        //Then
        assertEquals("[help, tables, clear, delete, drop, DBdrop, databases, createDB, createTable, update]", commands.toString());
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
