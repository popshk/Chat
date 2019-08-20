<#import "parts/common.ftl" as c>
<#import "parts/forms.ftl" as f>
<@c.page>
    <div style="height:500px;width:400px; overflow : scroll;">
        <#list messages as message>
            <div>
                <p>${message.text}</p>
            </div>
        </#list>
    </div>
    <div>
        <form method="post">
            <textarea name="text" style="height:100px;width:400px;"></textarea>
            <input type="submit" value="Send">
        </form>
    </div>
</@c.page>