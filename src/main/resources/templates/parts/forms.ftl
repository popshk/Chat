<#macro login path>
    <form action="${path}" method="post">
        <div><label> Login : <input type="text" name="login"/> </label></div>
        <div><label> Password: <input type="password" name="password"/> </label></div>
        <div><input type="submit" value="Sign In"/></div>
    </form>
</#macro>

<#macro button path name>
    <form action="${path}" method="get">
        <input type="submit" value="${name}"/>
    </form>
</#macro>