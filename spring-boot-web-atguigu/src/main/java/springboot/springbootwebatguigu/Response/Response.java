package springboot.springbootwebatguigu.Response;

public class Response {

    private Status status;

    public Response success() {
        this.status = new Status(true,"success");
        return this;
    }

    public Response failure() {
        this.status = new Status(false,"fail");
        return this;
    }


    public Status getStatus() {
        return status;
    }

    public class Status {
        private boolean success;

        private String message;

        public Status(boolean success) {
            this.success = success;
        }

        public Status(boolean success, String message) {
            this.success = success;
            this.message = message;
        }

        public Status(String message) {
            this.message = message;
        }

        public boolean isSuccess() {
            return success;
        }

        public String getMessage() {
            return message;
        }
    }
}
