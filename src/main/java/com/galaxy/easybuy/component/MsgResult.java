package com.galaxy.easybuy.component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MsgResult {
    private Integer code;
    private String msg;
    private Object data;
    public MsgResult(Integer code,Object data){
        this.code = code;
        this.data = data;
        this.msg = "success";
    }

}
