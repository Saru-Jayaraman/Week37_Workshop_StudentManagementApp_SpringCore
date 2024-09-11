package se.lexicon.sequencer;

public class StudentIdSequencer {
    private int currentId;

    //Singleton Object
    private static StudentIdSequencer instance;

    //Private constructor - to make the class not to get instantiated from outside
    private StudentIdSequencer() {
        currentId = 0;
    }

    //When there is no object, create an object; Else return the instance of existing one.
    public static StudentIdSequencer getInstance() {
        if (instance == null)
            instance = new StudentIdSequencer();
        return instance;
    }

    public void setCurrentId(int currentId) {
        this.currentId = currentId;
    }

    public int nextId() {
        currentId++;
        setCurrentId(currentId);
        return currentId;
    }
}
