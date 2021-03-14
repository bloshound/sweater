<#import "parts/common.ftlh" as c>
<#import "parts/login_registration.ftlh" as l>

<@c.page>
    Add new user
    ${message!}
    <@l.login "/registration" />
    <div><a href="/login">On login page</a></div>
</@c.page>