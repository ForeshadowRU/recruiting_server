<#import "base.ftl" as base>
<!DOCTYPE html>
<html lang="en">
<head>
    <@base.page_head></@base.page_head>
    <title>Title</title>
</head>
<body>
    <@base.page_navbar></@base.page_navbar>

<table class="table table-hover">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th colspan="2"> <div style="text-align: center;">Action</div></th>
    </tr>
<#list companies as company>
    <tr>
        <td><a href="/company/${company.id}">${company.id}</a></td>
        <td>${company.name}</td>
        <td>${company.email}</td>
        <td><a href="/delete/${company.id}">Delete</a></td>
        <td><a href="/update/${company.id}">Update</a></td>
    </tr>
</#list>
</table>

</body>
</html>