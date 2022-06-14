package Interfaces;

public enum Type {
    SMALL(1), MEDIUM(2), LARGE(3), SUPERLARGE(4);

    private int i;

    Type(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }

    public boolean check(Type t1, Type t2){
        if (t1.i >= t2.i) return true;
        return false;
    }
}
