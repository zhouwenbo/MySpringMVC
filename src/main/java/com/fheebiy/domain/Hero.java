package com.fheebiy.domain;

/**
 * Created by zwb on 14-4-9.
 */
public class Hero {

    private long hero_id;

    private String name;

    private String age;

    private String from;

    private String skill;


    public long getHero_id() {
        return hero_id;
    }

    public void setHero_id(long hero_id) {
        this.hero_id = hero_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}
