<#macro page>

<#import "common.ftlh" as c>
<#include "security.ftlh">

<@c.page>

    <div class="row no-gutters">
        <div  class="col"></div>
        <div  class="col-auto">
            <#include "navbar.ftlh">
        </div>
        <div  class="col"></div>
    </div>

    <div class="row no-gutters" style="padding-top: 30px">
        <div class="col" style="width: 200px;"></div>
        <div class="col-auto">
            <div class="desk-panel shadow-sm">
                <#nested>
            </div>
        </div>
        <div class="col"></div>
    </div>

</@c.page>

</#macro>