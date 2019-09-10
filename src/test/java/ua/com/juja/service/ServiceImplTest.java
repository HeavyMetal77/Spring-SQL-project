package ua.com.juja.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-application-context.xml"})
public class ServiceImplTest {

    @Autowired
    private Service service;

    @Test
    public void testServiceCommands() {
        //When
        List<String> commands = service.commands();
        //Then
        assertEquals("[help, tables, clear, delete, drop, DBdrop, databases, createDB, createTable, update]", commands.toString());
    }

    @Test
    public void testConnect() throws Exception {
        service.connect("sqlcmd", "sqlcmd", "sqlcmd");
    }
}
