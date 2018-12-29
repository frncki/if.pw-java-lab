import java.util.ArrayList;
import java.util.List;

public class OrtographyException extends Exception {

    private List<String> mistakes;

    public OrtographyException(List<String> mistake) {
        this.mistakes = new ArrayList<String>(mistake);
    }

    public List<String> getMistake() {
        return mistakes;
    }
}

