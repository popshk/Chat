<#import "parts/common.ftl" as c>
<#import "parts/forms.ftl" as f>

<@c.page>
    Registration:
    ${message?if_exists}
    <@f.login "/registration"/>
</@c.page>