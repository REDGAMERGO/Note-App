<#macro login path isRegisterForm>


    <div class="card text-center shadow p-3 mb-3 bg-white rounded mx-auto align-middle" style="width: 18rem; margin-top:20%">
        <h2 class="text" style="margin-top: 1%; color: #FFCA73"><b>Note</b><span class="text" style="margin-top: 1%; color: #6E6363"><b>App</b></span></h2>
        <h6 class="text font-weight-normal" style="margin-top: -1%; color: #242421">Let's take a note</h6>
    </div>

    <div class="card text-center shadow p-3 mb-3 bg-white rounded mx-auto align-middle" style="width: 18rem; margin-top:auto">
        <div class="card-body ">
            <#if !isRegisterForm><p class="text font-weight-bold" style="margin-top: -5%">Sign in to your account</p>
            <#else><p class="text font-weight-bold" style="margin-top: -5%">Sign up for an account</p>
            </#if>

            <form action="${path}" method="post" style="margin-top: 10%">
                <!--Форма ввода логина-->
                <div class="form-group row col-15 center-block" >
                        <input type="text" name="username" class="form-control" placeholder="User name" />
                </div>
                <!--Форма ввода пароля-->
                <div class="form-group row col-15 center-block">
                        <input type="password" name="password" class="form-control" placeholder="Password" />
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <!--Гиперссылка на страницу регистрации-->
                <#if !isRegisterForm><a class="font-weight-light" href="/registration">Don't have an account? Sign up</a>
                <#else><a class="font-weight-light" href="/login">Have got an account? Sign In</a>
                </#if>
                <br>
                <br>
                <button class="btn btn-primary" type="submit" style="width:150px;height:40px"><#if isRegisterForm>Sign Up<#else>Sign In</#if></button>
            </form>
        </div>
    </div>

</#macro>

<!--Кнопка выхода из аккаунта в навигационной панели-->
<#macro logout>

    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button class="btn btn-primary" type="submit">Sign Out</button>
    </form>
</#macro>