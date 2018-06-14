<#import "base.ftl" as base>
<!DOCTYPE html>
<html lang="en">
<head>
    <@base.page_head></@base.page_head>
<title>Title</title>
</head>
<body>
<@base.page_navbar>
</@base.page_navbar>
<!-- style="margin-top: 50px; margin-right: 30px;margin-left: 30px"
 col-md-12 col-sm-12 col-xs-12
 !-->
<div class="featurebox">
    <#list rows as row>
    <div class="row" >
        <#list row as vacancy>
            <div class="col-md-3 col-sm-3" style="margin: auto; padding: auto" >
                <h2>${vacancy.name}</h2>
                <p>${vacancy.description}</p>

                <div id="require">
                    <#list vacancy.requirements as require>
                        <b>${require.skill.name}</b>
                        <#if require.important>
                        <div class="progress">
                            <div class="progress-bar progress-bar-striped bg-info" role="progressbar" style="width: ${require.level * 10}%" aria-valuenow="0" aria-valuemin="0" aria-valuemax="10">${require.level}/10</div>
                        </div>
                        <#else>
                        <div class="progress">
                            <div class="progress-bar progress-bar-striped bg-warning" role="progressbar" style="width: ${require.level * 10}%" aria-valuenow="0" aria-valuemin="0" aria-valuemax="10">${require.level}/10</div>
                        </div>
                        </#if>

                    </#list>
                </div>

            </div>

        </#list>
    </div>
    </#list>
</div>



</body>
</html>