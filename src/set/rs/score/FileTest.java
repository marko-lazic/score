package set.rs.score;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import set.rs.score.file.OriginalFile;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by set.rs on 14-Jun-17.
 */
public class FileTest {

    @BeforeAll
    static void initAll() {
    }

    @BeforeEach
    void init() {
    }

    @Test
    void OriginalFileTest() {

        OriginalFile file = new OriginalFile(1,1,"s", "m3", new BigInteger("11"), "dir", true);
        System.out.println(file.isStatusReady());
    }
}
