package labwork3.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class JPAUtils {

    private static final EntityManagerFactory entityManagerFactory = createEntityManagerFactory();

    private static EntityManagerFactory createEntityManagerFactory() {
        ResourceBundle config = ResourceBundle.getBundle("DBConnection");
        return Persistence.createEntityManagerFactory( "Labwork3", convertResourceBundleToMap(config));

    }

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    public static void shutdown() {
        entityManagerFactory.close();
    }

    private static Map<String, String> convertResourceBundleToMap(ResourceBundle resource) {
        Map<String, String> map = new HashMap<String, String>();

        Enumeration<String> keys = resource.getKeys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            map.put(key, resource.getString(key));
        }

        return map;
    }
}
