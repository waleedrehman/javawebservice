package uk.co.waleed.Permutation;

public class Permutation {

    private final long id;
    private final String permuteInt;

    public Permutation(long id, String permuteInt) {
        this.id = id;
        this.permuteInt = permuteInt;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return permuteInt;
    }
}
