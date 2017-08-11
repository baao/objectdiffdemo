import org.junit.Assert;
import org.junit.Test;

/**
 * Created by michael on 11.08.17.
 */
public class ApplicationTest {
    @Test
    public void thisDoesntWork() throws Exception {
        Assert.assertFalse(Application.thisDoesntWork());
    }

    @Test
    public void thisWorks() throws Exception {
        Assert.assertFalse(Application.thisWorks());
    }

    @Test
    public void thisDoesntWorkEither() throws Exception {
        Assert.assertFalse(Application.thisDoesntWorkEither());
    }

}