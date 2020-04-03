<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<div class="row">
    <div class="col-md-2">
        <tags:main-user-panel/>
    </div>
    <div class="col-md-10">
        <div class="panel panel-default">
            <tags:main-tasks-table/>
        </div>
    </div>
</div>