package com.example.springbootdemo.jdbcTemplateTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class jdbcTemplateTest {

    @Autowired
    @Qualifier("masterJdbcTemplate")
    private JdbcTemplate masterJdbcTemplate;

    @Autowired
    @Qualifier("slaveJdbcTemplate")
    private JdbcTemplate slaveJdbcTemplate;

    @Test
    public void testMaster(){
        masterJdbcTemplate.execute("insert into user2(name) values('大时代')");
    }

    @Test
    public void testSlave(){
        slaveJdbcTemplate.execute("insert into testglobal (name) values ('防守对方的')");
    }

}
