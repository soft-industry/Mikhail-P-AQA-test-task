package starter.apis;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDto {
    boolean error;
    String message;
    @JsonProperty("requested_item")
    String requestedItem;
    @JsonProperty("served_by")
    String servedBy;
}
