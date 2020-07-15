package com.ztp.raffleapi.message;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonResponse extends BaseResponse{
    @Builder
    public CommonResponse(ResponseCode responseCode){
        super(responseCode);
    }
}
