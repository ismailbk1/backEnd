package tn.pfe.rhbackend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {
    private String responseMessage;
    private String email;
}