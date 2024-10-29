package com.example.contacts.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Integer code;//Response code, 1 represents success; 0 represents failure
    private String msg;  //responseInformation descriptionString
    private Object data; //returnedData

    //add,delete,modify successfulResponse
    public static Result success() {
        return new Result(1, "success", null);
    }

    //query successfulResponse
    public static Result success(Object data) {
        return new Result(1, "success", data);
    }

    //failedResponse
    public static Result error(String msg) {
        return new Result(0, msg, null);
    }
}
