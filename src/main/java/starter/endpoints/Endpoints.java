package starter.endpoints;

import java.util.Arrays;

public enum Endpoints {


    APPLE_ENDPOINT("apple", "/api/v1/search/test/apple"),
    MANGO_ENDPOINT ("mango","/api/v1/search/test/mango"),
    CAR_ENDPOINT ("car", "/api/v1/search/test/car"),
    TOFU_ENDPOINT ("tofu", "/api/v1/search/test/tofu");

    private final String endpoint;
    private final String value;

    Endpoints(String value, String endpoint) {
        this.endpoint = endpoint;
        this.value = value;
    }

    public static Endpoints valueOfLabel(String label) {
        return Arrays.stream(Endpoints.values())
                .filter(e -> e.value.equals(label))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(String.format("Unsupported endpoint %s.", label)));
    }

    public String getEndpoint() {
        return endpoint;
    }
}
