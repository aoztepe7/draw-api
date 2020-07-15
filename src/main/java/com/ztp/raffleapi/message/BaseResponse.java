package com.ztp.raffleapi.message;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse {
    private Integer code;
    private String message;

    public BaseResponse() {
    }

    public BaseResponse(ResponseCode responseCode){
        this.code = responseCode.getCode();
        this.message = responseCode.getMessage();
    }
}
