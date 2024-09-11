package se.lexicon.models;

import se.lexicon.sequencer.StudentIdSequencer;

public class Student {
    private int id;
    private String name;

    public Student(String name) {
        StudentIdSequencer sequencerObject = StudentIdSequencer.getInstance();
        setId(sequencerObject.nextId());
        setName(name);
    }

    public Student(int id, String name) {
        setId(id);
        setName(name);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
