package deki.com.bootredissecuritytoken.common;

import deki.com.bootredissecuritytoken.dao.UserRepository;
import deki.com.bootredissecuritytoken.domain.User;
import deki.com.bootredissecuritytoken.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    UserRepository userRepository;
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String header = httpServletRequest.getHeader("Authorization");
        if(header!=null){
            String username = JWTUtil.getUsername(header);
            if(username!=null){
                List<User> users = userRepository.findByUserName(username);
                User user = users.get(0);
                if(user!=null){
                    filterChain.doFilter(httpServletRequest,httpServletResponse);
                }
            }
        }

    }
}
