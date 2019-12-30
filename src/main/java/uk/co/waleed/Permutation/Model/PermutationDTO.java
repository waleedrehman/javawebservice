package uk.co.waleed.Permutation.Model;

public class PermutationDTO {

    private final long id;
    private final String permuteInt;

    public PermutationDTO(long id, String permuteInt) {
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
