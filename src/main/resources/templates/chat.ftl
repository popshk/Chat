<#import "parts/common.ftl" as c>
<#import "parts/forms.ftl" as f>
<@c.page>
    <@f.logout/>
    <div style="height:500px;width:400px; overflow : scroll;">
        <#list messages as message>
            <div>
                <p>${message.date}</p>
                <p>${message.text}</p>
            </div>
            <#else>
        No message
        </#list>
    </div>
    <div>
        <form method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <textarea name="text" style="height:100px;width:400px;"></textarea>
            <input type="submit" value="Send">
        </form>
    </div>
</@c.page>