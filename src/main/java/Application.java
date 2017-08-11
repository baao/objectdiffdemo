import de.danielbechler.diff.ObjectDifferBuilder;
import de.danielbechler.diff.node.DiffNode;
import com.ECS.client.jax.Item;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by michael on 11.08.17.
 */
public class Application {
    public static void main(String[] args) throws JAXBException {
        JAXBContext context1 = JAXBContext.newInstance(Item.class);
        Unmarshaller m1 = context1.createUnmarshaller();

        Item base = (Item) m1.unmarshal(new File("itemxml.xml"));
        Item working = (Item) m1.unmarshal(new File("itemxml.xml"));

        base.getItemAttributes().getFeature().forEach(System.out::println);
        DiffNode diff5 = ObjectDifferBuilder
                .buildDefault()
                .compare(working, base);

        System.out.println("has changes: " + diff5.hasChanges());
    }
}
