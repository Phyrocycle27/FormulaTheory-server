package com.example.demo.repositories;

import java.util.List;

import com.example.demo.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class PersonRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int createPerson(String name){
        return jdbcTemplate.update("INSERT INTO \"PERSONS\" (\"NAME\") VALUES(?)", name);
    }

    public int updatePerson(Person person){
        return jdbcTemplate.update("UPDATE \"PERSONS\" SET \"NAME\" = ? WHERE \"ID\" = ?", person.getName(), person.getId());
    }

    public int deletePerson(Integer id){
        return jdbcTemplate.update("DELETE FROM \"PERSONS\" WHERE \"ID\" = ?",id);
    }

    public Person getPerson(Integer id){
        return jdbcTemplate.queryForObject("SELECT * FROM \"PERSONS\" WHERE \"ID\"=?", new PersonMapper(), id);
    }

    public List<Person> getPersons(){
        return jdbcTemplate.query("SELECT * FROM \"PERSONS\"", new PersonMapper());
    }
}
