package ${package.Mapper?substring(0,(package.Mapper)?length-6)}dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
* @author ${author}
* @since ${date}
*/
@Repository
@Slf4j
@AllArgsConstructor
<#if kotlin>
open class ${entity}Dao : extends ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

}
<#else>
public class ${entity}Dao extends ${superServiceImplClass}<${table.mapperName}, ${entity}> {

}
</#if>