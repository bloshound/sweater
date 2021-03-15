<#import "parts/common.ftlh" as c>
<#import "parts/login_registration.ftlh" as l>
<@c.page>

    <div>
        <@l.logout/>
    </div>

    <span>
        <a href="/user">User list</a>
    </span>

    <div>
        <form method="POST">
            <label><input type="text" name="text" placeholder="Input message"></label>
            <label><input type="text" name="tag" placeholder="Tag"></label>
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <button type="submit">Add message</button>
        </form>
    </div>

    <div>List of messages</div>

    <div>
        <form method="GET">
            <label><input type="text" name="filter" value="${filter!}"></label>
            <button type="submit">Find from filter</button>
        </form>
    </div>

    <#list messages as message>
        <div>
        <b>${message.id}</b>
        <span>${message.text}</span>
        <i>${message.tag}</i>
        <strong>${message.authorName}</strong>
        <div>
    <#else>
        No message
    </#list>
</@c.page>