<#include "security.ftl">

<nav class="navbar navbar-expand-md justify-content-center">
    <div class="container">
        <div class="navbar-collapse collapse justify-content-between align-items-center w-100" id="collapsingNavbar2">
            <ul id="navbar-list-id" class="topBotomBordersOut navbar-nav mx-auto text-center">
                <#if user??>
                    <li class="nav-item"><a class="nav-link" href="/declaration">Declaration</a></li>
                </#if>
                <#if isAdmin>
                    <li class="nav-item">
                        <form action="/user" method="post">
                            <input type="hidden" name="_csrf" value="${_csrf.token}">
                            <button class="nav-link" type="submit">Users List</button>
                        </form>
                    </li>
                </#if>
                <li class="nav-item"> <a class="nav-link" href="#">Contact</a>
                <#if user??>
                    <li class="nav-item">
                        <a class="nav-link" href="/">Personal Area of ${username}</a>
                    </li>
                    <li class="nav-item">
                        <form id="logout" action="/logout" method="post">
                            <input type="hidden" name="_csrf" value="${_csrf.token}">
                            <button class="nav-link" type="submit">Sign Out</button>
                        </form>
                    </li>
                </#if>
            </ul>
        </div>
    </div>
</nav>