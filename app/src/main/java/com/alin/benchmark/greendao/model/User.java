package com.alin.benchmark.greendao.model;

import org.greenrobot.greendao.annotation.*;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit.

/**
 * Entity mapped to table "USER".
 */
@Entity
public class User {

    @Id
    private Long id;

    @NotNull
    private String name;
    private Integer age;
    private Long timestamp;

    @Generated(hash = 586692638)
    public User() {
    }

    public User(Long id) {
        this.id = id;
    }

    @Generated(hash = 1156116846)
    public User(Long id, @NotNull String name, Integer age, Long timestamp) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    public String getName() {
        return name;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setName(@NotNull String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

}
