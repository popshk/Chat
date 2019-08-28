<#macro login path>
    <form action="${path}" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div><label> User name : <input type="text" name="username"/> </label></div>
        <div><label> Password: <input type="password" name="password"/> </label></div>
        <div><input type="submit" value="Sign In"/></div>
    </form>
</#macro>

<#macro button path name>
    <form action="${path}" method="get">
        <input type="submit" value="${name}"/>
    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <input type="submit" value="Sign Out"/>
    </form>
</#macro>