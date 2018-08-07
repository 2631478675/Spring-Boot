package deki.com.bootredissecuritytoken.common;

import java.io.Serializable;

public class Response<T> implements Serializable {
    private int status;
    private String msg;
    private T data;

    public Response(int status) {
        this.status = status;
    }

    public Response(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public Response(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public Response(int status, T data) {
        this.status = status;
        this.data = data;
    }

    public Response() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    public static <T> Response<T> createBySuccess(){
        return new Response<T>(Const.ResponseCode.SUCCESS.getCode());
    }
    public static <T> Response<T> createBySuccess(String msg){
        return new Response<T>(Const.ResponseCode.SUCCESS.getCode(),msg);
    }
    public static <T> Response<T> createBySuccess(T data){
        return new Response<T>(Const.ResponseCode.SUCCESS.getCode(),data);
    }
    public static <T> Response<T> createBySuccess(String msg,T data){
        return new Response<T>(Const.ResponseCode.SUCCESS.getCode(),msg,data);
    }
    public static <T> Response<T> createByError(){
        return new Response<T>(Const.ResponseCode.ERROR.getCode());
    }
    public static <T> Response<T> createByError(String msg){
        return new Response<T>(Const.ResponseCode.ERROR.getCode(),msg);
    }

}

