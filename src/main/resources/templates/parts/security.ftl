<#assign
    context = Session.SPRING_SECURITY_CONTEXT??
>

<#if context>
    <#assign
        user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
        username = user.getUsername()
        isAdmin = user.isInspector()
        >
    <#else>
        <#assign
            username = "Guest"
            isAdmin = false
            >
</#if>