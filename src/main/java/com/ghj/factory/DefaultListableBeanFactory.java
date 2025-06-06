package com.ghj.factory;

import java.util.HashMap;
import java.util.Map;

public class DefaultListableBeanFactory implements BeanDefinitionRegistry {
    private Map<String, Object> beanMap = new HashMap<>();

    public Object getBean(String name) {
        BeanDefinition beanDefinition = (BeanDefinition) beanMap.get(name);
        if (beanDefinition == null) {
            throw new IllegalArgumentException("No bean found with name: " + name);
        }
        Class<?> clazz = beanDefinition.getClazz();

        try {
            // 使用反射创建实例
            return clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create bean instance for class: " + clazz, e);
        }
    }

    @Override
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanMap.put(name, beanDefinition);
    }
}
