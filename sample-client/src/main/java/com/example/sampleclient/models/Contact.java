package com.example.sampleclient.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@ApiModel(description = "Represents a Contact instance")
@AllArgsConstructor
public class Contact {
    @ApiModelProperty(notes = "A UUID to uniquely identify this instance.")
    private String id;

    @ApiModelProperty(notes = "The first name of the contact.")
    private String firstName;

    @ApiModelProperty(notes = "The last name of the contact.")
    private String lastName;

    @ApiModelProperty(notes = "The email of the contact.")
    private String email;
}
