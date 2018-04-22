<#import "base.ftl" as base>
<#import "pieces/CompanyRegistration.ftl" as company_reg>
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
<form action="/addUser" method="post">
    <fieldset>
        <legend>Register your account to start looking for job</legend>
        <div class="form-group">
            <label for="emailInput">Email address</label>
            <input type="email" class="form-control" id="emailInput" aria-describedby="emailHelp" placeholder="Enter email">
            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
        </div>
        <div class="form-group">
            <label for="name">Name</label>
            <input type="text" class="form-control" id="name">
        </div>
        <div class="form-group">
            <label for="pass">Password</label>
            <input type="password" class="form-control" id="pass" placeholder="Password">
        </div>
        <div class="form-group">
            <label for="repeatpass">Password</label>
            <input type="password" class="form-control" id="repeatpass" placeholder="Password">
        </div>
    </fieldset>
</form>
    </div>
    <div class="col-md-6 col-sm-6 col-xs-12">
        <@company_reg.registrationpage></@company_reg.registrationpage>
    </div>
</div>
</div>
</body>
</html>