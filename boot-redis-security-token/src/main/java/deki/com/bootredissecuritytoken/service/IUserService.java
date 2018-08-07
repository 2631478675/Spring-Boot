package deki.com.bootredissecuritytoken.service;

import deki.com.bootredissecuritytoken.common.Response;
import deki.com.bootredissecuritytoken.domain.User;

public interface IUserService {
    public Response login(User user);
}
