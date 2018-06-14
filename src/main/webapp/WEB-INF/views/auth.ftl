<#import "base.ftl" as base>
<#import "pieces/UserRegistration.ftl" as user_reg>
<!DOCTYPE html>
<html lang="en">
<head>
    <@base.page_head></@base.page_head>
    <title>RecruitHub</title>
</head>
<body>
 <@base.page_navbar></@base.page_navbar>
<!-- TOTAL DIV !-->
<div class="featurebox col-md-12 col-sm-12 col-xs-12">
<div class="row">
    <div class="col-md-6 col-sm-6 col-xs-12">
        <@user_reg.user_reg></@user_reg.user_reg>
    </div>
</div>
</div>
</body>
</html>