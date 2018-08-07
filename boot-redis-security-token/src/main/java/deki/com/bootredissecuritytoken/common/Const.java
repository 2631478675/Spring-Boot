package deki.com.bootredissecuritytoken.common;

public class Const {

    public enum Role {
        PUBIC(1, "普通用户"),

        ADMIN(2, "管理员"),

        SUPER(3, "超级管理员");

        private Integer code;
        private String value;

        Role(Integer code, String value) {
            this.code = code;
            this.value = value;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public enum ResponseCode{

        SUCCESS(0,"SUCCESS"),ERROR(1,"ERROR"),NEED_LOGIN(10,"NEED_LOGIN"),ILLEGAL_ARGUMENT(20,"ILLEGAL_ARGUMENT");

        private int code;
        private String values;

        ResponseCode(int code, String values) {
            this.code = code;
            this.values = values;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getValues() {
            return values;
        }

        public void setValues(String values) {
            this.values = values;
        }
    }
}
