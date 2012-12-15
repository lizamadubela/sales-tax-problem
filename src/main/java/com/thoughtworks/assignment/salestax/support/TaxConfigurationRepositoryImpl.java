package com.thoughtworks.assignment.salestax.support;

import com.thoughtworks.assignment.salestax.domain.Category;
import com.thoughtworks.assignment.salestax.domain.Goods;
import com.thoughtworks.assignment.salestax.domain.ITaxConfigurationRepository;
import com.thoughtworks.assignment.salestax.domain.ITaxStrategy;
import com.thoughtworks.assignment.salestax.domain.Origin;
import com.thoughtworks.assignment.salestax.domain.TaxConfiguration;

import java.io.IOException;
import java.util.Properties;

public class TaxConfigurationRepositoryImpl implements ITaxConfigurationRepository {

    public static final String DEFAULT_CONFIG_PATH = "/com/thoughtworks/assignment/salestax/support/tax.properties";

    private String configPath;

    private Properties properties = new Properties();

    public TaxConfigurationRepositoryImpl() {
        configPath = DEFAULT_CONFIG_PATH;
    }

    public TaxConfigurationRepositoryImpl(String configPath) {
        if (configPath != null && !"".equals(configPath)) {
            this.configPath = configPath;
        } else {
            this.configPath = DEFAULT_CONFIG_PATH;
        }
    }

    public void init() {
        try {
            this.properties.load(this.getClass().getResourceAsStream(this.configPath));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    @Override
    public TaxConfiguration findConfiguration(Goods goods) {
        String categoryStr = goods.getCategory().toString();
        String originStr = goods.getOrigin().toString();
        String key = categoryStr + "@" + originStr;


        String clazz = properties.getProperty(key);


        Category category = new Category(categoryStr);
        Origin origin = Origin.valueOf(originStr);
        ITaxStrategy strategy = null;

        if (clazz != null && !"".equals(clazz)) {
            try {
                Class cls = Class.forName(clazz);
                strategy = (ITaxStrategy) cls.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        } else {
            throw new NullPointerException("Strategy implementation class cannot be empty");
        }

        TaxConfiguration configuration = new TaxConfiguration();
        configuration.setCategory(category);
        configuration.setOrigin(origin);
        configuration.setTaxStrategy(strategy);

        return configuration;
    }
}
