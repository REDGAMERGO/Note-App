<#import "../parts/common.ftlh" as c>
<#import "../parts/login.ftlh" as l>

<@c.page>
    <@l.login "/registration" true />

    <div class="text-center mx-auto align-middle" style="margin-top:3%">
        <h5 class="text" style="color: #6E6363"><b>${message?ifExists}</b></h5>
    </div>

</@c.page>