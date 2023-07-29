package lk.ijse.gdse63.shaili.assignment1.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Response {
    private Boolean status;
    private String responseMessage;
}
