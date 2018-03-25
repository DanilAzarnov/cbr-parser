package parcer;

import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class ServiceDB {

    private static StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure("hibernate_cfg.xml")
            .build();

    public static StandardServiceRegistry getRegistry() {
        return registry;
    }
}
