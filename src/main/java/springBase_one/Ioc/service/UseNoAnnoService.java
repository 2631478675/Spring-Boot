package springBase_one.Ioc.service;

/**
 * 未使用注解@Service和①处未使用注解@Autowired
 */
public class UseNoAnnoService {
    //①
    NoAnnoService noAnnoService;

    //初始化noAnnoService
    public void setNoAnnoService(NoAnnoService noAnnoService){
        this.noAnnoService=noAnnoService;
    }
}
