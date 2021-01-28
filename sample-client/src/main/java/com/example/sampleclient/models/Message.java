package com.example.sampleclient.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@ApiModel(description = "Represents a Message instance")
@AllArgsConstructor
public class Message {

    @ApiModelProperty(notes = "A unique message code.")
    private Integer code;

    @ApiModelProperty(notes = "The message to display.")
    private String value;
}
