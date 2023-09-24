package cn.org.oritention.accounts.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result {
    private Integer code;
    private String msg;
    private Object data;

    public static Result success() {
        return new Result(1,"success",null);
    }

    public static Result success(Object data) {
        return new Result(1,"success",data);
    }

    public static Result error() {
        return new Result(0,"error",null);
    }
}