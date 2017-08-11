import com.ECS.client.jax.Item;
import de.danielbechler.diff.ObjectDifferBuilder;
import de.danielbechler.diff.node.DiffNode;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by michael on 11.08.17.
 */
public class Application {
    public static boolean thisDoesntWork() throws JAXBException {
        JAXBContext context1 = JAXBContext.newInstance(Item.class);
        Unmarshaller m1 = context1.createUnmarshaller();

        Item base = (Item) m1.unmarshal(new File("itemxml.xml"));
        Item working = (Item) m1.unmarshal(new File("itemxml.xml"));
        DiffNode diff = ObjectDifferBuilder
                .buildDefault()
                .compare(working, base);

        System.out.println("thisDoesntWork | has changes: " + diff.hasChanges());
        return diff.hasChanges();
    }

    public static boolean thisWorks() throws JAXBException {
        JAXBContext context1 = JAXBContext.newInstance(Item.class);
        Unmarshaller m1 = context1.createUnmarshaller();

        Item base = (Item) m1.unmarshal(new File("itemxml.xml"));
        Item working = (Item) m1.unmarshal(new File("itemxml.xml"));
        DiffNode diff = ObjectDifferBuilder
                .buildDefault()
                .compare(working.getItemAttributes(), base.getItemAttributes());

        System.out.println("thisWorks | has changes: " + diff.hasChanges());
        return diff.hasChanges();
    }

    public static boolean thisDoesntWorkEither() throws JAXBException {
        JAXBContext context1 = JAXBContext.newInstance(Item.class);
        Unmarshaller m1 = context1.createUnmarshaller();

        Item base = (Item) m1.unmarshal(new File("itemxml.xml"));
        Item working = (Item) m1.unmarshal(new File("itemxml.xml"));
        DiffNode diff = ObjectDifferBuilder
                .buildDefault()
                .compare(working.getImageSets(), base.getImageSets());

        System.out.println("thisDoesntWorkEither | has changes: " + diff.hasChanges());
        return diff.hasChanges();
    }
}
