<#include "security.ftlh">
<#import "login.ftlh" as l>


<div class="nav-panel">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="/">NoteApp</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/main">Главная</a>
                </li>
                <#if isAdmin>
                    <li class="nav-item">
                        <a class="nav-link" href="/user">Список пользователей</a>
                    </li>
                </#if>
                <li class="nav-item">
                    <a class="nav-link" href="/main">Заметки</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/main">Категории</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/main">Метки</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/main">Найти</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/main">Корзина</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/main">Профиль</a>
                </li>

            </ul>

            <div class="navbar-text mr-3">${name}</div>
            <@l.logout />
        </div>
    </nav>
</div>