<#import "parts/common.ftl" as c>
<#import "parts/forms.ftl" as f>

<@c.page>
    Login:
    <@f.login "/login"/>
    <@f.button "/registration" "Create Account"/>
</@c.page>