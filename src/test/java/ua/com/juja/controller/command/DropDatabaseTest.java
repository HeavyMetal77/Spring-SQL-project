package ua.com.juja.controller.command;

import org.junit.Before;
import org.junit.Test;
import ua.com.juja.model.JDBCDBManager;
import ua.com.juja.view.View;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class DropDatabaseTest {
    private JDBCDBManager manager;
    private View view;
    private Command command;

    @Before
    public void setup() {
        manager = mock(JDBCDBManager.class);
        view = mock(View.class);
        command = new DropDatabase(manager, view);
    }

    @Test
    public void testCanProcess() {
        //when
        boolean canProcess = command.canProcess("dropDB|databaseName");
        //then
        assertTrue(canProcess);
    }

    @Test
    public void testProcessWithWrongCommand() {
        //when
        boolean canNotProcess = command.canProcess("dropBB|databaseName");
        //then
        assertFalse(canNotProcess);
    }

    @Test
    public void testCanProcessWithoutParameter() {
        //when
        boolean canProcess = command.canProcess("dropDB|");
        //then
        assertTrue(canProcess);
    }


    @Test
    public void testProcess() {
        //when
        command.process("dropDB|databaseName");
        //then
        verify(manager).dropDatabase("databaseName");
        verify(view).write("База данных 'databaseName' успешно удалена.");
    }

    @Test
    public void testProcessWrongFormat() {
        //when
        command.process("dropDB|databaseName|wrong");
        //then
        verify(view).write("Количество параметров не соответствует шаблону!");
    }
}
