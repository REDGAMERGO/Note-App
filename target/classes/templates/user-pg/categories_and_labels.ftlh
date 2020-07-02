<#import "../parts/main.ftlh" as m>
<#include "../parts/security.ftlh">
<@m.page>
    <div>


        <!--Список категорий-->
        <div class="category-list list-group">
            <div class="border">
                <div href="#" class="list-group-item active text-center rounded-0" style="color: white">
                    Категории
                </div>
                <div class="pre-scrollable" style=" height: 550px; background: #FCFCFC">
                    <#list categories as category>
                        <#if category.getAuthor().getId() == currentUserId>
                            <a class="list-group-item list-group-item rounded-0">
                                <div class="custom-control-inline">
                                    <div class="text-truncate"  style="width: 200px; border: none; ">
                                        ${category.getName()}
                                    </div>
                                    <div class="custom-control-inline" style="margin-left: 20px">

                                        <div class="btn-group" style="width: 40px; margin-right: 10px">
                                            <button class="btn btn-sm btn-outline-primary badge-pill nav-item dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="width: 95px">
                                                Изменить
                                            </button>
                                            <div class="dropdown-menu" style="width:220px">
                                                <form method="post" action="/update-category" style="width: 150px;">
                                                    <div style="padding-left: 10px; padding-top: 2px">
                                                        <input class="rounded border" type="text" style="width: 196px" name="name" value="${category.getName()}">
                                                    </div>
                                                    <input type="hidden" name="category_id" value="${category.getId()}">
                                                    <input type="hidden" name="_csrf" value="${_csrf.token}" />
                                                    <div style="padding-left: 115px; padding-top: 6px">
                                                        <button class="btn btn-sm btn-success" style="width: 90px; size: auto">Сохранить</button>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>

                                        <form method="get" action="/remove-category" style="width: 40px; margin-left: 60px">
                                            <input type="hidden" name="category_id" value=${category.getId()}>
                                            <div>
                                                <button class="btn btn-sm btn-outline-danger badge-pill" style="width: 90px;">
                                                    Удалить
                                                </button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </a>
                        </#if>
                    </#list>
                </div>
            </div>
        </div>

        <!--Форма добавления категории-->
        <div class="add-category-form">
            <div class="form-control border-top-0 rounded-0" style="height: 55px">
                <div>
                    <form method="get" action="/add-category">
                        <div style="padding-top: 7px;">
                            <input class="rounded border" required style="width: 250px" type="text" name="name" placeholder=" Введите название категории"; />
                        </div>
                        <div style="margin-top: -30px; padding-left: 290px">
                            <button type="submit" class="btn btn-success btn-sm badge-pill" style="width: 150px;">Добавить</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>


        <!--Список меток-->
        <div class="label-list list-group">
            <div class="border">
                <div href="#" class="list-group-item active text-center rounded-0" style="color: white">
                    Метки
                </div>
                <div class="pre-scrollable" style=" height: 550px; background: #FCFCFC">
                    <#list labels as label>
                        <#if label.getAuthor().getId() == currentUserId>
                            <a class="list-group-item list-group-item rounded-0 ">
                                <div class="custom-control-inline">
                                    <div class="text-truncate"  style="width: 220px; border: none;">
                                        ${label.getName()}
                                    </div>
                                    <div class="custom-control-inline" style="margin-left: 20px">
                                        <div class="btn-group" style="width: 40px; margin-right: 10px">
                                            <button class="btn btn-sm btn-outline-primary badge-pill nav-item dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="width: 95px">
                                                Изменить
                                            </button>
                                            <div class="dropdown-menu" style="width:220px">
                                                <form method="post" action="/update-label" style="width: 150px;">
                                                    <div style="padding-left: 10px; padding-top: 2px">
                                                        <input class="rounded border" type="text" style="width: 196px" name="name" value="${label.getName()}">
                                                    </div>
                                                    <input type="hidden" name="label_id" value="${label.getId()}">
                                                    <input type="hidden" name="_csrf" value="${_csrf.token}" />
                                                    <div style="padding-left: 115px; padding-top: 6px">
                                                        <button class="btn btn-sm btn-success" style="width: 90px; size: auto">Сохранить</button>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                        <form method="get" action="/remove-label" style="width: 40px; margin-left: 60px">
                                            <input type="hidden" name="label_id" value=${label.getId()}>
                                            <div>
                                                <button class="btn btn-sm btn-outline-danger badge-pill"  style="width: 90px;">Удалить</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </a>
                        </#if>
                    </#list>
                </div>
            </div>
        </div>

        <!--Форма добавления меток-->
        <div class="add-label-form">
            <div class="form-control border-top-0 rounded-0" style="height: 55px">
                <div>
                    <form method="get" action="/add-label">
                        <div style="padding-top: 7px;">
                            <input class="rounded border" required style="width: 250px" type="text" name="name" placeholder=" Введите название метки"; />
                        </div>
                        <div style="margin-top: -30px; margin-left: 310px">
                            <button type="submit" class="btn btn-success btn-sm badge-pill" style="width: 150px;">Добавить</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>



    </div>
</@m.page>