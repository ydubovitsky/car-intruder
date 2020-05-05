<#import "parts/general.ftl" as general>
<#include "parts/security.ftl">

<@general.general>
    <div class="container">
    <div class="jumbotron jumbotron-fluid">
        <div class="container">
            <h1 class="display-4">Choose a menu item</h1>
            <p class="lead">You can apply for a car accident and see its status.</p>
            <div class="btn-declaration">
                <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#input-declaration-form" aria-expanded="false" aria-controls="collapseExample">
                    Add new declaration
                </button>
                <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#declaration-list" aria-expanded="false" aria-controls="collapseExample">
                    Show declaration
                </button>
                <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#filter-declaration" aria-expanded="false" aria-controls="collapseExample">
                    Filter declaration
                </button>
            </div>
        </div>
    </div>

<#--    Input Declaration form start -->
    <div class="collapse" id="input-declaration-form">
        <form method="post" action="declaration" enctype="multipart/form-data">
            <div class="form-group row">
                <label for="inputEmail3" class="col-sm-2 col-form-label">Declaration name</label>
                <div class="col-sm-10">
                    <input type="text" name="name" class="form-control" placeholder="Declaration name">
                </div>
            </div>
            <div class="form-group row">
                <label for="inputEmail3" class="col-sm-2 col-form-label">Address</label>
                <div class="col-sm-10">
                    <input type="text" name="address" class="form-control" placeholder="Address">
                </div>
            </div>
            <div class="form-group row">
                <label for="inputEmail3" class="col-sm-2 col-form-label">Car number</label>
                <div class="col-sm-10">
                    <input type="text" name="carNumber" class="form-control" placeholder="Car number">
                </div>
            </div>
            <div class="form-group row">
                <label for="inputPassword3" class="col-sm-2 col-form-label">Description</label>
                <div class="col-sm-10">
                    <input type="text" name="description" class="form-control" placeholder="Description">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="exampleFormControlFile1">Photo of car acident</label>
                <div class="col-sm-10">
                    <input type="file" name="photo" class="form-control-file" id="exampleFormControlFile1">
                </div>
            </div>
            <fieldset class="form-group">
                <div class="row">
                    <legend class="col-form-label col-sm-2 pt-0">Status</legend>
                    <div class="col-sm-10">
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="status" value="ACCEPTED" checked>
                            <label class="form-check-label" for="gridRadios1">
                                ACCEPTED
                            </label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="status" value="COMPLETED">
                            <label class="form-check-label" for="gridRadios2">
                                COMPLETED
                            </label>
                        </div>
                        <div class="form-check disabled">
                            <input class="form-check-input" type="radio" name="status" value="DECLINE">
                            <label class="form-check-label" for="gridRadios3">
                                DECLINE
                            </label>
                        </div>
                    </div>
                </div>
            </fieldset>
            <div class="form-group row">
                <div class="col-sm-10">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <button type="submit" class="btn btn-primary">Add declaration</button>
                </div>
            </div>
        </form>
    </div>
<#--    Input Declaration form end -->

<#--    Filter declaration start -->
    <div class="collapse" id="filter-declaration">
        <form method="post" action="filter">
            <div class="form-group row">
                <fieldset class="form-group">
                    <legend class="col-form-label col-sm-2 pt-0">Status</legend>
                    <div class="col-sm-10">
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="filter" value="ACCEPTED" checked>
                            <label class="form-check-label" for="gridRadios1">
                                ACCEPTED
                            </label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="filter" value="COMPLETED">
                            <label class="form-check-label" for="gridRadios2">
                                COMPLETED
                            </label>
                        </div>
                        <div class="form-check disabled">
                            <input class="form-check-input" type="radio" name="filter" value="DECLINE">
                            <label class="form-check-label" for="gridRadios3">
                                DECLINE
                            </label>
                        </div>
                    </div>
                </fieldset>
            </div>
            <div class="form-group row">
                <div class="col-sm-10">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <button type="submit" class="btn btn-primary">Show filter declaration</button>
                </div>
            </div>
        </form>
    </div>
<#--    Filter declaration end -->

<#--    Declaration list start -->
    <div class="collapse" id="declaration-list">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">name</th>
                <th scope="col">address</th>
                <th scope="col">carNumber</th>
                <th scope="col">description</th>
                <th scope="col">photo</th>
                <th scope="col">status</th>
                <th scope="col">Author</th>
                <#if isAdmin>
                    <th scope="col">Edit Declaration</th>
                </#if>
            </tr>
            </thead>
            <tbody>
            <#list declarationList as dec>
                <tr>
                    <td>${dec.id}</td>
                    <td>${dec.name}</td>
                    <td>${dec.address}</td>
                    <td>${dec.carNumber}</td>
                    <td>${dec.description}</td>
                    <#if dec.photo??>
                        <td><img src="/img/${dec.photo}" class="img-thumbnail" alt="no img exists"></td>
                        <#else>
                        <td>Sorry.. No image of car accident</td>
                    </#if>
                    <td>${dec.status}</td>
                    <td>${dec.getUser().getUsername()}</td>
                    <#if isAdmin>
                        <td>
                            <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#flag${dec.id}" aria-expanded="false" aria-controls="collapseExample">
                                Edit Declaration
                            </button>
                        </td>
                        <td>
                            <#--        Edit declaration start-->
                            <div class="collapse" id="flag${dec.id}">
                                <form method="post" action="/declaration/edit">
                                    <div class="form-group row">
                                        <div class="col-sm-2">Roles</div>
                                        <div class="col-sm-10">
                                            <#list declarationStatuses as st>
                                                <div class="form-check">
                                                    <input class="form-check-input" type="radio" name="status" id="exampleRadios1" value="${st}">
                                                    <label class="form-check-label" for="exampleRadios1">
                                                        ${st}
                                                    </label>
                                                </div>
                                            </#list>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <div class="col-sm-10">
                                            <input type="hidden" name="_csrf" value="${_csrf.token}">
                                            <input type="hidden" name="id" value="${dec.id}">
                                            <button type="submit" class="btn btn-primary">Save Change</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <#--        Edit declaration end-->
                        </td>
                    </#if>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>
<#--    Declaration list end -->
</@general.general>