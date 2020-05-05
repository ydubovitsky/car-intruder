<#macro signForm action>
    <div class="simple-login-container">
        <form action="${action}" method="post" enctype="multipart/form-data">
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
            <#if action == "/registration">
                <div class="row">
                    <div class="col-md-12 form-group">
                        <input class="form-control" type="email" name="email" placeholder="Email">
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12 form-group">
                        <label class="col-sm-2 col-form-label" for="exampleFormControlFile1">Your Photo</label>
                        <div class="col-sm-10">
                            <input type="file" name="avatar" class="form-control-file" id="exampleFormControlFile1">
                        </div>
                    </div>
                </div>
            </#if>
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <div class="row">
                <div class="col-md-12 form-group">
                    <input type="submit" class="btn btn-block btn-login">
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