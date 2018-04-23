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

<div class="featurebox col-md-12 col-sm-12 col-xs-12">
    <#list rows as row>
    <div class="row">
        <#list row as vacancy>
            <div class="col-md-6 col-sm-6 col-xs-12">
                <h2>${vacancy.name}</h2>
                <p>${vacancy.description}</p>
            </div>
        </#list>
    </div>
    </#list>
</div>



</body>
</html>