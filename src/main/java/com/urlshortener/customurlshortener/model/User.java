package com.urlshortener.customurlshortener.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Indexed;

@Document("UrlPilot-User")
@Data
public class User {
    @Id
    private String Id;
    private String userName;
    private String password;

    private String email;
}
