package ru.sberbank.school.HomeTask6.simplespring;


import ru.sberbank.school.HomeTask6.simplespring.x.CImlp;

/**
 * Created by svetlana on 25.09.16.
 */
@Component
public class A { //TODO: не абстрактный и не интерфейс

    @Autowired
    private B b;

    @Autowired
    private CImlp d;


    @PostConstruct
    public void init() {
        //TODO: some logic
    }

    public void execute() {
        System.out.println(b.getSomeData());
        System.out.println(d.getSomeStr());
    }

    @PreDestroy
    public void destroy() {
        //TODO: some logic
    }

}
