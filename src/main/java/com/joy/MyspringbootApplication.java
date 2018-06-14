package com.joy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;
/**
 * @Package: com.joy
 * @Class: MyspringbootApplication
 * @Author: Joy
 * @date: 2018/4/15 15:55
 * @Description: TODO
 * @Param: param
 * @ReturnType:
 * @Exception
 **/

/**
 *  SpringBootApplication
 * 用于代替 @SpringBootConfiguration（@Configuration）、 @EnableAutoConfiguration 、 @ComponentScan。
 * <p>
 * SpringBootConfiguration（Configuration） 注明为IoC容器的配置类，基于java config
 * EnableAutoConfiguration 借助@Import的帮助，将所有符合自动配置条件的bean定义加载到IoC容器
 * ComponentScan 自动扫描并加载符合条件的组件
 */
/**
 * 在用这个项目打war包的时候发现用tomcat7打包，serverlt容器初始化失败，换成tomcat8成功
 * exclude = {DataSourceAutoConfiguration.class}
 * 禁用springboot默认加载的application.properties单数据源配置
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableScheduling
@EnableJms
@ServletComponentScan
@EnableCaching
@EnableAutoConfiguration(exclude = {MultipartAutoConfiguration.class})
@MapperScan("com.joy.java.mybatis.mapper")
@EnableJpaRepositories
public class MyspringbootApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MyspringbootApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(MyspringbootApplication.class, args);
        System.out.println(""+"");
        System.out.println("                           _ooOoo_");
        System.out.println("                          o8888888o");
        System.out.println("                          88\" . \"88 ");
        System.out.println("                          (| -_- |) ");
        System.out.println("                          O\\  =  /O ");
        System.out.println("                       ____/`---'\\____");
        System.out.println("                     .'  \\\\|     |//  `.");
        System.out.println("                    /  \\\\|||  :  |||//  \\ ");
        System.out.println("                   /  _||||| -:- |||||-  \\ ");
        System.out.println("                   |   | \\\\\\  -  /// |   | ");
        System.out.println("                   | \\_|  ''\\---/''  |   | ");
        System.out.println("                   \\  .-\\__  `-`  ___/-. /");
        System.out.println("                 ___`. .'  /--.--\\  `. . __");
        System.out.println("              .\"\" '<  `.___\\_<|>_/___.'  >'\"\".");
        System.out.println("             | | :  `- \\`.;`\\ _ /`;.`/ - ` : | |");
        System.out.println("             \\  \\ `-.   \\_ __\\ /__ _/   .-` /  /");
        System.out.println("        ======`-.____`-.___\\_____/___.-`____.-'======");
        System.out.println("                          `=---='");
        System.out.println("        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("                   佛祖保佑        永无BUG");
        System.out.println("          佛曰:");
        System.out.println("                 写字楼里写字间，写字间里程序员；");
        System.out.println("                 程序人员写程序，又拿程序换酒钱。");
        System.out.println("                 酒醒只在网上坐，酒醉还来网下眠；");
        System.out.println("                 酒醉酒醒日复日，网上网下年复年。");
        System.out.println("                 但愿老死电脑间，不愿鞠躬老板前；");
        System.out.println("                 奔驰宝马贵者趣，公交自行程序员。");
        System.out.println("                 别人笑我忒疯癫，我笑自己命太贱；");
        System.out.println("                 不见满街漂亮妹，哪个归得程序员？");
    }
    /*

总结：

1、获取运行环境信息和回调接口。例如ApplicationContextIntializer、ApplicationListener。
完成后，通知所有SpringApplicationRunListener执行started()。
2、创建并准备Environment。
完成后，通知所有SpringApplicationRunListener执行environmentPrepared()
3、创建并初始化 ApplicationContext 。例如，设置 Environment、加载配置等
完成后，通知所有SpringApplicationRunListener执行contextPrepared()、contextLoaded()
4、执行 ApplicationContext 的 refresh，完成程序启动
完成后，遍历执行 CommanadLineRunner、通知SpringApplicationRunListener 执行 finished()
参考：
https://blog.csdn.net/zxzzxzzxz123/article/details/69941910
https://www.cnblogs.com/shamo89/p/8184960.html
https://www.cnblogs.com/trgl/p/7353782.html

分析：
1） 创建一个SpringApplication对象实例，然后调用这个创建好的SpringApplication的实例方法
public static ConfigurableApplicationContext run(Object source, String... args)
public static ConfigurableApplicationContext run(Object[] sources, String[] args)

2） SpringApplication实例初始化完成并且完成设置后，就开始执行run方法的逻辑了，
方法执行伊始，首先遍历执行所有通过SpringFactoriesLoader可以查找到并加载的
SpringApplicationRunListener，调用它们的started()方法。

public SpringApplication(Object... sources)
private final Set<Object> sources = new LinkedHashSet<Object>();
private Banner.Mode bannerMode = Banner.Mode.CONSOLE;
...
private void initialize(Object[] sources)

3） 创建并配置当前SpringBoot应用将要使用的Environment（包括配置要使用的PropertySource以及Profile）。

private boolean deduceWebEnvironment()

4） 遍历调用所有SpringApplicationRunListener的environmentPrepared()的方法，通知Environment准备完毕。

5） 如果SpringApplication的showBanner属性被设置为true，则打印banner。

6） 根据用户是否明确设置了applicationContextClass类型以及初始化阶段的推断结果，
决定该为当前SpringBoot应用创建什么类型的ApplicationContext并创建完成，
然后根据条件决定是否添加ShutdownHook，决定是否使用自定义的BeanNameGenerator，
决定是否使用自定义的ResourceLoader，当然，最重要的，
将之前准备好的Environment设置给创建好的ApplicationContext使用。
7） ApplicationContext创建好之后，SpringApplication会再次借助Spring-FactoriesLoader，
查找并加载classpath中所有可用的ApplicationContext-Initializer，
然后遍历调用这些ApplicationContextInitializer的initialize（applicationContext）方法
来对已经创建好的ApplicationContext进行进一步的处理。
8） 遍历调用所有SpringApplicationRunListener的contextPrepared()方法。
9） 最核心的一步，将之前通过@EnableAutoConfiguration获取的所有配置以及其他形式的
IoC容器配置加载到已经准备完毕的ApplicationContext。
10） 遍历调用所有SpringApplicationRunListener的contextLoaded()方法。
11） 调用ApplicationContext的refresh()方法，完成IoC容器可用的最后一道工序。
12） 查找当前ApplicationContext中是否注册有CommandLineRunner，如果有，则遍历执行它们。
13） 正常情况下，遍历执行SpringApplicationRunListener的finished()方法、
（如果整个过程出现异常，则依然调用所有SpringApplicationRunListener的finished()方法，
只不过这种情况下会将异常信息一并传入处理）

private <T> Collection<? extends T> getSpringFactoriesInstances(Class<T> type)
private <T> Collection<? extends T> getSpringFactoriesInstances(Class<T> type,
			Class<?>[] parameterTypes, Object... args)
public void setInitializers
private Class<?> deduceMainApplicationClass()
public ConfigurableApplicationContext run(String... args)
private void configureHeadlessProperty()
private SpringApplicationRunListeners getRunListeners(String[] args)
public static List<String> loadFactoryNames(Class<?> factoryClass, ClassLoader classLoader)
*/
}
