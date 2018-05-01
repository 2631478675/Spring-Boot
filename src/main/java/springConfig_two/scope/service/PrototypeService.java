package springConfig_two.scope.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype") //每次调用创建新的
public class PrototypeService {

}
