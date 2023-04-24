package de.oninek.trainmate.api;

import org.testcontainers.containers.PostgreSQLContainer;

public class TestPostgresContainer extends PostgreSQLContainer<TestPostgresContainer> {

    private static final String IMAGE_VERSION = "postgres:13";
    private static TestPostgresContainer container;

    private TestPostgresContainer() {
        super(IMAGE_VERSION);
    }

    public static TestPostgresContainer getInstance() {
        if (container == null) {
            container = new TestPostgresContainer();
            container.start();
        }
        return container;
    }

    @Override
    public void stop() {

    }
}
