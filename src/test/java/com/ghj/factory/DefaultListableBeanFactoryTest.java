package com.ghj.factory;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class DefaultListableBeanFactoryTest extends TestCase {

    @Test
    public void testGetBean() throws Exception {
//        BeanFactory beanFactory = new BeanFactory();
//        beanFactory.registerBean("helloService", new HelloService());
//        HelloService helloService = (HelloService) beanFactory.getBean("helloService");
//        System.out.println(helloService.sayHello());
//        assertThat(helloService).isNotNull();
//        assertThat(helloService.sayHello()).isEqualTo("hello");
    }

    @Test
    public void testBeanFactory() throws Exception {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        HelloService helloService = new HelloService();
        helloService.setName("haha");
        BeanDefinition beanDefinition = new BeanDefinition(helloService.getClass());
        defaultListableBeanFactory.registerBeanDefinition("helloService", beanDefinition);
        HelloService helloService2 = (HelloService) defaultListableBeanFactory.getBean("helloService");
        helloService2.sayHello();
        System.out.println(helloService2.getName());
    }

    public static class HelloService {

        String name;

        public String sayHello() {
            System.out.println("hello");
            return "hello";
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}