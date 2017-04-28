package technancy.javatraining;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import technancy.javatraining.health.ProductReviewHealthCheck;
import technancy.javatraining.models.ProductReviewConfiguration;
import technancy.javatraining.resources.ProductResource;

public class ProductReviewApplication extends Application<ProductReviewConfiguration> {
    public static void main(String[] args) throws Exception {
        new ProductReviewApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<ProductReviewConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(ProductReviewConfiguration configuration,
                    Environment environment) {
        final ProductResource resource = new ProductResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );
        environment.jersey().register(resource);

        final ProductReviewHealthCheck healthCheck =
                new ProductReviewHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("ProductReview", healthCheck);
        environment.jersey().register(resource);
    }
}

