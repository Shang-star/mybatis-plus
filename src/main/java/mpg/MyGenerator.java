package mpg;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

/**
 * @author shang
 * @Description: 代码生成器
 * @date 2021/4/14 10:40
 */
@Slf4j
public class MyGenerator {

    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();

        final String projectPath = System.getProperty("user.dir");
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(projectPath + "/src/main/java"); // 设置输出路径
        gc.setFileOverride(true); // 设置是否覆盖已有文件
        gc.setOpen(false); // 是否打开文件
        // gc.setEnableCache(false); // 是否在xml开启二级缓存
        gc.setAuthor("shang"); // 设置开发人员
        gc.setSwagger2(true); // 开启swagger2 模式
        gc.setActiveRecord(true); // 开启AR模式
        //gc.setXmlName("%sMapper");//Mapper xml 命名方式
        gc.setMapperName("%sMapper");//mapper 命名方式
        gc.setServiceName("%sService");//service 命名方式
        gc.setServiceImplName("%sServiceImpl");//service impl 命名方式
        gc.setControllerName("%sController");//controller 命名方式
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/mybatis-plus?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=UTC");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        mpg.setDataSource(dsc);

        // 包配置
        final PackageConfig pc = new PackageConfig();
        pc.setModuleName("sys");
        pc.setParent("com.shang");
        mpg.setPackageInfo(pc);

        // 自定义配置
        String mapperTemplatePath = "/templates/mapper.xml.ftl";
        InjectionConfig cfg = new InjectionConfig() {
            public void initMap() {

            }
        };
        // 自定义输出配置
        ArrayList<FileOutConfig> focList = new ArrayList<FileOutConfig>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(mapperTemplatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });


        String daoTemplatePath = "/templates/dao.java.ftl";
        focList.add(new FileOutConfig(daoTemplatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + "/src/main/java/" + pc.getParent().replaceAll("\\.","/") + "/dao"
                        + "/" + tableInfo.getEntityName() + "Dao" + StringPool.DOT_JAVA;
            }
        });

        log.info("parent: {}",pc.getParent());
        log.info("modify parent: {}",pc.getParent().replaceAll("\\.","/"));

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        // 配置自定义输出模板
        templateConfig.setXml(null); // 效果：java文件夹下不会出现 mapper.xml
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude("sys_user","sys_student");
        strategy.setTablePrefix(pc.getModuleName() + "_"); // eg sys_
        strategy.setEntityBooleanColumnRemoveIsPrefix(true);
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // strategy.setSuperEntityColumns("id");
        strategy.setControllerMappingHyphenStyle(true);
        mpg.setStrategy(strategy);

        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}
