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
import java.util.Set;
import java.time.Instant;
import java.sql.Timestamp;
import java.time.OffsetDateTime;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import com.firmys.gameservices.generated.models.Feature;
import com.firmys.gameservices.generated.models.Entities;
import com.firmys.gameservices.generated.models.AttributeEntry;

import static com.firmys.gameservices.common.JsonUtils.JSON;
<#if javaDoc?has_content>
    /**
    <#list javaDoc as javaDocLine>
        * ${javaDocLine}
    </#list>
    */
</#if>
<#if generatedAnnotation && generatedInfo.getGeneratedType()?has_content>
    @${generatedInfo.getGeneratedType()}(
    value = "com.kobylynskyi.graphql.codegen.GraphQLCodegen",
    date = "${generatedInfo.getDateTime()}"
    )
</#if>
<#list annotations as annotation>
    @${annotation}
</#list>
public interface ${className} <#if className == "CommonEntity" || className == "CommonValue" || className == "CommonPercentile" || className == "CommonDistribution">extends CommonObject </#if><#if implements?has_content>extends <#list implements as interface>${interface}<#if interface_has_next>, </#if></#list></#if>{

<#if !className?contains("Common")>
    <#if fields?has_content>
        <#list fields as field>
            <#if field.javaDoc?has_content>
                /**
                <#list field.javaDoc as javaDocLine>
                    * ${javaDocLine}
                </#list>
                */
            </#if>
            <#if field.deprecated?has_content>
                @${field.deprecated.annotation}
            </#if>
            <#list field.annotations as annotation>
                @${annotation}
            </#list>
            ${field.type} ${field.name?lower_case}(<#list field.inputParameters as param><#list param.annotations as paramAnnotation>@${paramAnnotation}<#if param.annotations?has_content> </#if></#list>${param.type} ${param.name}<#if param_has_next>, </#if></#list>);

        </#list>
    </#if>
</#if>


<#if className == "CommonObject">
    default String toJson() {
    return JSON.toJson(this);
    }
</#if>
<#if className == "CommonEntity">
ObjectId id();

Error error();

String summary();

Entities type();

Integer version();

OffsetDateTime created();

OffsetDateTime updated();

Set
<Feature> features();

    Set
    <AttributeEntry> entries();

        CommonEntity withId(ObjectId id);

        CommonEntity withError(Error error);

        CommonEntity withType(Entities type);

        CommonEntity withSummary(String summary);

        CommonEntity withVersion(Integer version);

        CommonEntity withCreated(OffsetDateTime dateTime);

        CommonEntity withUpdated(OffsetDateTime dateTime);

        CommonEntity withFeatures(Set
        <Feature> features);

            CommonEntity withEntries(Set
            <AttributeEntry> entries);
                </#if>


                }
