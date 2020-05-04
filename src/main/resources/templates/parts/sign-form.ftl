<#macro signForm action>
    <div class="simple-login-container">
        <form action="${action}" method="post">
            <#if action == "/registration">
                <h2>Registration From</h2>
            <#else>
                <h2>Login Form</h2>
            </#if>
            <div class="row">
                <div class="col-md-12 form-group">
                    <input class="form-control" type="text" name="username" placeholder="Username">
                </div>
            </div>
            <div class="row">
                <div class="col-md-12 form-group">
                    <input class="form-control" type="password" name="password" placeholder="Password">
                </div>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <div class="row">
                <div class="col-md-12 form-group">
                    <input type="submit" class="btn btn-block btn-login" placeholder="Sign In" >
                </div>
            </div>
            <#if action == "/login">
                <div class="row">
                    <div class="col-md-12">
                        <a href="/registration" class="forgot">Don't have an account? Register now.</a>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <a href="#" class="forgot">Forgot your email or password?</a>
                    </div>
                </div>
            </#if>
        </form>
    </div>
</#macro>