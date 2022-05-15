package model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Builder
@ToString
@Getter
public class Auth {
    String email;
    String password;
}
