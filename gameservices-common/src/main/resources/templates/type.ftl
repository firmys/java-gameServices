<#assign MapperUtil=statics["com.kobylynskyi.graphql.codegen.java.JavaGraphQLTypeMapper"]>
<#if package?has_content>
    package ${package};

</#if>
<#if imports??>
    <#list imports as import>
        <#list operations as operation>
            import ${import}.${operation.type};
        </#list>
    </#list>
</#if>
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.OffsetDateTime;
import java.util.Set;
import lombok.Builder;
import lombok.Singular;
import lombok.With;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.relational.core.mapping.Column;

<#list annotations as annotation>
    @${annotation}
</#list>

@With
@Document
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public record ${className}(<#if fields?has_content>
    <#list fields as field>
        <#if field.name == "name">
            @Indexed(unique = true)
        </#if>
        <#if field.type?contains("List")>
            @Singular
            ${field.type?replace("java.util.List<", "Set<")} ${field.name}<#if field_has_next>,</#if>
        </#if>
        <#if !field.type?contains("List")>
            <#if field.type == "double">
                Double ${field.name}<#if field_has_next>,</#if>
            <#elseif field.type == "DateTime" || field.name == "created" || field.name == "updated">
                OffsetDateTime ${field.name}<#if field_has_next>,</#if>
            <#elseif field.name == "version">
                @Version
                ${field.type} ${field.name}<#if field_has_next>,</#if>
            <#elseif field.name == "id">
                @Id @BsonId @BsonRepresentation(BsonType.OBJECT_ID)
                ObjectId ${field.name}<#if field_has_next>,</#if>
            <#else>
                ${field.type} ${field.name}<#if field_has_next>,</#if>
            </#if>
        </#if>
    </#list>
</#if>)
<#if implements?has_content>implements <#list implements as interface>${interface}<#if interface_has_next>, </#if></#list>
</#if>
<#if !implements?has_content>
    implements CommonObject
</#if> {

}