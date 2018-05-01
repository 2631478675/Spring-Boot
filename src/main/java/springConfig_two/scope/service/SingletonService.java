package springConfig_two.scope.service;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton") //默认，可有可无：只初始化构建一次
public class SingletonService {

}
