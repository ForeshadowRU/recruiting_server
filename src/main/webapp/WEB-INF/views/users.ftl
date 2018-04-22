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
<#list users as user>
    <tr>
        <td><a href="/user/${user.id}">${user.id}</a></td>
        <td>${user.name}</td>
        <td>${user.email}</td>
        <td><a href="/delete/${user.id}">Delete</a></td>
        <td><a href="/update/${user.id}">Update</a></td>
    </tr>
</#list>
</table>

</body>
</html>