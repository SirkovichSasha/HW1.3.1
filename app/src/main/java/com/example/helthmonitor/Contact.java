package com.example.helthmonitor;

import java.util.Objects;

public class Contact implements Comparable<Contact> {
    private String name;
    private String surname;
    private String fathername;
    private String fullName;
    private int age;

    public Contact() {
    }

    public Contact(String name, String surname, String fathername, int age) {
        this.name = name;
        this.surname = surname;
        this.fathername = fathername;
        this.age = age;
        fullName = name + surname + fathername + age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return name.equals(contact.name) &&
                surname.equals(contact.surname) && fathername.equals(contact.fathername);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, fathername);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", fathername='" + fathername + '\'' +
                ", age=" + age +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getFathername() {
        return fathername;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Contact o) {
        return fullName.compareTo(o.fullName);
    }
}
