package dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BasicUser {

    String login;

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    String password;

}
