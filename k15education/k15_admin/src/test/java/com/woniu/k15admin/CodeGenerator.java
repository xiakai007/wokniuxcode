package com.woniu.k15admin;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.jupiter.api.Test;

public class CodeGenerator {
    //@Test
    public void genCode(){
        AutoGenerator autoGenerator = new AutoGenerator();
        GlobalConfig globalConfig = new GlobalConfig();
        String prijectpath=System.getProperty("user.dir");
        globalConfig.setOutputDir("D:\\ideaprojects\\k15education\\k15_admin"+"/src/main/java");
        globalConfig.setAuthor("xiakai");
        globalConfig.setOpen(false);
        globalConfig.setFileOverride(false);
        globalConfig.setServiceName("%sService");
        globalConfig.setIdType(IdType.AUTO);
        globalConfig.setDateType(DateType.ONLY_DATE);
        globalConfig.setSwagger2(true);
        autoGenerator.setGlobalConfig(globalConfig);
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/rbac?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai");
        dataSourceConfig.setDriverName("com.mysql.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("123456");
        dataSourceConfig.setDbType(DbType.MYSQL);
        autoGenerator.setDataSource(dataSourceConfig);
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.woniu.springboot");
        packageConfig.setModuleName("mp");
        packageConfig.setController("controller");
        packageConfig.setEntity("pojo");
        packageConfig.setService("service");
        packageConfig.setMapper("mapper");
        autoGenerator.setPackageInfo(packageConfig);
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setInclude("sys_dept","sys_permission","sys_role","sys_user");
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setTablePrefix(packageConfig.getModuleName()+"_");
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setEntityLombokModel(true);
        strategyConfig.setRestControllerStyle(true);
        strategyConfig.setControllerMappingHyphenStyle(true);
        autoGenerator.setStrategy(strategyConfig);
        autoGenerator.execute();
    }
}
