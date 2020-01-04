package uk.co.waleed.Permutation.Model;

public class PermutationDTO {

    private final long id;
    private final String result;

    public PermutationDTO(long id, String result) {
        this.id = id;
        this.result = result;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return result;
    }
}
