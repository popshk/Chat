<#import "parts/common.ftl" as c>
<#import "parts/forms.ftl" as f>
<@c.page>
    <div>
        <textarea name="chatArea" readonly>
            <#list messages as message>
                <p>${message.text}</p>
            </#list>
        </textarea>
    </div>
    <div>
        <form  action="/chat" method="post">
            <textarea name="inputMessage"></textarea>
            <input type="submit" value="Send">
        </form>
    </div>
</@c.page>