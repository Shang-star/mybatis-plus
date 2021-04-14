package ${package.Service};

import ${package.Entity}.${entity};
import ${superServiceClassPackage};

/**
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.serviceName}>
<#else>
public interface ${table.serviceName} {

}
</#if>
