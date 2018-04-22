<#macro user_reg>
<form action="/addUser" method="post">
    <fieldset>
        <legend>Register your account to start looking for job</legend>
        <div class="form-group">
            <label for="emailInput">Email address</label>
            <input type="email" name="email" class="form-control" id="emailInput" aria-describedby="emailHelp" placeholder="Enter email">
            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
        </div>
        <div class="form-group">
            <label for="name">Name</label>
            <input type="text" class="form-control" id="name" name="name">
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" class="form-control" name="password" id="password" placeholder="Password">
        </div>
        <div class="form-group">
            <label for="repeatpass">Password</label>
            <input type="password" class="form-control" id="repeatpass" placeholder="Password">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </fieldset>
</form>
</#macro>