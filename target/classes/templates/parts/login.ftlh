<#macro login path isRegisterForm>

    <div class="row no-gutters">
        <div class="col"></div>
        <div class="col-auto">
            <div style="padding-top: 150px">
                <div class="card text-center shadow p-3 mb-3 bg-white rounded mx-auto align-middle" style="width: 18rem; margin-top:20%">
                    <h2 class="text" style="margin-top: 1%; color: #FFCA73"><b>Note</b><span class="text" style="margin-top: 1%; color: #6E6363"><b>App</b></span></h2>
                    <h6 class="text font-weight-normal" style="margin-top: -1%; color: #242421">Let's take a note</h6>
                </div>

                <div class="card text-center shadow p-3 mb-3 bg-white rounded mx-auto align-middle" style="width: 18rem; margin-top:auto">
                    <div class="card-body ">
                        <#if !isRegisterForm><p class="text font-weight-bold" style="margin-top: -5%">Войти в аккаунт</p>
                        <#else><p class="text font-weight-bold" style="margin-top: -5%">Создать новый аккаут</p>
                        </#if>

                        <form action="${path}" method="post" style="margin-top: 10%">
                            <!--Форма ввода логина-->
                            <div class="form-group row col-15 center-block" >
                                <input type="text" name="username" class="form-control" placeholder="Логин" />
                            </div>
                            <!--Форма ввода пароля-->
                            <div class="form-group row col-15 center-block">
                                <input type="password" name="password" class="form-control" placeholder="Пароль" />
                            </div>
                            <input type="hidden" name="_csrf" value="${_csrf.token}" />
                            <div style="padding-top: 10px">
                                <button class="btn btn-primary" type="submit" style="width:180px;height:40px"><#if isRegisterForm>Зарегистрироваться<#else>Войти</#if></button>
                            </div>
                            <br>
                            <!--Гиперссылка на страницу регистрации-->
                            <#if !isRegisterForm><a class="font-weight-light" href="/registration">Ещё нет аккаунта? Зарегистрироваться</a>
                            <#else><a class="font-weight-light" href="/login">Уже есть аккаунт? Войти</a>
                            </#if>
                            <br>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="col"></div>
    </div>

</#macro>

<!--Кнопка выхода из аккаунта в навигационной панели-->
<#macro logout>

    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button class="btn btn-sm btn-outline-danger" type="submit">Выход</button>
    </form>
</#macro>