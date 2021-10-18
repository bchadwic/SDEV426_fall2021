package edu.greenriver.sdev.programminglanguages.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity //this marks the class as a Hibernate Entity (a table will be created to store Language objects)
public class Framework implements Comparable<Framework>
{
    //surrogate key
    @Id //this is a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //this is auto-increment
    private int frameworkId;

    private String name;
    private String language;
    private int ranking;

    @Override
    public int compareTo(Framework other)
    {
        return this.ranking - other.ranking;
    }
}
