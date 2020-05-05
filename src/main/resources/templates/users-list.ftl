<#import "parts/general.ftl" as general>

<@general.general>
    <#if allUsers??>
        <div class="container">
            <div class="jumbotron jumbotron-fluid">
                <div class="container">
                    <h1 class="display-4">List of all users of the "Car Intruder"</h1>
                    <p class="lead">You can see all users and edit their data.</p>
                    <div class="btn-declaration">
                        <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#show-all-users" aria-expanded="false" aria-controls="collapseExample">
                            Show all users
                        </button>
                    </div>
                </div>
            </div>
            <#--        Table of users start-->
            <div class="collapse" id="show-all-users">
                <table class="table">
                    <thead class="thead-dark">
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Active</th>
                        <th scope="col">Password</th>
                        <th scope="col">Username</th>
                        <th scope="col">Role</th>
                        <th scope="col">Delete User</th>
                        <th scope="col">Edit user</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list allUsers as u>
                        <tr>
                            <td>${u.id}</td>
                            <td>${u.active?string("yes", "no")}</td>
                            <td>${u.password}</td>
                            <td>${u.username}</td>
                            <td>
                                <#list u.roles as r>
                                    <label class="form-check-label" for="exampleCheck1">${r.name()}<#sep>, </label>
                                </#list>
                            </td>
                            <td>
                                <form method="post" action="/user/delete">
                                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                                    <input type="hidden" name="id" value="${u.id}">
                                    <button type="submit" class="btn btn-danger">Delete user</button>
                                </form>
                            </td>
                            <td>
                                <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#flag${u.id}" aria-expanded="false" aria-controls="collapseExample">
                                    Edit user
                                </button>
                            </td>
                            <td>
                                <#--        Edit user start-->
                                <div class="collapse" id="flag${u.id}">
                                    <form method="post" action="/user/edit">
                                        <div class="form-group row">
                                            <label for="inputEmail3" class="col-sm-2 col-form-label">Username</label>
                                            <div class="col-sm-10">
                                                <input type="text" name="username" placeholder="${u.username}" class="form-control">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label for="inputPassword3" class="col-sm-2 col-form-label">Password</label>
                                            <div class="col-sm-10">
                                                <input type="password" placeholder="${u.password}" name="password" class="form-control">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <div class="col-sm-2">Roles</div>
                                            <div class="col-sm-10">
                                                <#list rolesArray as rl>
                                                    <div class="form-check">
                                                        <input type="checkbox" name="${rl}" class="form-check-input" ${u.roles?seq_contains(rl)?string("checked", "")}
                                                               value="${rl}">
                                                        <label class="form-check-label" for="gridCheck1">${rl}</label>
                                                    </div>
                                                </#list>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <div class="col-sm-10">
                                                <input type="hidden" name="_csrf" value="${_csrf.token}">
                                                <input type="hidden" name="id" value="${u.id}">
                                                <button type="submit" class="btn btn-primary">Save Change</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <#--        Edit user end-->
                            </td>
                        </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
            <#--        Table of users end-->
        </div>
    <#else>
        Oooops!
    </#if>
</@general.general>
