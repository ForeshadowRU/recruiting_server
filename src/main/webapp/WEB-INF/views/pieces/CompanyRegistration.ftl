<#macro registrationpage>
    <form action="/addCompany" method="post">
        <fieldset>
            <legend>Register your company to start looking for recruits</legend>
            <div class="form-group">
                <label for="emailInput">Email address</label>
                <input type="email" name="email" class="form-control" id="emailInput" aria-describedby="emailHelp" placeholder="Enter email">
                <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
            </div>
            <div class="form-group">
                <label for="companyName">CompanyName</label>
                <input type="text" name="name"class="form-control" id="companyName">
            </div>
            <div class="form-group">
                <label for="pass">Password</label>
                <input type="password" name="password" class="form-control" id="pass" placeholder="Password">
            </div>
            <div class="form-group">
                <label for="repeatpass">Password</label>
                <input type="password" class="form-control" id="repeatpass" placeholder="Repeat Password">
            </div>
        </fieldset>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>

</#macro>