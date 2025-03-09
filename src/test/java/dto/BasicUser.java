package dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BasicUser {

    String login;
    String password;
    String creditCard;

    public String getCreditCard() { return creditCard; }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

}
